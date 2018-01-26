package com.ai.slp.user.api.contactsinfo.interfaces;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.BaseResponse;
import com.ai.slp.user.api.contactsinfo.param.InsertContactsInfoRequest;
import com.ai.slp.user.api.contactsinfo.param.QueryContactsInfoRequest;
import com.ai.slp.user.api.contactsinfo.param.QueryContactsInfoResponse;
import com.ai.slp.user.api.contactsinfo.param.QueryContactsInfoSingleRequest;
import com.ai.slp.user.api.contactsinfo.param.QueryContactsInfoSingleResponse;
import com.ai.slp.user.api.contactsinfo.param.UpdateContactsInfoRequest;

/**
 * 用户联系人服务 Date: 2016年4月29日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * 
 * @author zhangqiang7
 */
@Path("/contactsinfoservice")
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
public interface IUcContactsInfoSV {

    /**
     * 创建用户联系人
     * 
     * @param contactsInfoRequest
     * @return
     * @throws BusinessException
     * @throws SystemException
     * @author zhangqiang7
     * @ApiCode UCUSER_007
     * @RestRelativeURL contactsinfoservice/insertContactsInfo
     */
    @POST
    @Path("/insertContactsInfo")
    BaseResponse insertContactsInfo(InsertContactsInfoRequest contactsInfoRequest)
            throws BusinessException, SystemException;

    /**
     * 更新用户联系人
     * 
     * @param contactsInfoRequest
     * @return
     * @throws BusinessException
     * @throws SystemException
     * @author zhangqiang7
     * @ApiCode UCUSER_008
     * @RestRelativeURL contactsinfoservice/updateContactsInfo
     */
    @POST
    @Path("/updateContactsInfo")
    BaseResponse updateContactsInfo(UpdateContactsInfoRequest contactsInfoRequest)
            throws BusinessException, SystemException;

    /**
     * 获取用户联系人
     * 
     * @param contactsInfoRequest
     * @return
     * @throws BusinessException
     * @throws SystemException
     * @author zhangqiang7
     * @ApiCode UCUSER_008
     * @RestRelativeURL contactsinfoservice/updateContactsInfo
     */
    @POST
    @Path("/updateContactsInfo")
    QueryContactsInfoResponse queryContactsInfo(QueryContactsInfoRequest contactsInfoRequest)
            throws BusinessException, SystemException;
    
    /**
     * 获取单个用户联系人
     * 
     * @param contactsInfoRequest
     * @return
     * @throws BusinessException
     * @throws SystemException
     * @author zhangqiang7
     * @ApiCode UCUSER_009
     * @RestRelativeURL contactsinfoservice/queryContactsInfoSingle
     */
    @POST
    @Path("/queryContactsInfoSingle")
    QueryContactsInfoSingleResponse queryContactsInfoSingle(QueryContactsInfoSingleRequest contactsInfoRequest)
            throws BusinessException, SystemException;

}
