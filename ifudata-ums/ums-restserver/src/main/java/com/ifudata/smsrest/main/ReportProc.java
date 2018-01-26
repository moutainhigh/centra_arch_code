package com.ifudata.smsrest.main;

public class ReportProc implements Runnable {
//	private static final Log log = LogFactory.getLog(ReportProc.class);
//	private ISmsRestTask smsRestTaskService = (ISmsRestTask)ApplicationContextUtil
//			.getInstance().getBean("smsRestTaskService");
//	private ISysSequenceCredit sysSequence = (ISysSequenceCredit)ApplicationContextUtil
//			.getInstance().getBean("sysSequence");
	
	@Override
	public void run() {
		while (true) {
			
			//Iterator<String> iterator = RestServer.reportArray.iterator();
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
