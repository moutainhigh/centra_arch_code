package com.ifudata.ic.pay.service.atom.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ifudata.centra.base.exception.BusinessException;
import com.ifudata.centra.sdk.util.CollectionUtil;
import com.ifudata.ic.pay.constants.ExceptCodeConstants;
import com.ifudata.ic.pay.dao.mapper.bo.PayTenantConfig;
import com.ifudata.ic.pay.dao.mapper.bo.PayTenantConfigCriteria;
import com.ifudata.ic.pay.dao.mapper.bo.PayTenantConfigCriteria.Criteria;
import com.ifudata.ic.pay.dao.mapper.factory.MapperFactory;
import com.ifudata.ic.pay.service.atom.interfaces.IPayTenantConfigSV;
/**
 * 租户配置原子服务
 * Date: 2015年12月11日 <br>
 */
@Component
public class PayTenantConfigSVImpl implements IPayTenantConfigSV {

    @Override
    public void savePayTenantConfig(PayTenantConfig config) {
        MapperFactory.getPayTenantConfigMapper().insert(config);
    }

    @Override
    public void createOrModifyTenantConfig(PayTenantConfig config) {
        PayTenantConfigCriteria configCriteria = new PayTenantConfigCriteria();
        Criteria sql = configCriteria.createCriteria();
        sql.andConfigTypeEqualTo(config.getConfigType());
        sql.andTenantIdEqualTo(config.getTenantId());
        List<PayTenantConfig> configs = MapperFactory.getPayTenantConfigMapper().selectByExample(configCriteria);
        if(CollectionUtil.isEmpty(configs)){
            MapperFactory.getPayTenantConfigMapper().insert(config);
        }else if(configs.size()>1){
            throw new BusinessException(ExceptCodeConstants.RESULT_COUNT_WRONG, "配置信息超过一条");
        }else{
            MapperFactory.getPayTenantConfigMapper().updateByExampleSelective(config, configCriteria);        
        }      
    }

    @Override
    public List<PayTenantConfig> getPayTenantConfigByTenantId(String tenantId) {
        PayTenantConfigCriteria configCriteria = new PayTenantConfigCriteria();
        Criteria sql = configCriteria.createCriteria();
        sql.andTenantIdEqualTo(tenantId);
        List<PayTenantConfig> configs = MapperFactory.getPayTenantConfigMapper().selectByExample(configCriteria);
        if(CollectionUtil.isEmpty(configs)){
            return null;
        }
        return configs;
    }

    @Override
    public PayTenantConfig getPayTenantConfigByConfigType(String tenantId, String configType) {
        PayTenantConfigCriteria configCriteria = new PayTenantConfigCriteria();
        Criteria sql = configCriteria.createCriteria();
        sql.andConfigTypeEqualTo(configType);
        sql.andConfigTypeEqualTo(tenantId);
        List<PayTenantConfig> configs = MapperFactory.getPayTenantConfigMapper().selectByExample(configCriteria);
        if(CollectionUtil.isEmpty(configs)){
            return null;
        }else if(configs.size()>1){
            throw new BusinessException(ExceptCodeConstants.RESULT_COUNT_WRONG, "配置信息超过一条");
        }else{
            return configs.get(0);
        }
    }

}
