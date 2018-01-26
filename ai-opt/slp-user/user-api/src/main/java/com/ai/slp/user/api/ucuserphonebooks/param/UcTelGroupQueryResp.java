package com.ai.slp.user.api.ucuserphonebooks.param;

import java.util.List;

import com.ai.opt.base.vo.BaseResponse;

public class UcTelGroupQueryResp extends BaseResponse {

    private static final long serialVersionUID = 1L;

    /**
     * 通信录分组列表
     */
    private List<UcTelGroup> groups;

    public List<UcTelGroup> getGroups() {
        return groups;
    }

    public void setGroups(List<UcTelGroup> groups) {
        this.groups = groups;
    }

}
