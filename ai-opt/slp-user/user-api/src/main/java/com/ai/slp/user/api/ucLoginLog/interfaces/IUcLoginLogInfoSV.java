package com.ai.slp.user.api.ucLoginLog.interfaces;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.BaseResponse;
import com.ai.slp.user.api.ucLoginLog.param.UcLoginLogParamsRequest;
import com.ai.slp.user.api.ucLoginLog.param.UcLoginLogQueryResponse;

@Path("/ucLoginLogInfoservice")
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
public interface IUcLoginLogInfoSV {
   
    /**
     * 
     * 新增登录日志   </br>
     * @param contactsGroup
     * @return
     * @author zhangyuehong
     * @ApiDocMethod
     * @RestRelativeURL ucLoginLogInfoservice/insertUserLoginLog
     */
    @POST
    @Path("/insertUserLoginLog")
    BaseResponse insertUserLoginLog(UcLoginLogParamsRequest userLoginParam) throws BusinessException, SystemException;
    /**
     * 登录日志查询
     * @param ucLoginLogParam
     * @param limitStart
     * @param limitEnd
     * @return
     * @throws BusinessException
     * @throws SystemException
     * @author zhangyh7
     * @ApiDocMethod
     * @RestRelativeURL ucLoginLogInfoservice/getUcLoginLogInfo
     */
    @POST
    @Path("/getUcLoginLogInfo")
    public UcLoginLogQueryResponse getUcLoginLogInfo(UcLoginLogParamsRequest ucLoginLogParam) throws BusinessException, SystemException;
}
