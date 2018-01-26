package com.ifudata.dvp.pay.service.atom.impl;

import org.springframework.stereotype.Component;

import com.ifudata.dvp.pay.dao.mapper.bo.PayCenterLogState;
import com.ifudata.dvp.pay.dao.mapper.factory.MapperFactory;
import com.ifudata.dvp.pay.service.atom.interfaces.IPayCenterLogStateSV;


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
