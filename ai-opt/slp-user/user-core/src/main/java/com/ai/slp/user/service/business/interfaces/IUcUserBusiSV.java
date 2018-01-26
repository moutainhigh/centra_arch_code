package com.ai.slp.user.service.business.interfaces;

import java.util.List;

import com.ai.opt.base.exception.SystemException;
import com.ai.slp.user.api.ucuser.param.SearchUserListResponse;
import com.ai.slp.user.api.ucuser.param.SearchUserRequest;
import com.ai.slp.user.dao.mapper.bo.UcUser;
import com.ai.slp.user.dao.mapper.bo.UcUserCriteria;

/**
 * 用户信息 Date: 2016年4月29日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * 
 * @author zhaogw
 */
public interface IUcUserBusiSV {
    SearchUserListResponse searchUserList(SearchUserRequest userListRequest);
    
    UcUser queryByPhone(SearchUserRequest request)throws SystemException;
    
    UcUser queryByEmail(String email)throws SystemException;
    
    UcUser queryBaseInfo(UcUserCriteria criteria) throws SystemException;
    
    int updateByAccountId(UcUser gnAccount,UcUserCriteria example) throws SystemException;
    
    int updateByAcountInfo(UcUser gnAccount,UcUserCriteria example) throws SystemException;
    
    UcUser queryByBaseInfo(UcUser gnAcount) throws SystemException;
    
}
