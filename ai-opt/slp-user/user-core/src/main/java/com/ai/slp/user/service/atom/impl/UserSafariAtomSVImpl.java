package com.ai.slp.user.service.atom.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.slp.user.dao.mapper.bo.UcUserSafari;
import com.ai.slp.user.dao.mapper.bo.UcUserSafariCriteria;
import com.ai.slp.user.dao.mapper.interfaces.UcUserSafariMapper;
import com.ai.slp.user.service.atom.interfaces.IUserSafariAtomSV;

@Component
public class UserSafariAtomSVImpl implements IUserSafariAtomSV {

    @Autowired
    private transient UcUserSafariMapper userSafariMapper;
    
    @Override
    public int insert(UcUserSafari record) {
        return userSafariMapper.insert(record);
    }

    @Override
    public List<UcUserSafari> selectByExample(UcUserSafariCriteria example) {
        return userSafariMapper.selectByExample(example);
    }

    @Override
    public int deleteByExample(UcUserSafariCriteria example) {
        return userSafariMapper.deleteByExample(example);
    }

    @Override
    public int countByExample(UcUserSafariCriteria example) {
        return userSafariMapper.countByExample(example);
    }

    @Override
    public int updateByExampleSelective(UcUserSafari record, UcUserSafariCriteria example) {
        return userSafariMapper.updateByExampleSelective(record, example);
    }
    
}
