package com.ifudata.ums.service.http.dahansantong.client.Submit;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;




import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ifudata.ums.core.SMAbstractClient;
import com.ifudata.ums.constant.Constant;
import com.ifudata.ums.service.http.dahansantong.constant.DaHanSanTongConstant;
import com.ifudata.ums.service.http.dahansantong.until.MD;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

/**
 *
 * 2015年10月9日下午3:54:52
 * hongzhenfu
 *
 */
public class DHSTClientSubmit extends SMAbstractClient {
	
	private static final Log log = LogFactory.getLog(DHSTClientSubmit.class);
	@Override
	public Map<String, Object> writeMessage(String userNumber, String content) {
		// TODO Auto-generated method stub
        log.debug("********** DHSTClientSubmit下行，大汉三通http发送 : 号码 ：["
                + userNumber
                + "]；内容：[" + content + "] **********");
        Map<String, Object> status = new HashMap<String, Object>();
        Map<String, String> sendMessage = new HashMap<String, String>();
        
    	
		try {
			URL myurl = new URL(DaHanSanTongConstant.SUBMIT_URL);
			URLConnection urlc = myurl.openConnection();
			urlc.setReadTimeout(1000 * 30);
			urlc.setDoOutput(true);
			urlc.setDoInput(true);
			urlc.setAllowUserInteraction(false);
			String pwd = MD.md5(DaHanSanTongConstant.PASSWORD);
	        sendMessage.put("account", DaHanSanTongConstant.ACCOUNT);
//	        sendMessage.put("password", "de605371dd3fc51383ef24a437a7a1b2");
	        sendMessage.put("password", pwd);
	        sendMessage.put("msgid", "");
	        sendMessage.put("phones", userNumber);
	        sendMessage.put("content", content);
	        sendMessage.put("sign", DaHanSanTongConstant.SIGN);
	        sendMessage.put("subcode", DaHanSanTongConstant.SUBCODE);
//	        sendMessage.put("sendtime", DateUtil.getDateString(DaHanSanTongConstant.SENDTIME, null));
	        sendMessage.put("sendtime", "");
			
			DataOutputStream server = new DataOutputStream(urlc.getOutputStream());
			server.write(JSON.toJSONString(sendMessage).getBytes("utf-8"));
	        log.debug("********** DHSTClientSubmit 大汉三通http下行  发送地址： ["
	                + DaHanSanTongConstant.SUBMIT_URL + "]; account：["
	                + DaHanSanTongConstant.ACCOUNT + "]; password：["
	                + DaHanSanTongConstant.PASSWORD+"]; 加密后password:["+ pwd +"] 直接赋值的密码[de605371dd3fc51383ef24a437a7a1b2] sign:["
	                + DaHanSanTongConstant.SIGN+"]; subcode:["
	                + DaHanSanTongConstant.SUBCODE+"]; sendtime:[]; phones:["+ userNumber+"]; content:["+content+"] **********");
			server.close();

			BufferedReader in = new BufferedReader(new InputStreamReader(
					urlc.getInputStream(), "utf-8"));
			String result = "", s = "";
			while ((s = in.readLine()) != null)
				result = result + s;
			in.close();
//			log.debug("接收数据=" + URLDecoder.decode(result,"utf-8"));
			Map<String,String> jsonMap = JSON.parseObject(result, new TypeReference<Map<String, String>>() {});
			if(jsonMap.get("result").equals("0")){
				status.put("RESULT_CODE", "0");
                status.put("msgId", jsonMap.get("msgid"));
                log.debug("********** DHSTClientSubmit短信发送成功 接收到的响应值msgid:["+jsonMap.get("msgid")+"] result:["+jsonMap.get("result")+"] desc:["+jsonMap.get("desc")+"] failPhones:["+jsonMap.get("failPhones")+"]");
			}else{
				log.error("********** DHSTClientSubmit短信发送失败 接收到的响应值msgid:["+jsonMap.get("msgid")+"] result:["+jsonMap.get("result")+"] desc:["+jsonMap.get("desc")+"] failPhones:["+jsonMap.get("failPhones")+"]");
                status.put("RESULT_CODE", "-1");
                status.put("msgId", jsonMap.get("msgid"));
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			log.error("********** submit_url无法连接，请查看url配置是否正确以及有效 **********");
			log.error(e.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			log.error("********** submit_url无法连接，请查看url配置是否正确以及有效 **********");
			log.error(e.toString());
		}
		return status;
	}

	@Override
	public Map<String, Object> readMessage() {
		// TODO Auto-generated method stub
		
		Map<String, Object> status = new HashMap<String, Object>();
	    Map<String, String> sendMessage = new HashMap<String, String>();
		try {
			URL myurl = new URL(DaHanSanTongConstant.REPORT_URL);
			URLConnection urlc = myurl.openConnection();
			urlc.setReadTimeout(1000 * 30);
			urlc.setDoOutput(true);
			urlc.setDoInput(true);
			urlc.setAllowUserInteraction(false);
			String pwd = MD.sign(DaHanSanTongConstant.PASSWORD, "", "utf-8");
		    sendMessage.put("account", DaHanSanTongConstant.ACCOUNT);
		    sendMessage.put("password", pwd);
		    
			DataOutputStream server = new DataOutputStream(urlc.getOutputStream());
			server.write(JSON.toJSONString(sendMessage).getBytes("utf-8"));
		    log.debug("********** DHSTClientReport 大汉三通http获取状态报告  发送地址： ["
		                + DaHanSanTongConstant.REPORT_URL + "]; account：["
		                + DaHanSanTongConstant.ACCOUNT + "]; password：["
		                + DaHanSanTongConstant.PASSWORD+"];加密后password:["+pwd+"] **********");
			server.close();

			BufferedReader in = new BufferedReader(new InputStreamReader(
					urlc.getInputStream(), "utf-8"));
			String result = "", s = "";
			while ((s = in.readLine()) != null)
				result = result + s;
			in.close();
			log.debug("********** DHSTClientReport短信状态报告 接收到的响应值:["+result+"]");
			Map<String,String> jsonMap = JSON.parseObject(result, new TypeReference<Map<String, String>>() {});
			status.put("dhst", "2");
			if("0".equals(jsonMap.get("result"))&&null!=jsonMap.get("reports")&&!"".equals(jsonMap.get("reports"))){
				//log.debug("原始报文信息："+result);
				//log.debug("原始报文信息："+result);
				//[{"result":"0","desc":"成功","reports":[{"msgid":"b6b7112f66e24ba9b13fb165d5f7ec39","phone":"13810780384","status":"0","desc":"0",
				//"wgcode":"DELIVRD","time":"2016-07-14 10:05:33","smsCount":1,"smsIndex":1}]}]
						
				List<Map<String, Object>> list = JSON.parseObject(jsonMap.get("reports").toString(), new TypeReference<List<Map<String, Object>>>() {});
            	
				//存放reports中的信息
				List<Map<String,Object>> dhstList = new ArrayList<>();
				
				for(Map<String,Object> reportsMap:list){
					Map<String,Object> detailMap = new HashMap<>();
					detailMap.put(Constant.SEQUENCE_NUM, reportsMap.get("msgid"));
					detailMap.put(Constant.RESULT_CODE, reportsMap.get("status"));
					if (reportsMap.get("status").equals("0"))
						detailMap.put(Constant.RESULT_CONTENT, "回执:发送成功");
					else
						detailMap.put(Constant.RESULT_CONTENT, reportsMap.get("desc"));
					detailMap.put(Constant.REPORT_TIME, reportsMap.get("time"));
					dhstList.add(detailMap);
            	}
				status.put("details", dhstList);
			}else{
//				if (null!=jsonMap.get("reports")&&!"".equals(jsonMap.get("reports"))){
//					log.error("********** DHSTClientReport短信状态报告 接收到的响应值result:["+jsonMap.toString()+"]");
//				}
	            status.put("result", "-1");
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			log.error("********** report_url无法连接，请查看url配置是否正确以及有效 :["+DaHanSanTongConstant.REPORT_URL+"]**********");
			log.error(e.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			log.error("********** report_url无法连接，请查看url配置是否正确以及有效 :["+DaHanSanTongConstant.REPORT_URL+"]**********");
			log.error(e.toString());
		}
		return status;
	}
}

