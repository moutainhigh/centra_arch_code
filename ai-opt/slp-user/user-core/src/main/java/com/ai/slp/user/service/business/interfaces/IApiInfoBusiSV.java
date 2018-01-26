package com.ai.slp.user.service.business.interfaces;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.BaseResponse;
import com.ai.slp.user.api.apiinfo.param.ApiInfoRequest;
import com.ai.slp.user.api.apiinfo.param.ApiInfoResponse;
import com.ai.slp.user.api.apiinfo.param.InsertApiInfoRequest;
import com.ai.slp.user.api.apiinfo.param.UcApiInfoParams;

public interface IApiInfoBusiSV {

    BaseResponse insertApiInfo(InsertApiInfoRequest infoRequest)
            throws BusinessException, SystemException;

    BaseResponse updateApiInfo(UcApiInfoParams ucApiInfoParams)
            throws BusinessException, SystemException;

    ApiInfoResponse queryApiInfo(ApiInfoRequest apiInfoRequest)
            throws BusinessException, SystemException;
}
