package com.ifudata.ic.pay.api.tenantinfoquery.impl;

import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Service;
import com.ifudata.centra.base.exception.BusinessException;
import com.ifudata.centra.sdk.util.StringUtil;
import com.ifudata.ic.pay.api.tenantinfoquery.interfaces.ITenantInfoQuerySV;
import com.ifudata.ic.pay.api.tenantinfoquery.param.PartnerInfoParam;
import com.ifudata.ic.pay.api.tenantinfoquery.param.TenantInfoParam;
import com.ifudata.ic.pay.constants.ExceptCodeConstants;
import com.ifudata.ic.pay.util.TenantInfoUtil;

/**
 * 合作方信息查询服务
 *
 * Date: 2015年11月5日 <br>
 */
@Service
@Component
public class TenantInfoQuerySVImpl implements ITenantInfoQuerySV {
    
    @Override
    public String getPartnerId(TenantInfoParam param)  {
        if (param == null) {
            throw new BusinessException(ExceptCodeConstants.PARAM_IS_NULL, "获取参数失败:合作方信息查询请求参数不能为空");
        }
        
        if (StringUtil.isBlank(param.getTenantId())) {
            throw new BusinessException(ExceptCodeConstants.PARAM_IS_NULL, "获取参数失败:租户ID不能为空");
        }
        
        return TenantInfoUtil.getPartnerId(param.getTenantId());
    }

    @Override
    public String getTenantId(PartnerInfoParam param)  {
        if (param == null) {
            throw new BusinessException(ExceptCodeConstants.PARAM_IS_NULL, "获取参数失败:租户信息查询请求参数不能为空");
        }
        
        if (StringUtil.isBlank(param.getPartnerId())) {
            throw new BusinessException(ExceptCodeConstants.PARAM_IS_NULL, "获取参数失败:合作方编码不能为空");
        }
        
        return TenantInfoUtil.getTenantId(param.getPartnerId());
    }

}
