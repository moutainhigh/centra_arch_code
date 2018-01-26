package com.ai.slp.user.service.atom.impl;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.slp.user.dao.mapper.bo.UcBankInfo;
import com.ai.slp.user.dao.mapper.bo.UcContactsInfo;
import com.ai.slp.user.dao.mapper.bo.UcContactsInfoCriteria;
import com.ai.slp.user.dao.mapper.bo.UcCustKeyInfo;
import com.ai.slp.user.dao.mapper.bo.UcCustKeyInfoCriteria;
import com.ai.slp.user.dao.mapper.bo.UcGroupKeyInfo;
import com.ai.slp.user.dao.mapper.bo.UcGroupKeyInfoCriteria;
import com.ai.slp.user.dao.mapper.bo.UcStateChg;
import com.ai.slp.user.dao.mapper.bo.UcStateChgCriteria;
import com.ai.slp.user.dao.mapper.bo.UcUser;
import com.ai.slp.user.dao.mapper.bo.UcUserAgree;
import com.ai.slp.user.dao.mapper.bo.UcUserAgreeCriteria;
import com.ai.slp.user.dao.mapper.bo.UcUserCriteria;
import com.ai.slp.user.dao.mapper.interfaces.UcBankInfoMapper;
import com.ai.slp.user.dao.mapper.interfaces.UcContactsInfoMapper;
import com.ai.slp.user.dao.mapper.interfaces.UcCustKeyInfoMapper;
import com.ai.slp.user.dao.mapper.interfaces.UcGroupKeyInfoMapper;
import com.ai.slp.user.dao.mapper.interfaces.UcStateChgMapper;
import com.ai.slp.user.dao.mapper.interfaces.UcUserAgreeMapper;
import com.ai.slp.user.dao.mapper.interfaces.UcUserMapper;
import com.ai.slp.user.service.atom.interfaces.IRegisterAtomSV;

@Component
public class RegisterAtomSVImpl implements IRegisterAtomSV {

    @Autowired
    private transient UcUserMapper ucUserMapper;

    @Autowired
    private transient UcGroupKeyInfoMapper groupKeyInfoMapper;

    @Autowired
    private transient UcContactsInfoMapper contactsInfoMapper;

    @Autowired
    private transient UcUserAgreeMapper userAgreeMapper;

    @Autowired
    private transient UcStateChgMapper stateChgMapper;

    @Autowired
    private transient UcCustKeyInfoMapper custKeyInfoMapper;

    @Autowired
    private transient UcUserMapper userMapper;

    @Autowired
    private transient UcBankInfoMapper bankInfoMapper;

    @Override
    public int insertUserInfo(UcUser user) {
        return ucUserMapper.insert(user);
    }

    @Override
    public List<UcUser> getUserInfo(UcUserCriteria criteria) {
        return ucUserMapper.selectByExample(criteria);
    }

    @Override
    public int insertUcGroupKeyInfo(UcGroupKeyInfo ucGroupKey) {
        return groupKeyInfoMapper.insert(ucGroupKey);
    }

    @Override
    public List<UcGroupKeyInfo> getUcGroupKeyInfo(UcGroupKeyInfoCriteria criteria) {
        return groupKeyInfoMapper.selectByExample(criteria);
    }

    @Override
    public int insertUcContactsInfo(UcContactsInfo ucContactsInfo) {

        return contactsInfoMapper.insert(ucContactsInfo);
    }

    @Override
    public void InsertUcUserAgreeAtomSv(UcUserAgree record) {
        userAgreeMapper.insert(record);
    }

    @Override
    public int updateUcStateChgBusiInfo(@Param("record") UcStateChg record,
            @Param("example") UcStateChgCriteria example) {
        return stateChgMapper.updateByExample(record, example);
    }

    @Override
    public int insertUcStateChgBusiInfo(UcStateChg ucStateChgParam) {
        return stateChgMapper.insert(ucStateChgParam);
    }

    @Override
    public int insertUcBankInfo(UcBankInfo ucBankInfo) {
        return bankInfoMapper.insert(ucBankInfo);
    }

    @Override
    public int insertUcCustKeyInfo(UcCustKeyInfo ucContactsInfo) {
        return custKeyInfoMapper.insert(ucContactsInfo);
    }

    @Override
    public int updateUserInfo(UcUser record, UcUserCriteria example) {
        return userMapper.updateByExample(record, example);
    }

    @Override
    public int updateGroupKeyInfo(UcGroupKeyInfo record, UcGroupKeyInfoCriteria example) {
        return groupKeyInfoMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateUserAgree(UcUserAgree record, UcUserAgreeCriteria example) {
        return userAgreeMapper.updateByExample(record, example);
    }

    @Override
    public int updateCustKeyInfo(UcCustKeyInfo record, UcCustKeyInfoCriteria example) {
        return custKeyInfoMapper.updateByExample(record, example);
    }

    @Override
    public List<UcCustKeyInfo> getUcCustKeyInfo(UcCustKeyInfoCriteria criteria) {
        return custKeyInfoMapper.selectByExample(criteria);
    }

    @Override
    public List<UcContactsInfo> getUcContactsInfo(UcContactsInfoCriteria criteria) {
        return contactsInfoMapper.selectByExample(criteria);
    }

}
