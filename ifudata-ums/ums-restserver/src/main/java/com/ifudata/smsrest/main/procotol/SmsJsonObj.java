package com.ifudata.smsrest.main.procotol;

import java.util.List;

import com.ifudata.smsrest.db.mapper.bo.SmsResult;

public class SmsJsonObj {
	private List<SmsResult> submit;

	public List<SmsResult> getSubmit() {
		return submit;
	}

	public void setSubmit(List<SmsResult> submit) {
		this.submit = submit;
	}
}
