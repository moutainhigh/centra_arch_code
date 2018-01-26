package com.ifudata.ums.service.http.baiwunew.server;

public class ReportObj {
	private String cust_code;
	private String sgin;
	public String getCust_code() {
		return cust_code;
	}
	public void setCust_code(String cust_code) {
		this.cust_code = cust_code;
	}
	public String getSgin() {
		return sgin;
	}
	public void setSgin(String sgin) {
		this.sgin = sgin;
	}
	@Override
	public String toString() {
		return "ReportObj [cust_code=" + cust_code + ", sgin=" + sgin + "]";
	}
}
