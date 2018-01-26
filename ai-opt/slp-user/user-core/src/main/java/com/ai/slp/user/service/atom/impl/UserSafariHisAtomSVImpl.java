package com.ai.slp.user.service.atom.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.slp.user.dao.mapper.bo.UcUserSafariHis;
import com.ai.slp.user.dao.mapper.bo.UcUserSafariHisCriteria;
import com.ai.slp.user.dao.mapper.interfaces.UcUserSafariHisMapper;
import com.ai.slp.user.service.atom.interfaces.IUserSafariHisAtomSV;

@Component
public class UserSafariHisAtomSVImpl implements IUserSafariHisAtomSV {
    @Autowired
    private transient UcUserSafariHisMapper userSafariHisMapper;

    @Override
    public int insert(UcUserSafariHis record) {
        return userSafariHisMapper.insert(record);
    }

    @Override
    public List<UcUserSafariHis> selectByExample(UcUserSafariHisCriteria example) {
        return userSafariHisMapper.selectByExample(example);
    }

    @Override
    public int deleteByExample(UcUserSafariHisCriteria example) {
        return userSafariHisMapper.deleteByExample(example);
    }
}
