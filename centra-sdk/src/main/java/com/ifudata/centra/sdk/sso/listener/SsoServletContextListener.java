package com.ifudata.centra.sdk.sso.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.ifudata.centra.sdk.component.ccs.util.ConfigTool;
import com.ifudata.centra.sdk.config.sso.SsoConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * sso 配置项加载监听器
 * 
 * Date: 2017年5月9日 <br>
 * Copyright (c) 2017 ifudata.com <br>
 * 
 * @author panyl
 */
public class SsoServletContextListener implements ServletContextListener {

    private static final Logger logger = LoggerFactory.getLogger(SsoServletContextListener.class);

    public void contextInitialized(ServletContextEvent event) {
        
        logger.info(" SSOServletContextListener start ... ");
        SsoConfig ssoConfig = ConfigTool.getSsoConfigByRest();
        logger.info(" casServerLoginUrl is  ... {} ",ssoConfig.getCasServerLoginUrl());
        event.getServletContext().setInitParameter("casServerLoginUrl",
                ssoConfig.getCasServerLoginUrl());
        event.getServletContext().setInitParameter("casServerUrlPrefix",
                ssoConfig.getCasServerUrlPrefix());
        event.getServletContext().setInitParameter("serverName", ssoConfig.getServerName());
       
    }

    public void contextDestroyed(ServletContextEvent event) {
        logger.info("Destroying SSOServletContextListener ");
    }
}
