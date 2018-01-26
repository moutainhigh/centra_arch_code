package com.ai.slp.user.service.business.interfaces;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.BaseResponse;
import com.ai.slp.user.api.safari.param.DeleteSafariHisRequest;
import com.ai.slp.user.api.safari.param.DeleteSafariRequest;
import com.ai.slp.user.api.safari.param.InsertUserSafariRequest;
import com.ai.slp.user.api.safari.param.UserSafariInfoRequest;
import com.ai.slp.user.api.safari.param.UserSafariInfoResponse;

public interface IUserSafariBusiSV {
    BaseResponse insertUserSafari(InsertUserSafariRequest safariRequest)
            throws BusinessException, SystemException;

    public BaseResponse deleteUserSafari(DeleteSafariRequest deleteSafariRequest)
            throws BusinessException, SystemException;

    public UserSafariInfoResponse queryUserSafari(
            UserSafariInfoRequest userSafariInfoRequest) throws BusinessException, SystemException;

    public BaseResponse deleteUserSafariHis(DeleteSafariHisRequest deleteRequest)
            throws BusinessException, SystemException;

}
