package com.ai.slp.user.service.business.interfaces;

import com.ai.opt.base.vo.BaseResponse;
import com.ai.slp.user.api.ucLoginLog.param.UcLoginLogParamsRequest;
import com.ai.slp.user.api.ucLoginLog.param.UcLoginLogQueryResponse;

public interface IUcLoginLogBusiSV {
    public BaseResponse insertUcLoginLogInfo(UcLoginLogParamsRequest ucLoginLogParam);
    public UcLoginLogQueryResponse getUcLoginLogInfo(UcLoginLogParamsRequest ucLoginLogParam);
}
