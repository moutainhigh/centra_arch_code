package com.ifudata.ums.service.http.dahansantong.constant;

import com.ifudata.ums.core.SMSender;
import com.ifudata.ums.util.PropertitesFiller;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;



/**
 *
 * 2015年7月29日下午4:55:43
 * hongzhenfu
 *
 */
public class DaHanSanTongConstant {
	private static final Log log = LogFactory.getLog(SMSender.class);
	public static String ACCOUNT;
	public static String PASSWORD;
	public static String SIGN;
	public static String SUBCODE;
	public static String SENDTIME;
	
	public static String SUBMIT_URL;
	public static Map<String,String> SUBMIT_CODE = new HashMap<>();
	
	public static String REPORT_URL;
	public static String REPORT_SLEEP;
	public static Map<String,String> REPORT_CODE = new HashMap<>();
	
	public static String DELIVER_URL;
	public static String CONTENT_TYPE;
	public static String DELIVER_SLEEP;
	
//	public static Map<String,String> RESPONSEMSG = new HashMap<String, String>();
	
	public static String DHSTSendErr[][] = {
			{"0", "提交成功"},
			{"1", "账号无效"},
			{"2", "密码错误"},
			{"3", "msgid太长，不得超过32位"},
			{"4", "错误号码/限制运营商号码"},
			{"5", "手机号码个数超过最大限制(500个)"},
			{"6", "短信内容超过最大限制(350字)"},
			{"7", "扩展子号码无效"},
			{"8", "定时时间格式错误"},
			{"14", "手机号码为空"},
			{"19", "用户被禁发或禁用"},
			{"20", "ip鉴权失败"},
			{"21", "短信内容为空"},
			{"22", "数据包大小不匹配"},
			{"98", "系统正忙"},
			{"99", "消息格式错误"}
	};
	
	public static String DHSTReceiveErr[][] = {
			{"4", "手机号码无效"},
			{"5", "签名不合法"},
			{"6", "短信内容超过最大限制"},
			{"9", "请求来源地址无效"},
			{"10", "内容包含敏感词"},
			{"11", "余额不足"},
			{"12", "购买产品或订购还未生效或产品已暂停使用"},
			{"13", "账号被禁用或禁发"},
			{"14", "不支持该运营商"},
			{"16", "发送号码数没有达到该产品的最小发送数"},
			{"19", "黑名单号码"},
			{"20", "该模板ID已被禁用"},
			{"21", "非法模板ID"},
			{"22", "不支持的MSGFMT"},
			{"23", "子号码无效"},
			{"24", "内容为空"},
			{"25", "号码为空"},
			{"26", "单个号码相同内容限制"},
			{"27", "单个号码次数限制"},
			{"96", "处理失败"},
			{"97", "接入方式错误"},
			{"98", "系统繁忙"},
			{"99", "消息格式错误"}
	};
	
	static{

		Properties props = PropertitesFiller.fillPropertitesFromClassPath("conf/http/dahansantong/dahansantong.properties");
		if(props != null){
			ACCOUNT = ((props.getProperty("account")!=null&&!"".equals(props.getProperty("account"))) ? props.getProperty("account") : "");
			PASSWORD = ((props.getProperty("password")!=null&&!"".equals(props.getProperty("password"))) ? props.getProperty("password") : "");
			SIGN = ((props.getProperty("sign")!=null&&!"".equals(props.getProperty("sign"))) ? props.getProperty("sign") : "");
			SUBCODE = ((props.getProperty("subcode")!=null&&!"".equals(props.getProperty("subcode"))) ? props.getProperty("subcode") : "");
			SENDTIME = ((props.getProperty("sendtime")!=null&&!"".equals(props.getProperty("sendtime"))) ? props.getProperty("sendtime") : "");
			
			SUBMIT_URL = ((props.getProperty("submit_url")!=null&&!"".equals(props.getProperty("submit_url"))) ? props.getProperty("submit_url") : "");
			String submit[] =((props.getProperty("submit_code")!=null&&!"".equals(props.getProperty("submit_code"))) ? props.getProperty("submit_code") : "").split(";");
			for(int subEach=0;subEach<submit.length;subEach++){
				SUBMIT_CODE.put(submit[subEach].split("_")[0],submit[subEach].split("_")[1]);
			}
			
			REPORT_URL = ((props.getProperty("report_url")!=null&&!"".equals(props.getProperty("report_url"))) ? props.getProperty("report_url") : "");
			String report[] =((props.getProperty("report_code")!=null&&!"".equals(props.getProperty("report_code"))) ? props.getProperty("report_code") : "").split(";");
			for(int repEach=0;repEach<report.length;repEach++){
				REPORT_CODE.put(report[repEach].split("_")[0],report[repEach].split("_")[1]);
			}
			
			DELIVER_URL = ((props.getProperty("deliver_url")!=null&&!"".equals(props.getProperty("deliver_url"))) ? props.getProperty("deliver_url") : "");
			CONTENT_TYPE = ((props.getProperty("content_type")!=null&&!"".equals(props.getProperty("content_type"))) ? props.getProperty("content_type") : "");
			
			REPORT_SLEEP = ((props.getProperty("report_sleep")!=null&&!"".equals(props.getProperty("report_sleep"))) ? props.getProperty("report_sleep") : "");
			DELIVER_SLEEP = ((props.getProperty("deliver_sleep")!=null&&!"".equals(props.getProperty("deliver_sleep"))) ? props.getProperty("deliver_sleep") : "");
			
			
//			RESPONSEMSG.put("0", (props.getProperty("responseMsg.0")!=null&&!"".equals(props.getProperty("responseMsg.0"))) ? props.getProperty("responseMsg.0") : "");
//			RESPONSEMSG.put("-1", (props.getProperty("responseMsg.-1")!=null&&!"".equals(props.getProperty("responseMsg.-1"))) ? props.getProperty("responseMsg.-1") : "");
			
		}else{
			log.error("文件【dahansantong.properties】不存在");
		}
	}
}

