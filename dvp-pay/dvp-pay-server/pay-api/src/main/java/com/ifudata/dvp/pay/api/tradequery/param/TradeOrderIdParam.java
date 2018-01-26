package com.ifudata.dvp.pay.api.tradequery.param;

import com.ifudata.dvp.base.vo.BaseInfo;

/**
 * 内部交易订单号入参.<br>
 * Date: 2015年8月18日 <br>
 */
public class TradeOrderIdParam extends BaseInfo {

    private static final long serialVersionUID = -5611965352621441423L;

    /**
     * 内部交易订单号，必填项
     */
    private String tradeOrderId;

    public String getTradeOrderId() {
        return tradeOrderId;
    }

    public void setTradeOrderId(String tradeOrderId) {
        this.tradeOrderId = tradeOrderId;
    }
}
