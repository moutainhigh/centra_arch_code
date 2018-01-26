package com.ifudata.ums.service.http.baiwunew.server;

import java.util.List;

import org.dom4j.Element;

public class ReportRespObj {
	private String corp_id;
	private String mobile;
	private String sub_seq;
	private String msg_id;
	private String err;
	private String fail_desc;
	private String report_time;
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
	public String getSub_seq() {
		return sub_seq;
	}
	public void setSub_seq(String sub_seq) {
		this.sub_seq = sub_seq;
	}
	public String getMsg_id() {
		return msg_id;
	}
	public void setMsg_id(String msg_id) {
		this.msg_id = msg_id;
	}
	public String getErr() {
		return err;
	}
	public void setErr(String err) {
		this.err = err;
	}
	public String getFail_desc() {
		return fail_desc;
	}
	public void setFail_desc(String fail_desc) {
		this.fail_desc = fail_desc;
	}
	public String getReport_time() {
		return report_time;
	}
	public void setReport_time(String report_time) {
		this.report_time = report_time;
	}
	@Override
	public String toString() {
		return "ReportObj [corp_id=" + corp_id + ", mobile=" + mobile + ", sub_seq=" + sub_seq + ", msg_id=" + msg_id
				+ ", err=" + err + ", fail_desc=" + fail_desc + ", report_time=" + report_time + "]";
	}
	
	@SuppressWarnings("unchecked")
	public static ReportRespObj loadFromDocument(Element ele) {
		if (!ele.getName().equalsIgnoreCase("report")) {
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
		if (!elechildNodes.get(icount++).getName().equalsIgnoreCase("sub_seq")) {
			return null;
		}
		if (!elechildNodes.get(icount++).getName().equalsIgnoreCase("msg_id")) {
			return null;
		}
		if (!elechildNodes.get(icount++).getName().equalsIgnoreCase("err")) {
			return null;
		}
		if (!elechildNodes.get(icount++).getName().equalsIgnoreCase("fail_desc")) {
			return null;
		}
		if (!elechildNodes.get(icount++).getName().equalsIgnoreCase("report_time")) {
			return null;
		}		
		ReportRespObj obj = new ReportRespObj();
		icount = 0;
		obj.corp_id = elechildNodes.get(icount++).getStringValue();
		obj.mobile = elechildNodes.get(icount++).getStringValue();
		obj.sub_seq = elechildNodes.get(icount++).getStringValue();
		obj.msg_id = elechildNodes.get(icount++).getStringValue();
		obj.err = elechildNodes.get(icount++).getStringValue();
		obj.fail_desc = elechildNodes.get(icount++).getStringValue();
		obj.report_time = elechildNodes.get(icount++).getStringValue();
		return obj;
	}	
}
