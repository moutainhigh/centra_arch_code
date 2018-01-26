package com.ifudata.ums.service.http.baiwu.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Pattern;

import com.ifudata.ums.service.http.baiwu.constant.BaiwuConstant;
import com.ifudata.ums.util.DateUtils;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.ifudata.ums.constant.Constant;
import com.ifudata.ums.constant.SysParamConstant;
import com.ifudata.ums.core.SMAbstractClient;
import com.ifudata.ums.service.http.baiwu.util.StringUtils;
import com.ifudata.ums.service.http.baiwunew.server.ReportRespObj;

public class BWClient extends SMAbstractClient {

	private static final Log log = LogFactory.getLog(BWClient.class);

	@Override
	public Map<String, Object> writeMessage(String userNumber, String content) {

		Map<String, Object> status = new HashMap<String, Object>();
		try {
			// 提取参数
			String url = BaiwuConstant.WRITE_URL;
			String contentType = BaiwuConstant.CONTENT_TYPE;
			String corpId = BaiwuConstant.CORP_ID;
			//String userId = BaiwuConstant.USER_ID;
			String userPwd = BaiwuConstant.USER_PWD;
			String corpService = BaiwuConstant.CORP_SERVICE;
			String ext = BaiwuConstant.EXT;

			String mobile = userNumber;
			String msgContent = content;
			// msgId通过程序生成
			String msgId = genMsgId();
			status.put("msgId", msgId);
			log.debug("********** new HttpClient()方法状态 :  **********");
			// 实例化HttpClient对象
			HttpClient client = new HttpClient();
			// PostMethod对象用于存放地址
			PostMethod post = new PostMethod(url);
			// 在头文件中设置转码
			post.addRequestHeader("Content-Type", contentType);

			// NameValuePair数组对象用于传入参数
			NameValuePair _corpId = new NameValuePair("corp_id", corpId);
			// NameValuePair _userId = new NameValuePair("user_id", userId);
			// NameValuePair _userPwd = new NameValuePair("user_pwd", userPwd);
			NameValuePair _userPwd = new NameValuePair("corp_pwd", userPwd);
			NameValuePair _corpService = new NameValuePair("corp_service", corpService);
			NameValuePair _ext = new NameValuePair("ext", ext);
			NameValuePair _mobile = new NameValuePair("mobile", mobile);
			NameValuePair _msgContent = new NameValuePair("msg_content", msgContent);
			NameValuePair _msgId = new NameValuePair("msg_id", msgId);

			// post.setRequestBody(new NameValuePair[] {_corpId, _userId,
			// _userPwd, _corpService, _mobile, _msgContent, _msgId, _ext});
			post.setRequestBody(
					new NameValuePair[] { _corpId, _userPwd, _corpService, _mobile, _msgContent, _msgId, _ext });
			// 执行的状态
			int excuteStatus = client.executeMethod(post);
			log.debug("********** HttpClient执行post方法状态 : " + excuteStatus + " **********");
			// 返回的数字，对应着不同的情况
			String responseBody = post.getResponseBodyAsString();
			// 关闭连接
			post.releaseConnection();
			log.debug("********** responseBody : " + responseBody + " **********");

			status.put(Constant.RESULT_CODE, parseString4MSGResult(responseBody));
			status.put(Constant.RESULT_CONTENT, parseString4MSGResult(responseBody));
		} catch (Exception e) {
			log.debug("**********write message 过程发生异常**********", e);
		}

		return status;
	}

	@Override
	public Map<String, Object> readMessage() {

		if (isFirstRead) {
			new Thread(new ReadTask()).start();
			isFirstRead = false;
		}

		Map<String, Object> recMap = new HashMap<String, Object>();
		if (BWClient.tempResultMap != null && BWClient.tempResultMap.size() > 0) {
			for (Map.Entry<String, Object> entry : BWClient.tempResultMap.entrySet()) {
				if (entry.getValue() instanceof  ReportRespObj) {
					ReportRespObj entry1 = (ReportRespObj)entry;
				
					recMap.put(Constant.SEQUENCE_NUM, entry.getKey());
					recMap.put(Constant.RESULT_CODE, entry1.getErr());
					recMap.put(Constant.RESULT_CONTENT, entry1.getErr().equals("0") ? "回执:发送成功" : "回执:发送失败");
				}
				BWClient.tempResultMap.remove(entry.getKey());
				break;
			}
		}
		return recMap;
	}

	private class ReadTask implements Runnable {

		@Override
		public void run() {

			while (true) {
				try {
					Thread.sleep(SysParamConstant.SLEEP_TIME_RECEIVER);
				} catch (InterruptedException e) {
					log.error("Error", e);
				}

				// 实例化HttpClient对象
				HttpClient client = new HttpClient();
				// PostMethod对象用于存放地址
				PostMethod post = new PostMethod(BaiwuConstant.READ_URL);
				// NameValuePair数组对象用于传入参数
				post.addRequestHeader("Content-Type", BaiwuConstant.CONTENT_TYPE);// 在头文件中设置转码

				NameValuePair corp_id = new NameValuePair("corp_id", BaiwuConstant.CORP_ID);
				// NameValuePair user_id = new NameValuePair("user_id",
				// BaiwuConstant.USER_ID);
				// NameValuePair user_pwd = new NameValuePair("user_pwd",
				// BaiwuConstant.USER_PWD);
				NameValuePair userPwd = new NameValuePair("corp_pwd", BaiwuConstant.USER_PWD);
				// post.setRequestBody(new NameValuePair[] {corp_id, user_id,
				// user_pwd});
				post.setRequestBody(new NameValuePair[] { corp_id, userPwd });
				// 执行的状态
				int excuteStatus;
				InputStream is = null;
				try {
					excuteStatus = client.executeMethod(post);
					log.debug("********** HttpClient执行post方法状态 : " + excuteStatus + " **********");
					// 返回的数字，对应着不同的情况
					is = post.getResponseBodyAsStream();
					// 根据返回的xml内容判断是否要进行解析
					String result = BWClient.fromStream2String(is, "UTF-8");
					log.debug(
							"********** 此次状态报告返回结果为：" + result + System.getProperty("line.separator") + " **********");
					if (!isXML(result)) {
						continue;
					}
					result = StringUtils.CheckUnicodeStringAndReplcace(result, ' ');
					Map<String, String> map = BWClient.this.parseString4ReportResult(result);
					BWClient.tempResultMap.putAll(map);
				} catch (Exception e) {
					log.error("读取回执过程发生异常 ", e);
				} finally {
					try {
						if (is != null) {
							is.close();
						}
					} catch (IOException e) {
						log.error("Error ", e);
					}
					if (post != null) {
						// 关闭连接
						post.releaseConnection();
					}
				}
			}
		}
	}

	public static String parseString4MSGResult(String source) {
		String result = "";
		if (source != null) {
			if (source.startsWith("0")) {
				// 发送成功
				result = "0";
			} else {
				// 发送失败
				result = "1";
			}
		}
		return result;
	}

	private String genMsgId() {
		return (DateUtils.format(new Date(), "yyyyMMddHHmmss") + "-" + UUID.randomUUID()).substring(0, 36);
	}

	/**
	 * 将流转化为字符串
	 * 
	 * @param is
	 * @return
	 */
	public static String fromStream2String(InputStream is, String encode) {
		if (is == null)
			return null;
		StringBuilder sb = new StringBuilder("");
		try {
			InputStreamReader isr = new InputStreamReader(is, encode);
			BufferedReader br = new BufferedReader(isr);
			String line = null;
			while ((line = br.readLine()) != null)
				sb.append(line);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sb.toString();
	}

	private boolean isXML(String result) {
		return Pattern.compile("<?xml[\\s\\S]*").matcher(result).find();
	}

	/**
	 * 解析短信状态接口返回的xml格式字符串
	 * 
	 * @param responseBody
	 * @param string
	 * @return Map<String,String>key：短信id，value：短信结果
	 */
	private Map<String, String> parseString4ReportResult(String responseBody) {
		// 判断传递参数
		if (responseBody == null)
			return null;
		Map<String, String> map = null;
		try {
			// 获取document对象
			log.debug("********** responseBody : " + responseBody + " **********");
			Document doc = DocumentHelper.parseText(responseBody);
			// 创建Map容器
			map = new HashMap<String, String>();
			// 获取root节点
			Element root = doc.getRootElement();

			@SuppressWarnings("rawtypes")
			Iterator reports = root.elementIterator("report");
			while (reports.hasNext()) {
				Element msgReport = (Element) reports.next();
				// 将信息添加进map容器中
				map.put(msgReport.elementTextTrim("msg_id"), msgReport.elementTextTrim("result"));
			}
		} catch (DocumentException e) {
			e.printStackTrace();
			log.debug("********** 状态报告接口返回结果:" + responseBody + System.getProperty("line.separater") + " **********");
		}
		return map;
	}
}
