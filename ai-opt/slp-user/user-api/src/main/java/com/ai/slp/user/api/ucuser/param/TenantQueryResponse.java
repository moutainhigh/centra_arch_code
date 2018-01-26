package com.ai.slp.user.api.ucuser.param;

import com.ai.opt.base.vo.BaseResponse;

public class TenantQueryResponse extends BaseResponse {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 租户ID
	 */
	private String tenantId;

	/**
	 * 公司名称
	 */
	private String tenantName;
	
	/**
	 * 公司类型
	 */
	private String industryCode;

    public String getTenantId() {
		return tenantId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

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
}
