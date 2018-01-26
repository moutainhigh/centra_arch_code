package com.ifudata.ic.pay.service.business.interfaces;

import java.util.List;

import com.ifudata.centra.base.exception.BusinessException;
import com.ifudata.ic.pay.api.tenantconfig.param.TenantConfigParam;
import com.ifudata.ic.pay.api.tenantconfig.param.TenantConfigQryParam;


/**
 * 租户配置服务
 * Date: 2015年12月10日 <br>
 */
public interface ITenantConfigCombSV {

    /**
     * 创建租户配置信息
     * @param param
     * @throws BusinessException
     * @ApiDocMethod
     */
    void createTenantConfig(TenantConfigParam param) throws BusinessException;
    /**
     * 修改租户配置信息
     * @param param
     * @throws BusinessException
     * @ApiDocMethod
     */
    void createOrModifyTenantConfig(TenantConfigParam param) throws BusinessException;
    
    /**
     * 通过租户id查询租户配置信息
     * @param param
     * @return
     * @throws BusinessException
     * @ApiDocMethod
     */
    List<TenantConfigParam> queryTenantConfigByTenantId(TenantConfigQryParam param) throws BusinessException;
    /**
     * 通过配置类型查询租户配置信息
     * @param param
     * @return
     * @throws BusinessException
     * @ApiDocMethod
     */
    TenantConfigParam queryTenantConfigByConfigTypeId(TenantConfigQryParam param) throws BusinessException;
    
}
