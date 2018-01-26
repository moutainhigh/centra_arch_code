package com.ai.slp.user.api.login.param;

import com.ai.opt.base.vo.BaseResponse;

/**
 * 登录服务出参 Date: 2016年4月20日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * 
 * @author zhangqiang7
 */
public class LoginResponse extends BaseResponse {

	private static final long serialVersionUID = 1L;

	/**
	 * 租户类型
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
	 * 用户昵称
	 */
	private String userNickname;

	/**
	 * 用户登陆用户名
	 */
	private String UserLoginName;

	/**
	 * 用户邮箱
	 */
	private String userEmail;

	/**
	 * 用户手机号
	 */
	private String userMp;

	/**
	 * 用户密码
	 */
	private String userLoginPwd;

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getUserLoginName() {
		return UserLoginName;
	}

	public void setUserLoginName(String userLoginName) {
		UserLoginName = userLoginName;
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

	public String getUserNickname() {
		return userNickname;
	}

	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}

}
