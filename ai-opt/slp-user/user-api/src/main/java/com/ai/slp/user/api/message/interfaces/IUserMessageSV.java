package com.ai.slp.user.api.message.interfaces;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.BaseResponse;
import com.ai.slp.user.api.message.param.DeleteMessageRequest;
import com.ai.slp.user.api.message.param.InsertUserMessageRequest;
import com.ai.slp.user.api.message.param.QueryMessageRequest;
import com.ai.slp.user.api.message.param.QueryMessageResponse;
import com.ai.slp.user.api.message.param.UpdateMessageRequest;

/**
 * 用户消息服务 Date: 2016年4月20日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * 
 * @author zhangqiang7
 */
@Path("/messageservice")
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
public interface IUserMessageSV {
    
    /**
     * 用户消息新增
     * 
     * @param createUserMessageRequest
     * @return
     * @throws BusinessException
     * @throws SystemException
     * @author zhangqiang7
     * @ApiCode UCUSER_100023
     * @RestRelativeURL messageservice/insertUserMessage
     */
    @POST
    @Path("/insertUserMessage")
    BaseResponse insertUserMessage(InsertUserMessageRequest messageRequest)
            throws BusinessException, SystemException;

    /**
     * 页面删除即更新消息状态
     * 
     * @param ucUserMessageParams
     * @return
     * @throws BusinessException
     * @throws SystemException
     * @author zhangqiang7
     * @ApiCode UCUSER_100024
     * @RestRelativeURL messageservice/updateUserMessage
     */
    @POST
    @Path("/updateUserMessage")
    BaseResponse updateUserMessage(UpdateMessageRequest updateRequest)
            throws BusinessException, SystemException;

    /**
     * 查询消息
     * 
     * @param deleteRequest
     * @throws BusinessException
     * @throws SystemException
     * @author zhangqiang7
     * @ApiCode UCUSER_100025
     * @RestRelativeURL messageservice/queryUserMessage
     */
    @POST
    @Path("/queryUserMessage")
    QueryMessageResponse queryUserMessage(QueryMessageRequest queryRequest)
            throws BusinessException, SystemException;

    /**
     * 后台删除消息
     * 
     * @param deleteRequest
     * @throws BusinessException
     * @throws SystemException
     * @author zhangqiang7
     * @ApiCode UCUSER_100026
     * @RestRelativeURL messageservice/deleteMessage
     */
    @POST
    @Path("/deleteMessage")
    BaseResponse deleteMessage(DeleteMessageRequest deleteRequest)
            throws BusinessException, SystemException;
}
