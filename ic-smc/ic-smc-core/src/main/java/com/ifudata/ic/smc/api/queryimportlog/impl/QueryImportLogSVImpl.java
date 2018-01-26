package com.ifudata.ic.smc.api.queryimportlog.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.ifudata.dvp.base.exception.BusinessException;
import com.ifudata.ic.smc.api.queryimportlog.interfaces.IQueryImportLogSV;
import com.ifudata.ic.smc.api.queryimportlog.param.QueryImportLogRequest;
import com.ifudata.ic.smc.api.queryimportlog.param.QueryImportLogResponse;
import com.ifudata.ic.smc.service.busi.interfaces.IQueryImportLogBusiSV;
import com.ifudata.ic.smc.util.BusinessUtil;
import com.alibaba.dubbo.config.annotation.Service;

@Service
public class QueryImportLogSVImpl implements IQueryImportLogSV {

    @Autowired
    private IQueryImportLogBusiSV iQueryImportLogBusiSV;

    @Override
    public QueryImportLogResponse queryImportLog(QueryImportLogRequest queryImportLogRequest)
            throws BusinessException {
        BusinessUtil.checkBaseInfo(queryImportLogRequest);
        return iQueryImportLogBusiSV.queryImportLog(queryImportLogRequest);
    }

}
