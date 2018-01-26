package com.ai.slp.user.service.atom.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.slp.user.dao.mapper.bo.UcApiInfo;
import com.ai.slp.user.dao.mapper.bo.UcApiInfoCriteria;
import com.ai.slp.user.dao.mapper.interfaces.UcApiInfoMapper;
import com.ai.slp.user.service.atom.interfaces.IApiInfoAtomSV;

@Component
public class ApiInfoAtomSVImpl implements IApiInfoAtomSV {

    @Autowired
    private transient UcApiInfoMapper apiInfoMapper;

    @Override
    public int deleteByExample(UcApiInfoCriteria example) {
        return apiInfoMapper.deleteByExample(example);
    }

    @Override
    public int insert(UcApiInfo record) {
        return apiInfoMapper.insert(record);
    }

    @Override
    public List<UcApiInfo> selectByExample(UcApiInfoCriteria example) {
        return apiInfoMapper.selectByExample(example);
    }

    @Override
    public int updateByExampleSelective(UcApiInfo record, UcApiInfoCriteria example) {
        return apiInfoMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int countByExample(UcApiInfoCriteria example) {
        return apiInfoMapper.countByExample(example);
    }

}
