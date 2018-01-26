package com.ifudata.ums.core;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ifudata.ums.service.diy09.client.Diy09Client;
import com.ifudata.ums.service.diy09.client.Diy09Receiver;
import com.ifudata.ums.service.diy09.client.Diy09Sender;
import com.ifudata.ums.service.http.baiwu.client.BWClient;
import com.ifudata.ums.service.http.baiwu.client.BWReceiver;
import com.ifudata.ums.service.http.baiwu.client.BWSender;
import com.ifudata.ums.service.http.baiwunew.client.BWNewClient;
import com.ifudata.ums.service.http.baiwunew.client.BWNewReceiver;
import com.ifudata.ums.service.http.baiwunew.client.BWNewSender;
import com.ifudata.ums.service.http.byd.client.BYDClient;
import com.ifudata.ums.service.http.byd.client.BYDReceiver;
import com.ifudata.ums.service.http.byd.client.BYDSender;
import com.ifudata.ums.service.http.dahansantong.client.Submit.DHSTClientSubmit;
import com.ifudata.ums.service.http.dahansantong.client.Submit.DHSTReceiverSubmit;
import com.ifudata.ums.service.http.dahansantong.client.Submit.DHSTSenderSubmit;
import com.ifudata.ums.service.http.sikong.client.SikongClient;
import com.ifudata.ums.service.http.weilaiwuxian.client.WLWXClient;
import com.ifudata.ums.service.http.weilaiwuxian.client.WLWXSender;
import com.ifudata.ums.service.http.youku.client.YKClient;
import com.ifudata.ums.service.http.youku.client.YKReceiver;
import com.ifudata.ums.service.http.youku.client.YKSender;
import com.ifudata.ums.service.sgip.client.SGIPClient;
import com.ifudata.ums.service.sgip.client.SGIPReceiver;
import com.ifudata.ums.service.sgip.client.SGIPSender;

/**
 * 短信邮递员,包括两个子线程:发送和接收
 * 
 * @author guofei
 */
public class SMPostman implements Runnable {

	private static final Log log = LogFactory.getLog(SMPostman.class);

	private SMAbstractClient smWriteClient;

	private SMAbstractClient smReadClient;

	@Override
	public void run() {

		log.info("********** SMPostman 启动。。。。。。**********");
		try {
			SMSender smSender = null;
			SMReceiver smReceiver = null;
			if (smWriteClient instanceof SGIPClient) {
				// 启动心跳机
				//new Thread(new HeartBeatMachine(smWriteClient)).start();
				smSender = new SGIPSender(smWriteClient);
				smReceiver = new SGIPReceiver(smReadClient);
			} else if (smWriteClient instanceof BWClient) {
				log.info("********** 当前协议是百悟, smWriteClient = " + smWriteClient + "**********");
				smSender = new BWSender(smWriteClient);
				smReceiver = new BWReceiver(smReadClient);
			} else if (smWriteClient instanceof BWNewClient) {
				log.info("********** 当前协议是百悟, smWriteClient = " + smWriteClient + "**********");
				smSender = new BWNewSender(smWriteClient);
				smReceiver = new BWNewReceiver(smReadClient);
			} else if (smWriteClient instanceof YKClient) {
				smSender = new YKSender(smWriteClient);
				smReceiver = new YKReceiver(smReadClient);
			} else if (smWriteClient instanceof DHSTClientSubmit) {
				smSender = new DHSTSenderSubmit(smWriteClient);
				smReceiver = new DHSTReceiverSubmit(smReadClient);
			} else if (smWriteClient instanceof Diy09Client) {
				log.info("********** 当前协议是diy09, smWriteClient = " + smWriteClient + "**********");
				smSender = new Diy09Sender(smWriteClient);
				smReceiver = new Diy09Receiver(smReadClient);
			} else if (smWriteClient instanceof BYDClient) {
				log.info("********** 当前协议是byd, smWriteClient = " + smWriteClient + "**********");
				smSender = new BYDSender(smWriteClient);
				smReceiver = new BYDReceiver(smReadClient);
			} else if (smWriteClient instanceof WLWXClient) {
				smSender = new WLWXSender(smWriteClient);
			} else if (smWriteClient instanceof SikongClient) {
				smSender = new WLWXSender(smWriteClient);
			}			
			// 启动消息发送子线程
			new Thread(smSender).start();
			// 启动消息接收子线程
			new Thread(smReceiver).start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setSmWriteClient(SMAbstractClient smWriteClient) {
		this.smWriteClient = smWriteClient;
	}

	public void setSmReadClient(SMAbstractClient smReadClient) {
		this.smReadClient = smReadClient;
	}

}
