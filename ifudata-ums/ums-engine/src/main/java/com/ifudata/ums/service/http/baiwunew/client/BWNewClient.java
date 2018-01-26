package com.ifudata.ums.service.http.baiwunew.client;

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
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;
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
import com.ifudata.ums.service.http.baiwunew.constant.BaiwuNewConstant;
import com.ifudata.ums.service.http.baiwunew.server.ReportRespObj;

public class BWNewClient extends SMAbstractClient {
	private static final Log log = LogFactory.getLog(BWNewClient.class);
	public static final Map<String, Object> tempResultMap = new ConcurrentHashMap<String, Object>();
	@Override
	public Map<String, Object> writeMessage(String userNumber, String content){

		Map<String, Object> status = new HashMap<String, Object>();

////test
//		String msgId = genMsgId();
//		status.put("msgId", msgId);
//		String responseBody = "0#1";
//		status.put(Constant.RESULT_CODE, parseString4MSGResult(responseBody));
//		status.put(Constant.RESULT_CONTENT, responseBody);
////	end test	
		try {
			String mobile = userNumber;
			String msgContent = content;
			// msgId通过程序生成
			String msgId = genMsgId();
			status.put("msgId", msgId);
			log.debug("********** baiwunew writeMessage 方法状态 :  **********");
			// 实例化HttpClient对象
			HttpClient client = new HttpClient();
			// PostMethod对象用于存放地址
			PostMethod post = new PostMethod(BaiwuNewConstant.WRITE_URL);
			// 在头文件中设置转码
			post.addRequestHeader("Content-Type", BaiwuNewConstant.CONTENT_TYPE);

			NameValuePair id = new NameValuePair("id", BaiwuNewConstant.ID);
			NameValuePair MD5_td_code = new NameValuePair("MD5_td_code", BaiwuNewConstant.MD5_TD_CODE);
			NameValuePair ext = new NameValuePair("ext", BaiwuNewConstant.EXT);
			NameValuePair _mobile = new NameValuePair("mobile", mobile);
			NameValuePair _msgContent = new NameValuePair("msg_content", msgContent);
			NameValuePair _msgId = new NameValuePair("msg_id", msgId);

			post.setRequestBody(new NameValuePair[] { id, MD5_td_code, _mobile, _msgContent, _msgId, ext});
			// 执行的状态
			int excuteStatus = client.executeMethod(post);
			log.debug("********** HttpClient执行post方法状态 : "+excuteStatus+" **********");
			// 返回的数字，对应着不同的情况
			String responseBody = post.getResponseBodyAsString();
			// 关闭连接
			post.releaseConnection();
			log.debug("********** responseBody : "+responseBody+" **********");
			
			status.put(Constant.RESULT_CODE, parseString4MSGResult(responseBody));
			status.put(Constant.RESULT_CONTENT, responseBody);
		} catch (Exception e) {
			log.debug("**********write message 过程发生异常**********", e);
		}
		
		return status;
	}

	@Override
	public Map<String, Object> readMessage() {
		if(isFirstRead){
			new Thread(new ReadTask()).start();
			isFirstRead = false;
		}

		Map<String, Object> recMap = new HashMap<String, Object>();
		if (BWNewClient.tempResultMap != null && BWNewClient.tempResultMap.size() > 0) {

			List<Map<String, Object>> list = new ArrayList<>();
			try {
				
				Iterator<String> iterator = BWNewClient.tempResultMap.keySet().iterator();
			    while (iterator.hasNext()) {
			    	synchronized (Object.class) {
			    		String key = iterator.next();
			    		ReportRespObj robj = (ReportRespObj) BWNewClient.tempResultMap.get(key);
				    	
				//for (Map.Entry<String, Object> entry : BWNewClient.tempResultMap.entrySet()) {
				//	if (iterator.getValue() instanceof ReportRespObj) {
				//		ReportRespObj robj = (ReportRespObj) entry.getValue();
	
						Map<String, Object> detailMap = new HashMap<>();
						detailMap.put(Constant.SEQUENCE_NUM, key);
						detailMap.put(Constant.RESULT_CODE, robj.getErr());
						
						// 根据 百悟新协议 v1.1 发现 0 或者000都是成功 原来的
						//2	发送失败
						//2	发送失败 问题解决
						int ires = -1;
						try {
							ires = Integer.parseInt(robj.getErr());
						} catch (NumberFormatException e) {
							log.error("parseInt error:" + robj.getErr());
							ires = 0;
						}
						
						detailMap.put(Constant.RESULT_CONTENT, ires == 0 ? "回执:发送成功" : "回执:发送失败");
						detailMap.put(Constant.FAIL_DESC, robj.getFail_desc());
						detailMap.put(Constant.REPORT_TIME, robj.getReport_time());
						detailMap.put(Constant.SUB_SEQ, robj.getSub_seq());
						
						list.add(detailMap);
						
						BWNewClient.tempResultMap.remove(key);
					}
				}

				if (list.size() > 0) {
					recMap.put("baiwunew", list.size());
					recMap.put("details", list);
					log.debug("********** 状态报告接口返回结果:" + list + " list.size():" + list.size() + "**********");
				}
			} catch (Exception e) {
				log.error("********** 状态报告接口返回结果:" + list + System.getProperty("line.separater") + e.getMessage() + " **********");
			}			
		}
		return recMap;
	}

	private class ReadTask implements Runnable{

		@Override
		public void run() {
			Thread.currentThread().setName("BWNewClientReadTask");
			while(true){
				try {
					Thread.sleep(SysParamConstant.SLEEP_TIME_RECEIVER);
				} catch (InterruptedException e) {
					log.error("Error", e);
				}
////test
//<?xml version="1.0" encoding="GBK" ?><reports><report><corp_id>wj5016</corp_id><mobile>17000203763</mobile><sub_seq>0</sub_seq><msg_id>20161026185555-56e1ddf8-a7d1-404d-96</msg_id><err>0</err><fail_desc>DELIVRD</fail_desc><report_time>2016-10-26 18:55:37</report_time></report></reports>
//				String result = "<?xml version=\"1.0\" encoding=\"GBK\" ?><reports><report><corp_id>wj1566</corp_id><mobile>17058500339</mobile><sub_seq>0</sub_seq><msg_id>20161118123625-3ceffe4b-c3ce-49b1-b6</msg_id><err>null</err><fail_desc>UNDELIV</fail_desc><report_time>2016-11-18 12:37:13</report_time></report><report><corp_id>wj1566</corp_id><mobile>17058500339</mobile><sub_seq>0</sub_seq><msg_id>20161118123625-3ceffe4b-c3ce-49b1-b6</msg_id><err>null</err><fail_desc>UNDELIV</fail_desc><report_time>2016-11-18 12:37:13</report_time></report><report><corp_id>wj1566</corp_id><mobile>17058500385</mobile><sub_seq>0</sub_seq><msg_id>20161118123625-5766bd0c-07b7-4641-bb</msg_id><err>null</err><fail_desc>UNDELIV</fail_desc><report_time>2016-11-18 12:37:13</report_time></report><report><corp_id>wj1566</corp_id><mobile>17058500385</mobile><sub_seq>0</sub_seq><msg_id>20161118123625-5766bd0c-07b7-4641-bb</msg_id><err>null</err><fail_desc>UNDELIV</fail_desc><report_time>2016-11-18 12:37:13</report_time></report><report><corp_id>wj1566</corp_id><mobile>17058500505</mobile><sub_seq>0</sub_seq><msg_id>20161118123625-de8a67b1-204b-459e-a4</msg_id><err>null</err><fail_desc>UNDELIV</fail_desc><report_time>2016-11-18 12:37:13</report_time></report><report><corp_id>wj1566</corp_id><mobile>17058500505</mobile><sub_seq>0</sub_seq><msg_id>20161118123625-de8a67b1-204b-459e-a4</msg_id><err>null</err><fail_desc>UNDELIV</fail_desc><report_time>2016-11-18 12:37:13</report_time></report><report><corp_id>wj1566</corp_id><mobile>17058500582</mobile><sub_seq>0</sub_seq><msg_id>20161118123625-373ce6ad-8e06-4262-bb</msg_id><err>null</err><fail_desc>UNDELIV</fail_desc><report_time>2016-11-18 12:37:13</report_time></report><report><corp_id>wj1566</corp_id><mobile>17058500582</mobile><sub_seq>0</sub_seq><msg_id>20161118123625-373ce6ad-8e06-4262-bb</msg_id><err>null</err><fail_desc>UNDELIV</fail_desc><report_time>2016-11-18 12:37:13</report_time></report><report><corp_id>wj1566</corp_id><mobile>17058500633</mobile><sub_seq>0</sub_seq><msg_id>20161118123625-39881846-5d99-4c9e-9c</msg_id><err>null</err><fail_desc>UNDELIV</fail_desc><report_time>2016-11-18 12:37:13</report_time></report><report><corp_id>wj1566</corp_id><mobile>17058500633</mobile><sub_seq>0</sub_seq><msg_id>20161118123625-39881846-5d99-4c9e-9c</msg_id><err>null</err><fail_desc>UNDELIV</fail_desc><report_time>2016-11-18 12:37:13</report_time></report><report><corp_id>wj1566</corp_id><mobile>17058500640</mobile><sub_seq>0</sub_seq><msg_id>20161118123625-37ea830e-5583-4db2-92</msg_id><err>null</err><fail_desc>UNDELIV</fail_desc><report_time>2016-11-18 12:37:13</report_time></report><report><corp_id>wj1566</corp_id><mobile>17058500640</mobile><sub_seq>0</sub_seq><msg_id>20161118123625-37ea830e-5583-4db2-92</msg_id><err>null</err><fail_desc>UNDELIV</fail_desc><report_time>2016-11-18 12:37:13</report_time></report><report><corp_id>wj1566</corp_id><mobile>17058500662</mobile><sub_seq>0</sub_seq><msg_id>20161118123625-644b40f1-b88d-4aff-9d</msg_id><err>null</err><fail_desc>UNDELIV</fail_desc><report_time>2016-11-18 12:37:13</report_time></report><report><corp_id>wj1566</corp_id><mobile>17058500662</mobile><sub_seq>0</sub_seq><msg_id>20161118123625-644b40f1-b88d-4aff-9d</msg_id><err>null</err><fail_desc>UNDELIV</fail_desc><report_time>2016-11-18 12:37:13</report_time></report><report><corp_id>wj1566</corp_id><mobile>17058500666</mobile><sub_seq>0</sub_seq><msg_id>20161118123625-16e1a649-5dd0-41ab-ae</msg_id><err>null</err><fail_desc>UNDELIV</fail_desc><report_time>2016-11-18 12:37:13</report_time></report><report><corp_id>wj1566</corp_id><mobile>17058500666</mobile><sub_seq>0</sub_seq><msg_id>20161118123625-16e1a649-5dd0-41ab-ae</msg_id><err>null</err><fail_desc>UNDELIV</fail_desc><report_time>2016-11-18 12:37:13</report_time></report><report><corp_id>wj1566</corp_id><mobile>17058500709</mobile><sub_seq>0</sub_seq><msg_id>20161118123625-a8570203-8494-4511-90</msg_id><err>null</err><fail_desc>UNDELIV</fail_desc><report_time>2016-11-18 12:37:13</report_time></report><report><corp_id>wj1566</corp_id><mobile>17058500709</mobile><sub_seq>0</sub_seq><msg_id>20161118123625-a8570203-8494-4511-90</msg_id><err>null</err><fail_desc>UNDELIV</fail_desc><report_time>2016-11-18 12:37:13</report_time></report><report><corp_id>wj1566</corp_id><mobile>17058500528</mobile><sub_seq>0</sub_seq><msg_id>20161118123625-d88f0243-903f-4da6-b6</msg_id><err>null</err><fail_desc>UNDELIV</fail_desc><report_time>2016-11-18 12:37:13</report_time></report><report><corp_id>wj1566</corp_id><mobile>17058500528</mobile><sub_seq>0</sub_seq><msg_id>20161118123625-d88f0243-903f-4da6-b6</msg_id><err>null</err><fail_desc>UNDELIV</fail_desc><report_time>2016-11-18 12:37:13</report_time></report><report><corp_id>wj1566</corp_id><mobile>17058500552</mobile><sub_seq>0</sub_seq><msg_id>20161118123625-facd3545-e083-42e6-81</msg_id><err>null</err><fail_desc>UNDELIV</fail_desc><report_time>2016-11-18 12:37:13</report_time></report><report><corp_id>wj1566</corp_id><mobile>17058500552</mobile><sub_seq>0</sub_seq><msg_id>20161118123625-facd3545-e083-42e6-81</msg_id><err>null</err><fail_desc>UNDELIV</fail_desc><report_time>2016-11-18 12:37:13</report_time></report><report><corp_id>wj1566</corp_id><mobile>17058500620</mobile><sub_seq>0</sub_seq><msg_id>20161118123625-9c86e0ed-a675-437b-bb</msg_id><err>null</err><fail_desc>UNDELIV</fail_desc><report_time>2016-11-18 12:37:13</report_time></report><report><corp_id>wj1566</corp_id><mobile>17058500620</mobile><sub_seq>0</sub_seq><msg_id>20161118123625-9c86e0ed-a675-437b-bb</msg_id><err>null</err><fail_desc>UNDELIV</fail_desc><report_time>2016-11-18 12:37:13</report_time></report><report><corp_id>wj1566</corp_id><mobile>17058500675</mobile><sub_seq>0</sub_seq><msg_id>20161118123625-0118d7f6-89da-4b64-b0</msg_id><err>null</err><fail_desc>UNDELIV</fail_desc><report_time>2016-11-18 12:37:13</report_time></report><report><corp_id>wj1566</corp_id><mobile>17058500675</mobile><sub_seq>0</sub_seq><msg_id>20161118123625-0118d7f6-89da-4b64-b0</msg_id><err>null</err><fail_desc>UNDELIV</fail_desc><report_time>2016-11-18 12:37:13</report_time></report><report><corp_id>wj1566</corp_id><mobile>17058500702</mobile><sub_seq>0</sub_seq><msg_id>20161118123625-b8cad5a4-8c02-44c3-85</msg_id><err>null</err><fail_desc>UNDELIV</fail_desc><report_time>2016-11-18 12:37:13</report_time></report><report><corp_id>wj1566</corp_id><mobile>17058500702</mobile><sub_seq>0</sub_seq><msg_id>20161118123625-b8cad5a4-8c02-44c3-85</msg_id><err>null</err><fail_desc>UNDELIV</fail_desc><report_time>2016-11-18 12:37:13</report_time></report><report><corp_id>wj1566</corp_id><mobile>17058501855</mobile><sub_seq>0</sub_seq><msg_id>20161118123625-0e52b682-6321-4dd0-8e</msg_id><err>null</err><fail_desc>UNDELIV</fail_desc><report_time>2016-11-18 12:37:13</report_time></report><report><corp_id>wj1566</corp_id><mobile>17058501855</mobile><sub_seq>0</sub_seq><msg_id>20161118123625-0e52b682-6321-4dd0-8e</msg_id><err>null</err><fail_desc>UNDELIV</fail_desc><report_time>2016-11-18 12:37:13</report_time></report><report><corp_id>wj1566</corp_id><mobile>17058500726</mobile><sub_seq>0</sub_seq><msg_id>20161118123625-9ceb9e8d-56cb-49c7-a4</msg_id><err>null</err><fail_desc>UNDELIV</fail_desc><report_time>2016-11-18 12:37:13</report_time></report><report><corp_id>wj1566</corp_id><mobile>17058500726</mobile><sub_seq>0</sub_seq><msg_id>20161118123625-9ceb9e8d-56cb-49c7-a4</msg_id><err>null</err><fail_desc>UNDELIV</fail_desc><report_time>2016-11-18 12:37:13</report_time></report><report><corp_id>wj1566</corp_id><mobile>17058501000</mobile><sub_seq>0</sub_seq><msg_id>20161118123625-0df0f54f-991f-46fe-b1</msg_id><err>null</err><fail_desc>UNDELIV</fail_desc><report_time>2016-11-18 12:37:13</report_time></report><report><corp_id>wj1566</corp_id><mobile>17058501000</mobile><sub_seq>0</sub_seq><msg_id>20161118123625-0df0f54f-991f-46fe-b1</msg_id><err>null</err><fail_desc>UNDELIV</fail_desc><report_time>2016-11-18 12:37:13</report_time></report><report><corp_id>wj1566</corp_id><mobile>17058501188</mobile><sub_seq>0</sub_seq><msg_id>20161118123625-7ab9da57-0098-475a-b3</msg_id><err>null</err><fail_desc>UNDELIV</fail_desc><report_time>2016-11-18 12:37:13</report_time></report><report><corp_id>wj1566</corp_id><mobile>17058501188</mobile><sub_seq>0</sub_seq><msg_id>20161118123625-7ab9da57-0098-475a-b3</msg_id><err>null</err><fail_desc>UNDELIV</fail_desc><report_time>2016-11-18 12:37:13</report_time></report><report><corp_id>wj1566</corp_id><mobile>17058501900</mobile><sub_seq>0</sub_seq><msg_id>20161118123625-8279e103-1784-4343-bb</msg_id><err>null</err><fail_desc>UNDELIV</fail_desc><report_time>2016-11-18 12:37:13</report_time></report><report><corp_id>wj1566</corp_id><mobile>17058501900</mobile><sub_seq>0</sub_seq><msg_id>20161118123625-8279e103-1784-4343-bb</msg_id><err>null</err><fail_desc>UNDELIV</fail_desc><report_time>2016-11-18 12:37:13</report_time></report><report><corp_id>wj1566</corp_id><mobile>17058502006</mobile><sub_seq>0</sub_seq><msg_id>20161118123625-1dd1122c-738c-4e40-83</msg_id><err>null</err><fail_desc>UNDELIV</fail_desc><report_time>2016-11-18 12:37:13</report_time></report><report><corp_id>wj1566</corp_id><mobile>17058502006</mobile><sub_seq>0</sub_seq><msg_id>20161118123625-1dd1122c-738c-4e40-83</msg_id><err>null</err><fail_desc>UNDELIV</fail_desc><report_time>2016-11-18 12:37:13</report_time></report><report><corp_id>wj1566</corp_id><mobile>17058502111</mobile><sub_seq>0</sub_seq><msg_id>20161118123626-5f6d6e40-ba42-42a4-9e</msg_id><err>null</err><fail_desc>UNDELIV</fail_desc><report_time>2016-11-18 12:37:13</report_time></report><report><corp_id>wj1566</corp_id><mobile>17058502111</mobile><sub_seq>0</sub_seq><msg_id>20161118123626-5f6d6e40-ba42-42a4-9e</msg_id><err>null</err><fail_desc>UNDELIV</fail_desc><report_time>2016-11-18 12:37:13</report_time></report><report><corp_id>wj1566</corp_id><mobile>17058502168</mobile><sub_seq>0</sub_seq><msg_id>20161118123626-fd00ab64-167b-4e02-b8</msg_id><err>null</err><fail_desc>UNDELIV</fail_desc><report_time>2016-11-18 12:37:13</report_time></report><report><corp_id>wj1566</corp_id><mobile>17058502168</mobile><sub_seq>0</sub_seq><msg_id>20161118123626-fd00ab64-167b-4e02-b8</msg_id><err>null</err><fail_desc>UNDELIV</fail_desc><report_time>2016-11-18 12:37:13</report_time></report><report><corp_id>wj1566</corp_id><mobile>17058502187</mobile><sub_seq>0</sub_seq><msg_id>20161118123626-9902c976-ec25-47ae-ae</msg_id><err>null</err><fail_desc>UNDELIV</fail_desc><report_time>2016-11-18 12:37:13</report_time></report><report><corp_id>wj1566</corp_id><mobile>17058502187</mobile><sub_seq>0</sub_seq><msg_id>20161118123626-9902c976-ec25-47ae-ae</msg_id><err>null</err><fail_desc>UNDELIV</fail_desc><report_time>2016-11-18 12:37:13</report_time></report><report><corp_id>wj1566</corp_id><mobile>17058502348</mobile><sub_seq>0</sub_seq><msg_id>20161118123626-776a42d3-4f28-4281-98</msg_id><err>null</err><fail_desc>UNDELIV</fail_desc><report_time>2016-11-18 12:37:13</report_time></report><report><corp_id>wj1566</corp_id><mobile>17058502348</mobile><sub_seq>0</sub_seq><msg_id>20161118123626-776a42d3-4f28-4281-98</msg_id><err>null</err><fail_desc>UNDELIV</fail_desc><report_time>2016-11-18 12:37:13</report_time></report><report><corp_id>wj1566</corp_id><mobile>17058502381</mobile><sub_seq>0</sub_seq><msg_id>20161118123626-a7ee8143-5174-4de8-a2</msg_id><err>null</err><fail_desc>UNDELIV</fail_desc><report_time>2016-11-18 12:37:13</report_time></report><report><corp_id>wj1566</corp_id><mobile>17058502381</mobile><sub_seq>0</sub_seq><msg_id>20161118123626-a7ee8143-5174-4de8-a2</msg_id><err>null</err><fail_desc>UNDELIV</fail_desc><report_time>2016-11-18 12:37:13</report_time></report><report><corp_id>wj1566</corp_id><mobile>17058502382</mobile><sub_seq>0</sub_seq><msg_id>20161118123626-a6f0559a-080d-4197-9d</msg_id><err>null</err><fail_desc>UNDELIV</fail_desc><report_time>2016-11-18 12:37:13</report_time></report><report><corp_id>wj1566</corp_id><mobile>17058502382</mobile><sub_seq>0</sub_seq><msg_id>20161118123626-a6f0559a-080d-4197-9d</msg_id><err>null</err><fail_desc>UNDELIV</fail_desc><report_time>2016-11-18 12:37:13</report_time></report><report><corp_id>wj1566</corp_id><mobile>17058502392</mobile><sub_seq>0</sub_seq><msg_id>20161118123626-570a0af7-3bc9-4b60-b4</msg_id><err>null</err><fail_desc>UNDELIV</fail_desc><report_time>2016-11-18 12:37:13</report_time></report><report><corp_id>wj1566</corp_id><mobile>17058502392</mobile><sub_seq>0</sub_seq><msg_id>20161118123626-570a0af7-3bc9-4b60-b4</msg_id><err>null</err><fail_desc>UNDELIV</fail_desc><report_time>2016-11-18 12:37:13</report_time></report><report><corp_id>wj1566</corp_id><mobile>17058502508</mobile><sub_seq>0</sub_seq><msg_id>20161118123626-7393b654-b86b-4e87-b8</msg_id><err>null</err><fail_desc>UNDELIV</fail_desc><report_time>2016-11-18 12:37:13</report_time></report><report><corp_id>wj1566</corp_id><mobile>17058502508</mobile><sub_seq>0</sub_seq><msg_id>20161118123626-7393b654-b86b-4e87-b8</msg_id><err>null</err><fail_desc>UNDELIV</fail_desc><report_time>2016-11-18 12:37:13</report_time></report><report><corp_id>wj1566</corp_id><mobile>17058502419</mobile><sub_seq>0</sub_seq><msg_id>20161118123626-c36c40b5-9364-4869-88</msg_id><err>null</err><fail_desc>UNDELIV</fail_desc><report_time>2016-11-18 12:37:13</report_time></report><report><corp_id>wj1566</corp_id><mobile>17058502419</mobile><sub_seq>0</sub_seq><msg_id>20161118123626-c36c40b5-9364-4869-88</msg_id><err>null</err><fail_desc>UNDELIV</fail_desc><report_time>2016-11-18 12:37:13</report_time></report><report><corp_id>wj1566</corp_id><mobile>17058502007</mobile><sub_seq>0</sub_seq><msg_id>20161118123625-472885d5-2e27-4b5d-9e</msg_id><err>null</err><fail_desc>UNDELIV</fail_desc><report_time>2016-11-18 12:37:13</report_time></report><report><corp_id>wj1566</corp_id><mobile>17058502007</mobile><sub_seq>0</sub_seq><msg_id>20161118123625-472885d5-2e27-4b5d-9e</msg_id><err>null</err><fail_desc>UNDELIV</fail_desc><report_time>2016-11-18 12:37:13</report_time></report><report><corp_id>wj1566</corp_id><mobile>17058502016</mobile><sub_seq>0</sub_seq><msg_id>20161118123626-92ee0a66-8c86-4de1-b3</msg_id><err>null</err><fail_desc>UNDELIV</fail_desc><report_time>2016-11-18 12:37:13</report_time></report><report><corp_id>wj1566</corp_id><mobile>17058502016</mobile><sub_seq>0</sub_seq><msg_id>20161118123626-92ee0a66-8c86-4de1-b3</msg_id><err>null</err><fail_desc>UNDELIV</fail_desc><report_time>2016-11-18 12:37:13</report_time></report><report><corp_id>wj1566</corp_id><mobile>17058502271</mobile><sub_seq>0</sub_seq><msg_id>20161118123626-4b119dda-11c5-4e4a-81</msg_id><err>null</err><fail_desc>UNDELIV</fail_desc><report_time>2016-11-18 12:37:13</report_time></report><report><corp_id>wj1566</corp_id><mobile>17058502271</mobile><sub_seq>0</sub_seq><msg_id>20161118123626-4b119dda-11c5-4e4a-81</msg_id><err>null</err><fail_desc>UNDELIV</fail_desc><report_time>2016-11-18 12:37:13</report_time></report><report><corp_id>wj1566</corp_id><mobile>17058502282</mobile><sub_seq>0</sub_seq><msg_id>20161118123626-f4f7bf21-0668-482d-9b</msg_id><err>null</err><fail_desc>UNDELIV</fail_desc><report_time>2016-11-18 12:37:13</report_time></report><report><corp_id>wj1566</corp_id><mobile>17058502282</mobile><sub_seq>0</sub_seq><msg_id>20161118123626-f4f7bf21-0668-482d-9b</msg_id><err>null</err><fail_desc>UNDELIV</fail_desc><report_time>2016-11-18 12:37:13</report_time></report><report><corp_id>wj1566</corp_id><mobile>17058502349</mobile><sub_seq>0</sub_seq><msg_id>20161118123626-a927a1a2-4887-49f3-8f</msg_id><err>null</err><fail_desc>UNDELIV</fail_desc><report_time>2016-11-18 12:37:13</report_time></report><report><corp_id>wj1566</corp_id><mobile>17058502349</mobile><sub_seq>0</sub_seq><msg_id>20161118123626-a927a1a2-4887-49f3-8f</msg_id><err>null</err><fail_desc>UNDELIV</fail_desc><report_time>2016-11-18 12:37:13</report_time></report><report><corp_id>wj1566</corp_id><mobile>17058502351</mobile><sub_seq>0</sub_seq><msg_id>20161118123626-c2d36d47-1d26-4f71-a0</msg_id><err>null</err><fail_desc>UNDELIV</fail_desc><report_time>2016-11-18 12:37:13</report_time></report><report><corp_id>wj1566</corp_id><mobile>17058502351</mobile><sub_seq>0</sub_seq><msg_id>20161118123626-c2d36d47-1d26-4f71-a0</msg_id><err>null</err><fail_desc>UNDELIV</fail_desc><report_time>2016-11-18 12:37:13</report_time></report><report><corp_id>wj1566</corp_id><mobile>17058502354</mobile><sub_seq>0</sub_seq><msg_id>20161118123626-e7d1c5a7-ac58-49cb-a1</msg_id><err>null</err><fail_desc>UNDELIV</fail_desc><report_time>2016-11-18 12:37:13</report_time></report><report><corp_id>wj1566</corp_id><mobile>17058502354</mobile><sub_seq>0</sub_seq><msg_id>20161118123626-e7d1c5a7-ac58-49cb-a1</msg_id><err>null</err><fail_desc>UNDELIV</fail_desc><report_time>2016-11-18 12:37:13</report_time></report><report><corp_id>wj1566</corp_id><mobile>17058502375</mobile><sub_seq>0</sub_seq><msg_id>20161118123626-05f4ae20-b68e-4ae9-a7</msg_id><err>null</err><fail_desc>UNDELIV</fail_desc><report_time>2016-11-18 12:37:13</report_time></report><report><corp_id>wj1566</corp_id><mobile>17058502375</mobile><sub_seq>0</sub_seq><msg_id>20161118123626-05f4ae20-b68e-4ae9-a7</msg_id><err>null</err><fail_desc>UNDELIV</fail_desc><report_time>2016-11-18 12:37:13</report_time></report><report><corp_id>wj1566</corp_id><mobile>17058502389</mobile><sub_seq>0</sub_seq><msg_id>20161118123626-642ce973-1da3-40e7-8f</msg_id><err>null</err><fail_desc>UNDELIV</fail_desc><report_time>2016-11-18 12:37:13</report_time></report><report><corp_id>wj1566</corp_id><mobile>17058502389</mobile><sub_seq>0</sub_seq><msg_id>20161118123626-642ce973-1da3-40e7-8f</msg_id><err>null</err><fail_desc>UNDELIV</fail_desc><report_time>2016-11-18 12:37:13</report_time></report><report><corp_id>wj1566</corp_id><mobile>17058502391</mobile><sub_seq>0</sub_seq><msg_id>20161118123626-ac11e731-38ca-48ff-94</msg_id><err>null</err><fail_desc>UNDELIV</fail_desc><report_time>2016-11-18 12:37:13</report_time></report><report><corp_id>wj1566</corp_id><mobile>17058502391</mobile><sub_seq>0</sub_seq><msg_id>20161118123626-ac11e731-38ca-48ff-94</msg_id><err>null</err><fail_desc>UNDELIV</fail_desc><report_time>2016-11-18 12:37:13</report_time></report><report><corp_id>wj1566</corp_id><mobile>17058502444</mobile><sub_seq>0</sub_seq><msg_id>20161118123626-0caf21ff-6e4f-490b-91</msg_id><err>null</err><fail_desc>UNDELIV</fail_desc><report_time>2016-11-18 12:37:13</report_time></report><report><corp_id>wj1566</corp_id><mobile>17058502444</mobile><sub_seq>0</sub_seq><msg_id>20161118123626-0caf21ff-6e4f-490b-91</msg_id><err>null</err><fail_desc>UNDELIV</fail_desc><report_time>2016-11-18 12:37:13</report_time></report><report><corp_id>wj1566</corp_id><mobile>17058502489</mobile><sub_seq>0</sub_seq><msg_id>20161118123626-83b6a9dd-f8e0-4a45-97</msg_id><err>null</err><fail_desc>UNDELIV</fail_desc><report_time>2016-11-18 12:37:13</report_time></report><report><corp_id>wj1566</corp_id><mobile>17058502489</mobile><sub_seq>0</sub_seq><msg_id>20161118123626-83b6a9dd-f8e0-4a45-97</msg_id><err>null</err><fail_desc>UNDELIV</fail_desc><report_time>2016-11-18 12:37:13</report_time></report><report><corp_id>wj1566</corp_id><mobile>17058502545</mobile><sub_seq>0</sub_seq><msg_id>20161118123626-5866cf32-af12-4ce5-86</msg_id><err>null</err><fail_desc>UNDELIV</fail_desc><report_time>2016-11-18 12:37:13</report_time></report><report><corp_id>wj1566</corp_id><mobile>17058502545</mobile><sub_seq>0</sub_seq><msg_id>20161118123626-5866cf32-af12-4ce5-86</msg_id><err>null</err><fail_desc>UNDELIV</fail_desc><report_time>2016-11-18 12:37:13</report_time></report><report><corp_id>wj1566</corp_id><mobile>17058502546</mobile><sub_seq>0</sub_seq><msg_id>20161118123626-57419088-944c-443a-95</msg_id><err>null</err><fail_desc>UNDELIV</fail_desc><report_time>2016-11-18 12:37:13</report_time></report><report><corp_id>wj1566</corp_id><mobile>17058502546</mobile><sub_seq>0</sub_seq><msg_id>20161118123626-57419088-944c-443a-95</msg_id><err>null</err><fail_desc>UNDELIV</fail_desc><report_time>2016-11-18 12:37:13</report_time></report><report><corp_id>wj1566</corp_id><mobile>17058502555</mobile><sub_seq>0</sub_seq><msg_id>20161118123626-16a81408-2710-4051-8a</msg_id><err>null</err><fail_desc>UNDELIV</fail_desc><report_time>2016-11-18 12:37:13</report_time></report><report><corp_id>wj1566</corp_id><mobile>17058502555</mobile><sub_seq>0</sub_seq><msg_id>20161118123626-16a81408-2710-4051-8a</msg_id><err>null</err><fail_desc>UNDELIV</fail_desc><report_time>2016-11-18 12:37:13</report_time></report><report><corp_id>wj1566</corp_id><mobile>17058502608</mobile><sub_seq>0</sub_seq><msg_id>20161118123627-d2369c59-d97e-404b-8b</msg_id><err>null</err><fail_desc>UNDELIV</fail_desc><report_time>2016-11-18 12:37:13</report_time></report><report><corp_id>wj1566</corp_id><mobile>17058502608</mobile><sub_seq>0</sub_seq><msg_id>20161118123627-d2369c59-d97e-404b-8b</msg_id><err>null</err><fail_desc>UNDELIV</fail_desc><report_time>2016-11-18 12:37:13</report_time></report><report><corp_id>wj1566</corp_id><mobile>17058502632</mobile><sub_seq>0</sub_seq><msg_id>20161118123627-b8123bb3-bbd6-43d7-ac</msg_id><err>null</err><fail_desc>UNDELIV</fail_desc><report_time>2016-11-18 12:37:13</report_time></report><report><corp_id>wj1566</corp_id><mobile>17058502632</mobile><sub_seq>0</sub_seq><msg_id>20161118123627-b8123bb3-bbd6-43d7-ac</msg_id><err>null</err><fail_desc>UNDELIV</fail_desc><report_time>2016-11-18 12:37:13</report_time></report><report><corp_id>wj1566</corp_id><mobile>17058502770</mobile><sub_seq>0</sub_seq><msg_id>20161118123627-9424468a-378a-4745-85</msg_id><err>null</err><fail_desc>UNDELIV</fail_desc><report_time>2016-11-18 12:37:13</report_time></report><report><corp_id>wj1566</corp_id><mobile>17058502770</mobile><sub_seq>0</sub_seq><msg_id>20161118123627-9424468a-378a-4745-85</msg_id><err>null</err><fail_desc>UNDELIV</fail_desc><report_time>2016-11-18 12:37:13</report_time></report><report><corp_id>wj1566</corp_id><mobile>17058502805</mobile><sub_seq>0</sub_seq><msg_id>20161118123627-e5c70c50-c3e3-41f8-aa</msg_id><err>null</err><fail_desc>UNDELIV</fail_desc><report_time>2016-11-18 12:37:13</report_time></report><report><corp_id>wj1566</corp_id><mobile>17058502805</mobile><sub_seq>0</sub_seq><msg_id>20161118123627-e5c70c50-c3e3-41f8-aa</msg_id><err>null</err><fail_desc>UNDELIV</fail_desc><report_time>2016-11-18 12:37:13</report_time></report><report><corp_id>wj1566</corp_id><mobile>17058502556</mobile><sub_seq>0</sub_seq><msg_id>20161118123626-1d70106a-c86d-4417-97</msg_id><err>null</err><fail_desc>UNDELIV</fail_desc><report_time>2016-11-18 12:37:13</report_time></report><report><corp_id>wj1566</corp_id><mobile>17058502556</mobile><sub_seq>0</sub_seq><msg_id>20161118123626-1d70106a-c86d-4417-97</msg_id><err>null</err><fail_desc>UNDELIV</fail_desc><report_time>2016-11-18 12:37:13</report_time></report><report><corp_id>wj1566</corp_id><mobile>17058502600</mobile><sub_seq>0</sub_seq><msg_id>20161118123627-5c480914-c3ae-439e-9f</msg_id><err>null</err><fail_desc>UNDELIV</fail_desc><report_time>2016-11-18 12:37:13</report_time></report><report><corp_id>wj1566</corp_id><mobile>17058502600</mobile><sub_seq>0</sub_seq><msg_id>20161118123627-5c480914-c3ae-439e-9f</msg_id><err>null</err><fail_desc>UNDELIV</fail_desc><report_time>2016-11-18 12:37:13</report_time></report></reports>";
//				//"<?xml version=\"1.0\" encoding=\"GBK\" ?><reports><report><corp_id>wj5016</corp_id><mobile>17090010137</mobile><sub_seq>0</sub_seq><msg_id>20160714233317-645e1aaa-52d9-4d98-88</msg_id><err>2</err><fail_desc>UNDELIV</fail_desc><report_time>2016-07-14 22:32:00</report_time></report></reports>";
//				Map<String, Object> map = BWNewClient.parseString4ReportResult(result);
//				
//				log.debug("map= parseString4ReportResult:" + map.size());
//				BWNewClient.tempResultMap.putAll(map);			
////end test
				// 实例化HttpClient对象
				HttpClient client = new HttpClient();
				// PostMethod对象用于存放地址
				PostMethod post = new PostMethod(BaiwuNewConstant.READ_URL);
				// NameValuePair数组对象用于传入参数
				post.addRequestHeader("Content-Type", BaiwuNewConstant.CONTENT_TYPE);// 在头文件中设置转码

				NameValuePair corp_id = new NameValuePair("corp_id", BaiwuNewConstant.ID);
				NameValuePair user_id = new NameValuePair("user_id", BaiwuNewConstant.ID);
				NameValuePair corp_pwd = new NameValuePair("corp_pwd", BaiwuNewConstant.CORP_PWD);
				post.setRequestBody(new NameValuePair[] {corp_id, user_id, corp_pwd});
				// 执行的状态
				int excuteStatus;
				InputStream is = null;
				try {
					excuteStatus = client.executeMethod(post);
					log.debug("********** HttpClient执行post方法状态 : " + excuteStatus + " **********");

					//String responseBodyAA = post.getResponseBodyAsString();
					//log.debug("********** responseBodyAA：" + responseBodyAA + " **********");
					// 返回的数字，对应着不同的情况
					is = post.getResponseBodyAsStream();
					// 根据返回的xml内容判断是否要进行解析
					String result = BWNewClient.fromStream2String(is, "UTF-8");
					log.debug("********** 此次状态报告返回结果为：" + result + System.getProperty("line.separator") + " **********");
					if (!isXML(result)) {
						continue;
					}
					result = StringUtils.CheckUnicodeStringAndReplcace(result,' ');
					Map<String, Object> map = BWNewClient.parseString4ReportResult(result);
					
					BWNewClient.tempResultMap.putAll(map);

					log.debug("map= parseString4ReportResult:" + map.size());
					
				} catch (IOException e) {
					log.error("读取回执过程发生异常  socket error", e);
				} catch (Exception e) {
					log.error("读取回执过程发生异常 ", e);
				} finally {
					try {
						if (is != null){
							is.close();
						}
					} catch (IOException e) {
						log.error("Error ", e);
					}
					if(post!=null){
						// 关闭连接
						post.releaseConnection();
					}
				}
			}
		}
	}

	public static String parseString4MSGResult(String source){
		String result = "";
		if(source != null){
			if(source.startsWith("0")){
				//发送成功
				result = "0";
			}else{
				//发送失败
				result = "1";
			}
		}
		return result;
	}
	
	private String genMsgId(){
		return (DateUtils.format(new Date(), "yyyyMMddHHmmss")+"-"+UUID.randomUUID()).substring(0, 36);
	}
	
	/**
	 * 将流转化为字符串
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
	
	public static boolean isXML(String result) {
		return Pattern.compile("<?xml[\\s\\S]*").matcher(result).find();
	}
	
	/**
	 * 解析短信状态接口返回的xml格式字符串
	 * @param responseBody
	 * @param string
	 * @return Map<String,String>key：短信id，value：短信结果
	 */
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
			Iterator reports = root.elementIterator("report");
			while (reports.hasNext()) {
				Element msgReport = (Element) reports.next();
				// 将信息添加进map容器中 把其他信息写入到value里面
				//map.put(msgReport.elementTextTrim("msg_id"), msgReport.elementTextTrim("fail_desc"));
				
				ReportRespObj robj = new ReportRespObj();
				robj.setCorp_id(msgReport.elementTextTrim("corp_id"));
				robj.setMobile(msgReport.elementTextTrim("mobile"));
				robj.setSub_seq(msgReport.elementTextTrim("sub_seq"));
				robj.setErr(msgReport.elementTextTrim("err"));
				robj.setMsg_id(msgReport.elementTextTrim("msg_id"));
				robj.setFail_desc(msgReport.elementTextTrim("fail_desc"));
				robj.setReport_time(msgReport.elementTextTrim("report_time"));
				map.put(msgReport.elementTextTrim("msg_id"), robj);
			}
		} catch (DocumentException e) {
			e.printStackTrace();
			log.error("********** 状态报告接口返回结果 error:" + responseBody + System.getProperty("line.separater") + " error: ", e);
		}
		return map;
	}
}
