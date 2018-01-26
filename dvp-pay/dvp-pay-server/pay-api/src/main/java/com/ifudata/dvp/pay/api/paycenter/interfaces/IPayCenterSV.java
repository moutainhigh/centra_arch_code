package com.ifudata.dvp.pay.api.paycenter.interfaces;


import com.ifudata.dvp.pay.api.paycenter.param.TradeModifyReq;
import com.ifudata.dvp.pay.api.paycenter.param.TradeReq;


/**
 * 支付平台流水综合服务
 * Date: 2015年8月18日 <br>
 */
public interface IPayCenterSV {

    /**
     * 创建交易记录
     * @param param 发起交易请求参数
     * @return 支付流水号
     * @ApiDocMethod 
     * @ApiCode PAY_0001
     */
    long createTradeRecord(TradeReq req)  ;
    
    /**
     * 修改交易记录
     * @param param 修改交易记录请求参数
     * @ApiDocMethod 
     * @ApiCode PAY_0002
     */
    void modifyTradeRecord(TradeModifyReq req)  ;
    
}
