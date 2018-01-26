package com.ifudata.ic.smc.service.busi.interfaces;

import com.ifudata.dvp.base.exception.BusinessException;
import com.ifudata.ic.smc.api.billdata.param.QueryBillDataDetailRequest;
import com.ifudata.ic.smc.api.billdata.param.QueryBillDataRequest;
import com.ifudata.ic.smc.api.billdata.param.QueryBillDataResponse;
import com.ifudata.ic.smc.api.billdata.param.QueryBillDetailResponse;

public interface IBillDataBusiSV {
    /**
     * 账单信息查询<br>
     * 
     * @param queryBillDataRequest
     * @return
     * @author wangjl9
     * @ApiDocMethod
     */
    QueryBillDataResponse queryBillData(QueryBillDataRequest queryBillDataRequest)
            throws BusinessException;

    /**
     * 账单信息查询<br>
     * 
     * @param queryBillDataDetailRequest
     * @return
     * @author wangjl9
     * @ApiDocMethod
     */
    QueryBillDetailResponse queryBillDataDetail(
            QueryBillDataDetailRequest queryBillDataDetailRequest) throws BusinessException;
}
