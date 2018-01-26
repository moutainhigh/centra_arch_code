package com.ai.slp.order.api.orderlist.interfaces;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.slp.order.api.orderlist.param.BehindQueryOrderListRequest;
import com.ai.slp.order.api.orderlist.param.BehindQueryOrderListResponse;
import com.ai.slp.order.api.orderlist.param.QueryOrderRequest;
import com.ai.slp.order.api.orderlist.param.QueryOrderResponse;

/**
 * 查询订单列表 Date: 2016年5月3日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * 
 * @author zhangqiang7
 */
@Path("/orderlist")
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
public interface IOrderListSV {


	/**
	 * 订单详情查询
	 * @param orderRequest
	 * @return
	 * @throws BusinessException
	 * @throws SystemException
	 * @author caofz
	 * @ApiDocMethod
     * @ApiCode ORDERQUERY_002
     * @RestRelativeURL orderlist/queryOrder
	 */
	@POST
	@Path("/queryOrder")
	QueryOrderResponse queryOrder(QueryOrderRequest orderRequest) throws BusinessException, SystemException;
	
	/**
	 * 运营后台订单列表查询
	 * @param orderRequest
	 * @return
	 * @throws BusinessException
	 * @throws SystemException
	 * @author caofz
	 * @ApiDocMethod
     * @ApiCode ORDERQUERY_004
     * @RestRelativeURL orderlist/behindQueryOrderList
	 */
	@POST
	@Path("/behindQueryOrderList")
	BehindQueryOrderListResponse behindQueryOrderList(BehindQueryOrderListRequest orderListRequest) throws BusinessException, SystemException;
	
}
