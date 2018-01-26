package com.ai.slp.user.api.register.param;

import com.ai.opt.base.vo.BaseResponse;

public class RegisterResponse extends BaseResponse{
    private static final long serialVersionUID = 1L;

    /**
     * 账号ID
     */
    private String userId;
    
    private String responseCode;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

   
}
