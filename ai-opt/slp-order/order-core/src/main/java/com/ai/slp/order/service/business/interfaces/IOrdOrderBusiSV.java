package com.ai.slp.order.service.business.interfaces;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.slp.order.api.orderlist.param.BehindQueryOrderListRequest;
import com.ai.slp.order.api.orderlist.param.BehindQueryOrderListResponse;
import com.ai.slp.order.api.orderlist.param.QueryOrderRequest;
import com.ai.slp.order.api.orderlist.param.QueryOrderResponse;
import com.ai.slp.order.dao.mapper.bo.OrdOrder;

public interface IOrdOrderBusiSV {

    public QueryOrderResponse queryOrder(QueryOrderRequest orderRequest) 
    		throws BusinessException,SystemException;

    public BehindQueryOrderListResponse behindQueryOrderList(BehindQueryOrderListRequest orderListRequest)
            throws BusinessException, SystemException;
    
    public int updateOrder(OrdOrder request)
            throws BusinessException, SystemException;
    
}
