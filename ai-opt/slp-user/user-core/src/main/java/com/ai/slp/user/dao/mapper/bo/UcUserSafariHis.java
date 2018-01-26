package com.ai.slp.user.dao.mapper.bo;

import java.sql.Timestamp;

public class UcUserSafariHis {
    private String tenantId;

    private String userId;

    private String safariSeqId;

    private String prodId;

    private Timestamp safariTime;

    private String state;

    private Timestamp createTime;

    private String createChlId;

    private Long createOperId;

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

    public String getSafariSeqId() {
        return safariSeqId;
    }

    public void setSafariSeqId(String safariSeqId) {
        this.safariSeqId = safariSeqId == null ? null : safariSeqId.trim();
    }

    public String getProdId() {
        return prodId;
    }

    public void setProdId(String prodId) {
        this.prodId = prodId == null ? null : prodId.trim();
    }

    public Timestamp getSafariTime() {
        return safariTime;
    }

    public void setSafariTime(Timestamp safariTime) {
        this.safariTime = safariTime;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
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
}