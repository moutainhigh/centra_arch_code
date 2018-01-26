package com.ifudata.ic.smc.service.busi.interfaces;

import com.ifudata.dvp.base.exception.BusinessException;
import com.ifudata.ic.smc.api.querybillstyle.param.QueryBillStyle;
import com.ifudata.ic.smc.api.querybillstyle.param.QueryBillStyleInfo;
import com.ifudata.ic.smc.api.querybillstyle.param.QueryBillStyleListInfo;
import com.ifudata.ic.smc.api.querybillstyle.param.QueryBillStyleListVoResponse;

public interface IQueryBillStyleBusiSV {

    /**
     * 查询账单样式<br>
     * 
     * @param queryBillStyle
     * @return
     * @author wangjl9
     * @ApiDocMethod
     */
    QueryBillStyleInfo queryBillStyle(QueryBillStyle queryBillStyle) throws BusinessException;

    /**
     * 查询账单样式列表<br>
     * 
     * @param queryBillStyleListInfo
     * @return
     * @author wangjl9
     * @ApiDocMethod
     */
    QueryBillStyleListVoResponse queryBillStyleList(QueryBillStyleListInfo queryBillStyleListInfo)
            throws BusinessException;
}
