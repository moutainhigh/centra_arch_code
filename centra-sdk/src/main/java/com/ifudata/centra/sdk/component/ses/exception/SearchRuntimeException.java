package com.ifudata.centra.sdk.component.ses.exception;


public class SearchRuntimeException extends RuntimeException {

	private String errCode;
	private String errDetail;

	public SearchRuntimeException(String errDetail) {
		super(errDetail);
		this.errDetail = errDetail;
	}

	public SearchRuntimeException(String errCode, String errDetail) {
		super(errCode + ":" + errDetail);
		this.errCode = errCode;
		this.errDetail = errDetail;
	}

	public SearchRuntimeException(String errCode, Exception ex) {
		super(errCode + ":" + errCode, ex);
		this.errCode = errCode;
	}

	public SearchRuntimeException(String errCode, String errDetail, Exception ex) {
		super(errCode + ":" + errDetail, ex);
		this.errCode = errCode;
		this.errDetail = errDetail;
	}

	public String getErrCode() {
		return errCode;
	}

	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}

	public String getErrDetail() {
		return errDetail;
	}

	public void setErrDetail(String errDetail) {
		this.errDetail = errDetail;
	}

}
