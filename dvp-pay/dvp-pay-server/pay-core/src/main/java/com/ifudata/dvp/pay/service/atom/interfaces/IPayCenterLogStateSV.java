package com.ifudata.dvp.pay.service.atom.interfaces;

import com.ifudata.dvp.pay.dao.mapper.bo.PayCenterLogState;


/**
 * 支付中心流水轨迹表基础服务接口定义
 * Date: 2015年8月18日 <br>
 */
public interface IPayCenterLogStateSV {

    void savePayCenterLogState(PayCenterLogState log);
    
}
