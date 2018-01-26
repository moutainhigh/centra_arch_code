package com.ai.slp.user.api.ucUserSecurity.param;

import java.io.Serializable;

public class UcUserEmailRequest implements Serializable{

	private static final long serialVersionUID = 1L;
	
	/**
	 * 账号ID（必填）
	 */
	private Long accountId;

	/**
	 * 邮箱（必填）
	 */
	private String email;
	
	/**
	 * 更新人ID
	 */
	private Long updateAccountId;

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getUpdateAccountId() {
		return updateAccountId;
	}

	public void setUpdateAccountId(Long updateAccountId) {
		this.updateAccountId = updateAccountId;
	}

}
