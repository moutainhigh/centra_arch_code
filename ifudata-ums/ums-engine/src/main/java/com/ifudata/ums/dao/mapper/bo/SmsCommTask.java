package com.ifudata.ums.dao.mapper.bo;

public class SmsCommTask {
    private Integer commTaskSerial;

    private String svcType;

    private String regionId;

    private String deviceNumber;

    private String runStatus;

    private String message;

    private Integer tryNum;

    private String spNumber;

    private Integer returnResult;

    public Integer getCommTaskSerial() {
        return commTaskSerial;
    }

    public void setCommTaskSerial(Integer commTaskSerial) {
        this.commTaskSerial = commTaskSerial;
    }

    public String getSvcType() {
        return svcType;
    }

    public void setSvcType(String svcType) {
        this.svcType = svcType == null ? null : svcType.trim();
    }

    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId == null ? null : regionId.trim();
    }

    public String getDeviceNumber() {
        return deviceNumber;
    }

    public void setDeviceNumber(String deviceNumber) {
        this.deviceNumber = deviceNumber == null ? null : deviceNumber.trim();
    }

    public String getRunStatus() {
        return runStatus;
    }

    public void setRunStatus(String runStatus) {
        this.runStatus = runStatus == null ? null : runStatus.trim();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message == null ? null : message.trim();
    }

    public Integer getTryNum() {
        return tryNum;
    }

    public void setTryNum(Integer tryNum) {
        this.tryNum = tryNum;
    }

    public String getSpNumber() {
        return spNumber;
    }

    public void setSpNumber(String spNumber) {
        this.spNumber = spNumber == null ? null : spNumber.trim();
    }

    public Integer getReturnResult() {
        return returnResult;
    }

    public void setReturnResult(Integer returnResult) {
        this.returnResult = returnResult;
    }

	@Override
	public String toString() {
		return "SmsCommTask [commTaskSerial=" + commTaskSerial + ", svcType="
				+ svcType + ", regionId=" + regionId + ", deviceNumber="
				+ deviceNumber + ", runStatus=" + runStatus + ", message="
				+ message + ", tryNum=" + tryNum + ", spNumber=" + spNumber
				+ ", returnResult=" + returnResult + "]";
	}
    
}