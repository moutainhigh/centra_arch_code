package com.ai.runner.center.pay.service.atom.interfaces;

import com.ai.runner.center.pay.dao.mapper.bo.PayException;

/**
 * 支付中心异常记录基础服务接口定义
 * Date: 2017年5月11日 <br>
 * Copyright (c) 2017 asiainfo.com <br>
 * Created by liquid on 17/5/11.
 */
public interface IPayCenterExceptionSV {
    void savePayException(PayException payException);
}
