package com.ai.slp.user.api.favorite.param;

import com.ai.opt.base.vo.BaseInfo;

/**
 * 创建用户收藏信息参数 <br>
 * Date: 2016年4月18日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * 
 * @author zhangqiang7
 */
public class InsertUserFavoriteRequest extends BaseInfo {
    private static final long serialVersionUID = 1L;

    /**
     * 用户ID NOT NULL
     */
    private String userId;

    /**
     * 收藏ID
     */
    private String favoriteSeqId;

    /**
     * 收藏关系ID NOT NULL
     */
    private String favoriteRelId;

    /**
     * 收藏类型
     */

    private String favoriteType;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setFavoriteSeqId(String favoriteSeqId) {
        this.favoriteSeqId = favoriteSeqId;
    }

    public String getFavoriteRelId() {
        return favoriteRelId;
    }

    public void setFavoriteRelId(String favoriteRelId) {
        this.favoriteRelId = favoriteRelId;
    }

    public String getFavoriteType() {
        return favoriteType;
    }

    public void setFavoriteType(String favoriteType) {
        this.favoriteType = favoriteType;
    }

    public String getFavoriteSeqId() {
        return favoriteSeqId;
    }

    public void setFavoriteReqId(String favoriteSeqId) {
        this.favoriteSeqId = favoriteSeqId;
    }

}
