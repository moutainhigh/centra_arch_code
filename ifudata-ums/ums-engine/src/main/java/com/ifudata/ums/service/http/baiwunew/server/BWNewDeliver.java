package com.ifudata.ums.service.http.baiwunew.server;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
//import org.w3c.dom.Document;
//import org.w3c.dom.Element;
//import org.w3c.dom.Node;
//import org.w3c.dom.NodeList;
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
import com.ifudata.ums.util.ApplicationContextUtil;


public class BWNewDeliver implements Runnable {
	private static final Log log = LogFactory.getLog(BWNewDeliver.class);
	private ISmsCommTask smsCommTaskService = (ISmsCommTask)ApplicationContextUtil
			.getInstance().getBean("smsCommTaskService");
	private ISysSequenceCredit sysSequence = (ISysSequenceCredit)ApplicationContextUtil
			.getInstance().getBean("sysSequence");
	
	@Override
	public void run() {
		Thread.currentThread().setName("BWNewDeliver");
		while (true) {
			try {
				Thread.sleep(SysParamConstant.SLEEP_TIME_RECEIVER);
			} catch (InterruptedException e) {
				log.error("InterruptedException Error:", e);
			}
			//BWNewServer svrInstance = BWNewServer.getInstance();
			//svrInstance.deliverMap.put(key, value);
			
			Iterator<String> iterator = BWNewServer.deliverArray.iterator();
			while (iterator.hasNext()) {
		    	synchronized (Object.class) {
					String key = iterator.next();
					log.debug("**SGIPClient.tempResultMap key:" + key + "**");

					BWNewServer.deliverArray.remove(key);
					//System.setProperty( "javax.xml.parsers.DocumentBuilderFactory","com.sun.org.apache.xerces.internal.jaxp.DocumentBuilderFactoryImpl" );
					
					List<SmsCommTask> sctlist = new ArrayList<>();
					Document doc = null;
					try {
						doc = DocumentHelper.parseText(key);
					} catch (DocumentException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						continue;
					}
//					try {
//						doc = XmlUtils.loadString(key);
//					} catch (Exception e1) {
//						e1.printStackTrace();
//						//System.setProperty( "javax.xml.parsers.DocumentBuilderFactory","org.apache.xerces.jaxp.DocumentBuilderFactoryImpl" );
//						continue;
//					}
					//System.setProperty( "javax.xml.parsers.DocumentBuilderFactory","org.apache.xerces.jaxp.DocumentBuilderFactoryImpl" );
					
//					NodeList nl = doc.getElementsByTagName("deliver");
//					if (nl == null) 
//						continue;
//					
//					List<SmsCommTask> sctlist = new ArrayList<>();
//					for (int i = 0; i < nl.getLength(); i++) {
//				    	Element deliverNode = (Element) nl.item(i);
//				    	DeliverObj obj = DeliverObj.loadFromDocument(deliverNode);
//				       
//						if (obj != null) {
//							SmsCommTask sct = new SmsCommTask();
//							try {
//								sct.setCommTaskSerial(Integer.valueOf(sysSequence.getSequence("SMS_COMM_TASK").toString()));
//							} catch (NumberFormatException e) {
//								// TODO Auto-generated catch block
//								e.printStackTrace();
//							} catch (UpdateException e) {
//								// TODO Auto-generated catch block
//								e.printStackTrace();
//							} catch (FindSeqenceException e) {
//								// TODO Auto-generated catch block
//								e.printStackTrace();
//							} catch (Exception e) {
//								// TODO Auto-generated catch block
//								e.printStackTrace();
//							}								
//							sct.setSvcType("0");
//							sct.setRegionId("Z");
//							sct.setDeviceNumber(obj.getMobile());
//							sct.setRunStatus("0");
//							sct.setMessage(obj.getContent());
//							sct.setTryNum(0);
//							sct.setSpNumber(obj.getCorp_id());
//							sct.setReturnResult(null);
//							
//							sctlist.add(sct);
//						}
//					}
////					try {
////						doc = doc. XmlUtils.loadString(key);
////					} catch (Exception e1) {
////						e1.printStackTrace();
////						continue;
////					}

					Element root = doc.getRootElement();
					@SuppressWarnings("unchecked")
					List<Element> childNodes = root.elements();
					for (Element ele : childNodes) {
						if (ele.getName().equalsIgnoreCase("deliver")) {
							DeliverObj obj = DeliverObj.loadFromDocument(ele);
							if (obj != null) {
								SmsCommTask sct = new SmsCommTask();
								try {
									sct.setCommTaskSerial(Integer.valueOf(sysSequence.getSequence("SMS_COMM_TASK").toString()));
								} catch (NumberFormatException e) {
									e.printStackTrace();
									continue;
								} catch (UpdateException e) {
									e.printStackTrace();
									continue;
								} catch (FindSeqenceException e) {
									e.printStackTrace();
									continue;
								} catch (Exception e) {
									e.printStackTrace();
									continue;
								}								
								sct.setSvcType("0");
								sct.setRegionId("Z");
								sct.setDeviceNumber(obj.getMobile());
								sct.setRunStatus("0");
								sct.setMessage(obj.getContent());
								sct.setTryNum(0);
								sct.setSpNumber(obj.getCorp_id());
								sct.setReturnResult(null);
								
								sctlist.add(sct);
							}
						}
					}

					if (sctlist.size() <= 0)
						return;
					
					try {
						smsCommTaskService.insertSmsCommTask(sctlist);
					} catch (InsertException e) {
						log.debug("插入SmsCommTask表失败 "+e.toString());
					}					
				}
			} // while
		} // while true
	}
}
