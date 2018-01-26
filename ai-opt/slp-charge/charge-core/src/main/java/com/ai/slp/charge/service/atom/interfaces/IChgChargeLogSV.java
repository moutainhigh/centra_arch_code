package com.ai.slp.charge.service.atom.interfaces;

import com.ai.opt.base.vo.PageInfo;
import com.ai.slp.charge.api.paymentquery.param.ChargeInfoQueryByAcctIdParam;
import com.ai.slp.charge.api.paymentquery.param.ChargeInfoQueryByCustIdParam;
import com.ai.slp.charge.dao.mapper.bo.ChgChargeLog;

/**
 * 收费流水记录表操作服务 <br>
 * Date: 2015年8月7日 <br>
 * Copyright (c) 2015 asiainfo.com <br>
 * 
 * @author LiangMeng
 */
public interface IChgChargeLogSV {

    void saveChgChargeLog(ChgChargeLog log);
    
    ChgChargeLog getChgChargeLogByChargeId(long chargeId); 
    
    ChgChargeLog queryChgChargeLogByOrderId(String tenantId, String orderId);
    
    PageInfo<ChgChargeLog> queryChgChargeLogByCustId(ChargeInfoQueryByCustIdParam param);
    
    PageInfo<ChgChargeLog> queryChgChargeLogByAcctId(ChargeInfoQueryByAcctIdParam param);
  
}
