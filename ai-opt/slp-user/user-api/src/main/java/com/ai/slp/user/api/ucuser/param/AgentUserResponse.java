package com.ai.slp.user.api.ucuser.param;

import java.sql.Timestamp;

import com.ai.opt.base.vo.BaseResponse;

public class AgentUserResponse extends BaseResponse {
    private static final long serialVersionUID = 1L;
    /**
     * 租户ID
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
     * 用户vip等级
     */
    private String vipLevel;
    /**
     * 安全级别
     */
    private String safetyLevel;
    /**
     * 用户名称
     */
    private String userLoginName;
   
    /**
     * 手机号
     */
    private String userMp;
    /**
     * 用户邮件
     */
    private String userEmail;
    /**
     * 邮件验证标志
     */
    private String emailValidateFlag;
    /**
     * 昵称
     */
    private String userNickname;
    /**
     * 用户头像Id
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
     * 客户状态变更时间
     */
    private Timestamp stateChgTime;
    
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
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

    public Timestamp getStateChgTime() {
        return stateChgTime;
    }

    public void setStateChgTime(Timestamp stateChgTime) {
        this.stateChgTime = stateChgTime;
    }


}
