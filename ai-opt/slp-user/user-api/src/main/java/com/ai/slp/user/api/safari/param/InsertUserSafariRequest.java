package com.ai.slp.user.api.safari.param;

import com.ai.opt.base.vo.BaseInfo;

/**
 * 用户查看商品足迹信息参数<br>
 * Date: 2016年4月18日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * 
 * @author zhangqiang7
 */

public class InsertUserSafariRequest extends BaseInfo {
    private static final long serialVersionUID = 1L;

    /**
     * 用户ID NOT NULL
     */
    private String userId;

    /**
     * 浏览商品ID NOT NULL
     */
    private String prodId;

    public String getProdId() {
        return prodId;
    }

    public void setProdId(String prodId) {
        this.prodId = prodId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

}
