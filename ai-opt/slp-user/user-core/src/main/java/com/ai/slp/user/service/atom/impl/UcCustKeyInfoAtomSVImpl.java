package com.ai.slp.user.service.atom.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.slp.user.dao.mapper.bo.UcCustKeyInfo;
import com.ai.slp.user.dao.mapper.bo.UcCustKeyInfoCriteria;
import com.ai.slp.user.dao.mapper.interfaces.UcCustKeyInfoMapper;
import com.ai.slp.user.service.atom.interfaces.IUcCustKeyInfoAtomSV;

@Component
public class UcCustKeyInfoAtomSVImpl implements IUcCustKeyInfoAtomSV {

    @Autowired
    private UcCustKeyInfoMapper ucCustKeyInfoMapper;
    
    @Override
    public int insert(UcCustKeyInfo record) {
        return ucCustKeyInfoMapper.insert(record);
    }

    @Override
    public List<UcCustKeyInfo> selectByExample(UcCustKeyInfoCriteria example) {
        return ucCustKeyInfoMapper.selectByExample(example);
    }

    @Override
    public int updateByExampleSelective(UcCustKeyInfo record, UcCustKeyInfoCriteria example) {
        return ucCustKeyInfoMapper.updateByExampleSelective(record, example);
    }

}
