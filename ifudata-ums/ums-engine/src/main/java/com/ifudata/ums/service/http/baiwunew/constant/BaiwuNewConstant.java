package com.ifudata.ums.service.http.baiwunew.constant;

import com.ifudata.ums.util.PropertitesFiller;

import java.util.Properties;

public class BaiwuNewConstant {

	public static final String[][] BWSendErrMsg = {
			{"-10", "余额不足"}, 
			{"-11", "账号关闭"},
			{"-12", "短信内容超过500字或为空"},
			{"-13", "手机号码超过200个或合法的手机号码为空，或者手机号码与通道代码正则不匹配"},
			{"-14", "msg_id超过50个字符或没有传msg_id字段"},
			{"-16", "用户名不存在"}, 
			{"-18", "访问ip错误"},
			{"-19", "密码错误 或者业务代码错误 或者通道关闭 或者业务关闭"},
			{"-20", "小号错误"}
		};

	public static final String[][] BWReceiveErrMsg = {
			{"-11", "账号关闭"},
			{"-16", "用户名错误或用户名不存在"}, 
			{"-17", "密码错误"},
			{"-18", "不支持客户主动获取"},
			{"-19", "用户访问超过我方限制频率（间隔200毫秒访问一次）"},
			{"108", "指定访问IP错误"}
		};
	
	public static String getSendFailedReasonString(String strErr) {
		if (strErr.length() >= 3) {
			for (int iloop = 0; iloop < 9; iloop ++)
				if (BaiwuNewConstant.BWSendErrMsg[iloop][0].equals(strErr.substring(0, 3)))
				{
					return BaiwuNewConstant.BWSendErrMsg[iloop][1];
				}
		}
			
		return "未知错误";
	}
	
	public static String getReceiveFailedReasonString(String strErr)
	{
		if (strErr.length() >= 3) {
			for (int iloop = 0; iloop < 9; iloop ++)
				if (BaiwuNewConstant.BWReceiveErrMsg[iloop][0].equals(strErr.substring(0, 3))) {
					return BaiwuNewConstant.BWReceiveErrMsg[iloop][1];
				}
		}
		
		return "未知错误";
	}
	
	public static String ID;
	public static String CORP_PWD;
	public static String CORP_SERVICE;
	public static String MD5_TD_CODE;
	public static String WRITE_URL;
	public static String READ_URL;
	public static String DELIVER_URL;
	public static String DELIVER_PORT;	
	public static String CONTENT_TYPE;


	public static String EXT;

	static
	{
		Properties props = PropertitesFiller.fillPropertitesFromClassPath("conf/http/baiwunew/baiwunew.properties");
		if (props != null) {

			ID = ((props.getProperty("id")!=null&&!"".equals(props.getProperty("id"))) ? props.getProperty("id") : "");
			CORP_PWD = ((props.getProperty("corp_pwd")!=null&&!"".equals(props.getProperty("corp_pwd"))) ? props.getProperty("corp_pwd") : "");
			MD5_TD_CODE = ((props.getProperty("MD5_td_code")!=null&&!"".equals(props.getProperty("MD5_td_code"))) ? props.getProperty("MD5_td_code") : "");
			
			WRITE_URL = ((props.getProperty("write_url")!=null&&!"".equals(props.getProperty("write_url"))) ? props.getProperty("write_url") : "");
			READ_URL = ((props.getProperty("read_url")!=null&&!"".equals(props.getProperty("read_url"))) ? props.getProperty("read_url") : "");
			DELIVER_URL = ((props.getProperty("deliver_url")!=null&&!"".equals(props.getProperty("deliver_url"))) ? props.getProperty("deliver_url") : "");
			DELIVER_PORT = ((props.getProperty("deliver_port")!=null&&!"".equals(props.getProperty("deliver_port"))) ? props.getProperty("deliver_port") : "");
			CONTENT_TYPE = ((props.getProperty("content_type")!=null&&!"".equals(props.getProperty("content_type"))) ? props.getProperty("content_type") : "");
			CORP_SERVICE = ((props.getProperty("corp_service")!=null&&!"".equals(props.getProperty("corp_service"))) ? props.getProperty("corp_service") : "");
			EXT = ((props.getProperty("ext")!=null&&!"".equals(props.getProperty("ext"))) ? props.getProperty("ext") : "");
		}
	}
}
