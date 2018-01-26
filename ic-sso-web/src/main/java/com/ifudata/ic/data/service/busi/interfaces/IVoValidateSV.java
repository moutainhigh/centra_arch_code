package com.ifudata.ic.data.service.busi.interfaces;

import com.ifudata.centra.base.exception.BusinessException;
import com.ifudata.ic.data.api.user.param.UserQueryRequest;

public interface IVoValidateSV {

    /**
     * 登录参数检查
     */
    void validateLogin(String username) throws BusinessException;


    /**
     * 账户详情查询参数检查
     */
    void validateQueryAccountBaseInfo(UserQueryRequest accountQueryRequest)
            throws BusinessException;

}
