package com.ai.slp.order.api.orderrefund.interfaces;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.BaseResponse;
import com.ai.slp.order.api.orderrefund.param.OrderRefundRequest;
import com.ai.slp.order.api.orderrefund.param.OrderRefuseRefundRequest;

@Path("/aftersaleorder")
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
public interface IOrderRefundSV {
	
	/**
	 * 退款(金额修改)
	 * @param request
	 * @return
	 * @throws BusinessException
	 * @throws SystemException
	 * @author caofz
	 * @ApiDocMethod
	 * @ApiCode ORDER_PARTREFUND_001
	 * @RestRelativeURL   aftersaleorder/partRefund
	 */
	@POST
	@Path("/partRefund")
	public BaseResponse partRefund(OrderRefundRequest request) throws BusinessException,SystemException;
	
	
	
	/**
	 * 拒绝退款
	 * @param request
	 * @return
	 * @throws BusinessException
	 * @throws SystemException
	 * @author caofz
	 * @ApiDocMethod
	 * @ApiCode ORDER_REFUSEREFUND_001
	 * @RestRelativeURL   aftersaleorder/refuseRefund
	 */
	@POST
	@Path("/refuseRefund")
	public BaseResponse refuseRefund(OrderRefuseRefundRequest request) throws BusinessException,SystemException;
}
