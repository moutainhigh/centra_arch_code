package com.ai.slp.user.api.safari.param;

import java.util.List;

import com.ai.opt.base.vo.BaseInfo;

/**
 * 删除浏览历史表入参 Date: 2016年4月27日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * 
 * @author zhangqiang7
 */
public class DeleteSafariHisRequest extends BaseInfo {

    private static final long serialVersionUID = 1L;

    /**
     * 用户ID NOT NULL
     */
    private String userId;

    /**
     * 浏览ID列表
     */
    private List<String> safariHisIdList;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<String> getSafariHisIdList() {
        return safariHisIdList;
    }

    public void setSafariHisIdList(List<String> safariHisIdList) {
        this.safariHisIdList = safariHisIdList;
    }

}
