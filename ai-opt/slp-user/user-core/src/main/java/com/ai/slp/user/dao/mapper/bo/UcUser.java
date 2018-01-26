package com.ai.slp.user.dao.mapper.bo;

import java.sql.Timestamp;

public class UcUser {
    private String tenantId;

    private String userId;

    private String userType;

    private String userFlag;

    private String userState;

    private String vipLevel;

    private String safetyLevel;

    private String userLoginName;

    private String userLoginPwd;

    private String pwdSafetyLevel;

    private String userMp;

    private String userEmail;

    private String emailValidateFlag;

    private String userNickname;

    private String ortraitFileId;

    private String provinceCode;

    private String cityCode;

    private String registerWay;

    private String registerSource;

    private String creditFlag;

    private Timestamp stateChgTime;

    private Timestamp createTime;

    private String createChlId;

    private Long createOperId;

    private Timestamp updateTime;

    private String updateChlId;

    private Long updateOperId;

    private String remark;

    private String userEmailToken;

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

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType == null ? null : userType.trim();
    }

    public String getUserFlag() {
        return userFlag;
    }

    public void setUserFlag(String userFlag) {
        this.userFlag = userFlag == null ? null : userFlag.trim();
    }

    public String getUserState() {
        return userState;
    }

    public void setUserState(String userState) {
        this.userState = userState == null ? null : userState.trim();
    }

    public String getVipLevel() {
        return vipLevel;
    }

    public void setVipLevel(String vipLevel) {
        this.vipLevel = vipLevel == null ? null : vipLevel.trim();
    }

    public String getSafetyLevel() {
        return safetyLevel;
    }

    public void setSafetyLevel(String safetyLevel) {
        this.safetyLevel = safetyLevel == null ? null : safetyLevel.trim();
    }

    public String getUserLoginName() {
        return userLoginName;
    }

    public void setUserLoginName(String userLoginName) {
        this.userLoginName = userLoginName == null ? null : userLoginName.trim();
    }

    public String getUserLoginPwd() {
        return userLoginPwd;
    }

    public void setUserLoginPwd(String userLoginPwd) {
        this.userLoginPwd = userLoginPwd == null ? null : userLoginPwd.trim();
    }

    public String getPwdSafetyLevel() {
        return pwdSafetyLevel;
    }

    public void setPwdSafetyLevel(String pwdSafetyLevel) {
        this.pwdSafetyLevel = pwdSafetyLevel == null ? null : pwdSafetyLevel.trim();
    }

    public String getUserMp() {
        return userMp;
    }

    public void setUserMp(String userMp) {
        this.userMp = userMp == null ? null : userMp.trim();
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail == null ? null : userEmail.trim();
    }

    public String getEmailValidateFlag() {
        return emailValidateFlag;
    }

    public void setEmailValidateFlag(String emailValidateFlag) {
        this.emailValidateFlag = emailValidateFlag == null ? null : emailValidateFlag.trim();
    }

    public String getUserNickname() {
        return userNickname;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname == null ? null : userNickname.trim();
    }

    public String getOrtraitFileId() {
        return ortraitFileId;
    }

    public void setOrtraitFileId(String ortraitFileId) {
        this.ortraitFileId = ortraitFileId == null ? null : ortraitFileId.trim();
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

    public String getRegisterWay() {
        return registerWay;
    }

    public void setRegisterWay(String registerWay) {
        this.registerWay = registerWay == null ? null : registerWay.trim();
    }

    public String getRegisterSource() {
        return registerSource;
    }

    public void setRegisterSource(String registerSource) {
        this.registerSource = registerSource == null ? null : registerSource.trim();
    }

    public String getCreditFlag() {
        return creditFlag;
    }

    public void setCreditFlag(String creditFlag) {
        this.creditFlag = creditFlag == null ? null : creditFlag.trim();
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getUserEmailToken() {
        return userEmailToken;
    }

    public void setUserEmailToken(String userEmailToken) {
        this.userEmailToken = userEmailToken == null ? null : userEmailToken.trim();
    }
}