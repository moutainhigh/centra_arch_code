package com.ifudata.smsrest.main;

import java.util.Iterator;
import com.ifudata.smsrest.main.RestServer;

public class DeliverProc implements Runnable {
//	private static final Log log = LogFactory.getLog(DeliverProc.class);
//	private ISmsRestTask smsRestTaskService = (ISmsRestTask)ApplicationContextUtil
//			.getInstance().getBean("smsRestTaskService");
//	private ISysSequenceCredit sysSequence = (ISysSequenceCredit)ApplicationContextUtil
//			.getInstance().getBean("sysSequence");
//	
	@Override
	public void run() {
		while (true) {
			Iterator<String> iterator = RestServer.deliverArray.iterator();
			while (iterator.hasNext()) {
		    	synchronized (Object.class) {
					String key = iterator.next();

					RestServer.deliverArray.remove(key);
//					
//					List<SmsRestTask> sctlist;
//					try {
//						sctlist = smsRestTaskService.getSmsRestTask(SysParamConstant.SERVICE_TYPE);
//					} catch (Exception e) {
//						e.printStackTrace();
//						continue;
//					}
//					List<DeliverObj> deliverList = new ArrayList<DeliverObj>();
//					
//					for (SmsRestTask ele : sctlist) {
//						DeliverObj obj = new DeliverObj();
//						obj.setCust_code(Constant.CORP_SERVICE);
//						obj.setSp_code(ele.getSpNumber());
//						obj.setMobile(ele.getDeviceNumber());
//						obj.setMsg_id(ele.getMsgId());
//						obj.setContent(ele.getMessage());
//						obj.setRecv_time(ele.getGetDate().toString());
//						deliverList.add(obj);
//					}
//					
//					Gson gson = new Gson();
//					String gs= gson.toJson(deliverList);
//					
//					Document doc;
//					try {
//						doc = DocumentHelper.parseText(key);
//					} catch (DocumentException e1) {
//						// TODO Auto-generated catch block
//						e1.printStackTrace();
//						continue;
//					}

		    	}
			} // while
			
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} // while true
	}
}