package com.ifudata.ums.api.applybatch;

import com.alibaba.dubbo.config.annotation.Service;
import com.ifudata.centra.base.exception.BusinessException;
import com.ifudata.centra.base.exception.SystemException;
import com.ifudata.centra.base.vo.PageInfo;
import com.ifudata.centra.base.vo.ResponseHeader;
import com.ifudata.ums.api.applybatch.interfaces.IOrdApplyBatchDubboSV;
import com.ifudata.ums.api.applybatch.param.*;
import com.ifudata.ums.constants.ExceptCodeConstants;
import com.ifudata.ums.constants.OrdersConstants;
import com.ifudata.ums.dao.mapper.bo.OrdApplyBatch;
import com.ifudata.ums.exceptions.FileException;
import com.ifudata.ums.service.business.interfaces.IOrdApplyBatchProcessSV;
import com.ifudata.ums.service.business.interfaces.IUmsFreeBackSV;
import com.ifudata.ums.utils.ResponseHeaderUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;


/**
 * msg 短信营销平台
 * @author wangyongxin
 *
 */
@Service
public class OrdApplyBatchDubboSVImpl implements IOrdApplyBatchDubboSV {
	private static Log log = LogFactory.getLog(OrdApplyBatchDubboSVImpl.class);
	@Resource
	private IOrdApplyBatchProcessSV iOrdApplyBatchProcessSV;
	@Resource
	private IUmsFreeBackSV iUmsFreeBackSV;
	/**
	 * 批量入库服务
	 */
	@Override
	public OrdApplyBatchResponse batchApply(OrdApplyBatchRequest request) {
		log.debug("开始处理批量业务受理...");
		OrdApplyBatchResponse response = new OrdApplyBatchResponse();
		ResponseHeader responseHeader = new ResponseHeader();
		try {
			if (request == null) {
				throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "批量受理请求报文");
			}
			if (request.getRequestHeader() == null) {
				throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "批量受理请求报文头");
			}
			if (request.getApplyBatchDetailCredit() == null) {
				throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "批量受理请求业务信息");
			}
			if (StringUtils.isEmpty(request.getBusiType())) {
				throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "批量受理业务类型");
			}
			long batchId = iOrdApplyBatchProcessSV.batchApply(request);
			response.setBatchId(batchId);
			response.setBatchDesc("批量业务受理已经成功接收，请耐心等待系统处理");
			responseHeader = new ResponseHeader(true,ExceptCodeConstants.Special.SUCCESS, "成功接收批量业务请求");
		} catch (BusinessException ex) {
			responseHeader = ResponseHeaderUtil.assemble(ex);
			log.error("批量受理业务失败",ex);
		} catch (SystemException ex) {
			responseHeader = ResponseHeaderUtil.assemble(ex);
			log.error("批量受理业务失败",ex);
		} catch(FileException ex){
			responseHeader.setResultCode(ex.getCode());
			responseHeader.setResultMessage(ex.getMessage());
			log.error("批量受理业务失败",ex);
		}
		catch (Exception ex) {
			responseHeader = ResponseHeaderUtil.assemble(ex);
			log.error("批量受理业务失败",ex);
		}
		response.setResponseHeader(responseHeader);
		return response;

	}
	/**
	 * 发送状态查询服务
	 */
	@Override
	public OrdSendStatusResponse sendStatus(OrdSendStatusRequest request) {
		log.debug("开始发送状态查询服务...");
		OrdSendStatusResponse sendReponse=new OrdSendStatusResponse();
		ResponseHeader responseHeader = null;
		try {
			if (request.getFileName() == null) {
				throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "信息发送状态查询");
			}
			if(request.getPageInfo()==null){
				throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "信息发送状态查询");

			}
			if(request.getPageInfo().getPageNo()==null||request.getPageInfo().getPageNo()==0){
				throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "信息发送状态查询");

			}
			if(request.getPageInfo().getPageSize()==null||request.getPageInfo().getPageSize()==0){
				throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "信息发送状态查询");

			}
			OrdApplyBatch batchId = iOrdApplyBatchProcessSV.getBatchId(request.getFileName());
			sendReponse.setState(batchId.getState());
			if(OrdersConstants.OrdApplyBatch.State.PAID.equals(batchId.getState())){
				PageInfo<SendStatusInfo> pageInfo = iUmsFreeBackSV.getPageInfo(request, batchId.getBatchId());
				sendReponse.setSendStatus(pageInfo);
			}
		} catch (BusinessException ex) {
			responseHeader = ResponseHeaderUtil.assemble(ex);
		} catch (SystemException ex) {
			responseHeader = ResponseHeaderUtil.assemble(ex);
		} catch (Exception ex) {
			responseHeader = ResponseHeaderUtil.assemble(ex);
		}

		sendReponse.setResponseHeader(responseHeader);
		return sendReponse;
	}

}
