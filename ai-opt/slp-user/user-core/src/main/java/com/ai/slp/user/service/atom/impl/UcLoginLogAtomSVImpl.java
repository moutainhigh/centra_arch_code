package com.ai.slp.user.service.atom.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.slp.user.dao.mapper.bo.UcLoginLog;
import com.ai.slp.user.dao.mapper.bo.UcLoginLogCriteria;
import com.ai.slp.user.dao.mapper.interfaces.UcLoginLogMapper;
import com.ai.slp.user.service.atom.interfaces.IUcLoginLogAtomSV;

@Component
public class UcLoginLogAtomSVImpl implements IUcLoginLogAtomSV {
    @Autowired
    private transient UcLoginLogMapper loginLogMapper;
    
    @Override
    public void insertUcLoginLogInfo(UcLoginLog ucLoginLog) {
        loginLogMapper.insert(ucLoginLog);
    }

    @Override
    public List<UcLoginLog> selectUcTelGroupInfo(UcLoginLogCriteria example) {
        return loginLogMapper.selectByExample(example);
    }

    @Override
    public int countUcTelGroupInfo(UcLoginLogCriteria example) {
        return loginLogMapper.countByExample(example);
    }

}
