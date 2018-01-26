package com.ifudata.ums.service.http.baiwunew.server;

import java.util.List;

import org.dom4j.Element;

public class DeliverObj {
	private String corp_id;
	private String mobile;
	private String ext;
	private String time;
	private String content;
	
	public String getCorp_id() {
		return corp_id;
	}
	public void setCorp_id(String corp_id) {
		this.corp_id = corp_id;
	}
	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getExt() {
		return ext;
	}
	public void setExt(String ext) {
		this.ext = ext;
	}
	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "DeliverObj [corp_id=" + corp_id + ", mobile=" + mobile + ", ext=" + ext + ", time=" + time
				+ ", content=" + content + "]";
	}
	
	@SuppressWarnings("unchecked")
	public static DeliverObj loadFromDocument(Element ele) {
		if (!ele.getName().equalsIgnoreCase("deliver")) {
			return null;
		}
		
		List<Element> elechildNodes = ele.elements();
		//NodeList elechildNodes = ele.getChildNodes();
		if (elechildNodes.size() != 5)
			return null;
		
		int icount = 0;
		if (!elechildNodes.get(icount++).getName().equalsIgnoreCase("corp_id")) {
			return null;
		}
		if (!elechildNodes.get(icount++).getName().equalsIgnoreCase("mobile")) {
			return null;
		}
		if (!elechildNodes.get(icount++).getName().equalsIgnoreCase("ext")) {
			return null;
		}
		if (!elechildNodes.get(icount++).getName().equalsIgnoreCase("time")) {
			return null;
		}
		if (!elechildNodes.get(icount++).getName().equalsIgnoreCase("content")) {
			return null;
		}
		
		DeliverObj obj = new DeliverObj();
		icount = 0;
		obj.corp_id = elechildNodes.get(icount++).getStringValue();
		obj.mobile = elechildNodes.get(icount++).getStringValue();
		obj.ext = elechildNodes.get(icount++).getStringValue();
		obj.time = elechildNodes.get(icount++).getStringValue();
		obj.content = elechildNodes.get(icount++).getStringValue();
		return obj;
	}
}
