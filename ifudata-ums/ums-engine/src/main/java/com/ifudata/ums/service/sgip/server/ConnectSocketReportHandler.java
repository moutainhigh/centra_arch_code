package com.ifudata.ums.service.sgip.server;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Iterator;
import org.apache.log4j.Logger;
import com.ifudata.ums.service.sgip.SGIPMsg;
import com.ifudata.ums.service.sgip.interf.MessageHandleMonitor;

/**
 *  发送report 回执
 *  2016-02-17
 *  @author zhanghy6
 */

public class ConnectSocketReportHandler implements Runnable {

	private static final Logger logger = Logger.getLogger(ConnectSocketReportHandler.class);

	private Socket socket;

	private MessageHandleMonitor msgMonitor;

	public ConnectSocketReportHandler(Socket socket, MessageHandleMonitor messageHandler) {
		this.socket = socket;
		this.msgMonitor = messageHandler;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			OutputStream os = null;
			
			try {
				os = socket.getOutputStream();
				
				Iterator<SGIPMsg> iteratorMo = msgMonitor.mapMo.iterator();
				//logger.debug("msgMonitor.mapMo size:" + msgMonitor.mapMo.size());
			    while (iteratorMo.hasNext()) {
			    	synchronized (Object.class) {
				    	SGIPMsg value = iteratorMo.next(); //(SGIPMsg)msgMonitor.mapMo.get(key);
				    	//String key = iteratorMo.next();
						os.write(value.getByteData());
						os.flush();
						logger.debug("msgMonitor.mapMo write:" + value);
						//iteratorMo.remove();
						msgMonitor.mapMo.remove(value);
			    	}
			    }
				
			    //Iterator<String> iteratorMt = msgMonitor.mapMt.keySet().iterator();
			    Iterator<SGIPMsg> iteratorMt = msgMonitor.mapMt.iterator();
			    logger.debug("msgMonitor.mapMt size:" + msgMonitor.mapMt.size());
			    while (iteratorMt.hasNext()) {
			    	synchronized (Object.class) {
				    	//String key = iteratorMt.next();
				    	SGIPMsg value = iteratorMt.next(); //(SGIPMsg)msgMonitor.mapMt.get(key);
						os.write(value.getByteData());
						os.flush();
						
						logger.debug("msgMonitor.mapMt write:" + value);
						msgMonitor.mapMt.remove(value);
						//iteratorMt.remove();
			    	}
			    }
			} catch (IOException e) {
				logger.error(" sender server socket is closed", e);
				return;
			} catch (Exception e) {
				e.printStackTrace();
				try {
					this.finalize();
				} catch (Throwable e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				return;
			}

			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
