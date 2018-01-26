package com.ifudata.ums.service.http.byd.constant;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import com.ifudata.ums.util.PropertitesFiller;

public class BYDConstant {

	public static final String[][] BYDSMSErrMsg = { { "100", "成功" }, { "101", "失败" }, { "102", "验证失败" },
			{ "103", "号码有错" }, { "104", "内容有错" }, { "105", "操作频率过快" }, { "106", "限制发送" }, { "107", "参数不全" } };

	// 100 执行成功 101 失败
	public static final String C_BYD_SMSRESPONE_SUCCESS = "100";
	public static final String C_BYD_SMSRESPONE_FAILED = "101";

	public static final String C_BYD_SMS_GETMO = "getmo";
	public static final String C_BYD_SMS_GETMT = "send";
	public static final String C_BYD_SMS_GETSTATUS = "getstatus";
	public static final String C_BYD_SMS_GETNUM = "getnum";

	// 参数 psw为md5之后的数据
	public static String UID;
	public static String PSW;
	public static String MSGFORMAT;
	public static String GETMO_URL;
	public static String GETMT_URL;
	public static String GETSTATUS_URL;
	public static String GETNUM_URL;
	// application/x-www-form-urlencoded;charset=UTF-8
	public static String CONTENT_TYPE;
	// 内容分隔符 #
	public static String CONTENT_SPILT;
	// 回车换行 \n
	public static String LINE_SPILT;

	public static String CONCURRENCY;
	public static String PORT;
	public static String ACTIONNAME;

	public static Map<String, String> mapErr;

	static {
		Properties props = PropertitesFiller.fillPropertitesFromClassPath("conf/http/byd/byd.properties");
		if (props != null) {

			UID = ((props.getProperty("uid") != null && !"".equals(props.getProperty("uid"))) ? props.getProperty("uid")
					: "");
			PSW = ((props.getProperty("psw") != null && !"".equals(props.getProperty("psw"))) ? props.getProperty("psw")
					: "");
			MSGFORMAT = ((props.getProperty("msgformat") != null && !"".equals(props.getProperty("msgformat")))
					? props.getProperty("msgformat") : "0");

			GETMO_URL = ((props.getProperty("getmo_url") != null && !"".equals(props.getProperty("getmo_url")))
					? props.getProperty("getmo_url") : "");
			GETMT_URL = ((props.getProperty("getmt_url") != null && !"".equals(props.getProperty("getmt_url")))
					? props.getProperty("getmt_url") : "");
			GETSTATUS_URL = ((props.getProperty("getstatus_url") != null
					&& !"".equals(props.getProperty("getstatus_url"))) ? props.getProperty("getstatus_url") : "");
			GETNUM_URL = ((props.getProperty("getnum_url") != null && !"".equals(props.getProperty("getnum_url")))
					? props.getProperty("getnum_url") : "");
			CONTENT_TYPE = ((props.getProperty("content_type") != null && !"".equals(props.getProperty("content_type")))
					? props.getProperty("content_type") : "");
			CONTENT_SPILT = ((props.getProperty("content_spilt") != null
					&& !"".equals(props.getProperty("content_spilt"))) ? props.getProperty("content_spilt") : "#");
			LINE_SPILT = ((props.getProperty("line_spilt") != null && !"".equals(props.getProperty("line_spilt")))
					? props.getProperty("line_spilt") : "\n");

			CONCURRENCY = ((props.getProperty("concurrency") != null && !"".equals(props.getProperty("concurrency")))
					? props.getProperty("concurrency") : "");
			PORT = ((props.getProperty("port") != null && !"".equals(props.getProperty("port")))
					? props.getProperty("port") : "");
			ACTIONNAME = ((props.getProperty("actionName") != null && !"".equals(props.getProperty("actionName")))
					? props.getProperty("actionName") : "");
		}

		mapErr = new HashMap<String, String>();
		for (int iloop = 0; iloop < 8; iloop++)
			mapErr.put(BYDSMSErrMsg[iloop][0], BYDSMSErrMsg[iloop][1]);
	}
}
