package com.ai.slp.user.service.business.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.PageInfo;
import com.ai.opt.base.vo.ResponseHeader;
import com.ai.opt.sdk.util.StringUtil;
import com.ai.slp.user.api.ucuser.param.SearchUserListResponse;
import com.ai.slp.user.api.ucuser.param.SearchUserRequest;
import com.ai.slp.user.api.ucuser.param.UcUserInfoParams;
import com.ai.slp.user.dao.mapper.bo.UcUser;
import com.ai.slp.user.dao.mapper.bo.UcUserCriteria;
import com.ai.slp.user.service.atom.interfaces.IUcUserAtomSV;
import com.ai.slp.user.service.business.interfaces.IUcUserBusiSV;
import com.ai.slp.user.util.DateUtils;

/**
 * 登录服务 Date: 2016年4月22日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * 
 * @author zhangqiang7
 */
@Service
@Transactional
public class UcUserBusiSVImpl implements IUcUserBusiSV {

    static final Log LOG = LogFactory.getLog(UcUserBusiSVImpl.class);

    @Autowired
    private IUcUserAtomSV ucUserAtomSV;

    @Override
    public SearchUserListResponse searchUserList(SearchUserRequest userListRequest) {

        UcUserCriteria example = new UcUserCriteria();
        UcUserCriteria.Criteria criteria = example.createCriteria();

        //criteria.andTenantIdEqualTo(userListRequest.getTenantId());

        if (!StringUtils.isBlank(userListRequest.getUserLoginName())) {
            criteria.andUserLoginNameEqualTo(userListRequest.getUserLoginName());
        }
        if (!StringUtils.isBlank(userListRequest.getUserMp())) {
            criteria.andUserMpEqualTo(userListRequest.getUserMp());
        }
        if (!StringUtils.isBlank(userListRequest.getUserEmail())) {
            criteria.andUserEmailEqualTo(userListRequest.getUserEmail());
        }
        if (!StringUtils.isBlank(userListRequest.getVipLevel())) {
            criteria.andVipLevelEqualTo(userListRequest.getVipLevel());
        }
        if (!StringUtils.isBlank(userListRequest.getRegisterSource())) {
            criteria.andRegisterSourceEqualTo(userListRequest.getRegisterSource());
        }
        if (!StringUtils.isBlank(userListRequest.getUserState())) {
            criteria.andUserStateEqualTo(userListRequest.getUserState());
        }
        if(!StringUtils.isBlank(userListRequest.getUserType())){
            criteria.andUserStateEqualTo(userListRequest.getUserType());
        }
        if ((userListRequest.getBeginTime() != null) && (userListRequest.getEndTime() != null)) {
            criteria.andCreateTimeBetween(
                    DateUtils.getTimestamp(userListRequest.getBeginTime(), "yyyy-MM-dd HH:mm:ss"),
                    DateUtils.getTimestamp(userListRequest.getEndTime(), "yyyy-MM-dd HH:mm:ss"));
        }

        List<UcUser> list = new ArrayList<UcUser>();
        ResponseHeader responseHeader;
        Integer pageNo = userListRequest.getPageNo();
        Integer pageSize = userListRequest.getPageSize();
        int count = 0;
        try {
            count = ucUserAtomSV.countByExample(example);
            list = ucUserAtomSV.searchUcUserInfo(example);
            responseHeader = new ResponseHeader(true, "success", "查询成功");
        } catch (Exception e) {
            LOG.error("查询失败");
            responseHeader = new ResponseHeader(false, "fail", "查询失败");
        }
        List<UcUserInfoParams> responseList = new ArrayList<UcUserInfoParams>();
        for (UcUser user : list) {
            UcUserInfoParams ucUserInfoParams = new UcUserInfoParams();
            BeanUtils.copyProperties(user, ucUserInfoParams);
            responseList.add(ucUserInfoParams);
        }
        PageInfo<UcUserInfoParams> pageInfo = new PageInfo<UcUserInfoParams>();
        SearchUserListResponse response = new SearchUserListResponse();
        pageInfo.setCount(count);
        pageInfo.setPageNo(pageNo);
        pageInfo.setPageSize(pageSize);
        pageInfo.setResult(responseList);
        response.setPageInfo(pageInfo);
        response.setResponseHeader(responseHeader);
        return response;
    }

    @Override
    public UcUser queryByPhone(SearchUserRequest request) throws SystemException {
        
        return ucUserAtomSV.queryByPhone(request);
    }

    @Override
    public UcUser queryByEmail(String email) throws SystemException {
        return ucUserAtomSV.queryByEmail(email);
    }

    @Override
    public UcUser queryBaseInfo(UcUserCriteria criteria) throws SystemException {
        return  ucUserAtomSV.queryByBaseInfo(criteria);
    }

    @Override
    public int updateByAccountId(UcUser ucUser,UcUserCriteria example) throws SystemException {
        return ucUserAtomSV.updateByAccountId(ucUser,example) ;
    }

    @Override
    public int updateByAcountInfo(UcUser gnAccount, UcUserCriteria example) throws SystemException {
        return ucUserAtomSV.updateByAcountInfo(gnAccount, example);
    }

    @Override
    public UcUser queryByBaseInfo(UcUser gnAcount) throws SystemException {
        UcUserCriteria example = new UcUserCriteria();
        UcUserCriteria.Criteria criteria = example.createCriteria();
        criteria.andTenantIdEqualTo(gnAcount.getTenantId());
        criteria.andUserTypeEqualTo(gnAcount.getUserType());
        
        //判断用户登录账号
        if (!StringUtil.isBlank(gnAcount.getUserLoginName())) {
            criteria.andUserLoginNameEqualTo(gnAcount.getUserLoginName());
        }
        if (!StringUtil.isBlank(gnAcount.getUserEmail())) {
            criteria.andUserEmailEqualTo(gnAcount.getUserEmail());
            criteria.andEmailValidateFlagEqualTo("10");
        }
        if (!StringUtil.isBlank(gnAcount.getUserMp())) {
            criteria.andUserMpEqualTo(gnAcount.getUserMp());
        }
        return ucUserAtomSV.queryByBaseInfo(example);
    }

    
}
