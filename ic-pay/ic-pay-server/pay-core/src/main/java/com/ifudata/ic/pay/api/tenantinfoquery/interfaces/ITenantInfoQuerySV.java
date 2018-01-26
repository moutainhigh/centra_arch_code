package com.ifudata.ic.pay.api.tenantinfoquery.interfaces;

import com.ifudata.ic.pay.api.tenantinfoquery.param.PartnerInfoParam;
import com.ifudata.ic.pay.api.tenantinfoquery.param.TenantInfoParam;


/**
 * 合作方信息查询服务
 *
 * Date: 2015年11月5日 <br>
 */
public interface ITenantInfoQuerySV {

    /**
     * 获取分配的合作方编码
     * @param param 租户ID
     * @return 合作方编码
     * @ApiDocMethod
     * @ApiCode PAY_0007
     */
    String getPartnerId(TenantInfoParam param) ;
    
    /**
     * 通过合作方编码查询对应的租户信息
     * @param partnerId 合作方编码
     * @return 租户ID
     * @ApiDocMethod
     * @ApiCode PAY_0008
     */
    String getTenantId(PartnerInfoParam param) ;
    
}
