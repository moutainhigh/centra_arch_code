package com.ai.slp.charge.service.business.impl;

import java.sql.Timestamp;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.sdk.components.mds.MDSClientFactory;
import com.ai.paas.ipaas.mds.IMessageSender;
import com.ai.slp.charge.api.payment.param.PayOrderParam;
import com.ai.slp.charge.api.payment.param.PaymentParam;
import com.ai.slp.charge.constants.ChargeCostants;
import com.ai.slp.charge.dao.mapper.bo.ChgPayOrderLog;
import com.ai.slp.charge.service.atom.interfaces.IChgPayOrderLogSV;
import com.ai.slp.charge.service.business.interfaces.IPayOrderCombSV;
import com.ai.slp.charge.service.business.interfaces.IPaymentManagerSV;
import com.ai.slp.charge.util.ChargeSeqUtil;
import com.ai.slp.charge.vo.DeductVo;
import com.alibaba.fastjson.JSON;
/**
 * 缴费订单处理接口
 * Date: 2016年6月7日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * 
 * @author LiangMeng
 */
@Service
@Transactional
public class PayOrderCombSVImpl implements IPayOrderCombSV {
	private static final Logger log = LogManager.getLogger(PayOrderCombSVImpl.class);
    @Autowired
    private IPaymentManagerSV paymentManagerSV;

    @Autowired
    private IChgPayOrderLogSV chgPayOrderSV; 
    
    @Override
    public String createPayOrder(PayOrderParam payOrderParam) throws BusinessException,
            SystemException {
        ChgPayOrderLog payOrderLog = new ChgPayOrderLog();
        Timestamp now = new Timestamp(System.currentTimeMillis());
        String orderId = ChargeSeqUtil.createPayOrderId();
        payOrderLog.setOrderId(orderId);
        payOrderLog.setAcctId(payOrderParam.getAcctId());
        payOrderLog.setCheckStatus(ChargeCostants.PayOrderLog.CheckStatus.INIT);
        payOrderLog.setOrdDes(payOrderParam.getOrdDes());
        payOrderLog.setCreateTime(now);
        payOrderLog.setLastStatusDate(now);
        payOrderLog.setPayAmount(payOrderParam.getPayAmount());
        payOrderLog.setPayChannel(payOrderParam.getPayChannel());
        if(payOrderParam.getStatus()==null){
            payOrderLog.setStatus(payOrderParam.getStatus());
        }else{
            payOrderLog.setStatus(ChargeCostants.PayOrderLog.Status.INIT);
        }
        chgPayOrderSV.savePayOrderLog(payOrderLog);
        return orderId;
    }

    @Override
    public String updatePayOrder(PayOrderParam payOrderParam) throws BusinessException,
            SystemException {
        ChgPayOrderLog payOrderLog = chgPayOrderSV.queryChgPayOrderLogByOrderId(payOrderParam.getOrderId());
        Timestamp now = new Timestamp(System.currentTimeMillis());
        payOrderLog.setLastStatusDate(now);
        payOrderLog.setPayOrgId(payOrderParam.getPayOrgId());
        payOrderLog.setPayOrgSerial(payOrderParam.getPayOrgSerial());
        payOrderLog.setStatus(payOrderParam.getStatus());
        chgPayOrderSV.updatePayOrderLog(payOrderLog);
        return payOrderParam.getOrderId();
    }

    @Override
    public String callPayOrder(PayOrderParam payOrderParam, PaymentParam paymentParam)
            throws BusinessException, SystemException {
        ChgPayOrderLog payOrderLog =  chgPayOrderSV.queryChgPayOrderLogByOrderId(payOrderParam.getOrderId());
        Timestamp now = new Timestamp(System.currentTimeMillis());
        payOrderLog.setLastStatusDate(now);
        payOrderLog.setPayOrgId(payOrderParam.getPayOrgId());
        payOrderLog.setPayOrgSerial(payOrderParam.getPayOrgSerial());
        payOrderLog.setStatus(payOrderParam.getStatus());
        chgPayOrderSV.updatePayOrderLog(payOrderLog);
        
        //paymentManagerSV.payment(paymentParam);
        //
        DeductVo request = new DeductVo();
        request.setAccountId(paymentParam.getAcctId());
        request.setExternalId(paymentParam.getOrderId());
        request.setTenantId(paymentParam.getTenantId());
        request.setPaySerialCode(paymentParam.getOrderId());
        request.setTotalAmount(paymentParam.getTotalFee());
        request.setBusiType(ChargeCostants.ChgChargeLog.BusiType.ACCOUNT_CHARGE);
        //
        this.chargeMds(request);
        //
        return "0";
    }

    /**
     * 充值业务,发送MDS消息
     * @param request
     * @author zhangzd
     * @ApiDocMethod
     * @ApiCode
     */
    private void chargeMds(DeductVo request) {
        IMessageSender msgSender = MDSClientFactory
                .getSenderClient(ChargeCostants.OrdOrder.SLP_CHARGE_TOPIC);

        msgSender.send(JSON.toJSONString(request), 0);// 第二个参数为分区键，如果不分区，传入0
        log.info("----mds sender success");
    }
    @Override
    public PayOrderParam queryPayOrder(String orderId) throws BusinessException, SystemException {
        ChgPayOrderLog payOrderLog = chgPayOrderSV.queryChgPayOrderLogByOrderId(orderId);
        return this.conversLogToParam(payOrderLog);
    }

    private PayOrderParam conversLogToParam(ChgPayOrderLog payOrderLog){
        PayOrderParam payOrderParam = new PayOrderParam();
        payOrderParam.setAcctId(payOrderLog.getAcctId());
        payOrderParam.setCustId(payOrderLog.getCustId());
        payOrderParam.setOrdDes(payOrderLog.getOrdDes());
        payOrderParam.setOrderId(payOrderLog.getOrderId());
        payOrderParam.setPayAmount(payOrderLog.getPayAmount());
        payOrderParam.setPayChannel(payOrderLog.getPayChannel());
        payOrderParam.setPayOrgId(payOrderLog.getPayOrgId());
        payOrderParam.setPayOrgSerial(payOrderLog.getPayOrgSerial());
        payOrderParam.setStatus(payOrderLog.getStatus());
        return payOrderParam;
    }

}
