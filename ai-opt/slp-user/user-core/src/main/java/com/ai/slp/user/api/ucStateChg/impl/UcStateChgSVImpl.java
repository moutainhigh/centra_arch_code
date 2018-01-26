package com.ai.slp.user.api.ucStateChg.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.BaseResponse;
import com.ai.slp.user.api.ucStateChg.interfaces.IUcStateChgSV;
import com.ai.slp.user.api.ucStateChg.param.QueryStateChgRequest;
import com.ai.slp.user.api.ucStateChg.param.QueryStateChgResponse;
import com.ai.slp.user.api.ucStateChg.param.UcStateChgParamsRequest;
import com.ai.slp.user.service.business.interfaces.IUcStateChgBusiSV;
import com.alibaba.dubbo.config.annotation.Service;

@Component
@Service
public class UcStateChgSVImpl implements IUcStateChgSV {

    @Autowired
    IUcStateChgBusiSV ucStateChgBusiSv;

    @Override
    public BaseResponse insertUcStateChgInfo(UcStateChgParamsRequest ucStateChgParam) {

        return ucStateChgBusiSv.insertUcStateChgBusiInfo(ucStateChgParam);
    }

    @Override
    public BaseResponse updateUcStateChgInfo(UcStateChgParamsRequest ucStateChgParam) {
        return ucStateChgBusiSv.updateUcStateChgBusiInfo(ucStateChgParam);
    }

    @Override
    public QueryStateChgResponse queryStateChg(QueryStateChgRequest stateChgRequest)
            throws BusinessException, SystemException {
        return ucStateChgBusiSv.queryStateChg(stateChgRequest);
    }

}
