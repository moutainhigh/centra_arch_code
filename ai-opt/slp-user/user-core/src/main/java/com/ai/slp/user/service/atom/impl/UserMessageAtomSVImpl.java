package com.ai.slp.user.service.atom.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.slp.user.dao.mapper.bo.UcUserMessage;
import com.ai.slp.user.dao.mapper.bo.UcUserMessageCriteria;
import com.ai.slp.user.dao.mapper.interfaces.UcUserMessageMapper;
import com.ai.slp.user.service.atom.interfaces.IUserMessageAtomSV;

@Component
public class UserMessageAtomSVImpl implements IUserMessageAtomSV {

    @Autowired
    private transient UcUserMessageMapper userMessageMapper;
    
    @Override
    public int deleteByExample(UcUserMessageCriteria example) {
        return userMessageMapper.deleteByExample(example);
    }

    @Override
    public int insert(UcUserMessage record) {
        return userMessageMapper.insert(record);
    }

    @Override
    public int updateByExampleSelective(UcUserMessage record, UcUserMessageCriteria example) {
        return userMessageMapper.updateByExampleSelective(record, example);
    }

    @Override
    public List<UcUserMessage> selectByExample(UcUserMessageCriteria example) {
        return userMessageMapper.selectByExample(example);
    }

    @Override
    public int countByExample(UcUserMessageCriteria example) {
        return userMessageMapper.countByExample(example);
    }

}
