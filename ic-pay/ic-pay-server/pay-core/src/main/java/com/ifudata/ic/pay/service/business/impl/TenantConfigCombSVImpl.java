package com.ifudata.ic.pay.service.business.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ifudata.centra.base.exception.BusinessException;
import com.ifudata.centra.sdk.util.BeanUtils;
import com.ifudata.centra.sdk.util.CollectionUtil;
import com.ifudata.ic.pay.api.tenantconfig.param.TenantConfigParam;
import com.ifudata.ic.pay.api.tenantconfig.param.TenantConfigQryParam;
import com.ifudata.ic.pay.dao.mapper.bo.PayTenantConfig;
import com.ifudata.ic.pay.service.atom.interfaces.IPayTenantConfigSV;
import com.ifudata.ic.pay.service.business.interfaces.ITenantConfigCombSV;
@Service
@Transactional
public class TenantConfigCombSVImpl implements ITenantConfigCombSV {

    @Autowired
    private IPayTenantConfigSV payTenantConfigSV;

    @Override
    public void createTenantConfig(TenantConfigParam param) throws BusinessException {
        PayTenantConfig tenantConfig = new PayTenantConfig();
        BeanUtils.copyProperties(tenantConfig, param);
        payTenantConfigSV.savePayTenantConfig(tenantConfig);
    }

    @Override
    public void createOrModifyTenantConfig(TenantConfigParam param) throws BusinessException {
        PayTenantConfig tenantConfig = new PayTenantConfig();
        BeanUtils.copyProperties(tenantConfig, param);
        payTenantConfigSV.createOrModifyTenantConfig(tenantConfig);
    }

    @Override
    public List<TenantConfigParam> queryTenantConfigByTenantId(TenantConfigQryParam param)
            throws BusinessException {
        List<TenantConfigParam> tenantConfigParamList = new ArrayList<TenantConfigParam>();
        List<PayTenantConfig> configs = payTenantConfigSV.getPayTenantConfigByTenantId(param
                .getTenantId());
        if (!CollectionUtil.isEmpty(configs)) {
            for (PayTenantConfig payTenantConfig : configs) {
                TenantConfigParam tenantConfigParam = new TenantConfigParam();
                BeanUtils.copyProperties(tenantConfigParam, payTenantConfig);
                tenantConfigParamList.add(tenantConfigParam);
            }
        }
        return tenantConfigParamList;
    }

    @Override
    public TenantConfigParam queryTenantConfigByConfigTypeId(TenantConfigQryParam param)
            throws BusinessException {
        PayTenantConfig config = payTenantConfigSV.getPayTenantConfigByConfigType(
                param.getTenantId(), param.getConfigType());
        if (config == null) {
            return null;
        }
        TenantConfigParam tenantConfigParam = new TenantConfigParam();
        BeanUtils.copyProperties(tenantConfigParam, config);
        return tenantConfigParam;
    }

}
