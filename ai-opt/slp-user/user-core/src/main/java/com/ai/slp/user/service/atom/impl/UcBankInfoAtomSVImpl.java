package com.ai.slp.user.service.atom.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.slp.user.dao.mapper.bo.UcBankInfo;
import com.ai.slp.user.dao.mapper.bo.UcBankInfoCriteria;
import com.ai.slp.user.dao.mapper.interfaces.UcBankInfoMapper;
import com.ai.slp.user.service.atom.interfaces.IUcBankInfoAtomSV;

@Component
public class UcBankInfoAtomSVImpl implements IUcBankInfoAtomSV {
    @Autowired
    private transient UcBankInfoMapper bankInfoMapper;
    
    @Override
    public int insert(UcBankInfo record) {
        return bankInfoMapper.insert(record);
    }

    @Override
    public int updateByExampleSelective(UcBankInfo record, UcBankInfoCriteria example) {
        return bankInfoMapper.updateByExampleSelective(record, example);
    }

    @Override
    public List<UcBankInfo> selectByExample(UcBankInfoCriteria example) {
        return bankInfoMapper.selectByExample(example);
    }

    @Override
    public int countByExample(UcBankInfoCriteria example) {
        return bankInfoMapper.countByExample(example);
    }

}
