package com.ai.slp.user.api.safari.interfaces;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.BaseResponse;
import com.ai.slp.user.api.safari.param.DeleteSafariHisRequest;
import com.ai.slp.user.api.safari.param.DeleteSafariRequest;
import com.ai.slp.user.api.safari.param.InsertUserSafariRequest;
import com.ai.slp.user.api.safari.param.UserSafariInfoRequest;
import com.ai.slp.user.api.safari.param.UserSafariInfoResponse;

/**
 * 用户查看商品足迹服务<br>
 * Date: 2016年4月20日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * 
 * @author zhangqiang7
 */
@Path("/safariservice")
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
public interface IUserSafariSV {

    /**
     * 用户浏览商品信息创建
     * 
     * @param createUserSafariRequest
     * @return
     * @throws BusinessException
     * @throws SystemException
     * @author zhangqiang7
     * @ApiCode UCUSER_100047
     * @RestRelativeURL safariservice/insertUserSafari
     */
    @POST
    @Path("/insertUserSafari")
    BaseResponse insertUserSafari(InsertUserSafariRequest safariRequest)
            throws BusinessException, SystemException;
 
    /**
     * 用户浏览商品信息前端删除
     * 
     * @param ucUserSafariParams
     * @throws BusinessException
     * @throws SystemException
     * @author zhangqiang7
     * @ApiCode UCUSER_100048
     * @RestRelativeURL safariservice/deleteUserSafari
     */
    @POST
    @Path("/deleteUserSafari")
    BaseResponse deleteUserSafari(DeleteSafariRequest deletSafariRequest)
            throws BusinessException, SystemException;

    /**
     * 用户浏览商品信息后台删除
     * 
     * @param deleteRequest
     * @throws BusinessException
     * @throws SystemException
     * @author zhangqiang7
     * @ApiCode UCUSER_100049
     * @RestRelativeURL safariservice/deleteSafariBack
     */
    @POST
    @Path("/deleteSafariBack")
    BaseResponse deleteSafariBack(DeleteSafariRequest deleteRequest)
            throws BusinessException, SystemException;

    /**
     * 删除浏览商品足迹历史表
     * 
     * @param deleteReuqest
     * @throws BusinessException
     * @throws SystemException
     * @author zhangqiang7
     * @ApiCode UCUSER_100050
     * @RestRelativeURL safariservice/deleteUserSafariHis
     */
    @POST
    @Path("/deleteUserSafariHis")
    BaseResponse deleteUserSafariHis(DeleteSafariHisRequest deleteReuqest)
            throws BusinessException, SystemException;

    /**
     * 用户浏览商品信息查询
     * 
     * @param userSafariInfoRequest
     * @return
     * @throws BusinessException
     * @throws SystemException
     * @author zhangqiang7
     * @ApiCode UCUSER_100051
     * @RestRelativeURL safariservice/queryUserSafari
     */
    @POST
    @Path("/queryUserSafari")
    UserSafariInfoResponse queryUserSafari(UserSafariInfoRequest userSafariInfoRequest)
            throws BusinessException, SystemException;
}