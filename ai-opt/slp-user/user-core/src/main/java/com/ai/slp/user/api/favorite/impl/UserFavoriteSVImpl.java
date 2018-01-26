package com.ai.slp.user.api.favorite.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.BaseResponse;
import com.ai.slp.user.api.favorite.interfaces.IUserFavoriteSV;
import com.ai.slp.user.api.favorite.param.DeleteFavoriteListRequest;
import com.ai.slp.user.api.favorite.param.InsertUserFavoriteRequest;
import com.ai.slp.user.api.favorite.param.UpdateFavoriteRequest;
import com.ai.slp.user.api.favorite.param.UserFavoriteRequest;
import com.ai.slp.user.api.favorite.param.UserFavoriteResponse;
import com.ai.slp.user.service.business.interfaces.IUserFavoriteBusiSV;
import com.alibaba.dubbo.config.annotation.Service;

@Component
@Service
public class UserFavoriteSVImpl implements IUserFavoriteSV {

    @Autowired
    private IUserFavoriteBusiSV userFavoriteBusiSV;
    
    @Override
    public BaseResponse insertUcFavorite(InsertUserFavoriteRequest favoriteRequest)
            throws BusinessException, SystemException {
        return userFavoriteBusiSV.insertUcFavorite(favoriteRequest);
    }

    @Override
    public BaseResponse cancelFavorite(UpdateFavoriteRequest updateRequest)
            throws SystemException, BusinessException {
        return userFavoriteBusiSV.updateFavorite(updateRequest);
    }

    @Override
    public UserFavoriteResponse queryFavorite(UserFavoriteRequest userFavoriteRequest)
            throws SystemException, BusinessException {
        return userFavoriteBusiSV.queryFavorite(userFavoriteRequest);
    }

    @Override
    public BaseResponse deleteFavorite(DeleteFavoriteListRequest deleteListRequest)
            throws SystemException, BusinessException {
        return userFavoriteBusiSV.deleteFavorite(deleteListRequest);
    }

}
