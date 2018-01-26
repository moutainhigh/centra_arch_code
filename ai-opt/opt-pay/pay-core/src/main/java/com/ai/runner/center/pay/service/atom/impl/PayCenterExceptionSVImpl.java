package com.ai.runner.center.pay.service.atom.impl;

import com.ai.runner.center.pay.dao.mapper.bo.PayException;
import com.ai.runner.center.pay.dao.mapper.factory.MapperFactory;
import com.ai.runner.center.pay.service.atom.interfaces.IPayCenterExceptionSV;
import org.springframework.stereotype.Component;

/**
 * Created by liquid on 17/5/11.
 */
@Component
public class PayCenterExceptionSVImpl implements IPayCenterExceptionSV{
    @Override
    public void savePayException(PayException payException) {
        MapperFactory.getPayExceptionMapper().insert(payException);
    }
}
