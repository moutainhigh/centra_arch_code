package com.ai.slp.user.service.business.interfaces;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.slp.user.api.keyinfo.param.InsertCustKeyInfoRequest;
import com.ai.slp.user.api.keyinfo.param.SearchCustKeyInfoRequest;
import com.ai.slp.user.api.keyinfo.param.SearchCustKeyInfoResponse;
import com.ai.slp.user.api.keyinfo.param.UpdateCustKeyInfoRequest;

public interface IUcCustKeyInfoBusiSV {

    public int insertCustKeyInfo(InsertCustKeyInfoRequest request)
            throws SystemException, BusinessException ;
     
    public int updateCustKeyInfo(UpdateCustKeyInfoRequest request)
            throws SystemException, BusinessException;

    public SearchCustKeyInfoResponse searchCustKeyInfo(SearchCustKeyInfoRequest request)
            throws SystemException, BusinessException;
}
