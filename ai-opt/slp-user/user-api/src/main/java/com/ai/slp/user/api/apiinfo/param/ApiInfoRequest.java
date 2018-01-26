package com.ai.slp.user.api.apiinfo.param;

import com.ai.opt.base.vo.BaseInfo;

/**
 * API信息查询服务入参 Date: 2016年4月20日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * 
 * @author zhangqiang7
 */
public class ApiInfoRequest extends BaseInfo {
    private static final long serialVersionUID = 1L;

    /**
     * ApiID 不能为空
     */
    private String apiReqId;

    /**
     * 用户ID 不能为空
     */
    private String userId;

    /**
     * pageNo
     */
    private Integer pageNo;

    /**
     * pageSize
     */
    private Integer pageSize;

    public String getApiReqId() {
        return apiReqId;
    }

    public void setApiReqId(String apiReqId) {
        this.apiReqId = apiReqId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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
