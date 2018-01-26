package com.ai.slp.user.api.ucuser.param;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 用户信息 Date: 2016年5月3日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * 
 * @author zhangqiang7
 */
public class UcUserInfoParams implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 租户Id
     */
    private String tenantId;

    /**
     * 用户Id
     */
    private String userId;

    /**
     * 用户类型
     */
    private String userType;

    /**
     * 用户属性
     */
    private String userFlag;

    /**
     * 用户状态
     */
    private String userState;

    /**
     * 用户VIP等级
     */
    private String vipLevel;

    /**
     * 用户安全等级
     */
    private String safetyLevel;

    /**
     * 用户登录名
     */
    private String userLoginName;

    /**
     * 登录密码安全程度
     */
    private String pwdSafetyLevel;

    /**
     * 用户绑定手机号码
     */
    private String userMp;

    /**
     * 用户绑定邮箱
     */
    private String userEmail;

    /**
     * 邮箱验证标志
     */
    private String emailValidateFlag;

    /**
     * 用户昵称
     */
    private String userNickname;

    /**
     * 用户头像ID
     */
    private String ortraitFileId;

    /**
     * 用户手机归属省
     */
    private String provinceCode;

    /**
     * 用户手机归属地市
     */
    private String cityCode;

    /**
     * 注册方式
     */
    private String registerWay;

    /**
     * 注册来源
     */
    private String registerSource;

    /**
     * 认证标志
     */
    private String verifyFlag;

    /**
     * 授信状态
     */
    private String creditFlag;

    /**
     * 客户状态变更时间
     */
    private Timestamp stateChgTime;

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
     * 修改时间
     */
    private Timestamp updateTime;

    /**
     * 修改渠道
     */
    private String updateChlId;

    /**
     * 修改员工
     */
    private Long updateOperId;

    /**
     * 备注
     */
    private String remark;

    /**
     * 审核状态
     */
    private String auditState;

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

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getUserFlag() {
        return userFlag;
    }

    public void setUserFlag(String userFlag) {
        this.userFlag = userFlag;
    }

    public String getUserState() {
        return userState;
    }

    public void setUserState(String userState) {
        this.userState = userState;
    }

    public String getVipLevel() {
        return vipLevel;
    }

    public void setVipLevel(String vipLevel) {
        this.vipLevel = vipLevel;
    }

    public String getSafetyLevel() {
        return safetyLevel;
    }

    public void setSafetyLevel(String safetyLevel) {
        this.safetyLevel = safetyLevel;
    }

    public String getUserLoginName() {
        return userLoginName;
    }

    public void setUserLoginName(String userLoginName) {
        this.userLoginName = userLoginName;
    }

    public String getPwdSafetyLevel() {
        return pwdSafetyLevel;
    }

    public void setPwdSafetyLevel(String pwdSafetyLevel) {
        this.pwdSafetyLevel = pwdSafetyLevel;
    }

    public String getUserMp() {
        return userMp;
    }

    public void setUserMp(String userMp) {
        this.userMp = userMp;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getEmailValidateFlag() {
        return emailValidateFlag;
    }

    public void setEmailValidateFlag(String emailValidateFlag) {
        this.emailValidateFlag = emailValidateFlag;
    }

    public String getUserNickname() {
        return userNickname;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname;
    }

    public String getOrtraitFileId() {
        return ortraitFileId;
    }

    public void setOrtraitFileId(String ortraitFileId) {
        this.ortraitFileId = ortraitFileId;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getRegisterWay() {
        return registerWay;
    }

    public void setRegisterWay(String registerWay) {
        this.registerWay = registerWay;
    }

    public String getRegisterSource() {
        return registerSource;
    }

    public void setRegisterSource(String registerSource) {
        this.registerSource = registerSource;
    }

    public String getVerifyFlag() {
        return verifyFlag;
    }

    public void setVerifyFlag(String verifyFlag) {
        this.verifyFlag = verifyFlag;
    }

    public String getCreditFlag() {
        return creditFlag;
    }

    public void setCreditFlag(String creditFlag) {
        this.creditFlag = creditFlag;
    }

    public Timestamp getStateChgTime() {
        return stateChgTime;
    }

    public void setStateChgTime(Timestamp stateChgTime) {
        this.stateChgTime = stateChgTime;
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

    public String getAuditState() {
        return auditState;
    }

    public void setAuditState(String auditState) {
        this.auditState = auditState;
    }

}
