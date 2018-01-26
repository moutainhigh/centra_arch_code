package com.ai.slp.user.service.business.interfaces;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.BaseResponse;
import com.ai.slp.user.api.specialinfo.param.InsertSpecialInfoRequest;
import com.ai.slp.user.api.specialinfo.param.QuerySpecialInfoRequest;
import com.ai.slp.user.api.specialinfo.param.QuerySpecialInfoResponse;
import com.ai.slp.user.api.specialinfo.param.UpdateSepcialInfoRequest;

public interface IUcSpecialInfoBusiSV {
    public BaseResponse insertSpecialInfo(InsertSpecialInfoRequest specialInfoRequest)
            throws BusinessException, SystemException;

    public BaseResponse updateSpecialInfo(UpdateSepcialInfoRequest specialInfoRequest)
            throws BusinessException, SystemException;

    public QuerySpecialInfoResponse querySpecialInfo(QuerySpecialInfoRequest specialInfoRequest)
            throws BusinessException, SystemException;
}
