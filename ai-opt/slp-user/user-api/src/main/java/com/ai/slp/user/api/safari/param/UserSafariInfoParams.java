package com.ai.slp.user.api.safari.param;

import java.io.Serializable;
import java.sql.Timestamp;

public class UserSafariInfoParams implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 商品ID
     */
    private String prodId;

    /**
     * 浏览商品ID
     */
    private String safariSeqId;

    /**
     * 浏览时间
     */
    private Timestamp safariTime;

    /**
     * 状态
     */
    private String state;

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

    public String getSafariSeqId() {
        return safariSeqId;
    }

    public void setSafariSeqId(String safariSeqId) {
        this.safariSeqId = safariSeqId;
    }

    public Timestamp getSafariTime() {
        return safariTime;
    }

    public void setSafariTime(Timestamp safariTime) {
        this.safariTime = safariTime;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

}
