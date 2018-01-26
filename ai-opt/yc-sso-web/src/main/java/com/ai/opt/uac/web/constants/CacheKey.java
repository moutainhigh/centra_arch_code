package com.ai.opt.uac.web.constants;

import java.io.Serializable;

public class CacheKey implements Serializable {

	
	private static final long serialVersionUID = -5141871204873384493L;

	public final static class OrderType{
		private OrderType(){}
		  /**
	     * 口译
	     */
	    public static final String ORDER_TYPE_ORAL = "2";

	    /**
	     * 文档翻译
	     */
	    public static final String ORDER_TYPE_DOC = "1";

	    /**
	     * 快速翻译
	     */
	    public static final String ORDER_TYPE_FAST = "0";
	}
	
	/**
	 * 语言对
	 */
	public static final String DUAD_L_KEY = "DUAD_L";
	
	public static final String DUAD_D_KEY = "DUAD_D";
	
	/**
	 * 领域
	 */
    public static final String DOMAIN_L_KEY = "DOMAIN_L"; 
    
	public static final String DOMAIN_D_KEY = "DOMAIN_D";
	
	/**
	 * 用途
	 */
    public static final String PURPOSE_L_KEY = "PURPOSE_L";  
    
	public static final String PURPOSE_D_KEY = "PURPOSE_D";
	
	/**
	 * SEO
	 */
	public static final String SEOMANAGER_D_KEY = "SEOMANAGER_D";
	
	/**
	 * 首页数据配置
	 */
	public static final String HOME_DATA_CONFIG_KEY = "HOME_DATA_CONFIG";
	/**
	 * 国家
	 */
    public static final String COUNTRY_L_KEY = "COUNTRY_L"; 
    
	public static final String COUNTRY_D_KEY = "COUNTRY_D";

}