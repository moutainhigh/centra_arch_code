package com.ai.slp.user.api.ucStateChg.param;

import java.sql.Timestamp;

import com.ai.opt.base.vo.BaseResponse;

public class QueryStateChgResponse extends BaseResponse {

    private static final long serialVersionUID = 1L;

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
        this.tenantId = tenantId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getStateChgId() {
        return stateChgId;
    }

    public void setStateChgId(String stateChgId) {
        this.stateChgId = stateChgId;
    }

    public String getOperType() {
        return operType;
    }

    public void setOperType(String operType) {
        this.operType = operType;
    }

    public String getOldState() {
        return oldState;
    }

    public void setOldState(String oldState) {
        this.oldState = oldState;
    }

    public String getNewState() {
        return newState;
    }

    public void setNewState(String newState) {
        this.newState = newState;
    }

    public String getChgDesc() {
        return chgDesc;
    }

    public void setChgDesc(String chgDesc) {
        this.chgDesc = chgDesc;
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
        this.chlId = chlId;
    }

    public Long getOperId() {
        return operId;
    }

    public void setOperId(Long operId) {
        this.operId = operId;
    }

}
