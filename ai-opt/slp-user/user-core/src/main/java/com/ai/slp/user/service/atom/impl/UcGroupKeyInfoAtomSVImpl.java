package com.ai.slp.user.service.atom.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.slp.user.api.keyinfo.param.QueryGroupInfoRequest;
import com.ai.slp.user.api.keyinfo.param.SearchGroupKeyInfoRequest;
import com.ai.slp.user.api.keyinfo.param.SearchGroupUserInfoResponse;
import com.ai.slp.user.api.keyinfo.param.UcGroupKeyInfoVo;
import com.ai.slp.user.dao.mapper.attach.UcGroupKeyInfoAttrAttachMapper;
import com.ai.slp.user.dao.mapper.bo.UcGroupKeyInfo;
import com.ai.slp.user.dao.mapper.bo.UcGroupKeyInfoCriteria;
import com.ai.slp.user.dao.mapper.interfaces.UcGroupKeyInfoMapper;
import com.ai.slp.user.service.atom.interfaces.IUcGroupKeyInfoAtomSV;

@Component
public class UcGroupKeyInfoAtomSVImpl implements IUcGroupKeyInfoAtomSV {

    @Autowired
    private UcGroupKeyInfoMapper ucGroupKeyInfoMapper;
    
    @Autowired
    private UcGroupKeyInfoAttrAttachMapper groupKeyInfoAttachMapper;
    
    @Override
    public int insert(UcGroupKeyInfo record) {
        return ucGroupKeyInfoMapper.insert(record);
    }

    @Override
    public List<UcGroupKeyInfo> selectByExample(UcGroupKeyInfoCriteria example) {
        return ucGroupKeyInfoMapper.selectByExample(example);
    }

    @Override
    public int updateByExampleSelective(UcGroupKeyInfo record, UcGroupKeyInfoCriteria example) {
        return ucGroupKeyInfoMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int countByExample(UcGroupKeyInfoCriteria example) {
        return ucGroupKeyInfoMapper.countByExample(example);
    }

    @Override
    public SearchGroupUserInfoResponse searchGroupUserInfo(SearchGroupKeyInfoRequest groupKeyInfo) {
        return groupKeyInfoAttachMapper.selectGroupUserInfo(groupKeyInfo.getTenantId(), groupKeyInfo.getUserId(), groupKeyInfo.getAuditState());
    }

    @Override
    public List<UcGroupKeyInfoVo> searchGroupKeyInfo(
            QueryGroupInfoRequest groupKeyInfo,int startPage,int endPage) {
        return groupKeyInfoAttachMapper.selectGroupKeyInfo(groupKeyInfo.getTenantId(), groupKeyInfo.getCustName(),groupKeyInfo.getUserType(),groupKeyInfo.getAuditState(),startPage,endPage);
    }

    @Override
    public int selectCountGroupKeyInfo(QueryGroupInfoRequest groupKeyInfo) {
        return groupKeyInfoAttachMapper.selectCountGroupKeyInfo(groupKeyInfo.getTenantId(), groupKeyInfo.getCustName(),groupKeyInfo.getAuditState(),groupKeyInfo.getUserType());
    }
    
    
    
    
}
