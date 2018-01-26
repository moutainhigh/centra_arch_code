package com.ai.slp.user.service.atom.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.slp.user.dao.mapper.bo.UcUserPhonebooks;
import com.ai.slp.user.dao.mapper.bo.UcUserPhonebooksCriteria;
import com.ai.slp.user.dao.mapper.interfaces.UcTelGroupMapper;
import com.ai.slp.user.dao.mapper.interfaces.UcUserPhonebooksMapper;
import com.ai.slp.user.service.atom.interfaces.IUcUserPhoneBooksAtomSV;

@Component
public class UcUserPhoneBooksAtomSVImpl implements IUcUserPhoneBooksAtomSV {

    @Autowired
    private transient UcUserPhonebooksMapper userPhonebooksMapper;

    @Autowired
    private transient UcTelGroupMapper telGroupMapper;

    @Override
    public void insertUserPhoneBooksInfo(UcUserPhonebooks record) {
        userPhonebooksMapper.insert(record);
    }

    @Override
    public void updateUserPhoneBooksInfo(UcUserPhonebooks record,
            UcUserPhonebooksCriteria example) {
        userPhonebooksMapper.updateByExample(record, example);
    }

    @Override
    public void deleteUserPhoneBooksInfo(UcUserPhonebooksCriteria example) {
        userPhonebooksMapper.deleteByExample(example);
    }

    @Override
    public List<UcUserPhonebooks> selectUcTelGroupInfo(UcUserPhonebooksCriteria example) {
        List<UcUserPhonebooks> list = userPhonebooksMapper.selectByExample(example);
        return list;
    }

    @Override
    public int countUcTelGroupInfo(UcUserPhonebooksCriteria example) {
        return userPhonebooksMapper.countByExample(example);
    }

}
