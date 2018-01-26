package com.ifudata.ums.api.applybatch.param;



public class BatchAccCreditDate extends AbstractBatchData {
	
	
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CreditInfo creditInfo;
	//private RequestHeader requestHeader;
	public CreditInfo getCreditInfo() {
		return creditInfo;
	}
	public void setCreditInfo(CreditInfo creditInfo) {
		this.creditInfo = creditInfo;
	}
//	public RequestHeader getRequestHeader() {
//		return requestHeader;
//	}
//	public void setRequestHeader(RequestHeader requestHeader) {
//		this.requestHeader = requestHeader;
//	}
	
}
