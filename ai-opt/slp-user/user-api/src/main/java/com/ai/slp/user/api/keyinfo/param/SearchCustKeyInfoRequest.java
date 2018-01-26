package com.ai.slp.user.api.keyinfo.param;

import com.ai.opt.base.vo.BaseInfo;

public class SearchCustKeyInfoRequest extends BaseInfo {

    private static final long serialVersionUID = 1L;

    private String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

}
