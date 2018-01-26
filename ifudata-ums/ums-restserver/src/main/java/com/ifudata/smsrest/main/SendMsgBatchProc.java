package com.ifudata.smsrest.main;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SendMsgBatchProc implements Runnable {
	private static final Log log = LogFactory.getLog(SendMsgBatchProc.class);
	@Override
	public void run() {
		while (true) {
			
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
				log.error("SendMsgBatchProc error:" + e);
			}
		}
	}
}

