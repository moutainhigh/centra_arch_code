package com.ai.slp.user.api.ucuserphonebooks.interfaces;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.BaseResponse;
import com.ai.opt.base.vo.PageInfo;
import com.ai.slp.user.api.ucuserphonebooks.param.UcTelGroupMantainReq;
import com.ai.slp.user.api.ucuserphonebooks.param.UcTelGroupQueryReq;
import com.ai.slp.user.api.ucuserphonebooks.param.UcTelGroupQueryResp;
import com.ai.slp.user.api.ucuserphonebooks.param.UcUserPhonebooksBatchAddReq;
import com.ai.slp.user.api.ucuserphonebooks.param.UcUserPhonebooksBatchAddResp;
import com.ai.slp.user.api.ucuserphonebooks.param.UcUserPhonebooksBatchDeleteReq;
import com.ai.slp.user.api.ucuserphonebooks.param.UcUserPhonebooksModifyReq;
import com.ai.slp.user.api.ucuserphonebooks.param.UcUserPhonebooksQueryReq;
import com.ai.slp.user.api.ucuserphonebooks.param.UserPhonebook;

@Path("/phoneBooksService")
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
public interface IUserPhoneBooksSV {

	/**
	 * 增加通信录分组
	 * 
	 * @param req
	 * @throws BusinessException
	 * @throws SystemException
	 * @author zhangchao
	 * @RestRelativeURL phoneBooksService/addUcTelGroup
	 */
    @POST
    @Path("/addUcTelGroup")
	BaseResponse addUcTelGroup(UcTelGroupMantainReq req) throws BusinessException, SystemException;

	/**
	 * 修改通信录分组
	 * 
	 * @param req
	 * @throws BusinessException
	 * @throws SystemException
	 * @author zhangchao
	 * @RestRelativeURL phoneBooksService/modifyUcTelGroup
	 */
    @POST
    @Path("/modifyUcTelGroup")
	BaseResponse modifyUcTelGroup(UcTelGroupMantainReq req) throws BusinessException, SystemException;

	/**
	 * 修改通信录分组
	 * 
	 * @param req
	 * @throws BusinessException
	 * @throws SystemException
	 * @author zhangchao
	 * @RestRelativeURL phoneBooksService/deleteUcTelGroup
	 */
    @POST
    @Path("/deleteUcTelGroup")
	BaseResponse deleteUcTelGroup(UcTelGroupMantainReq req) throws BusinessException, SystemException;

	/**
	 * 获取用户通信录列表
	 * 
	 * @param req
	 * @return
	 * @throws BusinessException
	 * @throws SystemException
	 * @author zhangchao
	 * @RestRelativeURL phoneBooksService/getUcTelGroups
	 */
    @POST
    @Path("/getUcTelGroups")
	UcTelGroupQueryResp getUcTelGroups(UcTelGroupQueryReq req) throws BusinessException, SystemException;

	/**
	 * 获取通信录分页信息
	 * 
	 * @param req
	 * @return
	 * @throws BusinessException
	 * @throws SystemException
	 * @author zhangchao
	 * @RestRelativeURL phoneBooksService/queryUserPhonebooks
	 */
    @POST
    @Path("/queryUserPhonebooks")
	PageInfo<UserPhonebook> queryUserPhonebooks(UcUserPhonebooksQueryReq req) throws BusinessException, SystemException;

	/**
	 * 修改单个用户通信录记录
	 * 
	 * @param req
	 * @return
	 * @throws BusinessException
	 * @throws SystemException
	 * @author zhangchao
	 * @RestRelativeURL phoneBooksService/modifyUserPhonebook
	 */
    @POST
    @Path("/modifyUserPhonebook")
	BaseResponse modifyUserPhonebook(UcUserPhonebooksModifyReq req) throws BusinessException, SystemException;

	/**
	 * 批量添加或导入用户通信录
	 * 
	 * @param req
	 * @return
	 * @throws BusinessException
	 * @throws SystemException
	 * @author zhangchao
	 * @RestRelativeURL phoneBooksService/batchAddUserPhonebooks
	 */
    @POST
    @Path("/batchAddUserPhonebooks")
	UcUserPhonebooksBatchAddResp batchAddUserPhonebooks(UcUserPhonebooksBatchAddReq req)
			throws BusinessException, SystemException;

	/**
	 * 批量删除用户通信录记录
	 * 
	 * @param req
	 * @return
	 * @throws BusinessException
	 * @throws SystemException
	 * @author zhangchao
	 * @RestRelativeURL phoneBooksService/batchDeleteUserPhonebooks
	 */
    @POST
    @Path("/batchDeleteUserPhonebooks")
	BaseResponse batchDeleteUserPhonebooks(UcUserPhonebooksBatchDeleteReq req)
			throws BusinessException, SystemException;

}
