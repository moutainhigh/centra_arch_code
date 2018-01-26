package com.ifudata.ums.dao.mapper.bo;

import java.sql.Timestamp;

public class UmsSendStatus {
    private Long resSeq;

    private Long detailId;

    private String batchId;

    private String corpId;

    private String srcName;

    private Long templateId;

    private String serviceType;

    private Long verifyId;

    private String phoneNum;

    private String paraContent;

    private String smsContent;

    private Integer transformStatus;

    private String sendSeq;

    private Integer sendFlag;

    private Integer reportFlag;

    private Integer reportRecFlag;

    private String reportRecResult;

    private Integer retryTimes;

    private Integer maxTimes;

    private Timestamp createTime;

    private Timestamp sendTime;

    private Timestamp reportTime;

    private String reserved;

    private String remark;

    public Long getResSeq() {
        return resSeq;
    }

    public void setResSeq(Long resSeq) {
        this.resSeq = resSeq;
    }

    public Long getDetailId() {
        return detailId;
    }

    public void setDetailId(Long detailId) {
        this.detailId = detailId;
    }

    public String getBatchId() {
        return batchId;
    }

    public void setBatchId(String batchId) {
        this.batchId = batchId == null ? null : batchId.trim();
    }

    public String getCorpId() {
        return corpId;
    }

    public void setCorpId(String corpId) {
        this.corpId = corpId == null ? null : corpId.trim();
    }

    public String getSrcName() {
        return srcName;
    }

    public void setSrcName(String srcName) {
        this.srcName = srcName == null ? null : srcName.trim();
    }

    public Long getTemplateId() {
        return templateId;
    }

    public void setTemplateId(Long templateId) {
        this.templateId = templateId;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType == null ? null : serviceType.trim();
    }

    public Long getVerifyId() {
        return verifyId;
    }

    public void setVerifyId(Long verifyId) {
        this.verifyId = verifyId;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum == null ? null : phoneNum.trim();
    }

    public String getParaContent() {
        return paraContent;
    }

    public void setParaContent(String paraContent) {
        this.paraContent = paraContent == null ? null : paraContent.trim();
    }

    public String getSmsContent() {
        return smsContent;
    }

    public void setSmsContent(String smsContent) {
        this.smsContent = smsContent == null ? null : smsContent.trim();
    }

    public Integer getTransformStatus() {
        return transformStatus;
    }

    public void setTransformStatus(Integer transformStatus) {
        this.transformStatus = transformStatus;
    }

    public String getSendSeq() {
        return sendSeq;
    }

    public void setSendSeq(String sendSeq) {
        this.sendSeq = sendSeq == null ? null : sendSeq.trim();
    }

    public Integer getSendFlag() {
        return sendFlag;
    }

    public void setSendFlag(Integer sendFlag) {
        this.sendFlag = sendFlag;
    }

    public Integer getReportFlag() {
        return reportFlag;
    }

    public void setReportFlag(Integer reportFlag) {
        this.reportFlag = reportFlag;
    }

    public Integer getReportRecFlag() {
        return reportRecFlag;
    }

    public void setReportRecFlag(Integer reportRecFlag) {
        this.reportRecFlag = reportRecFlag;
    }

    public String getReportRecResult() {
        return reportRecResult;
    }

    public void setReportRecResult(String reportRecResult) {
        this.reportRecResult = reportRecResult == null ? null : reportRecResult.trim();
    }

    public Integer getRetryTimes() {
        return retryTimes;
    }

    public void setRetryTimes(Integer retryTimes) {
        this.retryTimes = retryTimes;
    }

    public Integer getMaxTimes() {
        return maxTimes;
    }

    public void setMaxTimes(Integer maxTimes) {
        this.maxTimes = maxTimes;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
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

    public String getReserved() {
        return reserved;
    }

    public void setReserved(String reserved) {
        this.reserved = reserved == null ? null : reserved.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}