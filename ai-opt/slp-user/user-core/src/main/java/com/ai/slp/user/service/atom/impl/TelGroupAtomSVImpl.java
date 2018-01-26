package com.ai.slp.user.service.atom.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.slp.user.dao.mapper.bo.UcTelGroup;
import com.ai.slp.user.dao.mapper.bo.UcTelGroupCriteria;
import com.ai.slp.user.dao.mapper.interfaces.UcTelGroupMapper;
import com.ai.slp.user.service.atom.interfaces.IUcTelGroupAtomSV;

@Component
public class TelGroupAtomSVImpl implements IUcTelGroupAtomSV {
    @Autowired
    private transient UcTelGroupMapper telGroupMapper;

    @Override
    public void insertUcTelGroupInfo(UcTelGroup contactsGroup) {
        telGroupMapper.insert(contactsGroup);
    }

    @Override
    public List<UcTelGroup> selectUcTelGroupInfo(UcTelGroupCriteria ucTelGroupCriteria) {
        List<UcTelGroup> result = telGroupMapper.selectByExample(ucTelGroupCriteria);
        return result;
    }

    @Override
    public void updateUcTelGroupInfo(UcTelGroup contactsGroup, UcTelGroupCriteria example) {
        telGroupMapper.updateByExample(contactsGroup, example);
    }

    @Override
    public int countUcTelGroupInfo(UcTelGroupCriteria example) {
        return telGroupMapper.countByExample(example);
    }

    @Override
    public void deleteUcTelGroupInfo(UcTelGroupCriteria example) {
        telGroupMapper.deleteByExample(example);
    }

}
