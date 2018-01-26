package com.ifudata.ums.service.http.baiwu.constant;

import com.ifudata.ums.util.PropertitesFiller;

import java.util.Properties;



public class BaiwuConstant {

	public static String WRITE_URL;
	public static String READ_URL;
	public static String DELIVER_URL;
	public static String DELIVER_PORT;
	public static String CONTENT_TYPE;
	public static String CORP_ID;
	public static String USER_ID;
	public static String USER_PWD;
	public static String CORP_SERVICE;
	public static String EXT;

	static
	{
		Properties props = PropertitesFiller.fillPropertitesFromClassPath("conf/http/baiwu/baiwu.properties");
		if(props != null){

			WRITE_URL = ((props.getProperty("write_url")!=null&&!"".equals(props.getProperty("write_url"))) ? props.getProperty("write_url") : "");
			READ_URL = ((props.getProperty("read_url")!=null&&!"".equals(props.getProperty("read_url"))) ? props.getProperty("read_url") : "");
			DELIVER_URL = ((props.getProperty("deliver_url")!=null&&!"".equals(props.getProperty("deliver_url"))) ? props.getProperty("deliver_url") : "");
			DELIVER_PORT = ((props.getProperty("deliver_port")!=null&&!"".equals(props.getProperty("deliver_port"))) ? props.getProperty("deliver_port") : "");
			CONTENT_TYPE = ((props.getProperty("content_type")!=null&&!"".equals(props.getProperty("content_type"))) ? props.getProperty("content_type") : "");
			CORP_ID = ((props.getProperty("corp_id")!=null&&!"".equals(props.getProperty("corp_id"))) ? props.getProperty("corp_id") : "");
			USER_ID = ((props.getProperty("user_id")!=null&&!"".equals(props.getProperty("user_id"))) ? props.getProperty("user_id") : "");
			USER_PWD = ((props.getProperty("user_pwd")!=null&&!"".equals(props.getProperty("user_pwd"))) ? props.getProperty("user_pwd") : "");
			CORP_SERVICE = ((props.getProperty("corp_service")!=null&&!"".equals(props.getProperty("corp_service"))) ? props.getProperty("corp_service") : "");
			EXT = ((props.getProperty("ext")!=null&&!"".equals(props.getProperty("ext"))) ? props.getProperty("ext") : "");
		}
	}
	
}
