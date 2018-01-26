package com.ai.slp.user.api.apiinfo.interfaces;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.BaseResponse;
import com.ai.slp.user.api.apiinfo.param.ApiInfoRequest;
import com.ai.slp.user.api.apiinfo.param.ApiInfoResponse;
import com.ai.slp.user.api.apiinfo.param.InsertApiInfoRequest;
import com.ai.slp.user.api.apiinfo.param.UcApiInfoParams;

/**
 * 企业、代理商申请API服务 <br>
 * Date: 2016年4月20日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * 
 * @author zhangqiang7
 */
@Path("/apiservice")
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
public interface IApiInfoSV {

    /**
     * 企业、代理商申请API信息创建
     * 
     * @param saveApiInfoRequest
     * @return
     * @throws BusinessException
     * @throws SystemException
     * @author zhangqiang7
     * @ApiCode UCUSER_001
     * @RestRelativeURL apiservice/insertApiInfo
     */
    @POST
    @Path("/insertApiInfo")
    BaseResponse insertApiInfo(InsertApiInfoRequest infoRequest)
            throws BusinessException, SystemException;

    /**
     * 企业、代理商申请API信息更新
     * 
     * @param ucApiInfoParams
     * @return
     * @throws BusinessException
     * @throws SystemException
     * @author zhangqiang7
     * @ApiCode UCUSER_002
     * @RestRelativeURL apiservice/updateApiInfo
     */
    @POST
    @Path("/updateApiInfo")
    BaseResponse updateApiInfo(UcApiInfoParams ucApiInfoParams)
            throws BusinessException, SystemException;

    /**
     * 企业、代理商申请API信息查询
     * 
     * @param apiInfoRequest
     * @return
     * @throws BusinessException
     * @throws SystemException
     * @author zhangqiang7
     * @ApiCode UCUSER_003
     @RestRelativeURL apiservice/queryApiInfo
     */
    @POST
    @Path("/queryApiInfo")
    ApiInfoResponse queryApiInfo(ApiInfoRequest apiInfoRequest)
            throws BusinessException, SystemException;
}
