package com.ifudata.dvp.pay.api.tenantconfig;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Service;
import com.ifudata.dvp.base.exception.BusinessException;
import com.ifudata.dvp.pay.api.tenantconfig.interfaces.ITenantConfigSV;
import com.ifudata.dvp.pay.api.tenantconfig.param.TenantConfigParam;
import com.ifudata.dvp.pay.api.tenantconfig.param.TenantConfigQryParam;
import com.ifudata.dvp.pay.constants.ExceptCodeConstants;
import com.ifudata.dvp.pay.service.business.interfaces.ITenantConfigCombSV;
import com.ifudata.dvp.sdk.util.StringUtil;

@Service
@Component
public class TenantConfigSVImpl implements ITenantConfigSV {
    private static final Log LOG = LogFactory.getLog(ITenantConfigSV.class);
    @Autowired
    private ITenantConfigCombSV tenantConfigCombSV;

    @Override
    public void createTenantConfig(TenantConfigParam param)  {
        LOG.info("创建租户配置信息开始");
        if (param == null) {
            throw new BusinessException(ExceptCodeConstants.PARAM_IS_NULL, "获取参数失败:请求参数不能为空");
        }
        if (StringUtil.isBlank(param.getTenantId())) {
            throw new BusinessException(ExceptCodeConstants.PARAM_IS_NULL, "获取参数失败:租户ID不能为空");
        }
        if (StringUtil.isBlank(param.getConfigType())) {
            throw new BusinessException(ExceptCodeConstants.PARAM_IS_NULL, "获取参数失败:配置类型不能为空");
        }
        if (StringUtil.isBlank(param.getConfigInfo())) {
            throw new BusinessException(ExceptCodeConstants.PARAM_IS_NULL, "获取参数失败:配置信息不能为空");
        }
        tenantConfigCombSV.createTenantConfig(param);
        LOG.info("创建租户配置信息结束");
    }

    @Override
    public void createOrModifyTenantConfig(TenantConfigParam param)  {
        LOG.info("修改租户配置信息开始");
        if (param == null) {
            throw new BusinessException(ExceptCodeConstants.PARAM_IS_NULL, "获取参数失败:请求参数不能为空");
        }
        if (StringUtil.isBlank(param.getTenantId())) {
            throw new BusinessException(ExceptCodeConstants.PARAM_IS_NULL, "获取参数失败:租户ID不能为空");
        }
        if (StringUtil.isBlank(param.getConfigType())) {
            throw new BusinessException(ExceptCodeConstants.PARAM_IS_NULL, "获取参数失败:配置类型不能为空");
        }
        if (StringUtil.isBlank(param.getConfigInfo())) {
            throw new BusinessException(ExceptCodeConstants.PARAM_IS_NULL, "获取参数失败:配置信息不能为空");
        }
        tenantConfigCombSV.createOrModifyTenantConfig(param);
        LOG.info("修改租户配置信息结束");
    }

    @Override
    public List<TenantConfigParam> queryTenantConfigByTenantId(TenantConfigQryParam param)
             {
        LOG.info("查询租户配置信息开始");
        if (param == null) {
            throw new BusinessException(ExceptCodeConstants.PARAM_IS_NULL, "获取参数失败:请求参数不能为空");
        }
        if (StringUtil.isBlank(param.getTenantId())) {
            throw new BusinessException(ExceptCodeConstants.PARAM_IS_NULL, "获取参数失败:租户ID不能为空");
        }
        return tenantConfigCombSV.queryTenantConfigByTenantId(param);
    }

    @Override
    public TenantConfigParam queryTenantConfigByConfigTypeId(TenantConfigQryParam param)
             {
        LOG.info("查询租户配置信息开始");
        if (param == null) {
            throw new BusinessException(ExceptCodeConstants.PARAM_IS_NULL, "获取参数失败:请求参数不能为空");
        }
        if (StringUtil.isBlank(param.getTenantId())) {
            throw new BusinessException(ExceptCodeConstants.PARAM_IS_NULL, "获取参数失败:租户ID不能为空");
        }
        if (StringUtil.isBlank(param.getConfigType())) {
            throw new BusinessException(ExceptCodeConstants.PARAM_IS_NULL, "获取参数失败:配置类型不能为空");
        }
        return tenantConfigCombSV.queryTenantConfigByConfigTypeId(param);
    }

}
