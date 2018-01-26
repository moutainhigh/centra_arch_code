package com.ai.slp.user.api.safari.param;

import java.sql.Timestamp;

import com.ai.opt.base.vo.BaseInfo;

/**
 * 查询用户浏览信息入参 Date: 2016年4月25日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * 
 * @author zhangqiang7
 */
public class UserSafariInfoRequest extends BaseInfo {

    private static final long serialVersionUID = 1L;

    /**
     * 用户ID NOT NULL
     */
    private String userId;

    /**
     * 浏览时间
     */
    private Timestamp safariTime;

    /**
     * pageNo
     */
    private Integer pageNo;

    /**
     * pageSize
     */
    private Integer pageSize;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Timestamp getSafariTime() {
        return safariTime;
    }

    public void setSafariTime(Timestamp safariTime) {
        this.safariTime = safariTime;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

}
