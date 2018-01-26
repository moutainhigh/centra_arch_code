package com.ai.slp.user.api.ucuser.param;

import com.ai.opt.base.vo.BaseInfo;

public class TenantInfoRequest extends BaseInfo {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 公司名称(必填)
	 */
	private String tenantName;
	
	/**
	 * 公司类型(必填)
	 */
	private String industryCode;
	
	/**
	 * 账户ID(必填)
	 */
	private String accountId;
	
	/**
	 * 修改人ID(必填)
	 */
	private Long updateAccountId;
	
	public String getTenantName() {
		return tenantName;
	}

	public void setTenantName(String tenantName) {
		this.tenantName = tenantName;
	}

	public String getIndustryCode() {
		return industryCode;
	}

	public void setIndustryCode(String industryCode) {
		this.industryCode = industryCode;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	

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
}
