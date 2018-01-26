package com.ifudata.ums.service.business.impl;

import com.alibaba.fastjson.JSON;
import com.ifudata.centra.base.exception.BusinessException;
import com.ifudata.centra.base.exception.SystemException;
import com.ifudata.centra.sdk.util.DateUtil;
import com.ifudata.ums.api.applybatch.param.OrdApplyBatchRequest;
import com.ifudata.ums.constants.ExceptCodeConstants;
import com.ifudata.ums.constants.OrdersConstants;
import com.ifudata.ums.dao.mapper.bo.OrdApplyBatch;
import com.ifudata.ums.dao.mapper.bo.OrdApplyBatchDetail;
import com.ifudata.ums.dao.mapper.bo.OrdApplyBatchDetailWithBLOBs;
import com.ifudata.ums.service.atom.interfaces.IOrdAppayBatchDetailSV;
import com.ifudata.ums.service.atom.interfaces.IOrdAppayBatchSV;
import com.ifudata.ums.service.business.interfaces.IOrdApplyBatchProcessSV;
import com.ifudata.ums.utils.UmsSeqUtil;
import com.ifudata.ums.vo.AbstractBaseAssembleBusiVo;
import com.ifudata.ums.vo.ApplyBatchDetailBody;
import com.ifudata.ums.vo.GroupOrdApplyBatchFactory;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author wangyongxin
 *
 */

@Service
@Transactional
public class OrdApplyBatchProcessSVImpl implements IOrdApplyBatchProcessSV {
	private static Log log = LogFactory.getLog(OrdApplyBatchProcessSVImpl.class);

	@Autowired
	private IOrdAppayBatchDetailSV iOrdAppayBatchDetailSV;
	@Autowired
	private IOrdAppayBatchSV iOrdAppayBatchSV;

	@Override
	public long batchApply(OrdApplyBatchRequest request) throws Exception {
		String busiType = request.getBusiType();
		Long batchId = UmsSeqUtil.createOrdApplyBatchId();
		Timestamp sysdate = new Timestamp(System.currentTimeMillis());
		log.debug("开始处理批量受理[业务类型=" + busiType + "],产生的批次号[" + batchId + "]");
		/* 1.封装批次总表信息 */
		OrdApplyBatch applyBatchBean =new OrdApplyBatch();
		applyBatchBean.setBatchId(batchId);
		applyBatchBean.setBusiType(busiType);
		applyBatchBean.setChlId(request.getRequestHeader().getChlId());
		applyBatchBean.setOperId(request.getRequestHeader().getOperId());
		applyBatchBean.setProvinceCode(request.getRequestHeader().getProvinceCode());
		applyBatchBean.setCityCode(request.getRequestHeader().getCityCode());
		applyBatchBean.setApplyTime(sysdate);
		applyBatchBean.setState(OrdersConstants.OrdApplyBatch.State.SUBMITTED);
		applyBatchBean.setStateChgTime(sysdate);
		applyBatchBean.setStateDesc("成功接收批量受理业务信息，等待处理");
		applyBatchBean.setCreateTime(sysdate);
		applyBatchBean.setCorpId(request.getRequestHeader().getCorpId());
		applyBatchBean.setJobTime(DateUtil.getTimestamp(request.getJobTime(), DateUtil.YYYYMMDDHHMMSS));
		applyBatchBean.setFileName(request.getFileName());
		applyBatchBean.setRemark(request.getBatchContext());
		iOrdAppayBatchSV.save(applyBatchBean);

		/* 2.解析明细表数据 */
		List<ApplyBatchDetailBody> details = GroupOrdApplyBatchFactory.getInstance(busiType)
				.analyBatchApplyReqData(request.getApplyBatchDetailCredit(),
						request.getRequestHeader());
		if (!CollectionUtils.isEmpty(details)) {
			List<OrdApplyBatchDetailWithBLOBs> detailBeans = new ArrayList<OrdApplyBatchDetailWithBLOBs>();
			for (ApplyBatchDetailBody body : details) {
				String serviceNum = body.getServiceNum();
				AbstractBaseAssembleBusiVo baseBusiVo = body.getBaseBusiVo();
				if (baseBusiVo == null) {
					throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL,"批量业务处理组件返回的业务包装对象为空");
				}
				/* 2.1 封装明细表记录 */
				long detailId = UmsSeqUtil.createOrdApplyBatchDetailId();
				OrdApplyBatchDetailWithBLOBs detailBean = new OrdApplyBatchDetailWithBLOBs();
				detailBean.setDetailId(detailId);
				detailBean.setBatchId(batchId);
				detailBean.setBusiType(busiType);
				detailBean.setServiceNum(serviceNum);
				if (!StringUtils.isEmpty(body.getValidateInfo())
						&& body.getValidateInfo().startsWith("ERROR")) {
					log.debug("REMARK字段中带有携带有ERROR信息，将此记录生成为错误数据，待批次查询时导出");
					detailBean.setState(OrdersConstants.OrdApplyBatchDetail.State.FAILURE);
					detailBean.setStateDesc(body.getValidateInfo());
				} else {
					detailBean.setState(OrdersConstants.OrdApplyBatchDetail.State.UNDO);
					detailBean.setStateDesc("成功接收批量受理业务明细，等待生成订单");
				}
				detailBean.setStateChgTime(sysdate);
				detailBean.setCreateTime(sysdate);

				String reqBody = JSON.toJSONString(baseBusiVo);
				String body1 = null;
				String body2 = null;
				String body3 = null;
				if (reqBody.length() <= 4000) {
					body1 = reqBody;
				} else if (reqBody.length() > 4000 && reqBody.length() <= 8000) {
					body1 = reqBody.substring(0, 4000);
					body2 = reqBody.substring(4000, reqBody.length());
				} else if (reqBody.length() > 8000 && reqBody.length() <= 12000) {
					body1 = reqBody.substring(0, 4000);
					body2 = reqBody.substring(4000, 8000);
					body3 = reqBody.substring(8000, reqBody.length());
				} else {
					throw new SystemException("服务号码[" + serviceNum + "]在批量业务[BUSI_TYPE=" + busiType
							+ "]解析到的报文长度超出范围");
				}
				detailBean.setExcelBody1(body1);
				detailBean.setExcelBody2(body2);
				detailBean.setExcelBody3(body3);
				detailBeans.add(detailBean);
			}
			iOrdAppayBatchDetailSV.sava(detailBeans);
			log.debug("保存批次详细完成，校验批次详细状态是否都为FAIL");
			this.validateBatchDetailState(batchId , detailBeans , applyBatchBean);
		}
		return batchId;
	}
	 /**
     * 检查批次详细状态是否全部为失败，<br>
     * 如果全部都是失败，<br>
     * 将批次表中该批次的状态变更为 已完成：4
     * 
     * @param batchId
     * @param detailBeans
     * @param applyBatchBean
     * @throws Exception
     * @author zhaixs
     */
    private void validateBatchDetailState(long batchId ,List<OrdApplyBatchDetailWithBLOBs> detailBeans,
            OrdApplyBatch applyBatchBean) throws Exception {
        for (OrdApplyBatchDetail detailBean : detailBeans) {
            if (detailBean.getState().equals(OrdersConstants.OrdApplyBatchDetail.State.UNDO)) {
                return;
            }
        }
        applyBatchBean.setBatchId(batchId);
        applyBatchBean.setState(OrdersConstants.OrdApplyBatch.State.PAID);
        applyBatchBean.setStateDesc("该批次详细信息全部验证失败，请检查号码是否正确");
        iOrdAppayBatchSV.save(applyBatchBean);
    }
    /**
     * @param fileName 文件名
     * @return long 批次号
     * @throws Exception
     * @author zhaixs
     */
	@Override
	public OrdApplyBatch getBatchId(String fileName) throws Exception {
		return iOrdAppayBatchSV.query(fileName);
	}
}
