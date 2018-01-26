package com.ifudata.ic.pay.service.business.interfaces;

import com.ifudata.centra.base.exception.BusinessException;
import com.ifudata.ic.pay.api.paycenter.param.TradeModifyReq;
import com.ifudata.ic.pay.api.paycenter.param.TradeReq;


/**
 * 支付平台流水服务业务定义类
 * Date: 2015年8月18日 <br>
 */
public interface IPayCenterCombSV {

    /**
     * 保存支付平台流水
     * @param req
     * @return
     * @throws BusinessException
     * @ApiDocMethod
     */
    long savePayCenterLog(TradeReq req) throws BusinessException;
    
    /**
     * 更新支付平台流水
     * @param req
     * @throws BusinessException
     * @ApiDocMethod
     */
    void updatePayCenterLog(TradeModifyReq req) throws BusinessException;
    
}
