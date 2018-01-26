package com.ai.slp.user.service.business.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.sdk.util.BeanUtils;
import com.ai.opt.sdk.util.StringUtil;
import com.ai.slp.user.api.login.param.LoginRequest;
import com.ai.slp.user.api.login.param.LoginResponse;
import com.ai.slp.user.constants.UserLoginErrorCode;
import com.ai.slp.user.dao.mapper.bo.UcUser;
import com.ai.slp.user.dao.mapper.bo.UcUserCriteria;
import com.ai.slp.user.dao.mapper.interfaces.UcUserMapper;
import com.ai.slp.user.service.business.interfaces.ILoginBusiSV;

/**
 * 登录服务 Date: 2016年4月22日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * 
 * @author zhangqiang7
 */
@Service
@Transactional
public class LoginBusiSVImpl implements ILoginBusiSV {

    static final Log LOG = LogFactory.getLog(LoginBusiSVImpl.class);

    @Autowired
    private transient UcUserMapper userMapper;

    @Override
    public LoginResponse login(LoginRequest loginRequest) throws BusinessException{

        UcUserCriteria example = new UcUserCriteria();
        UcUserCriteria.Criteria criteria = example.createCriteria();
        //criteria.andTenantIdEqualTo(loginRequest.getTenantId());
        criteria.andUserTypeEqualTo(loginRequest.getUserType());
        LoginResponse response = new LoginResponse();
        List<UcUser> userList = new ArrayList<UcUser>();

        if (!StringUtil.isBlank(loginRequest.getUserLoginName())) {
            criteria.andUserLoginNameEqualTo(loginRequest.getUserLoginName());
            userList = userMapper.selectByExample(example);
            if (userList.size() == 0) {
                throw new BusinessException(UserLoginErrorCode.USER_ERR_001, "用户不存在");
            } else {
                response.setUserLoginName(userList.get(0).getUserLoginName());
            }
        }
        if (!StringUtil.isBlank(loginRequest.getUserEmail())) {
            criteria.andUserEmailEqualTo(loginRequest.getUserEmail());
            criteria.andEmailValidateFlagEqualTo("10");
            userList = userMapper.selectByExample(example);
            if (userList.size() == 0) {
                throw new BusinessException(UserLoginErrorCode.USER_ERR_002, "邮箱未验证");
            } else {
                response.setUserEmail(userList.get(0).getUserEmail());
            }
        }
        if (!StringUtil.isBlank(loginRequest.getUserMp())) {
            criteria.andUserMpEqualTo(loginRequest.getUserMp());
            userList = userMapper.selectByExample(example);
            if (userList.size() == 0) {
                throw new BusinessException(UserLoginErrorCode.USER_ERR_003, "手机号未绑定");
            } else {
                response.setUserMp(userList.get(0).getUserMp());
            }
        }
        if (userList.size() != 0) {
            /*response.setUserId(userList.get(0).getUserId());
            response.setTenantId(userList.get(0).getTenantId());
            response.setUserType(userList.get(0).getUserType());
            response.setUserLoginPwd(userList.get(0).getUserLoginPwd());
            if(userList.get(0).getUserNickname()!=null)
            response.setUserNickname(userList.get(0).getUserNickname());*/
            
            BeanUtils.copyProperties(response, userList.get(0));
        }
        return response;
    }
}
