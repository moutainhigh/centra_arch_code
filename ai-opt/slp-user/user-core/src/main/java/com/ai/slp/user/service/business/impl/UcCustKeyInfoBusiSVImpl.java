package com.ai.slp.user.service.business.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.slp.user.api.keyinfo.param.InsertCustKeyInfoRequest;
import com.ai.slp.user.api.keyinfo.param.SearchCustKeyInfoRequest;
import com.ai.slp.user.api.keyinfo.param.SearchCustKeyInfoResponse;
import com.ai.slp.user.api.keyinfo.param.UpdateCustKeyInfoRequest;
import com.ai.slp.user.dao.mapper.bo.UcCustKeyInfo;
import com.ai.slp.user.dao.mapper.bo.UcCustKeyInfoCriteria;
import com.ai.slp.user.service.atom.interfaces.IUcCustKeyInfoAtomSV;
import com.ai.slp.user.service.business.interfaces.IUcCustKeyInfoBusiSV;
import com.ai.slp.user.util.DateUtils;

@Component
@Transactional
public class UcCustKeyInfoBusiSVImpl implements IUcCustKeyInfoBusiSV {

    @Autowired
    private IUcCustKeyInfoAtomSV ucCustKeyInfoAtomSV;
    
    @Override
    public int insertCustKeyInfo(InsertCustKeyInfoRequest request)
            throws SystemException, BusinessException {
        UcCustKeyInfo record = new UcCustKeyInfo();
        BeanUtils.copyProperties(request, record);
        record.setCreateTime(DateUtils.currTimeStamp());
        return ucCustKeyInfoAtomSV.insert(record);
    }

    @Override
    public int updateCustKeyInfo(UpdateCustKeyInfoRequest request)
            throws SystemException, BusinessException {
        UcCustKeyInfoCriteria example = new UcCustKeyInfoCriteria();
        UcCustKeyInfoCriteria.Criteria criteria = example.createCriteria();
        criteria.andTenantIdEqualTo(request.getTenantId());
        criteria.andUserIdEqualTo(request.getUserId());
        
        UcCustKeyInfo record = new UcCustKeyInfo();
        BeanUtils.copyProperties(request, record);
        record.setUpdateTime(DateUtils.currTimeStamp());
        return ucCustKeyInfoAtomSV.updateByExampleSelective(record, example);
    }

    @Override
    public SearchCustKeyInfoResponse searchCustKeyInfo(SearchCustKeyInfoRequest request)
            throws SystemException, BusinessException {
        UcCustKeyInfoCriteria example = new UcCustKeyInfoCriteria();
        UcCustKeyInfoCriteria.Criteria criteria = example.createCriteria();
        criteria.andTenantIdEqualTo(request.getTenantId());
        criteria.andUserIdEqualTo(request.getUserId());
        
        List<UcCustKeyInfo> list = ucCustKeyInfoAtomSV.selectByExample(example);
        
        SearchCustKeyInfoResponse response = new SearchCustKeyInfoResponse();
        if(!list.isEmpty()){
            BeanUtils.copyProperties(list.get(0), response);
        }
        return response;
    }

}
