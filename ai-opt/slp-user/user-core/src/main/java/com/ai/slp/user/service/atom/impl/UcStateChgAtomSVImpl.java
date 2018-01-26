package com.ai.slp.user.service.atom.impl;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.slp.user.dao.mapper.bo.UcStateChg;
import com.ai.slp.user.dao.mapper.bo.UcStateChgCriteria;
import com.ai.slp.user.dao.mapper.interfaces.UcStateChgMapper;
import com.ai.slp.user.service.atom.interfaces.IUcStateChgAtomSV;

@Component
public class UcStateChgAtomSVImpl implements IUcStateChgAtomSV {
    @Autowired
    private transient UcStateChgMapper stateChgMapper;

    @Override
    public int insertUcStateChgBusiInfo(UcStateChg ucStateChgParam) {
        return stateChgMapper.insert(ucStateChgParam);
    }

    @Override
    public int updateUcStateChgBusiInfo(@Param("record") UcStateChg record,
            @Param("example") UcStateChgCriteria example) {
        return stateChgMapper.updateByExampleSelective(record, example);
    }

    @Override
    public List<UcStateChg> selectByExample(UcStateChgCriteria example) {
        return stateChgMapper.selectByExample(example);
    }

}
