package com.ifudata.ums.vo;


import com.ifudata.ums.api.applybatch.param.CreditInfo;
import com.ifudata.ums.api.applybatch.param.RequestHeader;

public class AssembleBatchAccCreditBusiVo extends AbstractBaseAssembleBusiVo{
	  // 请求报文头
    private RequestHeader requestHeader;
    // 业务操作,后台默认
    private String busiOperCode;
    
    private CreditInfo creditInfo;

	public RequestHeader getRequestHeader() {
		return requestHeader;
	}

	public void setRequestHeader(RequestHeader requestHeader) {
		this.requestHeader = requestHeader;
	}

	public String getBusiOperCode() {
		return busiOperCode;
	}

	public void setBusiOperCode(String busiOperCode) {
		this.busiOperCode = busiOperCode;
	}

	public CreditInfo getCreditInfo() {
		return creditInfo;
	}

	public void setCreditInfo(CreditInfo creditInfo) {
		this.creditInfo = creditInfo;
	}

	
    
}
