package com.ai.slp.user.dao.mapper.bo;

import java.sql.Timestamp;

public class UcUserPhonebooks {
    private String telNo;

    private String tenantId;

    private String userId;

    private String telGroupId;

    private long seq;

    private String telName;

    private String telMp;

    private String provinceCode;

    private String cityCode;

    private String basicOrgId;

    private Timestamp createTime;

    private String createChlId;

    private String createOperId;

    private Timestamp updateTime;

    private String updateChlId;

    private String updateOperId;

    public String getTelNo() {
        return telNo;
    }

    public void setTelNo(String telNo) {
        this.telNo = telNo == null ? null : telNo.trim();
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId == null ? null : tenantId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getTelGroupId() {
        return telGroupId;
    }

    public void setTelGroupId(String telGroupId) {
        this.telGroupId = telGroupId == null ? null : telGroupId.trim();
    }

    public long getSeq() {
        return seq;
    }

    public void setSeq(long seq) {
        this.seq = seq;
    }

    public String getTelName() {
        return telName;
    }

    public void setTelName(String telName) {
        this.telName = telName == null ? null : telName.trim();
    }

    public String getTelMp() {
        return telMp;
    }

    public void setTelMp(String telMp) {
        this.telMp = telMp == null ? null : telMp.trim();
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode == null ? null : provinceCode.trim();
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode == null ? null : cityCode.trim();
    }

    public String getBasicOrgId() {
        return basicOrgId;
    }

    public void setBasicOrgId(String basicOrgId) {
        this.basicOrgId = basicOrgId == null ? null : basicOrgId.trim();
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

    public String getCreateOperId() {
        return createOperId;
    }

    public void setCreateOperId(String createOperId) {
        this.createOperId = createOperId == null ? null : createOperId.trim();
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

    public String getUpdateOperId() {
        return updateOperId;
    }

    public void setUpdateOperId(String updateOperId) {
        this.updateOperId = updateOperId == null ? null : updateOperId.trim();
    }
}