package com.ai.slp.user.api.message.param;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 用户消息表 Date: 2016年5月2日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * 
 * @author zhangqiang7
 */
public class UserMessageParams implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 租户Id
     */
    private String tenantId;

    /**
     * 唯一标识
     */
    private String infoSeqId;

    /**
     * 用户Id
     */
    private String userId;

    /**
     * 消息类型
     */
    private String infoType;

    /**
     * 消息读取状态
     */
    private String readFlag;

    /**
     * 阅读时间
     */
    private Timestamp readTime;

    /**
     * 消息标题
     */
    private String infoHeadline;

    /**
     * 消息内容
     */
    private String infoMessage;

    /**
     * 状态
     */
    private String state;

    /**
     * 生效时间
     */
    private Timestamp activeTime;

    /**
     * 失效时间
     */
    private Timestamp inactiveTime;

    /**
     * 状态变更时间
     */
    private Timestamp stateUpdateTime;

    /**
     * 创建时间
     */
    private Timestamp createTime;

    /**
     * 创建渠道
     */
    private String createChlId;

    /**
     * 创建员工
     */
    private Long createOperId;

    /**
     * 更新时间
     */
    private Timestamp updateTime;

    /**
     * 更新渠道
     */
    private String updateChlId;

    /**
     * 更新员工
     */
    private Long updateOperId;

    /**
     * 备注
     */
    private String remark;

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getInfoSeqId() {
        return infoSeqId;
    }

    public void setInfoSeqId(String infoSeqId) {
        this.infoSeqId = infoSeqId;
    }


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getInfoType() {
        return infoType;
    }

    public void setInfoType(String infoType) {
        this.infoType = infoType;
    }

    public String getReadFlag() {
        return readFlag;
    }

    public void setReadFlag(String readFlag) {
        this.readFlag = readFlag;
    }

    public Timestamp getReadTime() {
        return readTime;
    }

    public void setReadTime(Timestamp readTime) {
        this.readTime = readTime;
    }

    public String getInfoHeadline() {
        return infoHeadline;
    }

    public void setInfoHeadline(String infoHeadline) {
        this.infoHeadline = infoHeadline;
    }

    public String getInfoMessage() {
        return infoMessage;
    }

    public void setInfoMessage(String infoMessage) {
        this.infoMessage = infoMessage;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Timestamp getActiveTime() {
        return activeTime;
    }

    public void setActiveTime(Timestamp activeTime) {
        this.activeTime = activeTime;
    }

    public Timestamp getInactiveTime() {
        return inactiveTime;
    }

    public void setInactiveTime(Timestamp inactiveTime) {
        this.inactiveTime = inactiveTime;
    }

    public Timestamp getStateUpdateTime() {
        return stateUpdateTime;
    }

    public void setStateUpdateTime(Timestamp stateUpdateTime) {
        this.stateUpdateTime = stateUpdateTime;
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
        this.createChlId = createChlId;
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
        this.updateChlId = updateChlId;
    }

    public Long getUpdateOperId() {
        return updateOperId;
    }

    public void setUpdateOperId(Long updateOperId) {
        this.updateOperId = updateOperId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}
