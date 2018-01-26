package com.ifudata.ums.dao.mapper.bo;

import java.sql.Timestamp;

public class SmsResult {
    private Long resSeq;

    private String srcName;

    private Long templateId;

    private String servicetype;

    private Long verifyid;

    private String phone;

    private String gsmcontent;

    private String content;

    private String sendSeq;

    private Integer sendFlag;

    private Integer recFlag;

    private String recResult;

    private Integer retryTimes;

    private Integer maxTimes;

    private Timestamp createTime;

    private Timestamp sendTime;

    private Timestamp recTime;

    private String remark;

    public Long getResSeq() {
        return resSeq;
    }

    public void setResSeq(Long resSeq) {
        this.resSeq = resSeq;
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

    public String getServicetype() {
        return servicetype;
    }

    public void setServicetype(String servicetype) {
        this.servicetype = servicetype == null ? null : servicetype.trim();
    }

    public Long getVerifyid() {
        return verifyid;
    }

    public void setVerifyid(Long verifyid) {
        this.verifyid = verifyid;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getGsmcontent() {
        return gsmcontent;
    }

    public void setGsmcontent(String gsmcontent) {
        this.gsmcontent = gsmcontent == null ? null : gsmcontent.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
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

    public Integer getRecFlag() {
        return recFlag;
    }

    public void setRecFlag(Integer recFlag) {
        this.recFlag = recFlag;
    }

    public String getRecResult() {
        return recResult;
    }

    public void setRecResult(String recResult) {
        this.recResult = recResult == null ? null : recResult.trim();
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

    public Timestamp getRecTime() {
        return recTime;
    }

    public void setRecTime(Timestamp recTime) {
        this.recTime = recTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}