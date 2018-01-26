package com.ifudata.dvp.pay.web.business.payment.util.third.cib;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cib.cap4i.appsvr.base.common.AppException;
import com.cib.cap4i.appsvr.client.AppClientService;
import com.ifudata.dvp.pay.web.system.listener.PaymentListener;

/**
 * 使用单例的方式初始化方式，让客户端服务类只初始化一次
 *
 * Date: 2016年1月12日 <br>
 */
public class AppClientServiceHolder {
    
    private static final Logger LOG = LoggerFactory.getLogger(PaymentListener.class);
    
    private static final String CONFIG_PATH = "/appsvr_conf.properties";

    private static class InstanceHolder {

        private static final AppClientServiceHolder instance = new AppClientServiceHolder();

    }

    public static AppClientServiceHolder getInstance() {
        return InstanceHolder.instance;
    }
    
    private AppClientService appClientService;
    
    private AppClientServiceHolder() {
        try {
            appClientService = new AppClientService(CONFIG_PATH);
        } catch (AppException ex) {
            LOG.error("初始化兴业客户端服务类失败", ex);
        }
    }

    public AppClientService getAppClientService() {
        return appClientService;
    }
}
