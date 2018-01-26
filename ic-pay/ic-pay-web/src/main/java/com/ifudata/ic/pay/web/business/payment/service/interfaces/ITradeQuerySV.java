package com.ifudata.ic.pay.web.business.payment.service.interfaces;

import com.ifudata.ic.pay.web.business.payment.model.TradeQueryRes;

/**
 * 交易结果查询接口
 *
 * Date: 2015年12月10日 <br>
 */
public interface ITradeQuerySV {

    TradeQueryRes tradeQuery(String tenantId, String orderId, String tradeOrderId);
    
}
