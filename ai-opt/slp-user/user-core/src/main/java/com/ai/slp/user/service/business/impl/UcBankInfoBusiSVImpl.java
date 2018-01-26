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
import com.ai.opt.base.vo.PageInfo;
import com.ai.opt.base.vo.ResponseHeader;
import com.ai.slp.user.api.bankinfo.param.InsertBankInfoRequest;
import com.ai.slp.user.api.bankinfo.param.QueryBankInfoRequest;
import com.ai.slp.user.api.bankinfo.param.QueryBankInfoResponse;
import com.ai.slp.user.api.bankinfo.param.QueryBankInfoSingleRequest;
import com.ai.slp.user.api.bankinfo.param.QueryBankInfoSingleResponse;
import com.ai.slp.user.api.bankinfo.param.UcBankInfoParams;
import com.ai.slp.user.api.bankinfo.param.UpdateBankInfoRequest;
import com.ai.slp.user.dao.mapper.bo.UcBankInfo;
import com.ai.slp.user.dao.mapper.bo.UcBankInfoCriteria;
import com.ai.slp.user.service.atom.interfaces.IUcBankInfoAtomSV;
import com.ai.slp.user.service.business.interfaces.IUcBankInfoBusiSV;
import com.ai.slp.user.util.DateUtils;
import com.ai.slp.user.util.SequenceUtil;

@Service
@Transactional
public class UcBankInfoBusiSVImpl implements IUcBankInfoBusiSV {

    static final Log LOG = LogFactory.getLog(UcBankInfoBusiSVImpl.class);

    @Autowired
    private IUcBankInfoAtomSV ucBankInfoAtomSV;

    @Override
    public int insertBankInfo(InsertBankInfoRequest bankInfoRequest)
            throws BusinessException, SystemException {
        UcBankInfo ucBankInfo = new UcBankInfo();
        BeanUtils.copyProperties(bankInfoRequest, ucBankInfo);
        ucBankInfo.setBankSeqId(SequenceUtil.createBankSeqId());
        ucBankInfo.setCreateTime(DateUtils.currTimeStamp());
        return ucBankInfoAtomSV.insert(ucBankInfo);
    }

    @Override
    public int UpdateBankInfo(UpdateBankInfoRequest bankInfoRequest)
            throws BusinessException, SystemException {
        UcBankInfo bankInfo = new UcBankInfo();
        BeanUtils.copyProperties(bankInfoRequest, bankInfo);
        UcBankInfoCriteria example = new UcBankInfoCriteria();
        UcBankInfoCriteria.Criteria criteria = example.createCriteria();
        criteria.andTenantIdEqualTo(bankInfoRequest.getTenantId());
        criteria.andUserIdEqualTo(bankInfoRequest.getUserId());
        return ucBankInfoAtomSV.updateByExampleSelective(bankInfo, example);
    }

    @Override
    public QueryBankInfoResponse queryBankInfo(QueryBankInfoRequest bankInfoRequest)
            throws BusinessException, SystemException {
        UcBankInfoCriteria example = new UcBankInfoCriteria();
        UcBankInfoCriteria.Criteria criteria = example.createCriteria();
        criteria.andTenantIdEqualTo(bankInfoRequest.getTenantId());
        criteria.andUserIdEqualTo(bankInfoRequest.getUserId());
        Integer pageNo = bankInfoRequest.getPageNo();
        Integer pageSize = bankInfoRequest.getPageSize();
        List<UcBankInfo> list = new ArrayList<UcBankInfo>();
        int count = 0;
        QueryBankInfoResponse response = new QueryBankInfoResponse();
        ResponseHeader responseHeader;
        try {
            count = ucBankInfoAtomSV.countByExample(example);
            list = ucBankInfoAtomSV.selectByExample(example);
            responseHeader = new ResponseHeader(true, "success", "查询成功");
        } catch (Exception e) {
            LOG.error("查询失败", e);
            responseHeader = new ResponseHeader(false, "fail", "查询失败");
        }
        PageInfo<UcBankInfoParams> pageInfo = new PageInfo<UcBankInfoParams>();
        List<UcBankInfoParams> responseList = new ArrayList<UcBankInfoParams>();
        for (UcBankInfo ucBankInfo : list) {
            UcBankInfoParams ucBankInfoParams = new UcBankInfoParams();
            BeanUtils.copyProperties(ucBankInfo, ucBankInfoParams);
            responseList.add(ucBankInfoParams);
        }
        pageInfo.setCount(count);
        pageInfo.setPageNo(pageNo);
        pageInfo.setPageSize(pageSize);
        pageInfo.setResult(responseList);
        response.setPageInfo(pageInfo);
        response.setResponseHeader(responseHeader);
        return response;
    }

    @Override
    public QueryBankInfoSingleResponse queryBankInfoSingle(QueryBankInfoSingleRequest bankInfoRequest)
            throws BusinessException, SystemException {
        UcBankInfoCriteria example = new UcBankInfoCriteria();
        UcBankInfoCriteria.Criteria criteria =example.createCriteria();
        criteria.andTenantIdEqualTo(bankInfoRequest.getTenantId());
        criteria.andUserIdEqualTo(bankInfoRequest.getUserId());
        
        List<UcBankInfo> list= ucBankInfoAtomSV.selectByExample(example);
        QueryBankInfoSingleResponse response = new QueryBankInfoSingleResponse();
        if(!list.isEmpty()){
            BeanUtils.copyProperties(list.get(0), response);
        }
        return response;
    }

}
