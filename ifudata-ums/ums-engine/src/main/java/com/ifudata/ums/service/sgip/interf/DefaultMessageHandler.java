/**
 * COPYRIGHT (C) 2010 LY. ALL RIGHTS RESERVED.
 *
 * No part of this publication may be reproduced, stored in a retrieval system,
 * or transmitted, on any form or by any means, electronic, mechanical, photocopying,
 * recording, or otherwise, without the prior written permission of 3KW.
 *
 * Created By: zzqiang
 * Created On: 2013-10-21
 *
 * Amendment History:
 * 
 * Amended By       Amended On      Amendment Description
 * ------------     -----------     ---------------------------------------------
 *
 **/
package com.ifudata.ums.service.sgip.interf;

import com.ifudata.ums.service.sgip.SGIPMsg;
import com.ifudata.ums.service.sgip.body.command.Deliver;
import com.ifudata.ums.service.sgip.body.command.Report;
import com.ifudata.ums.service.sgip.head.SGIPMsgHead;

import org.apache.log4j.Logger;

import com.ifudata.ums.service.sgip.body.command.Submit;

public class DefaultMessageHandler implements MessageHandler {

	private static final Logger logger = Logger.getLogger(DefaultMessageHandler.class);
	
	public static final MessageHandleMonitor msgMonitor = new MessageHandleMonitor();
	
	public boolean blFirst = false;
	@Override
	public void handleDeliverMessage(SGIPMsgHead head, Deliver deliver)
	{
		logger.debug("handle message recieve sgipMsgHead is " + head + " deliver detail:" + deliver);
		
		String key = head.getSequenceNumberStr();
		SGIPMsg value = new SGIPMsg();
		value.setHead(head);
		value.setCommand(deliver);
		
		if (!blFirst) {
			//new MessageHandleMonitor();
			new Thread(msgMonitor).start();
			blFirst = true;
		}
		msgMonitor.mapDeliver.put(key, value);
	}

	@Override
	public void handleReportMessage(SGIPMsgHead head, Report report)
	{
		logger.debug("handle message recieve sgipMsgHead is " + head + " report detail:" + report);
		
		//数据库 查询更新操作
		String key = head.getSequenceNumberStr();
		SGIPMsg value = new SGIPMsg();
		value.setHead(head);
		value.setCommand(report);
		
		if (!blFirst) {
			new Thread(msgMonitor).start();
			blFirst = true;
		}
		msgMonitor.mapReport.put(key, value);
	}
	
	@Override
	public void handleSubmitMessage(SGIPMsgHead head, Submit submit)
	{
		logger.debug("handle message send sgipMsgHead is " + head + " submit detail:" + submit);
		
		//此处处理来自客户端的 submit消息 处理后发送report回执
		//1. 写数据库 链表
		//2. 等待更新report状态
		//3. 将report状态发送回去
		
		//1. 此处不写数据库 只写链表
		String key = head.getSequenceNumberStr();
		SGIPMsg value = new SGIPMsg();
		value.setHead(head);
		value.setCommand(submit);
		
		if (!blFirst) {
			new Thread(msgMonitor).start();
			blFirst = true;
		}
		msgMonitor.mapSubmit.put(key, value);
		System.out.println("msgMonitor.mapSubmit:" + msgMonitor.mapSubmit.size());
	}
}
