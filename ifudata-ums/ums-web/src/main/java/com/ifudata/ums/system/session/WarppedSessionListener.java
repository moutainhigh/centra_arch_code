package com.ifudata.ums.system.session;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


public class WarppedSessionListener implements HttpSessionListener {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

	@Override
	public void sessionCreated(HttpSessionEvent sessionEvent) {
		Log log = LogFactory.getLog("WarppedSessionListener");
		log.info("---------------------------------创建session："+sessionEvent.getSession());
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent sessionEvent) {
		Log log = LogFactory.getLog("WarppedSessionListener");
		log.info("---------------------------------session失效："+sessionEvent.getSession());
		HttpSession session = sessionEvent.getSession();
		String sid = (String) session
				.getAttribute(SessionConstant.REDIS_SESSION_ID);
		if (null != sid) {
			SessionManager.removeSession(sid);
			
			//为了 判断所有实例session都失效时，再删除redis中的sessionAttr
			try {
				String localHost = InetAddress.getLocalHost().getHostAddress();
				Map redisMap = SessionService.getInstance().getSession(sid+"_HOST");
				redisMap.remove(localHost);
				if(redisMap.isEmpty()){
					SessionService.getInstance().removeSession(sid+"_HOST");
					// 删除redis的Map
					SessionService.getInstance().removeSession(sid);
				}else{
					SessionService.getInstance().saveSession(sid+"_HOST", redisMap);
				}
			} catch (UnknownHostException e) {
				e.printStackTrace();
			}
		}
	}

}
