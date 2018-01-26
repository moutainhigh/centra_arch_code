package com.ifudata.ums.system.session;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class SessionService {

	private static SessionService instance = null;

	//private ICacheSV sysSessionSv;

	public static synchronized SessionService getInstance() {
		if (instance == null) {
			instance = new SessionService();
		}
		return instance;
	}

	private SessionService() {
	}

	@SuppressWarnings("rawtypes")
	public Map getSession(String id) {
		/*Object obj = sysSessionSv.get4Serial(id);
		if (obj != null && obj instanceof Map) {
			return (Map) obj;
		} else {
			return new ConcurrentHashMap();
		}*/
		return null;
	}

	@SuppressWarnings("rawtypes")
	public void saveSession(String id, Map session) {

	}

	public void removeSession(String id) {

	}

	protected void finalize() {
		instance = null;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		Map sessionMap = new HashMap();
		sessionMap.put("aa", "aa");
		sessionMap.put("obj", new ArrayList());
		SessionService ser = SessionService.getInstance();
		ser.saveSession("test", sessionMap);

		Map retu = ser.getSession("test");
//		System.out.println(sessionMap);
//		System.out.println(retu);

	}

}
