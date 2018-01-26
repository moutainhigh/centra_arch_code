package com.ai.slp.user.service.business.interfaces;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.BaseResponse;
import com.ai.slp.user.api.favorite.param.DeleteFavoriteListRequest;
import com.ai.slp.user.api.favorite.param.InsertUserFavoriteRequest;
import com.ai.slp.user.api.favorite.param.UpdateFavoriteRequest;
import com.ai.slp.user.api.favorite.param.UserFavoriteRequest;
import com.ai.slp.user.api.favorite.param.UserFavoriteResponse;

public interface IUserFavoriteBusiSV {

    public BaseResponse insertUcFavorite(
            InsertUserFavoriteRequest favoriteRequest)
                    throws BusinessException, SystemException;

    public BaseResponse updateFavorite(UpdateFavoriteRequest updateRequest)
            throws SystemException, BusinessException;

    public BaseResponse deleteFavorite(DeleteFavoriteListRequest deleteFavoriteListRequest)
            throws SystemException, BusinessException;

    public UserFavoriteResponse queryFavorite(UserFavoriteRequest userFavoriteRequest)
            throws SystemException, BusinessException;

}
