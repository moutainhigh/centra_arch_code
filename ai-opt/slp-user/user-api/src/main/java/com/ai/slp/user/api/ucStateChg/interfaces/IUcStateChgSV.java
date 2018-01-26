package com.ai.slp.user.api.ucStateChg.interfaces;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.BaseResponse;
import com.ai.slp.user.api.ucStateChg.param.QueryStateChgRequest;
import com.ai.slp.user.api.ucStateChg.param.QueryStateChgResponse;
import com.ai.slp.user.api.ucStateChg.param.UcStateChgParamsRequest;

@Path("/ucStateChgservice")
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
public interface IUcStateChgSV {
    /**
     * 
     * 用户状态轨迹状态轨迹新增</br>
     * 
     * @param contactsGroup
     * @return
     * @author zhangyuehong
     * @ApiDocMethod
     * @RestRelativeURL ucStateChgservice/insertUcStateChgInfo
     */
    @POST
    @Path("/insertUcStateChgInfo")
    BaseResponse insertUcStateChgInfo(UcStateChgParamsRequest ucStateChgParam) throws BusinessException, SystemException;
   
    /**
     * 
     * 用户状态轨迹状态轨迹修改</br>
     * 
     * @param contactsGroup
     * @return
     * @author zhangyuehong
     * @ApiDocMethod
     * @RestRelativeURL ucStateChgservice/updateUcStateChgInfo
     */
    
    @POST
    @Path("/updateUcStateChgInfo")
    BaseResponse updateUcStateChgInfo(UcStateChgParamsRequest ucStateChgParam) throws BusinessException, SystemException;

    /**
     * 用户状态轨迹状态轨迹获取
     * 
     * @param stateChgRequest
     * @return
     * @throws BusinessException
     * @throws SystemException
     * @author zhangqiang7
     * @UCUSER
     * @RestRelativeURL ucStateChgservice/queryStateChg
     */
   
    @POST
    @Path("/queryStateChg")
    QueryStateChgResponse queryStateChg(QueryStateChgRequest stateChgRequest)
            throws BusinessException, SystemException;
}
