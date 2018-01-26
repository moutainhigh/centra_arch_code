package com.ifudata.ums.service.http.sikong.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;

//import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.ifudata.ums.core.SMAbstractClient;
import com.ifudata.ums.constant.Constant;
import com.ifudata.ums.constant.SysParamConstant;
import com.ifudata.ums.service.http.baiwunew.client.BWNewClient;
import com.ifudata.ums.service.http.sikong.constant.SikongConstant;
import com.ifudata.ums.service.http.sikong.msgobj.ReportRespObj;
import com.ifudata.ums.util.DateUtils;

public class SikongClient extends SMAbstractClient {

	private static final Log log = LogFactory.getLog(SikongClient.class);
	private static final Map<String, Object> tempResultMap = new ConcurrentHashMap<String, Object>();

	//private static int nWillSendNum = 0;

	@Override
	public Map<String, Object> writeMessage(String userNumber, String content) {
		Map<String, Object> status = new HashMap<String, Object>();

		//nWillSendNum = status.size();

		try {
			// msgId通过程序生成
			String msgId = genMsgId();
			status.put(Constant.SEQUENCE_NUM, msgId);
			log.debug("********** byd writeMessage 方法状态 :  **********");
			// 实例化HttpClient对象
			HttpClient client = new HttpClient();
			// PostMethod对象用于存放地址
			PostMethod post = new PostMethod(SikongConstant.SUBMIT_URL);
			// 在头文件中设置转码
			post.addRequestHeader("Content-Type", SikongConstant.CONTENT_TYPE);

			NameValuePair cmd = new NameValuePair("corp_id", SikongConstant.CORP_ID);
			NameValuePair uid = new NameValuePair("corp_pwd", SikongConstant.CORP_PWD);
			NameValuePair psw = new NameValuePair("corp_service", SikongConstant.CORP_SERVICE);
			NameValuePair mobiles = new NameValuePair("mobiles", userNumber);
			NameValuePair msg = new NameValuePair("msg_content", content);
			NameValuePair _msgId = new NameValuePair("corp_msg_id", msgId);
			NameValuePair msgformat = new NameValuePair("ext ", "");

			post.setRequestBody(new NameValuePair[] { cmd, uid, psw, mobiles, msg, _msgId, msgformat });
			// 执行的状态
			int excuteStatus = client.executeMethod(post);
			log.debug("********** HttpClient执行post方法状态 : " + excuteStatus + " **********");
			// 返回的数字，对应着不同的情况
			//Header[] headers = post.getResponseHeaders();
			int statusCode = post.getStatusCode();
			if (statusCode != 200) {
				log.error("********** post error http statuscode : " + statusCode + " **********");
			}
			String responseBody = post.getResponseBodyAsString();
			// 关闭连接
			post.releaseConnection();
			log.debug("********** responseBody : " + responseBody + " **********");
			String strres = parseString4MSGResult(responseBody);
			status.put(Constant.RESULT_CODE, strres);
			status.put(Constant.RESULT_CONTENT, responseBody);
			if (!strres.equals("0#")) {
				log.error("********** send sms failed : " + strres + " " + SikongConstant.getSubmitFailedReasonString(responseBody)
						+ " **********");
			}
		} catch (Exception e) {
			log.debug("**********write message 过程发生异常**********", e);
		}
		return status;
	}

	private String genMsgId() {
		// 时间+随机数
		Random r = new Random(100);
		int n4 = r.nextInt(100);
		System.out.println("random:" + n4);
		return (DateUtils.format(new Date(), "yyyyMMddHHmmssSSS") + String.format("%02d", n4));
	}

	// 判断下行短信是否发送成功
	public static String parseString4MSGResult(String source) {
		if (source == null)
			return "";
		if (source.substring(0, 1).equals("0#")) {
			return "0#";
		} else
			return source;
	}

	@Override
	public Map<String, Object> readMessage() {
		if (isFirstRead) {
			new Thread(new ReadTask()).start();
			isFirstRead = false;
		}

		Map<String, Object> recMap = new HashMap<String, Object>();
		if (SikongClient.tempResultMap != null && SikongClient.tempResultMap.size() > 0) {

			List<Map<String, Object>> list = new ArrayList<>();
			try {
				Iterator<String> iterator = BWNewClient.tempResultMap.keySet().iterator();
			    while (iterator.hasNext()) {
			    	synchronized (Object.class) {
			    		String key = iterator.next();
			    		ReportRespObj robj = (ReportRespObj) BWNewClient.tempResultMap.get(key);				
				
				//for (Map.Entry<String, Object> entry : SikongClient.tempResultMap.entrySet()) {
				//	if (entry.getValue() instanceof ReportRespObj) {
				//		ReportRespObj robj = (ReportRespObj) entry;
	
						Map<String, Object> detailMap = new HashMap<>();
						detailMap.put(Constant.SEQUENCE_NUM, key);
						detailMap.put(Constant.RESULT_CODE, robj.getErr());
						detailMap.put(Constant.RESULT_CONTENT, robj.getErr().equals("") ? "回执:发送成功" : "回执:发送失败");
						detailMap.put(Constant.FAIL_DESC, robj.getFail_desc());
						detailMap.put(Constant.REPORT_TIME, robj.getReport_time());
						detailMap.put(Constant.SUB_SEQ, robj.getSub_seq());
						
						list.add(detailMap);
						SikongClient.tempResultMap.remove(key);
						//BWNewClient.tempResultMap.remove(key);
					}
	
					
				}
			
				if (list.size() > 0) {
					recMap.put("baiwunew", list.size());
					recMap.put("details", list);
					log.debug("********** 状态报告接口返回结果:" + list + " **********");
				}
			} catch (Exception e) {
				e.printStackTrace();
				log.debug("********** 状态报告接口返回结果:" + list + System.getProperty("line.separater") + " **********");
			}			
		}		
		
		return recMap;
	}

	private boolean isXML(String result) {
		return Pattern.compile("<?xml[\\s\\S]*").matcher(result).find();
	}
	
	private class ReadTask implements Runnable {

		@Override
		public void run() {
			// 接收线程
			while (true) {
				try {
					Thread.sleep(SysParamConstant.SLEEP_TIME_RECEIVER);
				} catch (InterruptedException e) {
					log.error("Error:", e);
				}
				// 1. 先取是否发完

				// 2. 接收report
				int excuteStatus;
				InputStream is = null;
				// 实例化HttpClient对象
				HttpClient client = new HttpClient();
				// PostMethod对象用于存放地址
				PostMethod post = new PostMethod(SikongConstant.REPORT_URL);
				// NameValuePair数组对象用于传入参数
				post.addRequestHeader("Content-Type", SikongConstant.CONTENT_TYPE);// 在头文件中设置转码

				NameValuePair cmd = new NameValuePair("corp_id", SikongConstant.CORP_ID);
				NameValuePair uid = new NameValuePair("uid", SikongConstant.CORP_PWD);
				post.setRequestBody(new NameValuePair[] { cmd, uid });
				try {
					excuteStatus = client.executeMethod(post);
					log.debug("********** HttpClient执行post方法状态  GETSTATUS: " + excuteStatus + " **********");
					// 返回的数字，对应着不同的情况
					
					// 根据返回的xml内容判断是否要进行解析
					is = post.getResponseBodyAsStream();
					String result = SikongClient.fromStream2String(is, "GBK");
					
					//返回值  没有xml格式的内容
					if (result.length() <= 3) {
						//获取失败  或者没有report
						if (result.equals("0")) {
							log.info("********** 此次状态报告返回结果为：" + result + "暂时没有待推送的数据");
						} else {
							log.error("********** 此次状态报告返回结果为：" + result + SikongConstant.getSubmitFailedReasonString(result));
						}
						continue;
					}

					if(!isXML(result)){
						continue;
					}
					
					Map<String, Object> map = SikongClient.parseString4ReportResult(result);
					SikongClient.tempResultMap.putAll(map);
				} catch (Exception e) {
					log.error("读取数量过程发生异常 ", e);
				} finally {
					try {
						if (is != null) {
							is.close();
						}
					} catch (IOException e) {
						log.error("Error :", e);
					}
					if (post != null) {
						// 关闭连接
						post.releaseConnection();
					}
				}
			}
		}
	}

	// 把http响应数据流转成string
	public static String fromStream2String(InputStream is, String encode) {
		if (is == null)
			return null;
		StringBuilder sb = new StringBuilder("");
		try {
			InputStreamReader isr = new InputStreamReader(is, encode);
			BufferedReader br = new BufferedReader(isr);
			String line = null;
			while ((line = br.readLine()) != null)
				sb.append(line + SikongConstant.LINE_SPILT);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sb.toString();
	}

	// 解析状态报告
	public static Map<String, Object> parseString4ReportResult(String responseBody) {
		// 判断传递参数
		if (responseBody == null)
			return null;
		Map<String, Object> map = null;
		try {
			// 获取document对象
			log.debug("********** responseBody : "+ responseBody + " **********");
			Document doc = DocumentHelper.parseText(responseBody);
			// 创建Map容器
			map = new HashMap<String, Object>();
			// 获取root节点
			Element root = doc.getRootElement();
			
			@SuppressWarnings("rawtypes")	
			Iterator reports = root.elementIterator("reports");
			while (reports.hasNext()) {
				Element msgReport = (Element) reports.next();
				// 将信息添加进map容器中 todo 将信息添加进map容器中 把其他信息写入到value里面
				ReportRespObj robj = new ReportRespObj();
				robj.setCorp_id(msgReport.elementTextTrim("corp_id"));
				robj.setMobile(msgReport.elementTextTrim("mobile"));
				robj.setSub_seq(msgReport.elementTextTrim("sub_seq"));
				robj.setErr(msgReport.elementTextTrim("err"));
				robj.setMsg_id(msgReport.elementTextTrim("msg_id"));
				robj.setFail_desc(msgReport.elementTextTrim("fail_desc"));
				robj.setReport_time(msgReport.elementTextTrim("report_time"));
				
				map.put(msgReport.elementTextTrim("msg_id"), robj);
				//Gson gson = new Gson();
				//map.put(msgReport.elementTextTrim("msg_id"), gson.toJson(robj));
			}
		} catch (DocumentException e) {
			e.printStackTrace();
			log.debug("********** 状态报告接口返回结果:" + responseBody + System.getProperty("line.separater")+" **********");
		}
		return map;
	}		


}
