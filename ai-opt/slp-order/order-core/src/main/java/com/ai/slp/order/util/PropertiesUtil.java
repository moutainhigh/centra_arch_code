package com.ai.slp.order.util;
import java.util.Properties;  
import java.util.concurrent.ConcurrentHashMap;  
import java.util.concurrent.ConcurrentMap;  


/**
 * 读取配置文件工具类
 * Date: 2016年12月27日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * 
 * @author zhangqiang7
 */
public class PropertiesUtil {

	private static ResourceLoader loader = ResourceLoader.getInstance();  
	    private static ConcurrentMap<String, String> configMap = new ConcurrentHashMap<String, String>();  
	    private static final String DEFAULT_CONFIG_FILE = "ofcConfig.properties";  
	  
	    private static Properties prop = null;  
	    
	    /**
	     * 读取properties文件信息
	     */
	    public static String getStringByKey(String key, String propName) {  
	        try {  
	            prop = loader.getPropFromProperties(propName);  
	        } catch (Exception e) {  
	            throw new RuntimeException(e);  
	        }  
	        key = key.trim();  
	        if (!configMap.containsKey(key)) {  
	            if (prop.getProperty(key) != null) {  
	                configMap.put(key, prop.getProperty(key));  
	            }  
	        }  
	        return configMap.get(key);  
	    }  
	  
	    /**
	     * 读取properties文件信息
	     * @param key
	     * @return
	     * @author zhangqiang7
	     * @UCUSER
	     */
	    public static String getStringByKey(String key) {  
	        return getStringByKey(key, DEFAULT_CONFIG_FILE);  
	    }  
	  
	    /**
	     * 读取properties文件信息
	     * @return
	     * @author zhangqiang7
	     * @UCUSER
	     */
	    public static Properties getProperties() {  
	        try {  
	            return loader.getPropFromProperties(DEFAULT_CONFIG_FILE);  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	            return null;  
	        }  
	    }  
}
