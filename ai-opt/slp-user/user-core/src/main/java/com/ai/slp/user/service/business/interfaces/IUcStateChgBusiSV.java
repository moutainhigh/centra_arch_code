package com.ai.slp.user.service.business.interfaces;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.BaseResponse;
import com.ai.slp.user.api.ucStateChg.param.QueryStateChgRequest;
import com.ai.slp.user.api.ucStateChg.param.QueryStateChgResponse;
import com.ai.slp.user.api.ucStateChg.param.UcStateChgParamsRequest;

public interface IUcStateChgBusiSV {

    public BaseResponse insertUcStateChgBusiInfo(UcStateChgParamsRequest ucStateChgParam);

    public BaseResponse updateUcStateChgBusiInfo(UcStateChgParamsRequest ucStateChgParam);

    public QueryStateChgResponse queryStateChg(QueryStateChgRequest stateChgRequest)
            throws BusinessException, SystemException;
}
