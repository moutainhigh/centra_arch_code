package com.ai.slp.user.api.ucuser.param;

import java.sql.Timestamp;

import com.ai.opt.base.vo.BaseInfo;

/**
 * 查询用户入参 Date: 2016年5月3日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * 
 * @author zhangqiang7
 */
public class SearchUserRequest extends BaseInfo {

    private static final long serialVersionUID = 1L;
    
    /**
     * 用户Id
     */
    
    private String userId;
    

    /**
     * 注册来源
     */
    private String registerSource;

    /**
     * 用户VIP等级
     */
    private String vipLevel;

    /**
     * 用户登录名
     */
    private String userLoginName;

    /**
     * 户绑定手机号码
     */
    private String userMp;

    /**
     * 用户绑定邮箱
     */
    private String userEmail;

    /**
     * 用户状态
     */
    private String userState;

    /**
     * 开始时间
     */
    private String beginTime;

    /**
     * 结束时间
     */
    private String endTime;
    
    /**
     * 更新时间
     */
    private Timestamp  updateTime;

    /**
     * pageSize
     */
    private Integer pageSize;

    /**
     * pageNo
     */
    private Integer pageNo;

    private String emailValidateFlag;
    
    private String userType;
    
    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public String getVipLevel() {
        return vipLevel;
    }

    public void setVipLevel(String vipLevel) {
        this.vipLevel = vipLevel;
    }

    public String getUserLoginName() {
        return userLoginName;
    }

    public void setUserLoginName(String userLoginName) {
        this.userLoginName = userLoginName;
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

    public String getRegisterSource() {
        return registerSource;
    }

    public void setRegisterSource(String registerSource) {
        this.registerSource = registerSource;
    }

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getUserState() {
        return userState;
    }

    public void setUserState(String userState) {
        this.userState = userState;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) { 
        this.userId = userId;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public String getEmailValidateFlag() {
        return emailValidateFlag;
    }

    public void setEmailValidateFlag(String emailValidateFlag) {
        this.emailValidateFlag = emailValidateFlag;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

}
