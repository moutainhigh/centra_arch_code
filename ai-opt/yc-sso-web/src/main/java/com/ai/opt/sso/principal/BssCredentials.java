package com.ai.opt.sso.principal;

import org.jasig.cas.authentication.RememberMeUsernamePasswordCredential;
/**
 * BssCredentials
 *
 * Date: 2016年3月16日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * @author gucl
 */
public class BssCredentials extends RememberMeUsernamePasswordCredential {
    private static final long serialVersionUID = -8147635836938729264L;

    //租户ID
    private String tenantId;
    //账号ID
    private String userId;
    //账号名称
    private String loginName;
    //手机号码
    private String mobile;
    //邮件
    private String email;
    //国家代码
    private String domainname;
    /**
     * 验证码
     */
    private String captchaCode;
	/**
	 * 登录方式
	 * 0：普通登录
	 * 1：手机快速登录
	 * 2：金山登录
	 */
	private String loginType;

    private String errorNumCCS;
    
    private String errorNum;

    private String errorNumTimeOutCCS;
	/**
	 * sessionId
	 */
	private String sessionId;
    /**
     * 系统来源
     */
	private String systemId;
    
	public String getSystemId() {
		return systemId;
	}
	public void setSystemId(String systemId) {
		this.systemId = systemId;
	}
	public String getErrorNum() {
		return errorNum;
	}
	public void setErrorNum(String errorNum) {
		this.errorNum = errorNum;
	}
	public String getErrorNumTimeOutCCS() {
		return errorNumTimeOutCCS;
	}
	public void setErrorNumTimeOutCCS(String errorNumTimeOutCCS) {
		this.errorNumTimeOutCCS = errorNumTimeOutCCS;
	}
	public String getErrorNumCCS() {
		return errorNumCCS;
	}
	public void setErrorNumCCS(String errorNumCCS) {
		this.errorNumCCS = errorNumCCS;
	}
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
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCaptchaCode() {
		return captchaCode;
	}
	public void setCaptchaCode(String captchaCode) {
		this.captchaCode = captchaCode;
	}
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	public String getDomainname() {
		return domainname;
	}
	public void setDomainname(String domainname) {
		this.domainname = domainname;
	}

	public String getLoginType() {
		return loginType;
	}

	public void setLoginType(String loginType) {
		this.loginType = loginType;
	}
}
