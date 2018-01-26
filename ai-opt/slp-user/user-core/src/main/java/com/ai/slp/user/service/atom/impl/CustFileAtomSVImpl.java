package com.ai.slp.user.service.atom.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.slp.user.dao.mapper.bo.CmCustFileExt;
import com.ai.slp.user.dao.mapper.bo.CmCustFileExtCriteria;
import com.ai.slp.user.dao.mapper.interfaces.CmCustFileExtMapper;
import com.ai.slp.user.service.atom.interfaces.ICustFileAtomSV;

@Component
public class CustFileAtomSVImpl implements ICustFileAtomSV {

    @Autowired
    private transient CmCustFileExtMapper cmCustFileExtMapper;
    
    @Override
    public int insert(CmCustFileExt record) {
        return cmCustFileExtMapper.insert(record);
    }

    @Override
    public List<CmCustFileExt> selectByExample(CmCustFileExtCriteria example) {
        return cmCustFileExtMapper.selectByExample(example);
    }

    @Override
    public int updateByExampleSelective(CmCustFileExt record, CmCustFileExtCriteria example) {
        return cmCustFileExtMapper.updateByExampleSelective(record, example);
    }

}
