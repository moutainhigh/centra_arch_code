package com.ifudata.smsrest.main;

public class FullOjectStatusProc implements Runnable {
	//private static final Log log = LogFactory.getLog(FullOjectStatusProc.class);
	@Override
	public void run() {
		while (true) {
			
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
