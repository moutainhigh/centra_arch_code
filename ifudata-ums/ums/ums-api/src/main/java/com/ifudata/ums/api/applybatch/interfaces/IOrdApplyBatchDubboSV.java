package com.ifudata.ums.api.applybatch.interfaces;


import com.ifudata.ums.api.applybatch.param.OrdApplyBatchRequest;
import com.ifudata.ums.api.applybatch.param.OrdApplyBatchResponse;
import com.ifudata.ums.api.applybatch.param.OrdSendStatusRequest;
import com.ifudata.ums.api.applybatch.param.OrdSendStatusResponse;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/ordApplyBatch")
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({MediaType.APPLICATION_JSON,MediaType.TEXT_XML,MediaType.TEXT_PLAIN})
public interface IOrdApplyBatchDubboSV {

	/**
	 * 批量业务受理入口
	 * @param request
	 * @return
	 * @author wangyongxin
	 */
	@POST
	@Path("/batchApply")
	OrdApplyBatchResponse batchApply(OrdApplyBatchRequest request);

	/**
	 * 批量业务受理入口
	 * @param fileName
	 * @return
	 * @author wangyongxin
	 */
	@POST
	@Path("/sendStatus")
	OrdSendStatusResponse sendStatus(OrdSendStatusRequest fileName);
}
