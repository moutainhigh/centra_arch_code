package com.ifudata.ic.pay.service.atom.impl;

import org.springframework.stereotype.Component;

import com.ifudata.ic.pay.dao.mapper.bo.PayCenterLogState;
import com.ifudata.ic.pay.dao.mapper.factory.MapperFactory;
import com.ifudata.ic.pay.service.atom.interfaces.IPayCenterLogStateSV;


/**
 * 支付中心流水轨迹基础服务实现类
 */
@Component
public class PayCenterLogStateSVImpl implements IPayCenterLogStateSV {

    @Override
    public void savePayCenterLogState(PayCenterLogState log) {
        MapperFactory.getPayCenterLogStateMapper().insert(log);
    }

}
