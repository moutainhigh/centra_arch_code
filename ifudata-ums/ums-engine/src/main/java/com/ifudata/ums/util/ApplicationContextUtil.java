package com.ifudata.ums.util;

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
        ctx =  new ClassPathXmlApplicationContext("conf/applicationContext-mybatis.xml"); //classpath*:
    }
//    public ApplicationContext getCtx(){
//        return ctx;
//    }

    public Object getBean(String beanName){
        return ctx.getBean(beanName);
    }

}
