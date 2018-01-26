package com.ifudata.ums.core;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ifudata.ums.constant.SysParamConstant;

public class HeartBeatMachine implements Runnable {

	private static final Log log = LogFactory.getLog(HeartBeatMachine.class);

	private SMAbstractClient smClient;

	public HeartBeatMachine(SMAbstractClient smClient) {
		this.smClient = smClient;
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(SysParamConstant.SLEEP_TIME_HEART_BEAT_MACHINE);
			} catch (InterruptedException e) {
				log.error("InterruptedException Error: ", e);
			}
			// 发送空报文
			// 号码为空字符串，消息内容为 "empty package"
			this.smClient.writeMessage("", "empty package");
			// log.debug("**********发送一次心跳, 心跳内容为 : empty package");
		}
	}
}
