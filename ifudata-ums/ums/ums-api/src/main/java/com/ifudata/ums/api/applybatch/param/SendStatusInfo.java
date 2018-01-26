package com.ifudata.ums.api.applybatch.param;

import java.io.Serializable;
import java.sql.Timestamp;
/**
 * 
 * @author wangyongxin
 *
 */
public class SendStatusInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4260172760869661622L;
	private String batchId;
	private String phoneNum;
	private String smsContent;
	private Integer sendFlag;
	/**
	 * report成功状态 0 DELIVERED, 1 EXPIRED, 2 
	 */
	private Integer reportRecFlag;
	/**
	 * 获取report状态 0 无回执 1 有回执 2 超时
	 */
	
	private Integer reportFlag;
	/**
	 * report错误原因	
	 */
	private String reportRecResult;
	private  Timestamp sendTime;
	private Timestamp reportTime;
	public String getBatchId() {
		return batchId;
	}
	public void setBatchId(String batchId) {
		this.batchId = batchId;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public String getSmsContent() {
		return smsContent;
	}
	public void setSmsContent(String smsContent) {
		this.smsContent = smsContent;
	}
	public Integer getSendFlag() {
		return sendFlag;
	}
	public void setSendFlag(Integer sendFlag) {
		this.sendFlag = sendFlag;
	}
	public Integer getReportRecFlag() {
		return reportRecFlag;
	}
	public void setReportRecFlag(Integer reportRecFlag) {
		this.reportRecFlag = reportRecFlag;
	}
	public Integer getReportFlag() {
		return reportFlag;
	}
	public void setReportFlag(Integer reportFlag) {
		this.reportFlag = reportFlag;
	}
	public String getReportRecResult() {
		return reportRecResult;
	}
	public void setReportRecResult(String reportRecResult) {
		this.reportRecResult = reportRecResult;
	}
	public Timestamp getSendTime() {
		return sendTime;
	}
	public void setSendTime(Timestamp sendTime) {
		this.sendTime = sendTime;
	}
	public Timestamp getReportTime() {
		return reportTime;
	}
	public void setReportTime(Timestamp reportTime) {
		this.reportTime = reportTime;
	}
	
	
}
