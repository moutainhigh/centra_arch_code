package com.ai.slp.user.api.specialinfo.interfaces;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.BaseResponse;
import com.ai.slp.user.api.specialinfo.param.InsertSpecialInfoRequest;
import com.ai.slp.user.api.specialinfo.param.QuerySpecialInfoRequest;
import com.ai.slp.user.api.specialinfo.param.QuerySpecialInfoResponse;
import com.ai.slp.user.api.specialinfo.param.UpdateSepcialInfoRequest;

/**
 * 用户个性化信息服务 Date: 2016年4月28日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * 
 * @author zhangqiang7
 */
@Path("/ucSpecialInfoservice")
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
public interface IUcSpecialInfoSV {

    /**
     * 创建用户个性化信息
     * 
     * @param specialInfoRequest
     * @return
     * @throws BusinessException
     * @throws SystemException
     * @author zhangqiang7
     * @UCUSER
     * @RestRelativeURL ucSpecialInfoservice/insertSpecialInfo
     */
    @POST
    @Path("/insertSpecialInfo")
    BaseResponse insertSpecialInfo(InsertSpecialInfoRequest specialInfoRequest)
            throws BusinessException, SystemException;

    /**
     * 更新用户个性化信息
     * 
     * @param spInfoRequest
     * @throws BusinessException
     * @throws SystemException
     * @author zhangqiang7
     * @UCUSER
     * @RestRelativeURL ucSpecialInfoservice/updateSpecialInfo
     */
    @POST
    @Path("/updateSpecialInfo")
    BaseResponse updateSpecialInfo(UpdateSepcialInfoRequest specialInfoRequest)
            throws BusinessException, SystemException;


    /**
     * 获取用户个性化信息
     * 
     * @param specialInfoRequest
     * @return
     * @throws BusinessException
     * @throws SystemException
     * @author zhangqiang7
     * @UCUSER
     * @RestRelativeURL ucSpecialInfoservice/querySpecialInfo
     */
    @POST
    @Path("/querySpecialInfo")
    QuerySpecialInfoResponse querySpecialInfo(QuerySpecialInfoRequest specialInfoRequest)
            throws BusinessException, SystemException;
}
