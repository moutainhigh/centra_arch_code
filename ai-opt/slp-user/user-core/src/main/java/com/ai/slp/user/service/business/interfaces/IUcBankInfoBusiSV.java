package com.ai.slp.user.service.business.interfaces;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.slp.user.api.bankinfo.param.InsertBankInfoRequest;
import com.ai.slp.user.api.bankinfo.param.QueryBankInfoRequest;
import com.ai.slp.user.api.bankinfo.param.QueryBankInfoResponse;
import com.ai.slp.user.api.bankinfo.param.QueryBankInfoSingleRequest;
import com.ai.slp.user.api.bankinfo.param.QueryBankInfoSingleResponse;
import com.ai.slp.user.api.bankinfo.param.UpdateBankInfoRequest;

public interface IUcBankInfoBusiSV {

    int insertBankInfo(InsertBankInfoRequest bankInfoRequest)
            throws BusinessException, SystemException;

    int UpdateBankInfo(UpdateBankInfoRequest bankInfoRequest)
            throws BusinessException, SystemException;

    QueryBankInfoResponse queryBankInfo(QueryBankInfoRequest bankInfoRequest)
            throws BusinessException, SystemException;
    
    QueryBankInfoSingleResponse queryBankInfoSingle(QueryBankInfoSingleRequest bankInfoRequest)
            throws BusinessException, SystemException;
}
