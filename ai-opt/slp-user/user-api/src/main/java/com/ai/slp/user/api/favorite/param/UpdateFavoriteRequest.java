package com.ai.slp.user.api.favorite.param;

import java.util.List;

import com.ai.opt.base.vo.BaseInfo;

/**
 * 用户收藏信息更新入参 Date: 2016年4月27日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * 
 * @author zhangqiang7
 */
public class UpdateFavoriteRequest extends BaseInfo {

    private static final long serialVersionUID = 1L;

    /**
     * 用户ID NOT NULL
     */
    private String userId;

    /**
     * 收藏列表
     */
    private List<String> favoriteList;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<String> getFavoriteList() {
        return favoriteList;
    }

    public void setFavoriteList(List<String> favoriteList) {
        this.favoriteList = favoriteList;
    }

}
