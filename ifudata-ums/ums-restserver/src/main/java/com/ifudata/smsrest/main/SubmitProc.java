package com.ifudata.smsrest.main;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SubmitProc implements Runnable {
	private static final Log log = LogFactory.getLog(SubmitProc.class);
//	private ISmsRestTask smsRestTaskService = (ISmsRestTask)ApplicationContextUtil
//			.getInstance().getBean("smsRestTaskService");
//	private ISysSequenceCredit sysSequence = (ISysSequenceCredit)ApplicationContextUtil
//			.getInstance().getBean("sysSequence");
	
	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
				log.error("SubmitProc error:" + e);
			}			
		}
	}

}
