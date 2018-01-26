package com.ifudata.ums.service.diy09.client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ifudata.ums.core.SMAbstractClient;
import com.ifudata.ums.constant.Constant;
import com.ifudata.ums.constant.SysParamConstant;
import com.ifudata.ums.dao.mapper.bo.SmsCommTask;
import com.ifudata.ums.exception.InsertException;
import com.ifudata.ums.manager.ISmsCommTask;
import com.ifudata.ums.service.diy09.constant.diy09Constant;
import com.ifudata.ums.util.ApplicationContextUtil;

import smscommon.ComFun;
import smscommon.SmsClient;
import smsmessage.sms.DELIVER;
import smsmessage.sms.SMSclientSubmit;

public class Diy09Client extends SMAbstractClient {
	private static final Log log = LogFactory.getLog(Diy09Client.class);
	private static final Map<String, Object> tempResultMap = new ConcurrentHashMap<String, Object>();
	private ISmsCommTask smsCommTaskService = (ISmsCommTask)ApplicationContextUtil
			.getInstance().getBean("smsCommTaskService");
	
	static {
		SmsClient smsClient = SmsClient.getInstance();
		if (smsClient != null) {
			log.info("smsClient " + smsClient);
		}
	}

	private class ReadTask implements Runnable {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			log.debug("Diy09Client ReadTask run");

			DELIVER deliver = new DELIVER();
			while (true) {
				try {
					Thread.sleep(SysParamConstant.SLEEP_TIME_RECEIVER);
				} catch (InterruptedException e) {
					log.error("Error", e);
				}

				try {
					if ((deliver = ComFun.getSMS()) != null) {
					//destID=,serviceID=,msgFmt=0,srcID=17058500056,srcType=0,msgLength=83,msgContent=1601261729170001,linkID=0,
					//messageType=1,State=0,ErrorCode=0,Reserve=DELIVRD,ariveTime=20160126 17:29:21
						//for test
//					deliver.setReportState((byte) 0);
//					deliver.setMessageType(1);
//					deliver.setReserve("DELIVRD");
//					deliver.setAriveTime("20160126 17:29:21");
//					deliver.setMsgContent("1601261729170001");
						log.debug("*********************Diy09Client ReadTask run deliver:" + deliver
								+ "***********************");
						if (deliver.getMsgFlag() == diy09Constant.C_CMPP_REPORT) {
							Diy09Client.tempResultMap.put(Constant.SEQUENCE_NUM, deliver.getMsgContent());
							Diy09Client.tempResultMap.put(Constant.RESULT_CODE, String.valueOf(deliver.getReportState()));
							Diy09Client.tempResultMap.put(Constant.RESULT_CONTENT, deliver.getReserve());
							// "消息推送状态:" + deliver.getReportState() + ",
							// 消息推送状态描述：" + deliver.getReserve());
							log.debug(
									"Diy09Client ReadTask run Diy09Client.tempResultMap, " + Diy09Client.tempResultMap);
						} else {
							// 上行消息 此处不处理 应该是业务受理部分的短信 写日志
							log.debug("上行消息：destid=" + deliver.getDestID() + "; SrcID=" + deliver.getSrcID()
									+ "; MsgContent=" + deliver.getMsgContent() + "; AriveTime="
									+ deliver.getAriveTime());
							
							if (SysParamConstant.PROCESS_UPDELIVERS.equalsIgnoreCase("y")) {
								List<SmsCommTask> sctlist = new ArrayList<>();
								SmsCommTask sct = new SmsCommTask();
								sct.setSvcType(SysParamConstant.SERVICE_TYPE.toString());
								sct.setRegionId("Z");
								sct.setDeviceNumber(deliver.getSrcID());
								sct.setRunStatus("0");
								sct.setMessage(deliver.getMsgContent());
								sct.setTryNum(0);
								sct.setSpNumber(SysParamConstant.SERVER_ID);
								sct.setReturnResult(null);
								sctlist.add(sct);
								try {
									smsCommTaskService.insertSmsCommTask(sctlist);
								} catch (InsertException e) {
									// TODO Auto-generated catch block
									log.error("插入SmsCommTask表失败 "+e.toString());
								}
							}
						}
					}
					//else
					//	log.debug("Diy09Client ReadTask run deliver:" + deliver);
				} catch (Exception e) {
					if (!(e.getMessage().contains("read server response time out"))) {
						log.error("Error", e);
					}
				}
			}
		}
	}

	@Override
	public Map<String, Object> writeMessage(String userNumber, String content) {
		Map<String, Object> status = new HashMap<String, Object>();
// for test		
//		status.put(Constant.SEQUENCE_NUM, "1601261729170001");
//		status.put(Constant.RESULT_CODE, "0");
//		status.put(Constant.RESULT_CONTENT, "");
//		return status;
		try {
			SMSclientSubmit mt = new SMSclientSubmit();
			List<String> listUserNumber = new ArrayList<String>();
			listUserNumber.add(userNumber);
			mt.setDestID(userNumber);
			mt.setMsgContent(content);
			mt.setPriority(1);
			String retVal = "1";

			log.debug("*********************Diy09Client writeMessage content, " + content + " userNumber:" + userNumber
					+ "***********************");
			int iloop = 0;
			while ("1".equals(retVal) || "2".equals(retVal) || "3".equals(retVal) || "4".equals(retVal)
					|| "5".equals(retVal) || "6".equals(retVal) || "7".equals(retVal) || "8".equals(retVal)
					|| "78".equals(retVal)) {
				retVal = mt.sendSMS();

				log.debug("*********************Diy09Client writeMessage mt, " + mt + " retVal:" + retVal
						+ "***********************");

				if ("1".equals(retVal)) {
					Thread.sleep(SysParamConstant.SLEEP_TIME_SENDER);
					log.error("下发缓冲池已满.");
				} else if ("2".equals(retVal)) {
					log.error("没有建立连接或连接断开");
					Thread.sleep(SysParamConstant.SLEEP_TIME_SENDER * 1);
				} else if ("3".equals(retVal)) {
					log.error("流量超过设定值");
					Thread.sleep(SysParamConstant.SLEEP_TIME_SENDER);
				} else if ("4".equals(retVal)) {
					log.error("短信长度超出限制");
					Thread.sleep(SysParamConstant.SLEEP_TIME_SENDER);
				} else if ("5".equals(retVal)) {
					log.error("群发数量超出限制");
					Thread.sleep(SysParamConstant.SLEEP_TIME_SENDER);
				} else if ("7".equals(retVal)) {
					log.error("手机号为空");
					Thread.sleep(SysParamConstant.SLEEP_TIME_SENDER);
				} else if ("8".equals(retVal)) {
					log.error("手机号超长");
					Thread.sleep(SysParamConstant.SLEEP_TIME_SENDER);
				} else if ("78".equals(retVal)) {
					log.error("手机号为空或号码超长，没有正确的号码");
					Thread.sleep(SysParamConstant.SLEEP_TIME_SENDER);
				} else {
					// 发送成功 消息标示 入队列
					status.put(Constant.SEQUENCE_NUM, retVal);
					status.put(Constant.RESULT_CODE, "0");
					status.put(Constant.RESULT_CONTENT, "");

					log.info("企业下行消息标识 [userNumber]" + userNumber + "[" + retVal + "]，" + "短信内容 [" + mt.getMsgContent() + "]");
					//log.debug("企业下行消息标识 [" + retVal + "]，" + "短信内容 [" + mt.getMsgContent() + "]");
					return status;
					// break;
				}
				status.put(Constant.SEQUENCE_NUM, retVal);
				status.put(Constant.RESULT_CODE, retVal);
				status.put(Constant.RESULT_CONTENT, diy09Constant.getFailedSendReasonString(retVal));
				// log.debug("Diy09Client writeMessage status, " + status);
				iloop++;
				if (iloop > 3)
					return status;
			}
		} catch (Exception e) {
			log.error("Error", e);
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
		boolean blSuccessed = false;
		Iterator<String> iterator = Diy09Client.tempResultMap.keySet().iterator();
	    while (iterator.hasNext()) {
	    	synchronized (Object.class) {
		    	String key = iterator.next();
		    	String value = Diy09Client.tempResultMap.get(key).toString();
				if (key.equals(Constant.RESULT_CODE)) {
					recMap.put(Constant.RESULT_CODE, value);
					if ("0".equals(value)) {
						blSuccessed = true;
					}
				} else if (key.equals(Constant.SEQUENCE_NUM)){
					recMap.put(Constant.SEQUENCE_NUM, value);
				} else {
					if (!blSuccessed) {
						recMap.put(Constant.RESULT_CONTENT, diy09Constant.getFailedReceiveReasonString(value));
					} else
						recMap.put(Constant.RESULT_CONTENT, "");
				}
		        //iterator.remove();   // 关键代码，同步modCount和expectedModCount
				Diy09Client.tempResultMap.remove(key);
	    	}
	    }
	    
//		if (Diy09Client.tempResultMap != null && Diy09Client.tempResultMap.size() > 0) {
//			for (Map.Entry<String, String> entry : Diy09Client.tempResultMap.entrySet()) {
//				if (entry.getKey().equals(Constant.RESULT_CODE)) {
//					recMap.put(Constant.RESULT_CODE, entry.getValue());
//				} else if (entry.getKey().equals(Constant.SEQUENCE_NUM)){
//					recMap.put(Constant.SEQUENCE_NUM, entry.getValue());
//				} else {
//					recMap.put(Constant.RESULT_CONTENT, diy09Constant.getFailedReceiveReasonString(entry.getValue()));
//				}
//				
//				///sdfdsjfd
//				
//				Diy09Client.tempResultMap.remove(entry.getKey());
//			}
//			
//		}

		//log.debug("*********************** Diy09Client readMessage recMap, " + recMap + "***********************");
		return recMap;
	}
}
