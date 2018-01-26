package com.ai.slp.user.api.favorite.param;

import com.ai.opt.base.vo.BaseResponse;
import com.ai.opt.base.vo.PageInfo;

/**
 * 用户收藏信息出参 Date: 2016年4月20日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * 
 * @author zhangqiang7
 */
public class UserFavoriteResponse extends BaseResponse {

    private static final long serialVersionUID = 1L;

    /**
     * 返回信息
     */
    PageInfo<UserFavoriteParams> pageInfo;

    public PageInfo<UserFavoriteParams> getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo<UserFavoriteParams> pageInfo) {
        this.pageInfo = pageInfo;
    }

}
