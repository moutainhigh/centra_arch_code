package com.ifudata.ic.pay.service.business.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ifudata.centra.base.exception.BusinessException;
import com.ifudata.centra.sdk.util.BeanUtils;
import com.ifudata.centra.sdk.util.CollectionUtil;
import com.ifudata.ic.pay.api.tradequery.param.TradeRecord;
import com.ifudata.ic.pay.dao.mapper.bo.PayCenterLog;
import com.ifudata.ic.pay.service.atom.interfaces.IPayCenterLogSV;
import com.ifudata.ic.pay.service.business.interfaces.ITradeQueryCombSV;

/**
 * 交易记录查询业务具体实现
 * 
 * Date: 2015年10月29日 <br>
 */
@Service
@Transactional
public class TradeQueryCombSVImpl implements ITradeQueryCombSV {

    @Autowired
    private IPayCenterLogSV payCenterLogSV;

    @Override
    public TradeRecord querySingleTradeRecordByMerchantOrderId(String tenantId,
            String merchantOrderId) throws BusinessException {
        PayCenterLog payCenterLog = this.payCenterLogSV.getPayCenterLogByMerchantOrderId(tenantId,
                merchantOrderId);
        if (payCenterLog == null) {
            return null;
        }
        TradeRecord record = new TradeRecord();
        BeanUtils.copyProperties(record, payCenterLog);
        return record;
    }

    @Override
    public TradeRecord querySingleTradeRecordByTradeOrderId(String tenantId, String tradeOrderId)
            throws BusinessException {
        PayCenterLog payCenterLog = this.payCenterLogSV.getPayCenterLogByTradeOrderId(tenantId,
                tradeOrderId);
        if (payCenterLog == null) {
            return null;
        }
        TradeRecord record = new TradeRecord();
        BeanUtils.copyProperties(record, payCenterLog);
        return record;
    }

    @Override
    public List<TradeRecord> queryTradeRecordsByBatchNo(String tenantId, String batchNo,
            String payOrgSerial) throws BusinessException {
        List<TradeRecord> tradeRecordList = new ArrayList<TradeRecord>();
        List<PayCenterLog> payCenterLogs = this.payCenterLogSV.getPayCenterLogsByBatchNo(tenantId,
                batchNo, payOrgSerial);
        if (CollectionUtil.isEmpty(payCenterLogs)) {
            return tradeRecordList;
        }

        for (PayCenterLog payCenterLog : payCenterLogs) {
            TradeRecord record = new TradeRecord();
            BeanUtils.copyProperties(record, payCenterLog);
            tradeRecordList.add(record);
        }
        return tradeRecordList;
    }

}
