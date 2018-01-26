package com.ifudata.ums.service.route;

import com.ifudata.centra.base.exception.BusinessException;
import com.ifudata.centra.base.exception.SystemException;
import com.ifudata.ums.api.applybatch.param.BatchAccCreditDate;
import com.ifudata.ums.api.applybatch.param.OrdApplyBatchBaseInfo;
import com.ifudata.ums.api.applybatch.param.OrdApplyBatchDetailCredit;
import com.ifudata.ums.api.applybatch.param.RequestHeader;
import com.ifudata.ums.constants.ExceptCodeConstants;
import com.ifudata.ums.service.route.parent.AbstractGroupOrdApplyBatch;
import com.ifudata.ums.vo.ApplyBatchDetailBody;
import com.ifudata.ums.vo.AssembleBatchAccCreditBusiVo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 批量短信推送功能实现
 * @author zhaixs
 *
 */
public class OrdAppayBatchSmsPropelling extends AbstractGroupOrdApplyBatch {
	private static Log log = LogFactory.getLog(OrdAppayBatchSmsPropelling.class);

	@Override
	public List<ApplyBatchDetailBody> analyBatchApplyReqData(
			OrdApplyBatchBaseInfo baseInfo, RequestHeader requestHeader)
			throws Exception {
		log.debug("开始解析批量信控请求的业务报文");
		if(!(baseInfo instanceof OrdApplyBatchDetailCredit)){
			throw new SystemException("批量信控业务请求解析失败，类型不匹配");
		}

		OrdApplyBatchDetailCredit credit=(OrdApplyBatchDetailCredit)baseInfo;
		/* 1.基本参数校验 */
		List<BatchAccCreditDate> dateList = credit.getDateList();
		log.debug("OrdApplyBatchDetailCredit:"+dateList.size());

		if (CollectionUtils.isEmpty(dateList)) {
			throw new BusinessException(
					ExceptCodeConstants.Special.PARAM_IS_NULL, "待批量信控的数据列表为空");
		}
		List<ApplyBatchDetailBody> bodies = new ArrayList<ApplyBatchDetailBody>();
		/* 2.入库封装数据 */
		int i =0;
		for (BatchAccCreditDate batchAccCreditDate : dateList) {
			i=i+1;
			AssembleBatchAccCreditBusiVo baseBusiVo = new AssembleBatchAccCreditBusiVo();
			// baseBusiVo.set
			baseBusiVo.setRequestHeader(requestHeader);
			baseBusiVo.setCreditInfo(batchAccCreditDate.getCreditInfo());
			//baseBusiVo.setBusiOperCode(busiOperCode);

			ApplyBatchDetailBody body = new ApplyBatchDetailBody();
			body.setBaseBusiVo(baseBusiVo);
			if (StringUtils.isEmpty(batchAccCreditDate.getCreditInfo().getPhone())) {
				throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "导入的文件第["
						+ i + "]条数据：电话号码不能为空");
			}
			body.setServiceNum(batchAccCreditDate.getCreditInfo().getPhone());
			bodies.add(body);
			//	bodies
		}
		// TODO Auto-generated method stub
		return bodies;
	}

}
