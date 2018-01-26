package com.ifudata.dvp.pay.api.paycenter.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Service;
import com.ifudata.dvp.base.exception.BusinessException;
import com.ifudata.dvp.pay.api.paycenter.interfaces.IPayCenterSV;
import com.ifudata.dvp.pay.api.paycenter.param.TradeModifyReq;
import com.ifudata.dvp.pay.api.paycenter.param.TradeReq;
import com.ifudata.dvp.pay.constants.ExceptCodeConstants;
import com.ifudata.dvp.pay.constants.PayConstants;
import com.ifudata.dvp.pay.service.business.interfaces.IPayCenterCombSV;
import com.ifudata.dvp.sdk.util.StringUtil;

/**
 * 支付平台流水综合服务
 * 
 * Date: 2015年8月18日 <br>
 */
@Service
@Component
public class PayCenterSVImpl implements IPayCenterSV {

    private static final Log LOG = LogFactory.getLog(PayCenterSVImpl.class);
    
    @Autowired
    private IPayCenterCombSV payCenterCombSV;
    
    @Override
    public long createTradeRecord(TradeReq req)  {
        LOG.info("创建交易记录开始");
        long payId = 0l;
        if (req == null) {
            throw new BusinessException(ExceptCodeConstants.PARAM_IS_NULL, "获取参数失败:发起交易请求参数不能为空");
        }
        
        if (StringUtil.isBlank(req.getTenantId())) {
            throw new BusinessException(ExceptCodeConstants.PARAM_IS_NULL, "获取参数失败:租户ID不能为空");
        }
        
        if (StringUtil.isBlank(req.getOrderId())) {
            throw new BusinessException(ExceptCodeConstants.PARAM_IS_NULL, "获取参数失败:商户订单号不能为空");
        }
                
        if (StringUtil.isBlank(req.getTradeOrderId())) {
            throw new BusinessException(ExceptCodeConstants.PARAM_IS_NULL, "获取参数失败:交易订单号不能为空");
        }
        
        if (StringUtil.isBlank(req.getRequestSource())) {
            throw new BusinessException(ExceptCodeConstants.PARAM_IS_NULL, "获取参数失败:终端来源不能为空");
        }
        
        if(req.getPayAmount() == null || req.getPayAmount() == 0l) {
            throw new BusinessException(ExceptCodeConstants.PARAM_IS_NULL, "支付金额不能为零");
        }
        
        if (StringUtil.isBlank(req.getCurrencyUnit())) {
            throw new BusinessException(ExceptCodeConstants.PARAM_IS_NULL, "币种不能为空");
        }
        
        if (req.getPayRequestType() == null) {
            throw new BusinessException(ExceptCodeConstants.PARAM_IS_NULL, "支付请求类型不能为空");
        }
        
        if (PayConstants.PayCenterLog.PayRequestType.PAY != req.getPayRequestType()
                && PayConstants.PayCenterLog.PayRequestType.REFUND != req.getPayRequestType()
                && PayConstants.PayCenterLog.PayRequestType.TAKE != req.getPayRequestType()) {
            throw new BusinessException(ExceptCodeConstants.PARAM_IS_NULL, "支付请求类型传入有误");
        }
        
        if (PayConstants.PayCenterLog.PayRequestType.REFUND == req.getPayRequestType()) {
            if (StringUtil.isBlank(req.getOriOrderId())) {
                throw new BusinessException(ExceptCodeConstants.PARAM_IS_NULL, "原始订单号不能为空");
            }

            if (StringUtil.isBlank(req.getPayOrgSerial())) {
                throw new BusinessException(ExceptCodeConstants.PARAM_IS_NULL, "第三方支付平台交易流水号不能为空");
            }
        }
        
        payId = this.payCenterCombSV.savePayCenterLog(req);
        LOG.info("创建交易记录成功");
        return payId;
    }

    @Override
    public void modifyTradeRecord(TradeModifyReq req)  {
        LOG.info("修改交易记录开始");
        if (req == null) {
            throw new BusinessException(ExceptCodeConstants.PARAM_IS_NULL, "获取参数失败:修改交易记录请求参数不能为空");
        }
        
        if (StringUtil.isBlank(req.getTenantId())) {
            throw new BusinessException(ExceptCodeConstants.PARAM_IS_NULL, "获取参数失败:租户ID不能为空");
        }
        
        if (StringUtil.isBlank(req.getOrderId())) {
            throw new BusinessException(ExceptCodeConstants.PARAM_IS_NULL, "获取参数失败:订单号不能为空");
        }
        
        this.payCenterCombSV.updatePayCenterLog(req);
        LOG.info("修改交易记录成功");
    }
    
}
