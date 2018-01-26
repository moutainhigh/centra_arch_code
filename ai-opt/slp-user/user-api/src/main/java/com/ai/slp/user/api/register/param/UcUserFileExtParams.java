package com.ai.slp.user.api.register.param;

import java.io.Serializable;

/**
 * 用户信息 <br>
 * Date: 2016年4月18日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * 
 * @author zhaogw
 */
public class UcUserFileExtParams implements Serializable {

    private static final long serialVersionUID = 1L;

    private String tenantId;

    private String userId;

    private String extendinfo;

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

    public String getExtendinfo() {
        return extendinfo;
    }

    public void setExtendinfo(String extendinfo) {
        this.extendinfo = extendinfo;
    }

}
