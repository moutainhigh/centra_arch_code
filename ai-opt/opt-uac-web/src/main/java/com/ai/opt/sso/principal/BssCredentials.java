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

    //账号ID
    private long accountId;
    //租户id
    private String tenantId;
    //账号名称
    private String accountName;
    //昵称
    private String nickName;
    //手机号码
    private String phone;
    //邮件
    private String email;    
    //账号类型
    private String accountType;
    //账户级别
    private String accountLevel;
    //微信
    private String weixin;
    //微博
    private String weibo;
    //qq
    private String qq;
    
    
	public String getTenantId() {
		return tenantId;
	}
	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getAccountLevel() {
		return accountLevel;
	}
	public void setAccountLevel(String accountLevel) {
		this.accountLevel = accountLevel;
	}
	public String getWeixin() {
		return weixin;
	}
	public void setWeixin(String weixin) {
		this.weixin = weixin;
	}
	public String getWeibo() {
		return weibo;
	}
	public void setWeibo(String weibo) {
		this.weibo = weibo;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public long getAccountId() {
		return accountId;
	}
	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}
	
    
    

}
