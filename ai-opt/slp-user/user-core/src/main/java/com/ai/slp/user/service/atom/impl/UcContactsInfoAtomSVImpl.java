package com.ai.slp.user.service.atom.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.slp.user.dao.mapper.bo.UcContactsInfo;
import com.ai.slp.user.dao.mapper.bo.UcContactsInfoCriteria;
import com.ai.slp.user.dao.mapper.interfaces.UcContactsInfoMapper;
import com.ai.slp.user.service.atom.interfaces.IUcContactsInfoAtomSV;

@Component
public class UcContactsInfoAtomSVImpl implements IUcContactsInfoAtomSV {
    @Autowired
    private transient UcContactsInfoMapper contactsInfoMapper;

    @Override
    public int countByExample(UcContactsInfoCriteria example) {
        return contactsInfoMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(UcContactsInfoCriteria example) {
        return contactsInfoMapper.deleteByExample(example);
    }

    @Override
    public int insert(UcContactsInfo record) {
        return contactsInfoMapper.insert(record);
    }

    @Override
    public List<UcContactsInfo> selectByExample(UcContactsInfoCriteria example) {
        return contactsInfoMapper.selectByExample(example);
    }

    @Override
    public int updateByExampleSelective(UcContactsInfo record, UcContactsInfoCriteria example) {
        return contactsInfoMapper.updateByExampleSelective(record, example);
    }

}
