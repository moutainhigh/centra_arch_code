package com.ifudata.ic.smc.preprocess.topology.core.util;

import java.util.Map;
import java.util.Properties;

import com.ifudata.dvp.sdk.util.RedisConfUtil;
import com.ifudata.ic.smc.preprocess.topology.core.constant.SmcConstants;

public class LoadConfUtil {

//    public static void loadPaasConf(Map<String, String> conf) {
//        Properties p = new Properties();
//        p.setProperty(SmcConstants.PAAS_AUTH_URL, conf.get(SmcConstants.PAAS_AUTH_URL));
//        p.setProperty(SmcConstants.PAAS_AUTH_PID, conf.get(SmcConstants.PAAS_AUTH_PID));
//        p.setProperty(SmcConstants.PAAS_CCS_SERVICEID, conf.get(SmcConstants.PAAS_CCS_SERVICEID));
//        p.setProperty(SmcConstants.PAAS_CCS_SERVICEPASSWORD,
//                conf.get(SmcConstants.PAAS_CCS_SERVICEPASSWORD));
//        ComponentConfigLoader.loadPaaSConf(p);
//    }

    public static void loadRedisConf(Map<String, Object> conf) {
    	RedisConfUtil.init(conf);
    }
}
