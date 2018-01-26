package com.ai.slp.route.api.core.params;

import com.ai.opt.base.vo.BaseInfo;

/**
 * Created by xin on 16-4-22.
 */
public class SaleProductInfo extends BaseInfo {
    /**
     * 路由组ID
     */
    private String routeGroupId;

    // 商品金额 单位：厘
    private float totalConsumption;


    public String getRouteGroupId() {
        return routeGroupId;
    }

    public void setRouteGroupId(String routeGroupId) {
        this.routeGroupId = routeGroupId;
    }

    public float getTotalConsumption() {
        return totalConsumption;
    }

    public void setTotalConsumption(float totalConsumption) {
        this.totalConsumption = totalConsumption;
    }
}
