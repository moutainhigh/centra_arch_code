package com.ifudata.ums.api.applybatch.param;

import java.io.Serializable;



/**
 * Title: msg-CRM <br>
 * Description: 批量提交受理请求类 <br>
 * Date: 2014年5月20日 <br>
 * Copyright (c) 2014 ifudata <br>
 * 
 * @author wangyongxin
 */
public class OrdApplyBatchRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    // 请求报文头
    private RequestHeader requestHeader;

    // 批量业务类型
    private String busiType;
    //批量业务处理时间
    private String fileName;
    private String jobTime;
    private String batchContext;
    private Integer flag;
    // 批量请求信息
    private OrdApplyBatchDetailCredit applyBatchDetailCredit;
    
    public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getBatchContext() {
		return batchContext;
	}

	public void setBatchContext(String batchContext) {
		this.batchContext = batchContext;
	}

	public Integer getFlag() {
		return flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}

    public OrdApplyBatchDetailCredit getApplyBatchDetailCredit() {
        return applyBatchDetailCredit;
    }

    public void setApplyBatchDetailCredit(OrdApplyBatchDetailCredit applyBatchDetailCredit) {
        this.applyBatchDetailCredit = applyBatchDetailCredit;
    }

    public RequestHeader getRequestHeader() {
        return requestHeader;
    }

    public void setRequestHeader(RequestHeader requestHeader) {
        this.requestHeader = requestHeader;
    }

    public String getBusiType() {
        return busiType;
    }

    public void setBusiType(String busiType) {
        this.busiType = busiType;
    }

	public String getJobTime() {
		return jobTime;
	}

	public void setJobTime(String jobTime) {
		this.jobTime = jobTime;
	}

}
