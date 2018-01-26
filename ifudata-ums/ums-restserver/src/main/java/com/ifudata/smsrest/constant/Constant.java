package com.ifudata.smsrest.constant;

import com.ifudata.smsrest.util.PropertitesFiller;

import java.util.Properties;

public class Constant {

	public static final String[][] SendErrMsg = {
			{"0","发送成功"},
			{"1","IP限制"},
			{"2","用户不正确"},
			{"3","密码错误"},
			{"4","内容编码不正确"},
			{"5","手机号码有误"},
			{"6","Json格式错误"},
			{"7","内部错误"}
		};

	public static final String[][] ReceiveErrMsg = {
			{"0","暂时没有待推送的数据"},
			{"1","内容编码不正确"},
			{"2","手机号码有误"},
			{"3","密码错误"},
			{"4","Json格式错误"},
			{"5","内部错误"}
		};
	
	public static String getSendFailedReasonString(String strErr) {
		if (strErr.length() >= 3) {
			for (int iloop = 0; iloop < 9; iloop ++)
				if (Constant.SendErrMsg[iloop][0].equals(strErr.substring(0, 3)))
				{
					return Constant.SendErrMsg[iloop][1];
				}
		}
			
		return "未知错误";
	}
	
	public static String getReceiveFailedReasonString(String strErr)
	{
		if (strErr.length() >= 3) {
			for (int iloop = 0; iloop < 9; iloop ++)
				if (Constant.ReceiveErrMsg[iloop][0].equals(strErr.substring(0, 3))) {
					return Constant.ReceiveErrMsg[iloop][1];
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
	public static String REST_URL;
	public static String DELIVER_PORT;
	public static String SUBMIT_PORT;	
	public static String CONTENT_TYPE;
	public static String TEMPLATE_ID;
	public static String SRC_NAME;
	public static String TEMPLATE_BATCH_ID;
	public static String SRC_BATCH_NAME;
	public static String EXT;

	static
	{
		Properties props = PropertitesFiller.fillPropertitesFromClassPath("conf/spcorp.properties");
		if (props != null) {

			ID = ((props.getProperty("id")!=null&&!"".equals(props.getProperty("id"))) ? props.getProperty("id") : "");
			CORP_PWD = ((props.getProperty("corp_pwd")!=null&&!"".equals(props.getProperty("corp_pwd"))) ? props.getProperty("corp_pwd") : "");
			CORP_SERVICE = ((props.getProperty("corp_service")!=null&&!"".equals(props.getProperty("corp_service"))) ? props.getProperty("corp_service") : "");
			MD5_TD_CODE = ((props.getProperty("MD5_td_code")!=null&&!"".equals(props.getProperty("MD5_td_code"))) ? props.getProperty("MD5_td_code") : "");
			REST_URL = ((props.getProperty("rest_url")!=null&&!"".equals(props.getProperty("rest_url"))) ? props.getProperty("rest_url") : "http://127.0.0.1");
			SUBMIT_PORT = ((props.getProperty("submit_port")!=null&&!"".equals(props.getProperty("submit_port"))) ? props.getProperty("submit_port") : "38090");
			DELIVER_PORT = ((props.getProperty("deliver_port")!=null&&!"".equals(props.getProperty("deliver_port"))) ? props.getProperty("deliver_port") : "38091");
			CONTENT_TYPE = ((props.getProperty("content_type")!=null&&!"".equals(props.getProperty("content_type"))) ? props.getProperty("content_type") : "");
			TEMPLATE_ID = ((props.getProperty("template_id")!=null&&!"".equals(props.getProperty("template_id"))) ? props.getProperty("template_id") : "400");
			SRC_NAME = ((props.getProperty("src_name")!=null&&!"".equals(props.getProperty("src_name"))) ? props.getProperty("src_name") : "SMSPROXY");
			TEMPLATE_BATCH_ID = ((props.getProperty("template_batch_id")!=null&&!"".equals(props.getProperty("template_batch_id"))) ? props.getProperty("template_batch_id") : "401");
			SRC_BATCH_NAME = ((props.getProperty("src_batch_name")!=null&&!"".equals(props.getProperty("src_batch_name"))) ? props.getProperty("src_batch_name") : "SMSBATCHBUS");
			EXT = ((props.getProperty("ext")!=null&&!"".equals(props.getProperty("ext"))) ? props.getProperty("ext") : "");
		}
	}
}
