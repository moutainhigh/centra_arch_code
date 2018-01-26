package com.ai.slp.user.dao.mapper.bo;

import java.sql.Timestamp;

public class UcUserAgree {
    private String tenantId;

    private String agreeSeqId;

    private String userId;

    private String agreementId;

    private Timestamp subsTime;

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId == null ? null : tenantId.trim();
    }

    public String getAgreeSeqId() {
        return agreeSeqId;
    }

    public void setAgreeSeqId(String agreeSeqId) {
        this.agreeSeqId = agreeSeqId == null ? null : agreeSeqId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getAgreementId() {
        return agreementId;
    }

    public void setAgreementId(String agreementId) {
        this.agreementId = agreementId == null ? null : agreementId.trim();
    }

    public Timestamp getSubsTime() {
        return subsTime;
    }

    public void setSubsTime(Timestamp subsTime) {
        this.subsTime = subsTime;
    }
}