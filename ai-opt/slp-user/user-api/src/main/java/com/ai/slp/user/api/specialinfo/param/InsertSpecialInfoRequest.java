package com.ai.slp.user.api.specialinfo.param;

import com.ai.opt.base.vo.BaseInfo;

/**
 * 创建用户个性化信息入参 Date: 2016年4月28日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * 
 * @author zhangqiang7
 */
public class InsertSpecialInfoRequest extends BaseInfo {

    private static final long serialVersionUID = 1L;

    /**
     * 用户Id NOT NULL
     */
    private String userId;

    /**
     * 扩展ID
     */
    private Long infoSpecialId;

    /**
     * 个人性化分类
     */
    private String infoType;

    /**
     * 子分类
     */
    private String infoItem;

    /**
     * 状态
     */
    private String state;

    /**
     * 属性ID
     */
    private String attrId;

    /**
     * 属性值
     */
    private String attrValue;

    /**
     * 创建渠道
     */
    private String createChlId;

    /**
     * 创建员工
     */
    private Long createOperId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Long getInfoSpecialId() {
        return infoSpecialId;
    }

    public void setInfoSpecialId(Long infoSpecialId) {
        this.infoSpecialId = infoSpecialId;
    }

    public String getInfoType() {
        return infoType;
    }

    public void setInfoType(String infoType) {
        this.infoType = infoType;
    }

    public String getInfoItem() {
        return infoItem;
    }

    public void setInfoItem(String infoItem) {
        this.infoItem = infoItem;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getAttrId() {
        return attrId;
    }

    public void setAttrId(String attrId) {
        this.attrId = attrId;
    }

    public String getAttrValue() {
        return attrValue;
    }

    public void setAttrValue(String attrValue) {
        this.attrValue = attrValue;
    }

    public String getCreateChlId() {
        return createChlId;
    }

    public void setCreateChlId(String createChlId) {
        this.createChlId = createChlId;
    }

    public Long getCreateOperId() {
        return createOperId;
    }

    public void setCreateOperId(Long createOperId) {
        this.createOperId = createOperId;
    }

}
