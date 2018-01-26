package com.ifudata.ums.system.session;

import java.util.Enumeration;
import java.util.Map;

import javax.servlet.http.HttpSession;

public class HttpSessionSidWrapper extends HttpSessionWrapper {

	private String sid = "";

	// 如果里面放置大对象可就惨了，必须限定
	@SuppressWarnings("rawtypes")
	private Map map = null;

	public HttpSessionSidWrapper(String sid, HttpSession session) {
		super(session);
		this.sid = sid;
		this.map = SessionService.getInstance().getSession(sid);
	}

	public Object getAttribute(String arg0) {
		syncSessionAttr();
		return this.map.get(arg0);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Enumeration getAttributeNames() {
		syncSessionAttr();
		return (new Enumerator(this.map.keySet(), true));
	}

	public void invalidate() {
		this.map.clear();
		SessionService.getInstance().removeSession(this.sid);
	}

	public void removeAttribute(String arg0) {
		syncSessionAttr();
		this.map.remove(arg0);
		SessionService.getInstance().saveSession(this.sid, this.map);
	}

	@SuppressWarnings("unchecked")
	public void setAttribute(String arg0, Object arg1) {
		syncSessionAttr();
		this.map.put(arg0, arg1);
		SessionService.getInstance().saveSession(this.sid, this.map);
	}
	/**
	 * 设置本地的属性信息
	 * 把redis中session的属性信息载入到本地
	 * 
	 * @return
	 */
	private void syncSessionAttr(){
		this.map = SessionService.getInstance().getSession(sid);
	}

}
