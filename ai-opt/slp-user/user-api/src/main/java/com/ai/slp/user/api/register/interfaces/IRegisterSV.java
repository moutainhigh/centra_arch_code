package com.ai.slp.user.api.register.interfaces;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.BaseResponse;
import com.ai.slp.user.api.register.param.RegisterParamsRequest;
import com.ai.slp.user.api.register.param.RegisterResponse;
import com.ai.slp.user.api.register.param.UcBankKeyInfoParams;
import com.ai.slp.user.api.register.param.UcContactInfoParams;
import com.ai.slp.user.api.register.param.UcCustKeyInfoParams;
import com.ai.slp.user.api.register.param.UcGroupKeyInfoParams;
import com.ai.slp.user.api.register.param.UcUserFileExtParams;
import com.ai.slp.user.api.register.param.UcUserParams;

/**
 * 用户注册 <br>
 * Date: 2016年4月18日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * 
 * @author zhaogw
 */
@Path("/registerservice")
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
public interface IRegisterSV {
    
    /**
     * 注册用户账户 
     * @param registerParamsRequest
     * @return
     * @author zhangqiang7
     * @ApiCode UCUSER_100027
     * @RestRelativeURL registerservice/insertUcUser
     */
    @POST
    @Path("/insertUcUser")
    RegisterResponse insertUcUser( RegisterParamsRequest registerParamsRequest) 
            throws BusinessException, SystemException;
    
    /**
     * 更新用户信息
     * Date: 2016年4月20日 <br>
     * Copyright (c) 2016 asiainfo.com <br>
     * 
     * @author zhaogw
     * @ApiCode UCUSER_100028
     * @RestRelativeURL registerservice/updateUserInfo
     */
    //@POST
    //@Path("/updateUserInfo")
    //BaseResponse updateUserInfo(UpdateUserParams updateUserParams);
    
    /**
     * 查询单个用户信息</br> 
     *   
     * @param ucUser
     * @return
     * @author zhaogw
     * @ApiCode UCUSER_100029
     * @RestRelativeURL registerservice/searchUserInfo
     */
    @POST
    @Path("/searchUserInfo")
    BaseResponse searchUserInfo(UcUserParams ucUser)
            throws BusinessException, SystemException;
    
    /** 
     * 
     * 查询用户列表  </br> 
     * @param ucUser
     * @return
     * @author zhaogw
     * @ApiCode UCUSER_100030
     * @RestRelativeURL registerservice/searchUserIList
     */
    @POST
    @Path("/searchUserIList")
    BaseResponse searchUserIList(UcUserParams ucUser)
            throws BusinessException, SystemException;
   
    /**
     * 
     * 新增个人客户详细信息  </br> 
     * @param ucCust
     * @return
     * @author zhaogw
     * @ApiCode UCUSER_100031
     * @RestRelativeURL registerservice/insertUcCustInfo
     */
    @POST
    @Path("/insertUcCustInfo")
    BaseResponse insertUcCustInfo(UcCustKeyInfoParams ucCust)
            throws BusinessException, SystemException;
    /**
     * 
     *  查询用户详细信息</br> 
     * @param ucCust
     * @return
     * @author zhaogw
     * @ApiCode UCUSER_100032
     * @RestRelativeURL registerservice/searchUcCustInfo
     */
    @POST
    @Path("/searchUcCustInfo")
    BaseResponse searchUcCustInfo(UcCustKeyInfoParams ucCust)
            throws BusinessException, SystemException;
    
    /**
     * 
     * 更新用户详细信息  </br> 
     * @param ucCust
     * @return
     * @author zhaogw
     * @ApiCode UCUSER_100033
     * @RestRelativeURL registerservice/updateUcCustInfo
     */
    @POST
    @Path("/updateUcCustInfo")
    BaseResponse updateUcCustInfo(UcCustKeyInfoParams ucCust)
            throws BusinessException, SystemException;
    
    /**
     * 
     * 新增企业用户详细信息  </br> 
     * @param ucGroup
     * @return
     * @author zhaogw
     * @ApiCode UCUSER_100034
     * @RestRelativeURL registerservice/insertUcGroupInfo
     */
    @POST
    @Path("/insertUcGroupInfo")
    BaseResponse insertUcGroupInfo(UcGroupKeyInfoParams ucGroup)
            throws BusinessException, SystemException;
    
    /**
     * 
     * 查询企业详细信息  </br> 
     * @param ucGroup
     * @return
     * @author zhaogw
     * @ApiCode UCUSER_100035
     * @RestRelativeURL registerservice/searchUcGroupInfo
     */
    @POST
    @Path("/searchUcGroupInfo")
    BaseResponse searchUcGroupInfo(UcGroupKeyInfoParams ucGroup)
            throws BusinessException, SystemException;
    
    /**
     * 
     *  更新企业详细信息</br> 
     * @param ucGroup
     * @return
     * @author zhaogw
     * @ApiCode UCUSER_100036
     * @RestRelativeURL registerservice/updateUcGroupInfo
     */
    @POST
    @Path("/updateUcGroupInfo")
    BaseResponse updateUcGroupInfo(UcGroupKeyInfoParams ucGroup)
            throws BusinessException, SystemException;
    
    /**
     * 
     *   新增用户联系人信息</br> 
     * @param ucContact
     * @return
     * @author zhaogw
     * @ApiCode UCUSER_100037
     * @RestRelativeURL registerservice/insertUcContactInfo
     */
    @POST
    @Path("/insertUcContactInfo")
    BaseResponse insertUcContactInfo(UcContactInfoParams ucContact)
            throws BusinessException, SystemException;
    
    /**
     * 
     *  查询用户联系人信息 </br> 
     * @param ucContact
     * @return
     * @author zhaogw
     * @ApiDocMethod
     * @ApiCode UCUSER_100038
     * @RestRelativeURL registerservice/searchUcContactInfo
     */
    @POST
    @Path("/searchUcContactInfo")
    BaseResponse searchUcContactInfo(UcContactInfoParams ucContact)
            throws BusinessException, SystemException;
    
    /**
     * 
     *  修改用户联系人信息  </br> 
     * @param ucContact
     * @return
     * @author zhaogw
     * @ApiDocMethod
     * @ApiCode UCUSER_100039
     * @RestRelativeURL registerservice/updateUcContactInfo
     */
    @POST
    @Path("/updateUcContactInfo")
    BaseResponse updateUcContactInfo(UcContactInfoParams ucContact)
            throws BusinessException, SystemException;
    
    /**
     * 
     *   插入用户银行卡信息</br> 
     * @param ucBank
     * @return
     * @author zhaogw
     * @ApiDocMethod
     * @ApiCode UCUSER_100040
     * @RestRelativeURL registerservice/insertUcBankInfo
     */
    @POST
    @Path("/insertUcBankInfo")
    BaseResponse insertUcBankInfo(UcBankKeyInfoParams ucBank)
            throws BusinessException, SystemException;
    
    /**
     * 
     * 查询用户银行卡信息  </br> 
     * @param ucBank
     * @return
     * @author zhaogw
     * @ApiDocMethod
     * @ApiCode UCUSER_100041
     * @RestRelativeURL registerservice/searchUcBankInfo
     */
    @POST
    @Path("/searchUcBankInfo")
    BaseResponse searchUcBankInfo(UcBankKeyInfoParams ucBank)
            throws BusinessException, SystemException;
    /**
     * 
     *   修改用户银行卡信息</br> 
     * @param ucBank
     * @return
     * @author zhaogw
     * @ApiDocMethod
     * @ApiCode UCUSER_100042
     * @RestRelativeURL registerservice/updateUcBankInfo
     */
    @POST
    @Path("/updateUcBankInfo")
    BaseResponse updateUcBankInfo(UcBankKeyInfoParams ucBank)
            throws BusinessException, SystemException;
    
    /**
     * 
     *   新增用户扩展信息</br> 
     * @param ucUserFileExt
     * @return
     * @author zhaogw
     * @ApiDocMethod
     * @ApiCode UCUSER_100044
     * @RestRelativeURL registerservice/insertUcUserFileExtInfo
     */
    @POST
    @Path("/insertUcUserFileExtInfo")
    BaseResponse insertUcUserFileExtInfo(UcUserFileExtParams ucUserFileExt)
            throws BusinessException, SystemException;
    
    /**
     * 
     *  查询用户扩展信息</br> 
     * @param ucUserFileExt
     * @return
     * @author zhaogw
     * @ApiDocMethod
     * @ApiCode UCUSER_100045
     * @RestRelativeURL registerservice/searchUcUserFileExtInfo
     */
    @POST
    @Path("/searchUcUserFileExtInfo")
    BaseResponse searchUcUserFileExtInfo(UcUserFileExtParams ucUserFileExt)
            throws BusinessException, SystemException;
    
    /**
     * 
     * 更新用户扩展信息  </br> 
     * @param ucUserFileExt
     * @return
     * @author zhaogw
     * @ApiDocMethod
     * @ApiCode UCUSER_100046
     * @RestRelativeURL registerservice/updateUcUserFileExtInfo
     */
    @POST
    @Path("/updateUcUserFileExtInfo")
    BaseResponse updateUcUserFileExtInfo(UcUserFileExtParams ucUserFileExt)
            throws BusinessException, SystemException;
    
    
    
}
