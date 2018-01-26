package com.ai.slp.user.api.ucUserSecurity.interfaces;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.BaseResponse;
import com.ai.slp.user.api.ucUserSecurity.param.UcUserEmailRequest;
import com.ai.slp.user.api.ucUserSecurity.param.UcUserPasswordRequest;
import com.ai.slp.user.api.ucUserSecurity.param.UcUserPhoneRequest;
import com.ai.slp.user.api.ucUserSecurity.param.UpdatePasswordRequest;

@Path("userSecurityManageService")
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
public interface IUcUserSecurityManageSV {

    /**
     * 设置邮箱
     * 
     * @param emailModifyRequest
     * @return
     * @throws BusinessException
     * @throws SystemException
     * @author jiaxs
     * @ApiDocMethod
     * @ApiCode UAC_0007
     * @RestRelativeURL ucStateChgservice/setEmailData
     */
    @POST
    @Path("/setEmailData")
    BaseResponse setEmailData(UcUserEmailRequest emailModifyRequest)
            throws BusinessException, SystemException;

    /**
     * 设置密码
     * 
     * @param emailModifyRequest
     * @return
     * @throws BusinessException
     * @throws SystemException
     * @author jiaxs
     * @ApiDocMethod
     * @ApiCode UAC_0008
     * @RestRelativeURL ucStateChgservice/setPasswordData
     */
    @POST
    @Path("/setPasswordData")
    BaseResponse setPasswordData(UcUserPasswordRequest passwordModifyRequest)
            throws BusinessException, SystemException;

    /**
     * 根据账户信息更新密码
     * 
     * @param updatePasswordRequest
     * @return
     * @throws BusinessException
     * @throws SystemException
     * @author zhangqiang7
     * @ApiCode UAC_0011
     * @RestRelativeURL ucStateChgservice/updatePassword
     */
    @POST
    @Path("/updatePassword")
    BaseResponse updatePassword(UpdatePasswordRequest updatePasswordRequest)
            throws BusinessException, SystemException;

    /**
     * 设置手机号
     * 
     * @param phoneModifyRequest
     * @return
     * @throws BusinessException
     * @throws SystemException
     * @author jiaxs
     * @ApiDocMethod
     * @ApiCode UAC_0009
     * @RestRelativeURL ucStateChgservice/setPhoneData
     */
    @POST
    @Path("/setPhoneData")
    BaseResponse setPhoneData(UcUserPhoneRequest phoneModifyRequest)
            throws BusinessException, SystemException;
}
