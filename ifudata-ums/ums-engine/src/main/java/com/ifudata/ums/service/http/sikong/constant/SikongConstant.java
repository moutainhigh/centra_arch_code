package com.ifudata.ums.service.http.sikong.constant;

import java.util.Map;
import java.util.Properties;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.ifudata.ums.util.PropertitesFiller;

public class SikongConstant {
	private static final Log log = LogFactory.getLog(SikongConstant.class);
	
	public static String CORP_ID;
	public static String CORP_PWD;
	public static String CORP_SERVICE;
	public static String USER_ID;
	public static String SENDTIME;
	public static String SUBMIT_URL;
	public static String HSUBMIT_URL;
	public static String GETFEE_URL;
	public static String REPORT_URL;
	public static String DELIVER_URL;
	public static String DELIVER_SLEEP;
	public static String CONTENT_TYPE;
	public static String PORT;
	public static String CONCURRENCY;
	public static String ACTIONNAME;
	public static String IPSWITCH;
	public static String IPS;
	
	public static String SVR_REPORT_URL;
	public static final String[][] SubmitErrMsg = { { "0", "成功" }, { "100", "余额不足" }, { "101", "账号关闭" }, {"102", "短信内容超过1000字（包括1000字）或为空" }, 
			{ "103", "手机号码超过200个或合法手机号码为空或者与通道类型不匹配" }, 
			{ "104", "corp_msg_id超过50个字符或没有传corp_msg_id字段" }, { "106", "用户名不存在" }, { "107", "密码错误" }, { "108", "指定访问ip错误" },
			{ "109", "业务代码不存在或者通道关闭" }, { "110", "扩展号不合法" }, { "9", "访问地址不存在"} };
	public static final String[][] HSubmitErrMsg = { { "0", "成功" }, { "100", "余额不足" }, { "101", "账号关闭" }, 
			{ "106", "用户名不存在" }, { "107", "密码错误" }, { "108", "指定访问ip错误" },
			{ "109", "业务代码不存在" }, { "114", "接口提交应为POST，不支持GET" }, 
			{ "115", "total_count 与实际短信条数无法匹配，即，实际短信条数与total_count不一致。如果要返回此参数，则本次提交的所有短信作废，不入库"}, 
			{ "116", "个性化短信提交个数超过200条" }, { "9", "访问地址不存在"} };
	public static final String[][] FeeErrMsg = { { "101", "账号关闭" }, {"104", "两次访问间隔小于200ms" }, 
			{ "106", "用户名不存在" }, 
			{ "107", "密码错误" }, { "108", "指定访问的IP错误" }, { "9", "访问地址不存在"} };
	public static final String[][] ReportErrMsg = { { "0", "成功" }, { "9", "访问地址不存在"}, 
			{ "-11", "账户关闭" }, { "-16", "用户名错误或用户名不存在" }, {"-17", "密码错误" }, 
			{ "-18", "不支持客户主动获取" }, 
			{ "-19", "用户访问超过我方限制频率（间隔200毫秒访问一次）" }, { "108", "指定访问IP错误" } };
	

	public static String CONTENT_SPILT;
	// 回车换行 \n
	public static String LINE_SPILT;

	public static Map<String, String> mapErr;
	
	static{

		Properties props = PropertitesFiller.fillPropertitesFromClassPath("conf/http/weilaiwuxian/weilaiwuxian.properties");
		if(props != null){
			CORP_ID = ((props.getProperty("corp_id")!=null&&!"".equals(props.getProperty("corp_id"))) ? props.getProperty("corp_id") : "");
			CORP_PWD = ((props.getProperty("corp_pwd")!=null&&!"".equals(props.getProperty("corp_pwd"))) ? props.getProperty("corp_pwd") : "");
			CORP_SERVICE = ((props.getProperty("corp_service")!=null&&!"".equals(props.getProperty("corp_service"))) ? props.getProperty("corp_service") : "");
			USER_ID = ((props.getProperty("user_id")!=null&&!"".equals(props.getProperty("user_id"))) ? props.getProperty("user_id") : "");
			SENDTIME = ((props.getProperty("sendtime")!=null&&!"".equals(props.getProperty("sendtime"))) ? props.getProperty("sendtime") : "");
			SUBMIT_URL = ((props.getProperty("submit_url")!=null&&!"".equals(props.getProperty("submit_url"))) ? props.getProperty("submit_url") : "");
			HSUBMIT_URL = ((props.getProperty("hsubmit_url")!=null&&!"".equals(props.getProperty("hsubmit_url"))) ? props.getProperty("hsubmit_url") : "");
			GETFEE_URL = ((props.getProperty("getfee_url")!=null&&!"".equals(props.getProperty("getfee_url"))) ? props.getProperty("getfee_url") : "");
			REPORT_URL = ((props.getProperty("report_url")!=null&&!"".equals(props.getProperty("report_url"))) ? props.getProperty("report_url") : "");
			DELIVER_URL = ((props.getProperty("deliver_url")!=null&&!"".equals(props.getProperty("deliver_url"))) ? props.getProperty("deliver_url") : "");
			DELIVER_SLEEP = ((props.getProperty("deliver_sleep")!=null&&!"".equals(props.getProperty("deliver_sleep"))) ? props.getProperty("deliver_sleep") : "");
			CONTENT_TYPE = ((props.getProperty("content_type")!=null&&!"".equals(props.getProperty("content_type"))) ? props.getProperty("content_type") : "");
			PORT = ((props.getProperty("port")!=null&&!"".equals(props.getProperty("port"))) ? props.getProperty("port") : "");
			CONCURRENCY = ((props.getProperty("concurrency")!=null&&!"".equals(props.getProperty("concurrency"))) ? props.getProperty("concurrency") : "");
			ACTIONNAME = ((props.getProperty("actionname")!=null&&!"".equals(props.getProperty("actionname"))) ? props.getProperty("actionname") : "");
			IPSWITCH = ((props.getProperty("ipswitch")!=null&&!"".equals(props.getProperty("ipswitch"))) ? props.getProperty("ipswitch") : "");
			IPS = ((props.getProperty("ips")!=null&&!"".equals(props.getProperty("ips"))) ? props.getProperty("ips") : "");
			SVR_REPORT_URL = ((props.getProperty("svr_report_url")!=null&&!"".equals(props.getProperty("svr_report_url"))) ? props.getProperty("svr_report_url") : "");
		}else{
			log.error("文件【sikong.properties】不存在");
		}
	}
	
	public static String getSubmitFailedReasonString(String strErr) {
		if (strErr.length() >= 3) {
			for (int iloop = 0; iloop < 12; iloop ++)
				if (SubmitErrMsg[iloop][0].equals(strErr))
				{
					return SubmitErrMsg[iloop][1];
				}
		}
		return "未知错误";
	}
	
	public static String getHSubmitFailedReasonString(String strErr)
	{
		if (strErr.length() >= 3) {
			for (int iloop = 0; iloop < 11; iloop ++)
				if (HSubmitErrMsg[iloop][0].equals(strErr)) {
					return HSubmitErrMsg[iloop][1];
				}
		}
		return "未知错误";
	}

	public static String getFeeFailedReasonString(String strErr)
	{
		if (strErr.length() >= 3) {
			for (int iloop = 0; iloop < 6; iloop ++)
				if (FeeErrMsg[iloop][0].equals(strErr)) {
					return FeeErrMsg[iloop][1];
				}
		}
		return "未知错误";
	}	
	
	public static String getReportFailedReasonString(String strErr)
	{
		if (strErr.length() >= 3) {
			for (int iloop = 0; iloop < 8; iloop ++)
				if (ReportErrMsg[iloop][0].equals(strErr)) {
					return ReportErrMsg[iloop][1];
				}
		}
		return "未知错误";
	}	
	
}
