package com.ai.slp.user.service.business.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.BaseResponse;
import com.ai.opt.base.vo.PageInfo;
import com.ai.opt.base.vo.ResponseHeader;
import com.ai.slp.user.api.favorite.param.DeleteFavoriteListRequest;
import com.ai.slp.user.api.favorite.param.InsertUserFavoriteRequest;
import com.ai.slp.user.api.favorite.param.UpdateFavoriteRequest;
import com.ai.slp.user.api.favorite.param.UserFavoriteParams;
import com.ai.slp.user.api.favorite.param.UserFavoriteRequest;
import com.ai.slp.user.api.favorite.param.UserFavoriteResponse;
import com.ai.slp.user.dao.mapper.bo.UcUserFavorite;
import com.ai.slp.user.dao.mapper.bo.UcUserFavoriteCriteria;
import com.ai.slp.user.service.atom.interfaces.IUserFavoriteAtomSV;
import com.ai.slp.user.service.business.interfaces.IUserFavoriteBusiSV;
import com.ai.slp.user.util.DateUtils;
import com.ai.slp.user.util.SequenceUtil;

@Service
@Transactional
public class UserFavoriteBusiSVImpl implements IUserFavoriteBusiSV {

    private static final Log LOG = LogFactory.getLog(IUserFavoriteBusiSV.class);

    @Autowired
    private IUserFavoriteAtomSV userFavoriteAtomSV;

    @Override
    public BaseResponse insertUcFavorite(InsertUserFavoriteRequest favoriteRequest)
            throws BusinessException, SystemException {
        UcUserFavorite ucUserFavorite = new UcUserFavorite();
        ucUserFavorite.setFavoriteSeqId(SequenceUtil.createFavoriteSeqId());
        BeanUtils.copyProperties(favoriteRequest, ucUserFavorite);
        ucUserFavorite.setUserId(favoriteRequest.getUserId());
        ucUserFavorite.setCreateTime(DateUtils.currTimeStamp());
        ucUserFavorite.setState("0");
        BaseResponse response = new BaseResponse();
        ResponseHeader responseHeader;
        try {
            userFavoriteAtomSV.insert(ucUserFavorite);
            responseHeader = new ResponseHeader(true, "success", "添加成功");
        } catch (Exception e) {
            LOG.error("插入操作失败", e);
            responseHeader = new ResponseHeader(false, "fail", "添加失败");
        }
        response.setResponseHeader(responseHeader);
        return response;
    }

    @Override
    public BaseResponse updateFavorite(UpdateFavoriteRequest updateRequest)
            throws SystemException, BusinessException {
        UcUserFavorite ucUserFavorite = new UcUserFavorite();
        List<String> list = new ArrayList<String>();
        list = updateRequest.getFavoriteList();
        UcUserFavoriteCriteria example = new UcUserFavoriteCriteria();
        UcUserFavoriteCriteria.Criteria criteria = example.createCriteria();
        criteria.andTenantIdEqualTo(updateRequest.getTenantId());
        criteria.andUserIdEqualTo(updateRequest.getUserId());
        criteria.andFavoriteSeqIdIn(list);
        ucUserFavorite.setState("1");
        ucUserFavorite.setUpdateTime(DateUtils.currTimeStamp());
        BaseResponse response = new BaseResponse();
        ResponseHeader responseHeader;
        try {
            userFavoriteAtomSV.updateByExampleSelective(ucUserFavorite, example);
            responseHeader = new ResponseHeader(false, "fail", "更新成功");
        } catch (Exception e) {
            LOG.error("更新操作失败", e);
            responseHeader = new ResponseHeader(true, "success", "更新失败");
        }
        response.setResponseHeader(responseHeader);
        return response;
    }

    @Override
    public BaseResponse deleteFavorite(DeleteFavoriteListRequest deleteFavoriteRequest)
            throws SystemException, BusinessException {
        List<String> list = new ArrayList<String>();
        list = deleteFavoriteRequest.getFavoriteReqIdList();

        UcUserFavoriteCriteria example = new UcUserFavoriteCriteria();
        UcUserFavoriteCriteria.Criteria criteria = example.createCriteria();
        criteria.andTenantIdEqualTo(deleteFavoriteRequest.getTenantId());
        criteria.andUserIdEqualTo(deleteFavoriteRequest.getUserId());
        criteria.andFavoriteSeqIdIn(list);
        BaseResponse response = new BaseResponse();
        ResponseHeader responseHeader;
        try {
            userFavoriteAtomSV.deleteByExample(example);
            responseHeader = new ResponseHeader(true, "success", "删除成功");
        } catch (Exception e) {
            LOG.error("删除失败");
            responseHeader = new ResponseHeader(false, "fail", "删除失败");
        }
        response.setResponseHeader(responseHeader);
        return response;
    }

    @Override
    public UserFavoriteResponse queryFavorite(UserFavoriteRequest userFavoriteRequest)
            throws SystemException, BusinessException {
        UcUserFavoriteCriteria example = new UcUserFavoriteCriteria();
        UcUserFavoriteCriteria.Criteria criteria = example.createCriteria();
        criteria.andTenantIdEqualTo(userFavoriteRequest.getTenantId());
        criteria.andUserIdEqualTo(userFavoriteRequest.getUserId());
        List<UcUserFavorite> favoriteList = new ArrayList<UcUserFavorite>();
        List<UserFavoriteParams> responseList = new ArrayList<UserFavoriteParams>();
        ResponseHeader responseHeader;
        int count = 0;
        try {
            count = userFavoriteAtomSV.countByExample(example);
            responseHeader = new ResponseHeader(true, "success", "查询成功");
        } catch (Exception e) {
            LOG.error("查询失败", e);
            responseHeader = new ResponseHeader(false, "fail", "查询失败");
        }
        favoriteList = userFavoriteAtomSV.selectByExample(example);
        UserFavoriteResponse response = new UserFavoriteResponse();
        Integer pageSize = userFavoriteRequest.getPageSize();
        Integer pageNo = userFavoriteRequest.getPageNo();
        for (UcUserFavorite ucUserFavorite : favoriteList) {
            UserFavoriteParams userFavoriteParams = new UserFavoriteParams();
            BeanUtils.copyProperties(ucUserFavorite, userFavoriteParams);
            responseList.add(userFavoriteParams);
        }
        PageInfo<UserFavoriteParams> pageInfo = new PageInfo<UserFavoriteParams>();
        pageInfo.setResult(responseList);
        pageInfo.setCount(count);
        pageInfo.setPageNo(pageNo);
        pageInfo.setPageSize(pageSize);
        response.setPageInfo(pageInfo);
        response.setResponseHeader(responseHeader);
        return response;
    }

}