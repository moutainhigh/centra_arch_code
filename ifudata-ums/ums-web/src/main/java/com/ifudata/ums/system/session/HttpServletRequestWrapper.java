package com.ifudata.ums.system.session;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class HttpServletRequestWrapper extends
		javax.servlet.http.HttpServletRequestWrapper {
	private Log log = LogFactory.getLog(HttpServletRequestWrapper.class);
	// 需要将SID保存在实际的session中以便失效时删除
	String sid = "";
	HttpServletRequest request = null;

	public HttpServletRequestWrapper(String sid, HttpServletRequest request) {
		super(request);
		this.sid = sid;
		this.request = request;
	}

	public HttpSession getSession(boolean create) {
		log.debug("start get session....");
		// 问题就出在这里，每个获取session都返回一个不同的session对象回去，那放在里面的值永远也取不到了
		HttpSession session = super.getSession(create);
		if (null == session) {
			// 既然父类都没有创建，我们也不创建
			return null;
		}
		session.setAttribute(SessionConstant.REDIS_SESSION_ID, sid);
		HttpSessionSidWrapper wrappedSession = SessionManager.findSession(sid);
		if (null != wrappedSession)
			return wrappedSession;
		else
			return SessionManager.createSession(sid, session);
	}

	public HttpSession getSession() {
		HttpSession session = super.getSession();
		session.setAttribute(SessionConstant.REDIS_SESSION_ID, sid);
		HttpSessionSidWrapper wrappedSession = SessionManager.findSession(sid);
		if (null != wrappedSession)
			return wrappedSession;
		else
			return SessionManager.createSession(sid, session);
	}

}
