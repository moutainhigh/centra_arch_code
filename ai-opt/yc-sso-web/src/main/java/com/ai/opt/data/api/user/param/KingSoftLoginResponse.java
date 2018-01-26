package com.ai.opt.data.api.user.param;

import java.io.Serializable;

public class KingSoftLoginResponse implements Serializable{

	private static final long serialVersionUID = -797533781211009590L;
	/**
	 * uid
	 */
	private String uid;
	/**
	 * 邮箱
	 */
	private String email;
	/**
	 * 昵称
	 */
	private String nickname;
	/**
	 * 头像地址
	 */
	private String avatar;
	/**
	 * sso登录地址
	 */
	private String ssourl;
	/**
	 * ck值
	 */
	private String ck;
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public String getSsourl() {
		return ssourl;
	}
	public void setSsourl(String ssourl) {
		this.ssourl = ssourl;
	}
	public String getCk() {
		return ck;
	}
	public void setCk(String ck) {
		this.ck = ck;
	}
	
	
}
