package com.ifudata.ic.smc.api.querybillstyle.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.ifudata.dvp.base.exception.BusinessException;
import com.ifudata.ic.smc.api.querybillstyle.interfaces.IQueryBillStyleSV;
import com.ifudata.ic.smc.api.querybillstyle.param.QueryBillStyle;
import com.ifudata.ic.smc.api.querybillstyle.param.QueryBillStyleInfo;
import com.ifudata.ic.smc.api.querybillstyle.param.QueryBillStyleListInfo;
import com.ifudata.ic.smc.api.querybillstyle.param.QueryBillStyleListVoResponse;
import com.ifudata.ic.smc.constants.SmcExceptCodeConstant;
import com.ifudata.ic.smc.service.busi.interfaces.IQueryBillStyleBusiSV;
import com.ifudata.ic.smc.util.BusinessUtil;
import com.alibaba.dubbo.config.annotation.Service;

@Service
public class QueryBillStyleSVImpl implements IQueryBillStyleSV {

    @Autowired
    private IQueryBillStyleBusiSV iQueryBillStyleBusiSV;

    @Override
    public QueryBillStyleInfo queryBillStyle(QueryBillStyle queryBillStyle)
            throws BusinessException {
        // TODO Auto-generated method stub
        BusinessUtil.checkBaseInfo(queryBillStyle);
        if ((queryBillStyle.getBillStyleId() == null) || (queryBillStyle.getBillStyleId() == 0)) {
            throw new BusinessException(SmcExceptCodeConstant.PARAM_IS_NULL, "账单样式ID不可为空");
        }
        return iQueryBillStyleBusiSV.queryBillStyle(queryBillStyle);
    }

    @Override
    public QueryBillStyleListVoResponse queryBillStyleList(
            QueryBillStyleListInfo queryBillStyleListInfo) throws BusinessException {
        // TODO Auto-generated method stub
        BusinessUtil.checkBaseInfo(queryBillStyleListInfo);
        return iQueryBillStyleBusiSV.queryBillStyleList(queryBillStyleListInfo);
    }

}
