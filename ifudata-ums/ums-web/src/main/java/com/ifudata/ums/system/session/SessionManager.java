package com.ifudata.ums.system.session;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


public class SessionManager {
	// 还得在session失效时去掉这个
	private static Map<String, HttpSessionSidWrapper> sessions = new ConcurrentHashMap<String, HttpSessionSidWrapper>();

	private SessionManager() {
		// 禁止实例化
	}

	public static HttpSessionSidWrapper findSession(String sessionId) {

		if (sessionId == null)
			return (null);
		return sessions.get(sessionId);

	}

	public static HttpSessionSidWrapper createSession(String sessionId,
			HttpSession session) {

		HttpSessionSidWrapper wrapperSession = new HttpSessionSidWrapper(
				sessionId, session);
		sessions.put(sessionId, wrapperSession);
		Log log = LogFactory.getLog("SessionManager");
		log.info("Created the wrapped session for sessionId:" + sessionId);
		try {
			//为了 判断所有实例session都失效时，再删除redis中的sessionAttr
			String localHost = InetAddress.getLocalHost().getHostAddress();
			log.info("-------------localHost-------------:" + localHost);
			Map redisMap = SessionService.getInstance().getSession(sessionId+"_HOST");
			redisMap.put(localHost, localHost);
			SessionService.getInstance().saveSession(sessionId+"_HOST", redisMap);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return wrapperSession;

	}

	public static void removeSession(String sessionId) {
		Log log = LogFactory.getLog("SessionManager");
		log.info("Remove the wrapped session for sessionId:" + sessionId);
		sessions.remove(sessionId);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

}
