package com.ifudata.ums.api.applybatch.param;



import com.ifudata.centra.base.vo.PageInfo;
import com.ifudata.centra.base.vo.ResponseHeader;

import java.io.Serializable;


public class OrdSendStatusResponse implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1731519913358457490L;
	private PageInfo<SendStatusInfo> sendStatus;
	private String state;
	private ResponseHeader responseHeader;
	
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public PageInfo<SendStatusInfo> getSendStatus() {
		return sendStatus;
	}
	public void setSendStatus(PageInfo<SendStatusInfo> sendStatus) {
		this.sendStatus = sendStatus;
	}
	public ResponseHeader getResponseHeader() {
		return responseHeader;
	}
	public void setResponseHeader(ResponseHeader responseHeader) {
		this.responseHeader = responseHeader;
	}

}
