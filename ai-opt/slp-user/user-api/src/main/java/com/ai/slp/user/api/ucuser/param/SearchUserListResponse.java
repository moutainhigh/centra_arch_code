package com.ai.slp.user.api.ucuser.param;

import com.ai.opt.base.vo.BaseResponse;
import com.ai.opt.base.vo.PageInfo;

/**
 * 查询用户出参 Date: 2016年5月3日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * 
 * @author zhangqiang7
 */
public class SearchUserListResponse extends BaseResponse {

    private static final long serialVersionUID = 1L;

    /**
     * 返回信息
     */
    private PageInfo<UcUserInfoParams> pageInfo;

    public PageInfo<UcUserInfoParams> getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo<UcUserInfoParams> pageInfo) {
        this.pageInfo = pageInfo;
    }

}
