package com.ai.slp.user.api.apiinfo.param;

import com.ai.opt.base.vo.BaseResponse;
import com.ai.opt.base.vo.PageInfo;

/**
 * API信息查询服务出参 Date: 2016年4月20日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * 
 * @author zhangqiang7
 */
public class ApiInfoResponse extends BaseResponse {

    private static final long serialVersionUID = 1L;

    /**
     * 返回信息
     */
    private PageInfo<UcApiInfoParams> pageInfo;

    public PageInfo<UcApiInfoParams> getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo<UcApiInfoParams> pageInfo) {
        this.pageInfo = pageInfo;
    }

}
