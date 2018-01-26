package com.ai.slp.user.api.ucStateChg.param;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import com.ai.opt.base.vo.BaseInfo;
import com.ai.slp.user.api.ucStateChg.interfaces.IUcStateChgSV;

public class UcStateChgParamsRequest extends BaseInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 用户ID 
     */
    @NotNull(message = "用户ID不能为空")
    private String userId;


    /**
     * 业务操作类型
     */
    private String operType;

    /**
     * 原状态
     */
    private String oldState;

    /**
     * 新状态
     */
    private String newState;

    /**
     * 状态原因描述
     */
    private String chgdesc;


    /**
     * 操作渠道
     */
    private String chlId;

    /**
     * 操作员
     */
    private long operId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }


    public String getOperType() {
        return operType;
    }

    public void setOperType(String operType) {
        this.operType = operType;
    }

    public String getOldState() {
        return oldState;
    }

    public void setOldState(String oldState) {
        this.oldState = oldState;
    }

    public String getNewState() {
        return newState;
    }

    public void setNewState(String newState) {
        this.newState = newState;
    }

    public String getChgdesc() {
        return chgdesc;
    }

    public void setChgdesc(String chgdesc) {
        this.chgdesc = chgdesc;
    }

    public String getChlId() {
        return chlId;
    }

    public void setChlId(String chlId) {
        this.chlId = chlId;
    }

    public long getOperId() {
        return operId;
    }

    public void setOperId(long operId) {
        this.operId = operId;
    }

}
