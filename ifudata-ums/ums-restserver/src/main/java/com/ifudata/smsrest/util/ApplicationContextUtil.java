package com.ifudata.smsrest.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by lvsj on 2015/9/30.
 */
public class ApplicationContextUtil {
    private static ApplicationContextUtil ourInstance = new ApplicationContextUtil();

    public static ApplicationContextUtil getInstance() {
        return ourInstance;
    }
    private static ApplicationContext ctx;
    private ApplicationContextUtil() {
        try {
			ctx =  new ClassPathXmlApplicationContext("classpath*:conf/applicationContext-mybatis.xml");//applicationContext-mybatis.xml
        	//ctx =  new ClassPathXmlApplicationContext("classpath*:conf/a.xml");
		} catch (BeansException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
//    public ApplicationContext getCtx(){
//        return ctx;
//    }

    public Object getBean(String beanName){
        return ctx.getBean(beanName);
    }

}
