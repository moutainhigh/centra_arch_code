package com.ifudata.ums.service.http.sikong.client;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.ifudata.ums.constant.SysParamConstant;
import com.ifudata.ums.dao.mapper.bo.SmsCommTask;
import com.ifudata.ums.exception.FindSeqenceException;
import com.ifudata.ums.exception.InsertException;
import com.ifudata.ums.exception.UpdateException;
import com.ifudata.ums.manager.ISmsCommTask;
import com.ifudata.ums.manager.ISysSequenceCredit;
import com.ifudata.ums.service.http.sikong.constant.SikongConstant;
import com.ifudata.ums.service.http.sikong.msgobj.DeliverObj;
import com.ifudata.ums.util.ApplicationContextUtil;

public class SikongClientDeliver implements Runnable{
	
	private static final Log log = LogFactory.getLog(SikongClientDeliver.class);
	private ISmsCommTask smsCommTaskService = (ISmsCommTask)ApplicationContextUtil
			.getInstance().getBean("smsCommTaskService");
	private ISysSequenceCredit sysSequence = (ISysSequenceCredit)ApplicationContextUtil
			.getInstance().getBean("sysSequence");
	@Override
	public void run() {
		//首先设置当前线程名称
		Thread.currentThread().setName("SikongClientDeliver");
		while (true) {

			try {
				log.debug("********** sikong writeMessage 方法状态 :  **********");
				// 实例化HttpClient对象
				HttpClient client = new HttpClient();
				// PostMethod对象用于存放地址
				PostMethod post = new PostMethod(SikongConstant.DELIVER_URL);
				// 在头文件中设置转码
				post.addRequestHeader("Content-Type", SikongConstant.CONTENT_TYPE);

				NameValuePair corp_id = new NameValuePair("corp_id", SikongConstant.CORP_ID);
				NameValuePair user_id = new NameValuePair("user_id", SikongConstant.USER_ID);
				NameValuePair corp_pwd = new NameValuePair("corp_pwd", SikongConstant.CORP_PWD);
				
				post.setRequestBody(new NameValuePair[] { corp_id, user_id, corp_pwd});
				// 执行的状态
				int excuteStatus = client.executeMethod(post);
				log.debug("********** HttpClient执行post方法状态 : "+excuteStatus+" **********");
				// 返回的数字，对应着不同的情况
				String responseBody = post.getResponseBodyAsString();
				// 关闭连接
				post.releaseConnection();
				log.debug("********** responseBody : "+responseBody+" **********");
				
				Map<String, Object> map = this.parseString4DeliverResult(responseBody);
				if (map.size() > 0) {
					saveToSmsCommTask(map);
				}
			} catch (Exception e) {
				log.debug("**********write message 过程发生异常**********", e);
			} finally {
				try {
					Thread.sleep(SysParamConstant.SLEEP_TIME_RECEIVER);
				} catch (InterruptedException e) {
					log.error("接收异常", e);
				}
			}
		}
	}
	
	private void saveToSmsCommTask(Map<String, Object> map) {
		List<SmsCommTask> sctlist = new ArrayList<>();
		for (Map.Entry<String, Object> entry : map.entrySet()) {
			if (entry.getValue() instanceof DeliverObj) {
				DeliverObj robj = (DeliverObj) entry;
				
				SmsCommTask sct = new SmsCommTask();
				try {
					sct.setCommTaskSerial(Integer.valueOf(sysSequence.getSequence("SAC_SMS_MM").toString()));
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (UpdateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (FindSeqenceException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				sct.setSvcType("0");
				sct.setRegionId("Z");
				sct.setDeviceNumber(robj.getMobile());
				sct.setRunStatus("0");
				sct.setMessage(robj.getContent());
				sct.setTryNum(0);
				sct.setSpNumber(robj.getCorp_id());
				sct.setReturnResult(null);
				
				sctlist.add(sct);
			}
		}
		
		try {
			smsCommTaskService.insertSmsCommTask(sctlist);
		} catch (InsertException e) {
			// TODO Auto-generated catch block
			log.debug("插入SmsCommTask表失败 "+e.toString());
		}
		
	}
	
	private Map<String, Object> parseString4DeliverResult(String responseBody) {
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
			Iterator reports = root.elementIterator("deliver");
			while (reports.hasNext()) {
				Element msgReport = (Element) reports.next();
				// 将信息添加进map容器中 把其他信息写入到value里面
				//map.put(msgReport.elementTextTrim("msg_id"), msgReport.elementTextTrim("fail_desc"));
				
				DeliverObj robj = new DeliverObj();
				robj.setCorp_id(msgReport.elementTextTrim("corp_id"));
				robj.setMobile(msgReport.elementTextTrim("mobile"));
				robj.setExt(msgReport.elementTextTrim("ext"));
				robj.setTime(msgReport.elementTextTrim("time"));
				robj.setContent(msgReport.elementTextTrim("content"));
				map.put(msgReport.elementTextTrim("time") + msgReport.elementTextTrim("mobile"), robj);
			}
		} catch (DocumentException e) {
			e.printStackTrace();
			log.debug("********** 状态报告接口返回结果:" + responseBody + System.getProperty("line.separater")+" **********");
		}
		return map;
	}	
}
