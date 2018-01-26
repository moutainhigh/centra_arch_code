package com.ifudata.ic.pay.api.tenantconfig.interfaces;
import java.util.List;

import com.ifudata.ic.pay.api.tenantconfig.param.TenantConfigParam;
import com.ifudata.ic.pay.api.tenantconfig.param.TenantConfigQryParam;


/**
 * 租户配置信息服务
 * Date: 2015年12月10日 <br>
 * 
 */
public interface ITenantConfigSV {

    /**
     * 创建租户配置信息
     * @ 可能抛出的异常信息
     * @ApiDocMethod 
     * @ApiCode PAY_0009
     */
    void createTenantConfig(TenantConfigParam param) ;
    /**
     * 修改租户配置信息
     * @param param
     * @ApiDocMethod
     * @ApiCode PAY_0010
     */
    void createOrModifyTenantConfig(TenantConfigParam param) ;
    
    /**
     * 通过租户id查询租户配置信息
     * @ 可能抛出的异常信息
     * @ApiDocMethod
     * @ApiCode PAY_0011
     */
    List<TenantConfigParam> queryTenantConfigByTenantId(TenantConfigQryParam param) ;
    /**
     * 通过配置类型查询租户配置信息
     * @ 可能抛出的异常信息
     * @ApiDocMethod
     * @ApiCode PAY_0012
     */
    TenantConfigParam queryTenantConfigByConfigTypeId(TenantConfigQryParam param) ;
    
}
