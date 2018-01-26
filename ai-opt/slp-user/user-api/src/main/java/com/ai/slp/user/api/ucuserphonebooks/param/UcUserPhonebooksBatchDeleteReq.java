package com.ai.slp.user.api.ucuserphonebooks.param;

import java.util.List;

import com.ai.opt.base.vo.BaseInfo;

public class UcUserPhonebooksBatchDeleteReq extends BaseInfo {

    private static final long serialVersionUID = 1L;

    /**
     * 需要批量删除的记录ID列表
     */
    private List<String> recordIds;

    public List<String> getRecordIds() {
        return recordIds;
    }

    public void setRecordIds(List<String> recordIds) {
        this.recordIds = recordIds;
    }

}
