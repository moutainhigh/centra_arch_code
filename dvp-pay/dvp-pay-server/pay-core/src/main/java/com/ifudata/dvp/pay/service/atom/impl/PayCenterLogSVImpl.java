package com.ifudata.dvp.pay.service.atom.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ifudata.dvp.pay.dao.mapper.bo.PayCenterLog;
import com.ifudata.dvp.pay.dao.mapper.bo.PayCenterLogCriteria;
import com.ifudata.dvp.pay.dao.mapper.bo.PayCenterLogCriteria.Criteria;
import com.ifudata.dvp.pay.dao.mapper.factory.MapperFactory;
import com.ifudata.dvp.pay.service.atom.interfaces.IPayCenterLogSV;
import com.ifudata.dvp.sdk.util.CollectionUtil;
import com.ifudata.dvp.sdk.util.StringUtil;

/**
 * 支付中心流水基础服务实现类
 * Date: 2015年8月18日 <br>
 */
@Component
public class PayCenterLogSVImpl implements IPayCenterLogSV {

    @Override
    public void savePayCenterLog(PayCenterLog log) {
        MapperFactory.getPayCenterLogMapper().insert(log);
    }

    @Override
    public void modifyPayCenterLog(PayCenterLog log) {
        PayCenterLogCriteria sql = new PayCenterLogCriteria();
        Criteria criteria = sql.createCriteria(); 
        criteria.andTenantIdEqualTo(log.getTenantId());
        criteria.andOrderIdEqualTo(log.getOrderId());
        MapperFactory.getPayCenterLogMapper().updateByExampleSelective(log, sql);
    }

    @Override
    public PayCenterLog getPayCenterLogByMerchantOrderId(String tenantId, String merchantOrderId) {
        PayCenterLogCriteria sql = new PayCenterLogCriteria();
        Criteria criteria = sql.createCriteria();  
        if(!StringUtil.isBlank(tenantId)) {
            criteria.andTenantIdEqualTo(tenantId);
        }
        criteria.andOrderIdEqualTo(merchantOrderId);   
        List<PayCenterLog> payCenterLogs = MapperFactory.getPayCenterLogMapper().selectByExample(sql);
        if(CollectionUtil.isEmpty(payCenterLogs)) {
            return null;
        }
        
        return payCenterLogs.get(0);
    }
    
    @Override
    public PayCenterLog getPayCenterLogByTradeOrderId(String tenantId, String tradeOrderId) {
        PayCenterLogCriteria sql = new PayCenterLogCriteria();
        Criteria criteria = sql.createCriteria(); 
        if(!StringUtil.isBlank(tenantId)) {
            criteria.andTenantIdEqualTo(tenantId);
        }
        criteria.andTradeOrderIdEqualTo(tradeOrderId);
        List<PayCenterLog> payCenterLogs = MapperFactory.getPayCenterLogMapper().selectByExample(sql);
        if(CollectionUtil.isEmpty(payCenterLogs)) {
            return null;
        }
        
        return payCenterLogs.get(0);    
    }    

    @Override
    public PayCenterLog getPayCenterLogByPayId(long payId) {
        return MapperFactory.getPayCenterLogMapper().selectByPrimaryKey(payId);
    }

    @Override
    public List<PayCenterLog> getPayCenterLogsByBatchNo(String tenantId, String batchNo,
            String payOrgSerial) {
        PayCenterLogCriteria sql = new PayCenterLogCriteria();
        Criteria criteria = sql.createCriteria();  
        if(!StringUtil.isBlank(tenantId)) {
            criteria.andTenantIdEqualTo(tenantId);
        }
        criteria.andBatchNoEqualTo(batchNo);
        if(!StringUtil.isBlank(payOrgSerial)) {
            criteria.andPayOrgSerialEqualTo(payOrgSerial);
        }
        return MapperFactory.getPayCenterLogMapper().selectByExample(sql);
    }

}
