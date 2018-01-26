package com.ifudata.smsrest.main.procotol;

import java.util.List;

import com.ifudata.smsrest.db.mapper.bo.SmsResultHis;

public class StatusJsonObj {
	//BOUmsSendStatusBean
	private List<SmsResultHis> status;

	public List<SmsResultHis> getStatus() {
		return status;
	}

	public void setStatus(List<SmsResultHis> status) {
		this.status = status;
	}
}
