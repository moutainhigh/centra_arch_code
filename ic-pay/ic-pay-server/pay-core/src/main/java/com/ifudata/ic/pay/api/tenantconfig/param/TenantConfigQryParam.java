package com.ifudata.ic.pay.api.tenantconfig.param;

import com.ifudata.centra.base.vo.BaseInfo;
/**
 * 租户配置信息查询参数
 * Date: 2015年12月10日 <br>
 * 
 */
public class TenantConfigQryParam extends BaseInfo {
    private static final long serialVersionUID = -2934283921250768599L;
    /**
     * 配置类型
     */
    private String configType;

    public String getConfigType() {
        return configType;
    }

    public void setConfigType(String configType) {
        this.configType = configType == null ? null : configType.trim();
    }

}