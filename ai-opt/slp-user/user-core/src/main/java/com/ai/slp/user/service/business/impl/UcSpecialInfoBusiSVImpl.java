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
import com.ai.opt.base.vo.ResponseHeader;
import com.ai.slp.user.api.specialinfo.param.InsertSpecialInfoRequest;
import com.ai.slp.user.api.specialinfo.param.QuerySpecialInfoRequest;
import com.ai.slp.user.api.specialinfo.param.QuerySpecialInfoResponse;
import com.ai.slp.user.api.specialinfo.param.UpdateSepcialInfoRequest;
import com.ai.slp.user.dao.mapper.bo.UcSpecialInfo;
import com.ai.slp.user.dao.mapper.bo.UcSpecialInfoCriteria;
import com.ai.slp.user.service.atom.interfaces.IUcSpecialInfoAtomSV;
import com.ai.slp.user.service.business.interfaces.IUcSpecialInfoBusiSV;
import com.ai.slp.user.util.DateUtils;
import com.ai.slp.user.util.SequenceUtil;

@Service
@Transactional
public class UcSpecialInfoBusiSVImpl implements IUcSpecialInfoBusiSV {

    private static final Log LOG = LogFactory.getLog(UcSpecialInfoBusiSVImpl.class);

    @Autowired
    private IUcSpecialInfoAtomSV ucSpecialInfoAtomSV;

    @Override
    public BaseResponse insertSpecialInfo(InsertSpecialInfoRequest specialInfoRequest)
            throws BusinessException, SystemException {
        UcSpecialInfo ucSpecialInfo = new UcSpecialInfo();
        ucSpecialInfo.setInfoSpecialId(SequenceUtil.createInfoSpecialId());
        BeanUtils.copyProperties(specialInfoRequest, ucSpecialInfo);
        ucSpecialInfo.setCreateTime(DateUtils.currTimeStamp());
        BaseResponse response = new BaseResponse();
        ResponseHeader responseHeader;
        try {
            ucSpecialInfoAtomSV.insert(ucSpecialInfo);
            responseHeader = new ResponseHeader(true, "success", "插入成功");
        } catch (Exception e) {
            LOG.error("插入失败", e);
            responseHeader = new ResponseHeader(false, "fail", "插入失败");
        }
        response.setResponseHeader(responseHeader);
        return response;
    }

    @Override
    public BaseResponse updateSpecialInfo(UpdateSepcialInfoRequest specialInfoRequest)
            throws BusinessException, SystemException {
        UcSpecialInfo ucSpecialInfo = new UcSpecialInfo();
        BeanUtils.copyProperties(specialInfoRequest, ucSpecialInfo);
        ucSpecialInfo.setUpdateTime(DateUtils.currTimeStamp());
        UcSpecialInfoCriteria example = new UcSpecialInfoCriteria();
        UcSpecialInfoCriteria.Criteria criteria = example.createCriteria();
        criteria.andTenantIdEqualTo(specialInfoRequest.getTenantId());
        criteria.andUserIdEqualTo(specialInfoRequest.getUserId());
        criteria.andInfoSpecialIdEqualTo(specialInfoRequest.getInfoSpecialId());

        BaseResponse response = new BaseResponse();
        ResponseHeader responseHeader;
        try {
            ucSpecialInfoAtomSV.updateByExampleSelective(ucSpecialInfo, example);
            responseHeader = new ResponseHeader(true, "success", "更新成功");
        } catch (Exception e) {
            LOG.error("更新失败", e);
            responseHeader = new ResponseHeader(false, "fail", "更新失败");
        }
        response.setResponseHeader(responseHeader);
        return response;
    }

    @Override
    public QuerySpecialInfoResponse querySpecialInfo(QuerySpecialInfoRequest specialInfoRequest)
            throws BusinessException, SystemException {
        UcSpecialInfoCriteria example = new UcSpecialInfoCriteria();
        UcSpecialInfoCriteria.Criteria criteria = example.createCriteria();
        criteria.andTenantIdEqualTo(specialInfoRequest.getTenantId());
        criteria.andUserIdEqualTo(specialInfoRequest.getUserId());
        criteria.andInfoSpecialIdEqualTo(specialInfoRequest.getSpecialInfoId());

        List<UcSpecialInfo> list = new ArrayList<UcSpecialInfo>();
        ResponseHeader responseHeader;
        try {
            list = ucSpecialInfoAtomSV.selectByExample(example);
            responseHeader = new ResponseHeader(true, "success", "查询成功");
        } catch (Exception e) {
            LOG.error("查询失败", e);
            responseHeader = new ResponseHeader(false, "fail", "查询失败");
        }
        QuerySpecialInfoResponse response = new QuerySpecialInfoResponse();
        BeanUtils.copyProperties(list.get(0), response);
        response.setResponseHeader(responseHeader);
        return response;
    }

}
