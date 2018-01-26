package com.ai.slp.user.service.atom.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.slp.user.dao.mapper.bo.UcSpecialInfo;
import com.ai.slp.user.dao.mapper.bo.UcSpecialInfoCriteria;
import com.ai.slp.user.dao.mapper.interfaces.UcSpecialInfoMapper;
import com.ai.slp.user.service.atom.interfaces.IUcSpecialInfoAtomSV;

@Component
public class UcSpecialInfoAtomSVImpl implements IUcSpecialInfoAtomSV {
    @Autowired
    private transient UcSpecialInfoMapper contactsInfoMapper;

    @Override
    public int deleteByExample(UcSpecialInfoCriteria example) {
        return contactsInfoMapper.deleteByExample(example);
    }

    @Override
    public int insert(UcSpecialInfo record) {
        return contactsInfoMapper.insert(record);
    }

    @Override
    public List<UcSpecialInfo> selectByExample(UcSpecialInfoCriteria example) {
        return contactsInfoMapper.selectByExample(example);
    }

    @Override
    public int updateByExampleSelective(UcSpecialInfo record, UcSpecialInfoCriteria example) {
        return contactsInfoMapper.updateByExampleSelective(record, example);
    }

}
