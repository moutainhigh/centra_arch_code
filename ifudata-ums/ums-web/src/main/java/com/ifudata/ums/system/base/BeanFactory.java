package com.ifudata.ums.system.base;

import javax.servlet.ServletContext;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * 
 * Title: ums-CRM <br>
 * Description: <br>
 * Date: 2014年2月28日 <br>
 * Copyright (c) 2014 ifudata <br>
 * 
 * @author liwenxian
 */
public class BeanFactory {
	static Logger logger = Logger.getLogger(BeanFactory.class);

	private static ApplicationContext ctx;

	public static void loadApplicationContext(ServletContext servletContext)
			throws Exception {
		ctx = WebApplicationContextUtils
				.getWebApplicationContext(servletContext);
	}

	public static Object getBean(String beanname) {
		return ctx.getBean(beanname);
	}

	public static void loadApplicationContext(String[] xmlConfig)
			throws Exception {
		ctx = new ClassPathXmlApplicationContext(xmlConfig);
	}
	public static ApplicationContext getApplicationContext() {
		return ctx;
	}
	public static void setApplicationContext(ApplicationContext applicationContext) {
		ctx = applicationContext;
	}
}
