package com.ifudata.ums.service.sgip.interf;

import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

import org.apache.log4j.Logger;
import com.ifudata.ums.service.sgip.SGIPMsg;
import com.ifudata.ums.service.sgip.body.command.Deliver;
import com.ifudata.ums.service.sgip.body.command.Report;
import com.ifudata.ums.service.sgip.body.command.Submit;
import com.ifudata.ums.service.sgip.constant.ClientConstant;
import com.ifudata.ums.service.sgip.constant.SGIPConstant;
import com.ifudata.ums.service.sgip.factory.SGIPFactory;
import com.ifudata.ums.service.sgip.head.SGIPMsgHead;

/**
 * 消息后续处理机制监控器,负责轮询消息链表, 更新数据库状态, report消息回执等
 * 2016-02-17
 * @author zhanghy6
 */

public class MessageHandleMonitor implements Runnable {
	private static final Logger logger = Logger.getLogger(MessageHandleMonitor.class);
//和DefaultMessageHandler 相对应的消息处理  先不考虑数据库 
	//map中的key 就是消息头中的 SequenceNumber Object就是消息体
	public ConcurrentHashMap<String, Object> mapSubmit = new ConcurrentHashMap<String, Object>();
	public ConcurrentHashMap<String, Object> mapDeliver = new ConcurrentHashMap<String, Object>();
	public ConcurrentHashMap<String, Object> mapReport = new ConcurrentHashMap<String, Object>();
	
	//上行链表 各种可能 主要是report
	public CopyOnWriteArrayList<SGIPMsg> mapMo = new CopyOnWriteArrayList<SGIPMsg>();
	//下行链表
	public CopyOnWriteArrayList<SGIPMsg> mapMt = new CopyOnWriteArrayList<SGIPMsg>();
	@Override
	public void run() {
		// TODO Auto-generated method stub
		// 按照联通sgip协议流程处理 submit/deliver 后发report消息
		while (true) {
			//submit 的直接返回发送成功的状态
			Iterator<String> iteratorSubmit = this.mapSubmit.keySet().iterator();
//			System.out.println("mapSubmit:" + mapSubmit.size());
		    while (iteratorSubmit.hasNext()) {
		    	synchronized (Object.class) {

				String key = iteratorSubmit.next();
				SGIPMsg value = (SGIPMsg)mapSubmit.get(key);
				if (value == null) {
					logger.error("value == null :" + key + " this.mapSubmit.size:" + this.mapSubmit.size());
					break;
				}
					
				SGIPMsgHead head = value.getHead();
				Submit cmd = (Submit)value.getCommand();
				
				try {
					SGIPMsg sgipMsg = SGIPFactory.getSGIPMsg(SGIPConstant.SGIP_REPORT);
					Report report = new Report();
					report.setReportType(SGIPConstant.SGIP_REPORT_REPORTYPE_SUBMIT);
					report.setSubmitSequenceNumber(head.getSequenceNumber());
					report.setUserNumber(cmd.getListUserNumber().get(0));
					report.setState(0);
					report.setErrorCode(0);
					sgipMsg.setCommand(report);
					
					//下行
					mapMt.add(sgipMsg);
					logger.debug("mapMt.put:" + head.getSequenceNumberStr() + ",sgipMsg:" + sgipMsg);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				logger.debug("iteratorSubmit.remove before:" + this.mapSubmit.size() + " key:" + key);
				Object key1 = this.mapSubmit.remove(key);
				if (null == key1) {
					logger.debug("iteratorSubmit.remove null:" + " key:" + key);
				}
				//iteratorSubmit.remove();
				logger.debug("iteratorSubmit.remove after:" + this.mapSubmit.size() + " key:" + key);
		    }
		    }

		    Iterator<String> iteratorDeliver = mapDeliver.keySet().iterator();
		    while (iteratorDeliver.hasNext()) {
		    	synchronized (Object.class) {
		    	String key = iteratorDeliver.next();
				SGIPMsg value = (SGIPMsg)mapDeliver.get(key);
				  
				SGIPMsgHead head = value.getHead();
				Deliver cmd = (Deliver)value.getCommand();
				//应该先查表 更新状态此处略过
				try {
					SGIPMsg sgipMsg = SGIPFactory.getSGIPMsg(SGIPConstant.SGIP_REPORT);
					Report report = new Report();
					report.setReportType(SGIPConstant.SGIP_REPORT_REPORTYPE_SUBMIT);
					report.setSubmitSequenceNumber(head.getSequenceNumber());
					report.setUserNumber(cmd.getUserNumber());
					report.setState(0);
					report.setErrorCode(0);
					sgipMsg.setCommand(report);
					
					mapMo.add(sgipMsg);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				this.mapDeliver.remove(key);
				//iteratorDeliver.remove();
		    }
		    }
		    
		    Iterator<String> iteratorReport = mapReport.keySet().iterator();
		    while (iteratorReport.hasNext()) {
		    	synchronized (Object.class) {
		    	//更新数据库状态 无后续操作
				String key = iteratorReport.next();
				//SGIPMsg value = (SGIPMsg)mapReport.get(key);
//				  
//				SGIPMsgHead head = value.getHead();
//				SGIPCommand cmd = value.getCommand();
				if (ClientConstant.IS_NIO.equalsIgnoreCase("y")) {
					
				}
				this.mapReport.remove(key);
				//iteratorReport.remove();
		    }
		    }

			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
