package com.ifudata.ums.system.session;

import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

public class HttpSessionWrapper implements HttpSession {

	private HttpSession session;

	public HttpSessionWrapper(HttpSession session) {
		this.session = session;
	}

	public Object getAttribute(String arg0) {
		return this.session.getAttribute(arg0);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Enumeration getAttributeNames() {
		return this.session.getAttributeNames();
	}

	public long getCreationTime() {
		return session.getCreationTime();
	}

	public String getId() {
		return session.getId();
	}

	public long getLastAccessedTime() {
		return session.getLastAccessedTime();
	}

	public int getMaxInactiveInterval() {
		return session.getMaxInactiveInterval();
	}

	public ServletContext getServletContext() {
		return session.getServletContext();
	}

	@SuppressWarnings("deprecation")
	public javax.servlet.http.HttpSessionContext getSessionContext() {
		return session.getSessionContext();
	}

	@SuppressWarnings("deprecation")
	public Object getValue(String arg0) {
		return session.getValue(arg0);
	}

	@SuppressWarnings("deprecation")
	public String[] getValueNames() {
		return session.getValueNames();
	}

	public void invalidate() {
		this.session.invalidate();
	}

	public boolean isNew() {
		return session.isNew();
	}

	@SuppressWarnings("deprecation")
	public void putValue(String arg0, Object arg1) {
		session.putValue(arg0, arg1);
	}

	public void removeAttribute(String arg0) {
		this.session.removeAttribute(arg0);
	}

	@SuppressWarnings("deprecation")
	public void removeValue(String arg0) {
		session.removeValue(arg0);
	}

	public void setAttribute(String arg0, Object arg1) {
		this.session.setAttribute(arg0, arg1);
	}

	public void setMaxInactiveInterval(int arg0) {
		session.setMaxInactiveInterval(arg0);
	}

}
