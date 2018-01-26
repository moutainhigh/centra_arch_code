package com.ifudata.dvp.pay.util;

import com.ifudata.dvp.sdk.component.sequence.util.SeqUtil;

/**
 * 支付中心序列工具类
 * Date: 2015年8月13日 <br>
 */
public final class PaySeqUtil {
    
    private PaySeqUtil() {
        
    }
    
    /**
     * 获取支付流水号
     * @return
     * @ApiDocMethod
     */
    public static Long createPayId() {
        return SeqUtil.getNewId("PAY_CENTER_LOG$PAY_ID$SEQ");
    }
}
