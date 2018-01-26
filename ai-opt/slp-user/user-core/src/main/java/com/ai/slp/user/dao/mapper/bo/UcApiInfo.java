package com.ai.slp.user.dao.mapper.bo;

import java.sql.Timestamp;

public class UcApiInfo {
    private String tenantId;

    private String apiSeqId;

    private String userId;

    private String apiName;

    private String apiType;

    private String apiInfo;

    private String webAddr;

    private String ipAddr;

    private String operService;

    private String secretKey;

    private String apiKey;

    private String contactName;

    private String contactCertType;

    private String contactCertNum;

    private String contactWxId;

    private String contactMp;

    private String contactEmail;

    private String contactAddress;

    private String groupZip;

    private String contactDept;

    private String remark;

    private Timestamp createTime;

    private String createChlId;

    private Long createOperId;

    private Timestamp updateTime;

    private String updateChlId;

    private Long updateOperId;

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId == null ? null : tenantId.trim();
    }

    public String getApiSeqId() {
        return apiSeqId;
    }

    public void setApiSeqId(String apiSeqId) {
        this.apiSeqId = apiSeqId == null ? null : apiSeqId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getApiName() {
        return apiName;
    }

    public void setApiName(String apiName) {
        this.apiName = apiName == null ? null : apiName.trim();
    }

    public String getApiType() {
        return apiType;
    }

    public void setApiType(String apiType) {
        this.apiType = apiType == null ? null : apiType.trim();
    }

    public String getApiInfo() {
        return apiInfo;
    }

    public void setApiInfo(String apiInfo) {
        this.apiInfo = apiInfo == null ? null : apiInfo.trim();
    }

    public String getWebAddr() {
        return webAddr;
    }

    public void setWebAddr(String webAddr) {
        this.webAddr = webAddr == null ? null : webAddr.trim();
    }

    public String getIpAddr() {
        return ipAddr;
    }

    public void setIpAddr(String ipAddr) {
        this.ipAddr = ipAddr == null ? null : ipAddr.trim();
    }

    public String getOperService() {
        return operService;
    }

    public void setOperService(String operService) {
        this.operService = operService == null ? null : operService.trim();
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey == null ? null : secretKey.trim();
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey == null ? null : apiKey.trim();
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName == null ? null : contactName.trim();
    }

    public String getContactCertType() {
        return contactCertType;
    }

    public void setContactCertType(String contactCertType) {
        this.contactCertType = contactCertType == null ? null : contactCertType.trim();
    }

    public String getContactCertNum() {
        return contactCertNum;
    }

    public void setContactCertNum(String contactCertNum) {
        this.contactCertNum = contactCertNum == null ? null : contactCertNum.trim();
    }

    public String getContactWxId() {
        return contactWxId;
    }

    public void setContactWxId(String contactWxId) {
        this.contactWxId = contactWxId == null ? null : contactWxId.trim();
    }

    public String getContactMp() {
        return contactMp;
    }

    public void setContactMp(String contactMp) {
        this.contactMp = contactMp == null ? null : contactMp.trim();
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail == null ? null : contactEmail.trim();
    }

    public String getContactAddress() {
        return contactAddress;
    }

    public void setContactAddress(String contactAddress) {
        this.contactAddress = contactAddress == null ? null : contactAddress.trim();
    }

    public String getGroupZip() {
        return groupZip;
    }

    public void setGroupZip(String groupZip) {
        this.groupZip = groupZip == null ? null : groupZip.trim();
    }

    public String getContactDept() {
        return contactDept;
    }

    public void setContactDept(String contactDept) {
        this.contactDept = contactDept == null ? null : contactDept.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public String getCreateChlId() {
        return createChlId;
    }

    public void setCreateChlId(String createChlId) {
        this.createChlId = createChlId == null ? null : createChlId.trim();
    }

    public Long getCreateOperId() {
        return createOperId;
    }

    public void setCreateOperId(Long createOperId) {
        this.createOperId = createOperId;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateChlId() {
        return updateChlId;
    }

    public void setUpdateChlId(String updateChlId) {
        this.updateChlId = updateChlId == null ? null : updateChlId.trim();
    }

    public Long getUpdateOperId() {
        return updateOperId;
    }

    public void setUpdateOperId(Long updateOperId) {
        this.updateOperId = updateOperId;
    }
}