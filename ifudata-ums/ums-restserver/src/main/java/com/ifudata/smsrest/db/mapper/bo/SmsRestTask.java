package com.ifudata.smsrest.db.mapper.bo;

import java.sql.Timestamp;

public class SmsRestTask {
    private Integer taskSerial;
    private String svcType;
    private String regionId;
    private String msgId;    
    private String spNumber;
    private String deviceNumber;
    private String runStatus;
    private String message;
    private Timestamp getDate;
    private Timestamp optDate;
    private Integer tryNum;
    private Integer returnResult;
	public Integer getTaskSerial() {
		return taskSerial;
	}
	public void setTaskSerial(Integer taskSerial) {
		this.taskSerial = taskSerial;
	}
	public String getSvcType() {
		return svcType;
	}
	public void setSvcType(String svcType) {
		this.svcType = svcType;
	}
	public String getRegionId() {
		return regionId;
	}
	public void setRegionId(String regionId) {
		this.regionId = regionId;
	}
	public String getMsgId() {
		return msgId;
	}
	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}
	public String getSpNumber() {
		return spNumber;
	}
	public void setSpNumber(String spNumber) {
		this.spNumber = spNumber;
	}
	public String getDeviceNumber() {
		return deviceNumber;
	}
	public void setDeviceNumber(String deviceNumber) {
		this.deviceNumber = deviceNumber;
	}
	public String getRunStatus() {
		return runStatus;
	}
	public void setRunStatus(String runStatus) {
		this.runStatus = runStatus;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Timestamp getGetDate() {
		return getDate;
	}
	public void setGetDate(Timestamp getDate) {
		this.getDate = getDate;
	}
	public Timestamp getOptDate() {
		return optDate;
	}
	public void setOptDate(Timestamp optDate) {
		this.optDate = optDate;
	}
	public Integer getTryNum() {
		return tryNum;
	}
	public void setTryNum(Integer tryNum) {
		this.tryNum = tryNum;
	}
	public Integer getReturnResult() {
		return returnResult;
	}
	public void setReturnResult(Integer returnResult) {
		this.returnResult = returnResult;
	}
	@Override
	public String toString() {
		return "SmsRestTask [taskSerial=" + taskSerial + ", svcType=" + svcType + ", regionId=" + regionId + ", msgId="
				+ msgId + ", spNumber=" + spNumber + ", deviceNumber=" + deviceNumber + ", runStatus=" + runStatus
				+ ", message=" + message + ", getDate=" + getDate + ", optDate=" + optDate + ", tryNum=" + tryNum
				+ ", returnResult=" + returnResult + "]";
	}   
}