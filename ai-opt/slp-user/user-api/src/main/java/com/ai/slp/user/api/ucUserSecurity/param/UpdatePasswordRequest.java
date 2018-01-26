package com.ai.slp.user.api.ucUserSecurity.param;

import com.ai.opt.base.vo.BaseInfo;

public class UpdatePasswordRequest extends BaseInfo {

    private static final long serialVersionUID = 1L;

    /**
     * 用户类型 不能为空
     */
    private String userType;

    /**
     * 用户登陆用户名
     */
    private String userLoginName;

    /**
     * 用户邮箱
     */
    private String userEmail;

    /**
     * 用户手机号
     */
    private String userMp;

    /**
     * 密码（必填）
     */
    private String userLoginPwd;

    /**
     * 更新人ID
     */
    private Long updateOperId;

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getUserLoginName() {
        return userLoginName;
    }

    public void setUserLoginName(String userLoginName) {
        this.userLoginName = userLoginName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserMp() {
        return userMp;
    }

    public void setUserMp(String userMp) {
        this.userMp = userMp;
    }

    public String getUserLoginPwd() {
        return userLoginPwd;
    }

    public void setUserLoginPwd(String userLoginPwd) {
        this.userLoginPwd = userLoginPwd;
    }

    public Long getUpdateOperId() {
        return updateOperId;
    }

    public void setUpdateOperId(Long updateOperId) {
        this.updateOperId = updateOperId;
    }

}
