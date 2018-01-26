package com.ai.slp.user.api.specialinfo.param;

import com.ai.opt.base.vo.BaseInfo;

/**
 * 获取个性化信息出参 Date: 2016年4月28日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * 
 * @author zhangqiang7
 */
public class QuerySpecialInfoRequest extends BaseInfo {

    private static final long serialVersionUID = 1L;

    /**
     * 用户Id NOT NULL
     */
    private String userId;

    /**
     * 扩展ID
     */
    private Long specialInfoId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Long getSpecialInfoId() {
        return specialInfoId;
    }

    public void setSpecialInfoId(Long specialInfoId) {
        this.specialInfoId = specialInfoId;
    }

}
