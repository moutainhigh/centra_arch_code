package com.ai.slp.user.api.specialinfo.param;

import javax.validation.constraints.NotNull;

import com.ai.opt.base.vo.BaseInfo;
import com.ai.slp.user.api.specialinfo.interfaces.IUcSpecialInfoSV;

/**
 * 更新个性化信息入参 Date: 2016年4月28日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * 
 * @author zhangqiang7
 */
public class UpdateSepcialInfoRequest extends BaseInfo {

    private static final long serialVersionUID = 1L;

    /**
     * 用户Id NOT NULL
     */
    private String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * 拓展Id NOT NULL
     */
    @NotNull(message = "infoSpecialId不能为空")
    private Long infoSpecialId;

    /**
     * 个性化类型
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
     * 属性Id
     */
    private String attrId;

    /**
     * 属性名称
     */
    private String attrValue;

    /**
     * 更新渠道
     */
    private String updateChlId;

    /**
     * 更新员工
     */
    private Long updateOperId;

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

    public String getUpdateChlId() {
        return updateChlId;
    }

    public void setUpdateChlId(String updateChlId) {
        this.updateChlId = updateChlId;
    }

    public Long getUpdateOperId() {
        return updateOperId;
    }

    public void setUpdateOperId(Long updateOperId) {
        this.updateOperId = updateOperId;
    }

}
