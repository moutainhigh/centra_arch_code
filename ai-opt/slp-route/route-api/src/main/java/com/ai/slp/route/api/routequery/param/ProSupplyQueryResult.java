package com.ai.slp.route.api.routequery.param;

import java.util.List;

import com.ai.opt.base.vo.BaseResponse;

/**
 * 路由下商品查询返回参数<br>
 * Date: 2016年4月18日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * 
 * @author zhangxw
 */
public class ProSupplyQueryResult extends BaseResponse {

    private static final long serialVersionUID = 1L;

    /**
     * 供应商品ID
     */
    private String supplyId;

    /**
     * 供应商品名称
     */
    private String supplyName;

    /**
     * 总量
     */
    private long totalNum;

    /**
     * 可用量
     */
    private long usableNum;

    /**
     * 属性列表
     */
    private List<ProAttrDefVo> proAttrDefList;

    public long getTotalNum() {
        return totalNum;
    }

    public long getUsableNum() {
        return usableNum;
    }

    public List<ProAttrDefVo> getProAttrDefList() {
        return proAttrDefList;
    }

    public void setTotalNum(long totalNum) {
        this.totalNum = totalNum;
    }

    public void setUsableNum(long usableNum) {
        this.usableNum = usableNum;
    }

    public void setProAttrDefList(List<ProAttrDefVo> proAttrDefList) {
        this.proAttrDefList = proAttrDefList;
    }

    public String getSupplyId() {
        return supplyId;
    }

    public String getSupplyName() {
        return supplyName;
    }

    public void setSupplyId(String supplyId) {
        this.supplyId = supplyId;
    }

    public void setSupplyName(String supplyName) {
        this.supplyName = supplyName;
    }

}
