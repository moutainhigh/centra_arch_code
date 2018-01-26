package com.ifudata.ic.pay.web.business.payment.util.core;

import org.json.JSONObject;

import com.ifudata.ic.pay.web.business.payment.model.CommonPayRes;

/**
 * 返回值信息工具类
 * Description: <br>
 * Date: 2015年7月16日 <br>
 * 
 */
public class ResponseUtil {
    
    /**
     * 公共支付接口返回参数
     * @param commonPayRes
     * @return
     * @ApiDocMethod
     */
    public static String getCommonPayResponse(CommonPayRes commonPayRes){
        JSONObject json = new JSONObject();
        json.put("tenantId", commonPayRes.getTenantId());
        json.put("orderId", commonPayRes.getOrderId());
        json.put("returnCode", commonPayRes.getReturnCode());
        json.put("errCode", commonPayRes.getErrCode());
        json.put("errMsg", commonPayRes.getErrMsg());
        json.put("payOrgCode", commonPayRes.getPayOrgCode());
        json.put("payCenterOrderId", commonPayRes.getPayCenterOrderId());
        json.put("preOrderId", commonPayRes.getPreOrderId());
        json.put("subject", commonPayRes.getSubject());
        json.put("orderAmount", commonPayRes.getOrderAmount());
        json.put("payCenterNotifyUrl", commonPayRes.getPayCenterNotifyUrl());
        json.put("requestSource", commonPayRes.getRequestSource());
        json.put("infoMd5", commonPayRes.getInfoMd5());        
        return json.toString();
    }
}
