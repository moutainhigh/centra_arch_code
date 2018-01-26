package com.ai.slp.user.api.safari.param;

import com.ai.opt.base.vo.BaseResponse;
import com.ai.opt.base.vo.PageInfo;

/**
 * 查询浏览商品出参 Date: 2016年4月25日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * 
 * @author zhangqiang7
 */
public class UserSafariInfoResponse extends BaseResponse {

    private static final long serialVersionUID = 1L;

    /**
     * 返回信息
     */
    PageInfo<UserSafariInfoParams> pageInfo;

    public PageInfo<UserSafariInfoParams> getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo<UserSafariInfoParams> pageInfo) {
        this.pageInfo = pageInfo;
    }

}
