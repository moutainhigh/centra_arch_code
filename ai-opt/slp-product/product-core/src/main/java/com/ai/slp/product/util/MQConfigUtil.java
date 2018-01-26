package com.ai.slp.product.util;

import com.ai.opt.sdk.components.ccs.CCSClientFactory;
import com.ai.slp.product.constants.NormProdConstants;

public class MQConfigUtil {
	/** 
     * 从配置中心获取是否使用mq的标识 
     *  
     * @return true：使用mq；false：不使用mq 
     */  
    public static boolean getCCSMqFlag() {  
    	boolean ccsMqFlag=false;
        try {  
            String strCcsMqFlag=CCSClientFactory.getDefaultConfigClient().get(NormProdConstants.MDSNS.CCS_MQ_FLAG);
            ccsMqFlag=Boolean.valueOf(strCcsMqFlag);
        } catch(Exception e) {  
        	//异常情况，视为不启用mq
        }  
        return ccsMqFlag;  
    }  
}
