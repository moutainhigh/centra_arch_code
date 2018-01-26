package com.ai.slp.user.api.bankinfo.interfaces;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.BaseResponse;
import com.ai.slp.user.api.bankinfo.param.InsertBankInfoRequest;
import com.ai.slp.user.api.bankinfo.param.QueryBankInfoRequest;
import com.ai.slp.user.api.bankinfo.param.QueryBankInfoResponse;
import com.ai.slp.user.api.bankinfo.param.QueryBankInfoSingleRequest;
import com.ai.slp.user.api.bankinfo.param.QueryBankInfoSingleResponse;
import com.ai.slp.user.api.bankinfo.param.UpdateBankInfoRequest;

/**
 * 用户银行信息服务 Date: 2016年4月28日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * 
 * @author zhangqiang7
 */
@Path("/bankinfoservice")
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
public interface IUcBankInfoSV {

    /**
     * 创建用户银行信息
     * 
     * @param bankInfoRequest
     * @return
     * @throws BusinessException
     * @throws SystemException
     * @author zhangqiang7
     * @ApiCode UCUSER_004
     * @RestRelativeURL bankinfoservice/insertBankInfo
     */
    @POST
    @Path("/insertBankInfo")
    BaseResponse insertBankInfo(InsertBankInfoRequest bankInfoRequest)
            throws BusinessException, SystemException;

    /**
     * 更新用户银行信息
     * 
     * @param bankInfoRequest
     * @throws BusinessException
     * @throws SystemException
     * @author zhangqiang7
     * @ApiCode UCUSER_005
     * @RestRelativeURL bankinfoservice/updateBankInfo
     */
    @POST
    @Path("/updateBankInfo")
    BaseResponse updateBankInfo(UpdateBankInfoRequest bankInfoRequest)
            throws BusinessException, SystemException;

    /**
     * 查询用户银行信息
     * 
     * @param bankInfoRequest
     * @return
     * @throws BusinessException
     * @throws SystemException
     * @author zhangqiang7
     * @ApiCode UCUSER_006
     * @RestRelativeURL bankinfoservice/queryBankInfo
     */
    @POST
    @Path("/queryBankInfo")
    QueryBankInfoResponse queryBankInfo(QueryBankInfoRequest bankInfoRequest)
            throws BusinessException, SystemException;
    
    
    /**
     * 查询单个用户银行信息
     * 
     * @param bankInfoRequest
     * @return
     * @throws BusinessException
     * @throws SystemException
     * @author zhangqiang7
     * @ApiCode UCUSER_1000
     * @RestRelativeURL bankinfoservice/queryBankInfoSingle
     */ 
    @POST
    @Path("/queryBankInfoSingle")
    QueryBankInfoSingleResponse queryBankInfoSingle(QueryBankInfoSingleRequest bankInfoRequest)
            throws BusinessException, SystemException;
}
