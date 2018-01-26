package com.ai.slp.user.api.ucuser.param;

import com.ai.opt.base.vo.BaseResponse;

public class TenantInsertResponse extends BaseResponse {
	private static final long serialVersionUID = 1L;

	private String tenantId;

	public String getTenantId() {
		return tenantId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}
}
