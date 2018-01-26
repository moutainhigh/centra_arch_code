package com.ai.slp.user.service.business.interfaces;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.BaseResponse;
import com.ai.slp.user.api.message.param.DeleteMessageRequest;
import com.ai.slp.user.api.message.param.InsertUserMessageRequest;
import com.ai.slp.user.api.message.param.QueryMessageRequest;
import com.ai.slp.user.api.message.param.QueryMessageResponse;
import com.ai.slp.user.api.message.param.UpdateMessageRequest;

public interface IUserMessageBusiSV {

    public BaseResponse insertUserMessage(
            InsertUserMessageRequest messageRequest)
                    throws BusinessException, SystemException;

    public BaseResponse updateUserMessage(UpdateMessageRequest request)
            throws BusinessException, SystemException;

    public QueryMessageResponse queryUserMessage(QueryMessageRequest queryRequest)
            throws BusinessException, SystemException;

    public BaseResponse deleteMessage(DeleteMessageRequest deleteRequest)
            throws BusinessException, SystemException;
}
