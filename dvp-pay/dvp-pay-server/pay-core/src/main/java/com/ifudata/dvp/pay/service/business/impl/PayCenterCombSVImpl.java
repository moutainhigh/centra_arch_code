package com.ifudata.dvp.pay.service.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ifudata.dvp.base.exception.BusinessException;
import com.ifudata.dvp.pay.api.paycenter.param.TradeModifyReq;
import com.ifudata.dvp.pay.api.paycenter.param.TradeReq;
import com.ifudata.dvp.pay.constants.ExceptCodeConstants;
import com.ifudata.dvp.pay.constants.PayConstants;
import com.ifudata.dvp.pay.dao.mapper.bo.PayCenterLog;
import com.ifudata.dvp.pay.dao.mapper.bo.PayCenterLogState;
import com.ifudata.dvp.pay.service.atom.interfaces.IPayCenterLogSV;
import com.ifudata.dvp.pay.service.atom.interfaces.IPayCenterLogStateSV;
import com.ifudata.dvp.pay.service.business.interfaces.IPayCenterCombSV;
import com.ifudata.dvp.pay.util.PaySeqUtil;
import com.ifudata.dvp.sdk.util.BeanUtils;
import com.ifudata.dvp.sdk.util.DateUtil;


/**
 * 支付平台流水服务业务实现类
 * Date: 2015年8月18日 <br>
 */
@Service
@Transactional
public class PayCenterCombSVImpl implements IPayCenterCombSV {
    
    @Autowired
    private IPayCenterLogSV payCenterLogSV;
    
    @Autowired
    private IPayCenterLogStateSV payCenterLogStateSV;
    
    @Override
    public long savePayCenterLog(TradeReq req) throws BusinessException {
        /*1. 幂等性验证*/
        long originalPayId = this.validateDuplication(req.getTenantId(), req.getOrderId());
        if(originalPayId > 0) {
            return originalPayId;
        }
        /*2. 保存支付平台流水*/
        PayCenterLog log = new PayCenterLog();
        BeanUtils.copyProperties(log, req);
        Long payId = PaySeqUtil.createPayId();
        log.setPayId(payId);
        log.setCreateTime(DateUtil.getSysDate());
        Integer status = PayConstants.PayCenterLog.Status.CREATE;
        if(PayConstants.PayCenterLog.PayRequestType.REFUND == req.getPayRequestType()) {
            status = PayConstants.PayCenterLog.Status.REFUND_APPLY;
        }
        log.setStatus(status);
        log.setStatusChgTime(DateUtil.getSysDate());
        log.setCheckStatus(PayConstants.PayCenterLog.CheckStatus.YET_CHECK);
        this.payCenterLogSV.savePayCenterLog(log);
        
        /*3. 记录支付中心流水变更轨迹*/
        PayCenterLogState payCenterLogState = new PayCenterLogState();
        BeanUtils.copyProperties(payCenterLogState, log);
        payCenterLogStateSV.savePayCenterLogState(payCenterLogState);
        return payId;
    }
    
    /**
     * 幂等性验证
     * @param tenantId
     * @param orderId
     * @ApiDocMethod
     */
    private long validateDuplication(String tenantId, String orderId) {
        PayCenterLog payCenterLog = this.payCenterLogSV.getPayCenterLogByMerchantOrderId(tenantId, orderId);
        if(payCenterLog == null) {
            return -1;
        }
        
        return payCenterLog.getPayId();
    }

    @Override
    public void updatePayCenterLog(TradeModifyReq req) throws BusinessException {
        /*1. 更新支付平台流水*/
        PayCenterLog log = new PayCenterLog();
        BeanUtils.copyProperties(log, req);
        log.setStatusChgTime(DateUtil.getSysDate());
        this.payCenterLogSV.modifyPayCenterLog(log);
        
        /*2. 记录支付中心流水变更轨迹*/
        PayCenterLog payCenterLogAfterModify = this.payCenterLogSV
                .getPayCenterLogByMerchantOrderId(req.getTenantId(), req.getOrderId());
        if(payCenterLogAfterModify == null) {
            throw new BusinessException(ExceptCodeConstants.PARAM_IS_NULL, "修改交易记录失败：不存在此条交易记录!");
        }
        PayCenterLogState info = new PayCenterLogState();
        BeanUtils.copyProperties(info, payCenterLogAfterModify);
        info.setSendDetailData(req.getSendDetailData());
        info.setReceiveDetailData(req.getReceiveDetailData());
        payCenterLogStateSV.savePayCenterLogState(info);
    }

}
