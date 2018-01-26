package com.ai.slp.order.api.orderpay.interfaces;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.BaseResponse;
import com.ai.slp.order.api.orderpay.param.OrderOidRequest;
import com.ai.slp.order.api.orderpay.param.OrderPayRequest;
/**
 * 订单收费服务
 * Date: 2016年5月24日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * 
 * @author zhangxw
 */
@Path("/orderpay")
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
public interface IOrderPaySV {

    /**
     * 订单收费
     * @param request
     * @return
     * @throws BusinessException
     * @throws SystemException
     * @author zhangxw
     * @ApiDocMethod
     * @ApiCode ORDER_PAY_001
     * @RestRelativeURL orderpay/pay
     */
	@POST
	@Path("/pay")
    public BaseResponse pay(OrderPayRequest request)throws BusinessException,SystemException;
    //@interface pay{}
	
	
	 /**
     * 积分中心回调
     * @param request
     * @return
     * @throws BusinessException
     * @throws SystemException
     * @author zhangxw
     * @ApiDocMethod
     * @ApiCode ORDER_RETURNOID_001
     * @RestRelativeURL orderpay/returnOid
     */
	@POST
	@Path("/returnOid")
    public BaseResponse returnOid(OrderOidRequest request)throws BusinessException,SystemException;
}
