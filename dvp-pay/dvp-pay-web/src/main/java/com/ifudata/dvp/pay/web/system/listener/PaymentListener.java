package com.ifudata.dvp.pay.web.system.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ifudata.dvp.pay.web.business.payment.util.third.unionpay.sdk.SDKConfig;


/**
 * 支付平台监听器
 *
 * Date: 2015年12月7日 <br>
 */
public class PaymentListener implements ServletContextListener {

    private static final Logger LOG = LoggerFactory.getLogger(PaymentListener.class);
    
    @Override
    public void contextDestroyed(ServletContextEvent arg0) {

    }

    @Override
    public void contextInitialized(ServletContextEvent arg0) {
        try {
            SDKConfig.getConfig().loadPropertiesFromSrc();
            LOG.info("Application initialize successfully!");
        } catch(Exception ex) {
            LOG.error("加载银联支付配置文件出错！");
        }
    }

}
