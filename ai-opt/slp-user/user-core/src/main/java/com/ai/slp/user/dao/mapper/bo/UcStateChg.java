package com.ai.slp.user.dao.mapper.bo;

import java.sql.Timestamp;

public class UcStateChg {
    private String tenantId;

    private String userId;

    private String stateChgId;

    private String operType;

    private String oldState;

    private String newState;

    private String chgDesc;

    private Timestamp chgTime;

    private String chlId;

    private Long operId;

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

    public String getStateChgId() {
        return stateChgId;
    }

    public void setStateChgId(String stateChgId) {
        this.stateChgId = stateChgId == null ? null : stateChgId.trim();
    }

    public String getOperType() {
        return operType;
    }

    public void setOperType(String operType) {
        this.operType = operType == null ? null : operType.trim();
    }

    public String getOldState() {
        return oldState;
    }

    public void setOldState(String oldState) {
        this.oldState = oldState == null ? null : oldState.trim();
    }

    public String getNewState() {
        return newState;
    }

    public void setNewState(String newState) {
        this.newState = newState == null ? null : newState.trim();
    }

    public String getChgDesc() {
        return chgDesc;
    }

    public void setChgDesc(String chgDesc) {
        this.chgDesc = chgDesc == null ? null : chgDesc.trim();
    }

    public Timestamp getChgTime() {
        return chgTime;
    }

    public void setChgTime(Timestamp chgTime) {
        this.chgTime = chgTime;
    }

    public String getChlId() {
        return chlId;
    }

    public void setChlId(String chlId) {
        this.chlId = chlId == null ? null : chlId.trim();
    }

    public Long getOperId() {
        return operId;
    }

    public void setOperId(Long operId) {
        this.operId = operId;
    }
}