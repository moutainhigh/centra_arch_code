package com.ai.slp.user.api.ucUserSecurity.param;

import com.ai.opt.base.vo.BaseInfo;

public class UcUserPasswordRequest extends BaseInfo{

	private static final long serialVersionUID = 1L;
	
	/**
	 * 账号ID（必填）
	 */
	private String accountId;

	/**
	 * 密码（必填）
	 */
	private String accountPassword;
	
	/**
	 * 更新人ID
	 */
	private Long updateAccountId;

	

	public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public Long getUpdateAccountId() {
		return updateAccountId;
	}

	public void setUpdateAccountId(Long updateAccountId) {
		this.updateAccountId = updateAccountId;
	}

	public String getAccountPassword() {
		return accountPassword;
	}

	public void setAccountPassword(String accountPassword) {
		this.accountPassword = accountPassword;
	}
}
