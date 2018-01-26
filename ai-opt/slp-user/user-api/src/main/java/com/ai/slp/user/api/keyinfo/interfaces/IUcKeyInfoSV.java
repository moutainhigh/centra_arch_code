package com.ai.slp.user.api.keyinfo.interfaces;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.BaseResponse;
import com.ai.opt.base.vo.PageInfoResponse;
import com.ai.slp.user.api.keyinfo.param.InsertCustFileExtRequest;
import com.ai.slp.user.api.keyinfo.param.InsertCustKeyInfoRequest;
import com.ai.slp.user.api.keyinfo.param.InsertGroupKeyInfoRequest;
import com.ai.slp.user.api.keyinfo.param.QueryCustFileExtRequest;
import com.ai.slp.user.api.keyinfo.param.QueryCustFileExtResponse;
import com.ai.slp.user.api.keyinfo.param.QueryGroupInfoRequest;
import com.ai.slp.user.api.keyinfo.param.SearchCustKeyInfoRequest;
import com.ai.slp.user.api.keyinfo.param.SearchCustKeyInfoResponse;
import com.ai.slp.user.api.keyinfo.param.SearchGroupKeyInfoRequest;
import com.ai.slp.user.api.keyinfo.param.SearchGroupKeyInfoResponse;
import com.ai.slp.user.api.keyinfo.param.SearchGroupUserInfoResponse;
import com.ai.slp.user.api.keyinfo.param.UcGroupKeyInfoVo;
import com.ai.slp.user.api.keyinfo.param.UpdateCustFileExtRequest;
import com.ai.slp.user.api.keyinfo.param.UpdateCustKeyInfoRequest;
import com.ai.slp.user.api.keyinfo.param.UpdateGroupKeyInfoRequest;

@Path("/custkeyinfoservice")
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
public interface IUcKeyInfoSV {

    /**
     * 保存个人关键信息
     * 
     * @param request
     * @return
     * @throws SystemException
     * @throws BusinessException
     * @author zhangqiang7
     * @ApiCode USER_100013
     * @RestRelativeURL custkeyinfoservice/insertCustKeyInfo
     */
    @POST
    @Path("/insertCustKeyInfo")
    public BaseResponse insertCustKeyInfo(InsertCustKeyInfoRequest request)
            throws SystemException, BusinessException;

    /**
     * 更新个人关键信息
     * 
     * @param request
     * @return
     * @throws SystemException
     * @throws BusinessException
     * @author zhangqiang7
     * @ApiCode USER_100014
     * @RestRelativeURL custkeyinfoservice/updateCustKeyInfo
     */
    @POST
    @Path("/updateCustKeyInfo")
    public BaseResponse updateCustKeyInfo(UpdateCustKeyInfoRequest request)
            throws SystemException, BusinessException;

    /**
     * 更新个人关键信息
     * 
     * @param request
     * @return
     * @throws SystemException
     * @throws BusinessException
     * @author zhangqiang7
     * @ApiCode USER_100015
     * @RestRelativeURL custkeyinfoservice/searchCustKeyInfo
     */
    @POST
    @Path("/searchCustKeyInfo")
    public SearchCustKeyInfoResponse searchCustKeyInfo(SearchCustKeyInfoRequest request)
            throws SystemException, BusinessException;

    /**
     * 保存企业关键信息
     * 
     * @param request
     * @return
     * @throws SystemException
     * @throws BusinessException
     * @author zhangqiang7
     * @ApiCode USER_1000016
     * @RestRelativeURL custkeyinfoservice/insertGroupKeyInfo
     */
    @POST
    @Path("/insertGroupKeyInfo")
    public BaseResponse insertGroupKeyInfo(InsertGroupKeyInfoRequest request)
            throws SystemException, BusinessException;

    /**
     * 更新企业关键信息
     * 
     * @param request
     * @return
     * @throws SystemException
     * @throws BusinessException
     * @author zhangqiang7
     * @ApiCode USER_1000017
     * @RestRelativeURL custkeyinfoservice/updateGroupKeyInfo
     */
    @POST
    @Path("/updateGroupKeyInfo")
    public BaseResponse updateGroupKeyInfo(UpdateGroupKeyInfoRequest request)
            throws SystemException, BusinessException;

    /**
     * 查询企业关键信息
     * 
     * @param request
     * @return
     * @throws SystemException
     * @throws BusinessException
     * @author zhangqiang7
     * @ApiCode USER_1000018
     * @RestRelativeURL custkeyinfoservice/searchGroupKeyInfo
     */
    @POST
    @Path("/searchGroupKeyInfo")
    public SearchGroupKeyInfoResponse searchGroupKeyInfo(SearchGroupKeyInfoRequest request)
            throws SystemException, BusinessException;
    
    /**
     * 保存用户扩展信息
     * @param request
     * @return
     * @throws SystemException
     * @throws BusinessException
     * @author zhangqiang7
     * @ApiCode USER_1000019
     * @RestRelativeURL custkeyinfoservice/insertCustFileExt
     */
    @POST
    @Path("/insertCustFileExt")
    public BaseResponse insertCustFileExt(InsertCustFileExtRequest request)throws SystemException, BusinessException;
    
    
    /**
     * 查询用户扩展信息
     * @param request
     * @return
     * @throws SystemException
     * @throws BusinessException
     * @author zhangqiang7
     * @ApiCode USER_1000020
     * @RestRelativeURL custkeyinfoservice/queryCustFileExt
     */
    @POST
    @Path("/queryCustFileExt")
    public QueryCustFileExtResponse queryCustFileExt(QueryCustFileExtRequest request)throws SystemException, BusinessException;
    
    /**
     * 企业关键信息模糊分页查询
     * @param request
     * @return
     * @throws SystemException
     * @throws BusinessException
     * @author zhangqiang7
     * @ApiCode USER_1000021
     * @RestRelativeURL custkeyinfoservice/queryGroupInfo
     */
    @POST
    @Path("/queryGroupInfo")
    public PageInfoResponse<UcGroupKeyInfoVo> queryGroupInfo(QueryGroupInfoRequest request)throws SystemException, BusinessException;

    
    /**
     * 更新用户扩展信息
     * @param request
     * @return
     * @throws SystemException
     * @throws BusinessException
     * @author zhangqiang7
     * @ApiCode USER_110000
     * @RestRelativeURL custkeyinfoservice/updateCustFileExt
     */
    @POST
    @Path("/updateCustFileExt")
    public BaseResponse updateCustFileExt(UpdateCustFileExtRequest request)throws SystemException, BusinessException;
   
    /**
     * 根据企业信息获取企业和用户的信息
     * @param request
     * @return
     * @throws SystemException
     * @throws BusinessException
     * @author zhangyh7
     * @ApiCode USER_110001
     * @RestRelativeURL custkeyinfoservice/searchGroupUserInfo
     */
    @POST
    @Path("/searchGroupUserInfo")
    public SearchGroupUserInfoResponse searchGroupUserInfo(SearchGroupKeyInfoRequest request)
            throws SystemException, BusinessException;
}
