package com.ifudata.ums.service.http.weilaiwuxian.constant;

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
public class WeilaiwuxianConstant {
	private static final Log log = LogFactory.getLog(SMSender.class);
	public static String CUST_CODE;
	public static String SP_CODE;
	public static String WRITE_URL;
	public static String CONTENT_TYPE;
	public static String READ_URL;
	public static String PWD;
	//接收状态报告等信息
	public static String ACTIONNAME;
	public static String CONCURRENCY;
	public static String PORT;
	public static String IPSWITCH;
	public static String IPS;
	
	public static Map<String,String> RESPONSEMSG = new HashMap<String, String>();
	
	static{

		Properties props = PropertitesFiller.fillPropertitesFromClassPath("conf/http/weilaiwuxian/weilaiwuxian.properties");
		if(props != null){
			CUST_CODE = ((props.getProperty("cust_code")!=null&&!"".equals(props.getProperty("cust_code"))) ? props.getProperty("cust_code") : "");
			SP_CODE = ((props.getProperty("sp_code")!=null&&!"".equals(props.getProperty("sp_code"))) ? props.getProperty("sp_code") : "");
			PWD = ((props.getProperty("password")!=null&&!"".equals(props.getProperty("password"))) ? props.getProperty("password") : "");
			WRITE_URL = ((props.getProperty("write_url")!=null&&!"".equals(props.getProperty("write_url"))) ? props.getProperty("write_url") : "");
			CONTENT_TYPE = ((props.getProperty("content_type")!=null&&!"".equals(props.getProperty("content_type"))) ? props.getProperty("content_type") : "");
			READ_URL = ((props.getProperty("read_url")!=null&&!"".equals(props.getProperty("read_url"))) ? props.getProperty("read_url") : "");
		
			
			ACTIONNAME = ((props.getProperty("actionName")!=null&&!"".equals(props.getProperty("actionName"))) ? props.getProperty("actionName") : "");
			CONCURRENCY = ((props.getProperty("concurrency")!=null&&!"".equals(props.getProperty("concurrency"))) ? props.getProperty("concurrency") : "");
			PORT = ((props.getProperty("port")!=null&&!"".equals(props.getProperty("port"))) ? props.getProperty("port") : "");
			IPSWITCH = ((props.getProperty("IPSwitch")!=null&&!"".equals(props.getProperty("IPSwitch"))) ? props.getProperty("IPSwitch") : "");
			IPS = ((props.getProperty("IPS")!=null&&!"".equals(props.getProperty("IPS"))) ? props.getProperty("IPS") : "");
			//returnMsg
			RESPONSEMSG.put("0", (props.getProperty("responseMsg.0")!=null&&!"".equals(props.getProperty("responseMsg.0"))) ? props.getProperty("responseMsg.0") : "");
			RESPONSEMSG.put("-1", (props.getProperty("responseMsg.-1")!=null&&!"".equals(props.getProperty("responseMsg.-1"))) ? props.getProperty("responseMsg.-1") : "");
			
		}else{
			log.error("文件【weilaiwuxian.properties】不存在");
		}
	}
}

