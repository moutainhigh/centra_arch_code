package com.ifudata.smsrest.main.procotol;

public class DeliverRespObj {
	private String retcode;

	public String getRetcode() {
		return retcode;
	}

	public void setRetcode(String retcode) {
		this.retcode = retcode;
	}

	@Override
	public String toString() {
		return "DeliverRespObj [retcode=" + retcode + "]";
	}
}
