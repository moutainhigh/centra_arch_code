package com.ai.slp.user.service.atom.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.opt.base.exception.SystemException;
import com.ai.opt.sdk.util.CollectionUtil;
import com.ai.slp.user.api.ucuser.param.SearchUserRequest;
import com.ai.slp.user.dao.mapper.bo.UcCustKeyInfo;
import com.ai.slp.user.dao.mapper.bo.UcCustKeyInfoCriteria;
import com.ai.slp.user.dao.mapper.bo.UcGroupKeyInfo;
import com.ai.slp.user.dao.mapper.bo.UcGroupKeyInfoCriteria;
import com.ai.slp.user.dao.mapper.bo.UcUser;
import com.ai.slp.user.dao.mapper.bo.UcUserCriteria;
import com.ai.slp.user.dao.mapper.interfaces.UcCustKeyInfoMapper;
import com.ai.slp.user.dao.mapper.interfaces.UcGroupKeyInfoMapper;
import com.ai.slp.user.dao.mapper.interfaces.UcUserMapper;
import com.ai.slp.user.service.atom.interfaces.IUcUserAtomSV;

@Component
public class UcUserAtomSVImpl implements IUcUserAtomSV {
    @Autowired
    private transient UcUserMapper userMapper;

    @Autowired
    private transient UcCustKeyInfoMapper custKeyInfoMapper;

    @Autowired
    private transient UcGroupKeyInfoMapper groupKeyInfoMapper;

    @Override
    public List<UcUser> searchUcUserInfo(UcUserCriteria example) throws SystemException {
        return userMapper.selectByExample(example);
    }

    @Override
    public List<UcCustKeyInfo> searchUcCustKeyInfo(UcCustKeyInfoCriteria example)
            throws SystemException {
        return custKeyInfoMapper.selectByExample(example);
    }

    @Override
    public List<UcGroupKeyInfo> searchUcGroupKeyInfo(UcGroupKeyInfoCriteria example)
            throws SystemException {
        return groupKeyInfoMapper.selectByExample(example);
    }

    @Override
    public int countByExample(UcUserCriteria example) {
        return userMapper.countByExample(example);
    }

    @Override
    public UcUser queryByPhone(SearchUserRequest request) throws SystemException {
        
        UcUserCriteria conditon = new UcUserCriteria();
        UcUserCriteria.Criteria criteria = conditon.or();
        criteria.andUserMpEqualTo(request.getUserMp());
        criteria.andUserTypeEqualTo(request.getUserType());
        List<UcUser> list = userMapper.selectByExample(conditon);
        if(!CollectionUtil.isEmpty(list)){
            return list.get(0);
        }
        return null;
        
    }

    @Override
    public UcUser queryByEmail(String email) throws SystemException {
        UcUserCriteria example = new UcUserCriteria();
        UcUserCriteria.Criteria criteria = example.createCriteria();
        criteria.andUserEmailEqualTo(email);
        List<UcUser> list = userMapper.selectByExample(example);
        if(!CollectionUtil.isEmpty(list)){
            return list.get(0);
        }
        return null;
    }

    @Override
    public UcUser queryByUserId(String userId) throws SystemException {
        UcUserCriteria conditon = new UcUserCriteria();
        UcUserCriteria.Criteria criteria = conditon.or();
        criteria.andUserIdEqualTo(userId);
        List<UcUser> list = userMapper.selectByExample(conditon);
        if(CollectionUtil.isEmpty(list)){
            return null;
        }
        return list.get(0);
    }

    @Override
    public int updateByAccountId(UcUser ucUser,UcUserCriteria example) throws SystemException {
        return userMapper.updateByExampleSelective(ucUser, example);
    }

    @Override
    public int updateByAcountInfo(UcUser gnAccount, UcUserCriteria example) throws SystemException {
        return userMapper.updateByExampleSelective(gnAccount, example);
    }

    @Override
    public UcUser queryByBaseInfo(UcUserCriteria example) throws SystemException {
        List<UcUser> list = userMapper.selectByExample(example);
        UcUser ucUser = new UcUser();
        if(!list.isEmpty()){
            ucUser = list.get(0);
        }
        return ucUser;
    }
}
