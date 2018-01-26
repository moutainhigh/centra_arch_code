package com.ai.slp.user.api.ucStateChg.param;

import javax.validation.constraints.NotNull;

import com.ai.opt.base.vo.BaseInfo;

public class QueryStateChgRequest extends BaseInfo {

    private static final long serialVersionUID = 1L; 

    @NotNull(message = "userId不能为空")
    private String userId;

    private String stateChgId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getStateChgId() {
        return stateChgId;
    }

    public void setStateChgId(String stateChgId) {
        this.stateChgId = stateChgId;
    }

}
