package com.ai.slp.user.api.safari.param;

import com.ai.opt.base.vo.BaseInfo;

/**
 * 删除浏览商品记录入参 Date: 2016年4月25日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * 
 * @author zhangqiang7
 */
public class DeleteSafariRequest extends BaseInfo {

    private static final long serialVersionUID = 1L;

    /**
     * 用户ID NOT NULL
     */
    private String userId;

    /**
     * 全部删除code
     */
    private String deleteCode;

    /**
     * 浏览商品ID 可以为空
     */
    private String prodId;

    /**
     * 时间参数 可以为空
     */
    private String dateTime;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getProdId() {
        return prodId;
    }

    public void setProdId(String prodId) {
        this.prodId = prodId;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getDeleteCode() {
        return deleteCode;
    }

    public void setDeleteCode(String deleteCode) {
        this.deleteCode = deleteCode;
    }

}
