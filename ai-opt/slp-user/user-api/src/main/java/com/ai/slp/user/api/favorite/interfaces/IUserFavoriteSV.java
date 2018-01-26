package com.ai.slp.user.api.favorite.interfaces;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.BaseResponse;
import com.ai.slp.user.api.favorite.param.DeleteFavoriteListRequest;
import com.ai.slp.user.api.favorite.param.InsertUserFavoriteRequest;
import com.ai.slp.user.api.favorite.param.UpdateFavoriteRequest;
import com.ai.slp.user.api.favorite.param.UserFavoriteRequest;
import com.ai.slp.user.api.favorite.param.UserFavoriteResponse;

/**
 * 用户收藏信息服务<br>
 * Date: 2016年4月20日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * 
 * @author zhangqiang7
 */
@Path("/favoriteservice")
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
public interface IUserFavoriteSV {

    /**
     * 用户收藏信息创建
     * 
     * @param saveUserFavoriteRequest
     * @return
     * @throws BusinessException
     * @throws SystemException
     * @author zhangqiang7
     * @ApiCode UCUSER_00010
     * @RestRelativeURL favoriteservice/insertUcFavorite
     */
    @POST
    @Path("/insertUcFavorite")
    BaseResponse insertUcFavorite(InsertUserFavoriteRequest favoriteRequest)
            throws BusinessException, SystemException;

    /**
     * 用户收藏信息更新 
     * 取消收藏即更新收藏状态
     * 
     * @param ucUserFavoriteParams
     * @throws SystemException
     * @throws BusinessException
     * @author zhangqiang7
     * @ApiCode UCUSER_00011
     * @RestRelativeURL favoriteservice/cancelFavorite
     */
    @POST
    @Path("/cancelFavorite")
    BaseResponse cancelFavorite(UpdateFavoriteRequest updateRequest)
            throws SystemException, BusinessException;

    /**
     * 用户收藏信息删除
     * 
     * @param deleteRequest
     * @throws SystemException
     * @throws BusinessException
     * @author zhangqiang7
     * @ApiCode UCUSER_00012
     * @RestRelativeURL favoriteservice/deleteFavorite
     */
    @POST
    @Path("/deleteFavorite")
    BaseResponse deleteFavorite(DeleteFavoriteListRequest deleteListRequest)
            throws SystemException, BusinessException;

    /**
     * 用户收藏信息查询
     * 
     * @param userFavoriteRequest
     * @return
     * @throws SystemException
     * @throws BusinessException
     * @author zhangqiang7
     * @ApiCode UCUSER_00013
     * @RestRelativeURL favoriteservice/queryFavorite
     */
    @POST
    @Path("/queryFavorite")
   UserFavoriteResponse queryFavorite(UserFavoriteRequest userFavoriteRequest)
            throws SystemException, BusinessException;
}
