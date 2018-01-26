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
import com.ai.opt.sdk.components.sequence.util.SeqUtil;
import com.ai.slp.user.api.apiinfo.param.ApiInfoRequest;
import com.ai.slp.user.api.apiinfo.param.ApiInfoResponse;
import com.ai.slp.user.api.apiinfo.param.InsertApiInfoRequest;
import com.ai.slp.user.api.apiinfo.param.UcApiInfoParams;
import com.ai.slp.user.dao.mapper.bo.UcApiInfo;
import com.ai.slp.user.dao.mapper.bo.UcApiInfoCriteria;
import com.ai.slp.user.service.atom.interfaces.IApiInfoAtomSV;
import com.ai.slp.user.service.business.interfaces.IApiInfoBusiSV;
import com.ai.slp.user.util.DateUtils;

@Service
@Transactional
public class ApiInfoBusiSVImpl implements IApiInfoBusiSV {

    private static final Log LOG = LogFactory.getLog(ApiInfoBusiSVImpl.class);

    @Autowired
    private IApiInfoAtomSV apiInfoAtomSV;

    @Override
    public BaseResponse insertApiInfo(InsertApiInfoRequest infoRequest)
            throws BusinessException, SystemException {
        UcApiInfo ucApiInfo = new UcApiInfo();
        BeanUtils.copyProperties(infoRequest, ucApiInfo);
        ucApiInfo.setUserId(infoRequest.getUserId());
        ucApiInfo.setApiSeqId(SeqUtil.getNewId("UC_API_INFO$API_SEQ_ID$SEQ", 10));
        ucApiInfo.setCreateTime(DateUtils.currTimeStamp());
        ResponseHeader responseHeader;
        try {
            apiInfoAtomSV.insert(ucApiInfo);
            responseHeader = new ResponseHeader(true, "success", "添加成功");
        } catch (Exception e) {
            LOG.error("操作失败", e);
            responseHeader = new ResponseHeader(false, "fail", "添加失败");
        }
        BaseResponse response = new BaseResponse();
        response.setResponseHeader(responseHeader);
        return response;
    }

    @Override
    public BaseResponse updateApiInfo(UcApiInfoParams ucApiInfoParams)
            throws BusinessException, SystemException {
        UcApiInfo ucApiInfo = new UcApiInfo();
        BeanUtils.copyProperties(ucApiInfoParams, ucApiInfo);
        ucApiInfo.setUpdateTime(DateUtils.currTimeStamp());

        UcApiInfoCriteria example = new UcApiInfoCriteria();
        UcApiInfoCriteria.Criteria criteria = example.createCriteria();
        criteria.andTenantIdEqualTo(ucApiInfoParams.getTenantId());
        
        criteria.andUserIdEqualTo(ucApiInfo.getUserId());
        criteria.andApiSeqIdEqualTo(ucApiInfoParams.getApiSeqId());
        BaseResponse response = new BaseResponse();
        ResponseHeader responseHeader;
        try {
            apiInfoAtomSV.updateByExampleSelective(ucApiInfo, example);
            responseHeader = new ResponseHeader(true, "success", "更新失败");
        } catch (Exception e) {
            LOG.error("更新失败", e);
            responseHeader = new ResponseHeader(false, "fail", "更新失败");
        }
        response.setResponseHeader(responseHeader);
        return response;
    }

    @Override
    public ApiInfoResponse queryApiInfo(ApiInfoRequest apiInfoRequest)
            throws BusinessException, SystemException {

        UcApiInfoCriteria example = new UcApiInfoCriteria();
        UcApiInfoCriteria.Criteria criteria = example.createCriteria();
        criteria.andTenantIdEqualTo(apiInfoRequest.getTenantId());
        criteria.andUserIdEqualTo(apiInfoRequest.getUserId());

        Integer pageNo = apiInfoRequest.getPageNo();
        Integer pageSize = apiInfoRequest.getPageSize();
        List<UcApiInfo> list = new ArrayList<UcApiInfo>();
        int count = 0;
        ResponseHeader responseHeader;
        try {
            count = apiInfoAtomSV.countByExample(example);
            list = apiInfoAtomSV.selectByExample(example);
            responseHeader = new ResponseHeader(true, "success", "查寻失败");
        } catch (Exception e) {
            LOG.error("查询失败");
            responseHeader = new ResponseHeader(false, "fail", "查询失败");
        }
        ApiInfoResponse response = new ApiInfoResponse();
        List<UcApiInfoParams> responseList = new ArrayList<UcApiInfoParams>();
        for (UcApiInfo ucApiInfo : list) {
            UcApiInfoParams ucApiInfoParams = new UcApiInfoParams();
            BeanUtils.copyProperties(ucApiInfo, ucApiInfoParams);
            responseList.add(ucApiInfoParams);
        }
        response.setResponseHeader(responseHeader);
        PageInfo<UcApiInfoParams> pageInfo = new PageInfo<UcApiInfoParams>();
        pageInfo.setCount(count);
        pageInfo.setPageNo(pageNo);
        pageInfo.setPageSize(pageSize);
        pageInfo.setResult(responseList);
        response.setPageInfo(pageInfo);
        response.setResponseHeader(responseHeader);
        return response;
    }

}
