package com.ai.slp.user.service.business.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.BaseResponse;
import com.ai.opt.base.vo.PageInfo;
import com.ai.opt.base.vo.ResponseHeader;
import com.ai.opt.sdk.util.CollectionUtil;
import com.ai.opt.sdk.util.StringUtil;
import com.ai.slp.user.api.contactsinfo.param.InsertContactsInfoRequest;
import com.ai.slp.user.api.contactsinfo.param.QueryContactsInfoRequest;
import com.ai.slp.user.api.contactsinfo.param.QueryContactsInfoResponse;
import com.ai.slp.user.api.contactsinfo.param.QueryContactsInfoSingleRequest;
import com.ai.slp.user.api.contactsinfo.param.QueryContactsInfoSingleResponse;
import com.ai.slp.user.api.contactsinfo.param.UcContactsInfoParams;
import com.ai.slp.user.api.contactsinfo.param.UpdateContactsInfoRequest;
import com.ai.slp.user.constants.ExceptCodeConstants;
import com.ai.slp.user.dao.mapper.bo.UcContactsInfo;
import com.ai.slp.user.dao.mapper.bo.UcContactsInfoCriteria;
import com.ai.slp.user.service.atom.interfaces.IUcContactsInfoAtomSV;
import com.ai.slp.user.service.business.interfaces.IUcContactsInfoBusiSV;
import com.ai.slp.user.util.DateUtils;
import com.ai.slp.user.util.SequenceUtil;

@Service
@Transactional
public class UcContactsInfoBusiSVImpl implements IUcContactsInfoBusiSV {

    private static final Log LOG = LogFactory.getLog(UcContactsInfoBusiSVImpl.class);

    @Autowired
    private IUcContactsInfoAtomSV ucContactsInfoAtomSV;

    @Override
    public BaseResponse insertContactsInfo(InsertContactsInfoRequest contactsInfoRequest)
            throws BusinessException, SystemException {
        UcContactsInfo ucContactsInfo = new UcContactsInfo();
        BeanUtils.copyProperties(contactsInfoRequest, ucContactsInfo);
        ucContactsInfo.setContactSeqId(SequenceUtil.createContactSeqId());
        ucContactsInfo.setCreateTime(DateUtils.currTimeStamp());

        BaseResponse response = new BaseResponse();
        ResponseHeader responseHeader;
        try {
            ucContactsInfoAtomSV.insert(ucContactsInfo);
            responseHeader = new ResponseHeader(true, "success", "添加成功");
        } catch (Exception e) {
            LOG.error("添加失败", e);
            responseHeader = new ResponseHeader(false, "fail", "添加失败");
        }
        response.setResponseHeader(responseHeader);
        return response;
    }

    @Override
    public BaseResponse updateContactsInfo(UpdateContactsInfoRequest contactsInfoRequest)
            throws BusinessException, SystemException {
        UcContactsInfo ucContactsInfo = new UcContactsInfo();
        BeanUtils.copyProperties(contactsInfoRequest, ucContactsInfo);
        ucContactsInfo.setUpdateTime(DateUtils.currTimeStamp());

        UcContactsInfoCriteria example = new UcContactsInfoCriteria();
        UcContactsInfoCriteria.Criteria criteria = example.createCriteria();
        criteria.andTenantIdEqualTo(contactsInfoRequest.getTenantId());
        criteria.andUserIdEqualTo(contactsInfoRequest.getUserId());
        BaseResponse response = new BaseResponse();
        ResponseHeader responseHeader;
        try {
            ucContactsInfoAtomSV.updateByExampleSelective(ucContactsInfo, example);
            responseHeader = new ResponseHeader(true, "success", "更新成功");
        } catch (Exception e) {
            LOG.error("更新失败", e);
            responseHeader = new ResponseHeader(false, "fail", "更新失败");
        }
        response.setResponseHeader(responseHeader);
        return response;
    }

    @Override
    public QueryContactsInfoResponse queryContactsInfo(
            QueryContactsInfoRequest contactsInfoRequest)
                    throws BusinessException, SystemException {
        UcContactsInfoCriteria example = new UcContactsInfoCriteria();
        UcContactsInfoCriteria.Criteria criteria = example.createCriteria();
        criteria.andTenantIdEqualTo(contactsInfoRequest.getTenantId());
        criteria.andUserIdEqualTo(contactsInfoRequest.getUserId());

        QueryContactsInfoResponse response = new QueryContactsInfoResponse();
        List<UcContactsInfoParams> responseList = new ArrayList<UcContactsInfoParams>();
        ResponseHeader responseHeader;

        Integer pageNo = contactsInfoRequest.getPageNo();
        Integer pageSize = contactsInfoRequest.getPageSize();
        List<UcContactsInfo> list = new ArrayList<UcContactsInfo>();
        int count = 0;
        try {
            count = ucContactsInfoAtomSV.countByExample(example);
            list = ucContactsInfoAtomSV.selectByExample(example);
            responseHeader = new ResponseHeader(true, "success", "查询成功");
        } catch (Exception e) {
            LOG.error("查询失败", e);
            responseHeader = new ResponseHeader(false, "fail", "查询失败");
        }
        for (UcContactsInfo ucContactsInfo : list) {
            UcContactsInfoParams ucContactsInfoParams = new UcContactsInfoParams();
            BeanUtils.copyProperties(ucContactsInfo, ucContactsInfoParams);
            responseList.add(ucContactsInfoParams);
        }
        PageInfo<UcContactsInfoParams> pageInfo = new PageInfo<UcContactsInfoParams>();
        pageInfo.setCount(count);
        pageInfo.setPageNo(pageNo);
        pageInfo.setPageSize(pageSize);
        pageInfo.setResult(responseList);
        response.setPageInfo(pageInfo);
        response.setResponseHeader(responseHeader);
        return response;
    }

    @Override
    public QueryContactsInfoSingleResponse queryContactsInfoSingle(
            QueryContactsInfoSingleRequest contactsInfoRequest)
            throws BusinessException, SystemException {
        UcContactsInfoCriteria example = new UcContactsInfoCriteria();
        UcContactsInfoCriteria.Criteria criteria = example.createCriteria();
        criteria.andTenantIdEqualTo(contactsInfoRequest.getTenantId());
        if(!StringUtil.isBlank(contactsInfoRequest.getUserId())){
            criteria.andUserIdEqualTo(contactsInfoRequest.getUserId());
        }
        if(!StringUtil.isBlank(contactsInfoRequest.getContactMp())){
            criteria.andContactMpEqualTo(contactsInfoRequest.getContactMp());
        }
        List<UcContactsInfo> list = ucContactsInfoAtomSV.selectByExample(example);
        QueryContactsInfoSingleResponse response = new QueryContactsInfoSingleResponse();
        ResponseHeader responseHeader = new ResponseHeader();
        if (!CollectionUtil.isEmpty(list)) {
            BeanUtils.copyProperties(list.get(0), response);
            responseHeader = new ResponseHeader(true, ExceptCodeConstants.SUCCESS, "数据查询成功");
        }else{
            responseHeader = new ResponseHeader(true, ExceptCodeConstants.NO_RESULT, "数据不存在");
        }
        response.setResponseHeader(responseHeader);
        return response;
    }

}
