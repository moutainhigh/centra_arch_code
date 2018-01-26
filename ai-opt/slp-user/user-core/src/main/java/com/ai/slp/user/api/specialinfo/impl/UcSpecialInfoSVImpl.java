package com.ai.slp.user.api.specialinfo.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.BaseResponse;
import com.ai.slp.user.api.specialinfo.interfaces.IUcSpecialInfoSV;
import com.ai.slp.user.api.specialinfo.param.InsertSpecialInfoRequest;
import com.ai.slp.user.api.specialinfo.param.QuerySpecialInfoRequest;
import com.ai.slp.user.api.specialinfo.param.QuerySpecialInfoResponse;
import com.ai.slp.user.api.specialinfo.param.UpdateSepcialInfoRequest;
import com.ai.slp.user.service.business.interfaces.IUcSpecialInfoBusiSV;
import com.alibaba.dubbo.config.annotation.Service;

@Service
@Component
public class UcSpecialInfoSVImpl implements IUcSpecialInfoSV {

    @Autowired
    private IUcSpecialInfoBusiSV ucSpecialInfoBusiSV;

    @Override
    public BaseResponse insertSpecialInfo(InsertSpecialInfoRequest specialInfoRequest)
            throws BusinessException, SystemException {
        return ucSpecialInfoBusiSV.insertSpecialInfo(specialInfoRequest);
    }

    @Override
    public BaseResponse updateSpecialInfo(UpdateSepcialInfoRequest specialInfoRequest)
            throws BusinessException, SystemException {
        return ucSpecialInfoBusiSV.updateSpecialInfo(specialInfoRequest);
    }

    @Override
    public QuerySpecialInfoResponse querySpecialInfo(QuerySpecialInfoRequest specialInfoRequest)
            throws BusinessException, SystemException {
        return ucSpecialInfoBusiSV.querySpecialInfo(specialInfoRequest);
    }

}
