package com.ai.slp.user.api.ucuser.param;

import com.ai.opt.base.vo.BaseResponse;

public class SearchUserResponse extends BaseResponse {
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

    private String userFlag;
    /**
     * 用户状态
     */
    private String userState;
    
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
     * 用户密码
     */
    private String userLoginPwd;
    /**
     * 密码安全级别
     */
    private String pwdSafetyLevel;
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

    public String getUserLoginPwd() {
        return userLoginPwd;
    }

    public void setUserLoginPwd(String userLoginPwd) {
        this.userLoginPwd = userLoginPwd;
    }

    public String getPwdSafetyLevel() {
        return pwdSafetyLevel;
    }

    public void setPwdSafetyLevel(String pwdSafetyLevel) {
        this.pwdSafetyLevel = pwdSafetyLevel;
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


}
