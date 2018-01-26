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
import com.ai.opt.sdk.util.StringUtil;
import com.ai.slp.user.api.safari.param.DeleteSafariHisRequest;
import com.ai.slp.user.api.safari.param.DeleteSafariRequest;
import com.ai.slp.user.api.safari.param.InsertUserSafariRequest;
import com.ai.slp.user.api.safari.param.UserSafariInfoParams;
import com.ai.slp.user.api.safari.param.UserSafariInfoRequest;
import com.ai.slp.user.api.safari.param.UserSafariInfoResponse;
import com.ai.slp.user.dao.mapper.bo.UcUserSafari;
import com.ai.slp.user.dao.mapper.bo.UcUserSafariCriteria;
import com.ai.slp.user.dao.mapper.bo.UcUserSafariHisCriteria;
import com.ai.slp.user.service.atom.interfaces.IUserSafariAtomSV;
import com.ai.slp.user.service.atom.interfaces.IUserSafariHisAtomSV;
import com.ai.slp.user.service.business.interfaces.IUserSafariBusiSV;
import com.ai.slp.user.util.DateUtils;
import com.ai.slp.user.util.SequenceUtil;

@Service
@Transactional
public class UserSafariBusiSVImpl implements IUserSafariBusiSV {
    private final static Log LOG = LogFactory.getLog(UserSafariBusiSVImpl.class);

    @Autowired
    private IUserSafariAtomSV userSafariAtomSV;

    @Autowired
    private IUserSafariHisAtomSV userSafariHisAtomSV;

    @Override
    public BaseResponse insertUserSafari(InsertUserSafariRequest safariRequest)
            throws BusinessException, SystemException {
        UcUserSafari ucUserSafari = new UcUserSafari();
        ucUserSafari.setSafariSeqId(SequenceUtil.createSafariSeqId());
        ucUserSafari.setTenantId(safariRequest.getTenantId());
        ucUserSafari.setUserId(safariRequest.getUserId());
        ucUserSafari.setProdId(safariRequest.getProdId());
        ucUserSafari.setState("1");
        ucUserSafari.setSafariTime(DateUtils.currTimeStamp());

        BaseResponse response = new BaseResponse();
        ResponseHeader responseHeader;
        try {
            userSafariAtomSV.insert(ucUserSafari);
            responseHeader = new ResponseHeader(true, "success", "添加成功");
        } catch (Exception e) {
            LOG.error("添加失败", e);
            responseHeader = new ResponseHeader(false, "fail", "添加失败");
        }
        response.setResponseHeader(responseHeader);
        return response;
    }

    @Override
    public BaseResponse deleteUserSafari(DeleteSafariRequest deleteRequest)
            throws BusinessException, SystemException {
        UcUserSafariCriteria example = new UcUserSafariCriteria();
        UcUserSafariCriteria.Criteria criteria = example.createCriteria();
        criteria.andTenantIdEqualTo(deleteRequest.getTenantId());
        criteria.andUserIdEqualTo(deleteRequest.getUserId());

        BaseResponse response = new BaseResponse();
        // UcUserSafariHis safariHis = new UcUserSafariHis();
        // 浏览历史表
        if (!StringUtil.isBlank(deleteRequest.getDeleteCode())) {
            updateSafariSingle(example);
        } else {
            if (StringUtil.isBlank(deleteRequest.getDateTime())) {
                criteria.andProdIdEqualTo(deleteRequest.getProdId());
            } else {
                String beginTime = deleteRequest.getDateTime() + " 00:00:00";
                String endTime = deleteRequest.getDateTime() + " 23:59:59";
                criteria.andSafariTimeBetween(
                        DateUtils.getTimestamp(beginTime, "yyyy-MM-dd HH:mm:ss"),
                        DateUtils.getTimestamp(endTime, "yyyy-MM-dd HH:mm:ss"));
            }
            response = updateSafariSingle(example);
        }
        return response;
    }

    public BaseResponse updateSafariSingle(UcUserSafariCriteria example) {
        BaseResponse response = new BaseResponse();
        ResponseHeader responseHeader;
        try {
            UcUserSafari record = new UcUserSafari();
            record.setState("0");
            userSafariAtomSV.updateByExampleSelective(record, example);
            responseHeader = new ResponseHeader(true, "success", "更新成功");
        } catch (Exception e) {
            LOG.error("更新操作失败", e);
            responseHeader = new ResponseHeader(false, "fail", "更新失败");
        }
        response.setResponseHeader(responseHeader);
        return response;
    }

    @Override
    public UserSafariInfoResponse queryUserSafari(UserSafariInfoRequest request)
            throws BusinessException, SystemException {
        UcUserSafariCriteria example = new UcUserSafariCriteria();
        UcUserSafariCriteria.Criteria criteria = example.createCriteria();
        criteria.andTenantIdEqualTo(request.getTenantId());
        criteria.andUserIdEqualTo(request.getUserId());
        // criteria.andSafariTimeBetween(value1, value2);
        PageInfo<UserSafariInfoParams> pageInfo = new PageInfo<UserSafariInfoParams>();
        List<UcUserSafari> queryList = new ArrayList<UcUserSafari>();
        List<UserSafariInfoParams> responseList = new ArrayList<UserSafariInfoParams>();

        Integer pageNo = request.getPageNo();
        Integer pageSize = request.getPageSize();
        int count = 0;
        ResponseHeader responseHeader;
        try {
            count = userSafariAtomSV.countByExample(example);
            queryList = userSafariAtomSV.selectByExample(example);
            responseHeader = new ResponseHeader(true, "success", "查询成功");
        } catch (Exception e) {
            LOG.error("查询失败", e);
            responseHeader = new ResponseHeader(false, "fail", "查询失败");
        }
        UserSafariInfoResponse response = new UserSafariInfoResponse();
        for (UcUserSafari ucUserSafari : queryList) {
            UserSafariInfoParams userSafariInfoPatams = new UserSafariInfoParams();
            BeanUtils.copyProperties(ucUserSafari, userSafariInfoPatams);
            responseList.add(userSafariInfoPatams);
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
    public BaseResponse deleteUserSafariHis(DeleteSafariHisRequest deleteRequest)
            throws BusinessException, SystemException {
        BaseResponse response = new BaseResponse();
        ResponseHeader responseHeader;
        UcUserSafariHisCriteria example = new UcUserSafariHisCriteria();
        UcUserSafariHisCriteria.Criteria criteria = example.createCriteria();
        criteria.andTenantIdEqualTo(deleteRequest.getTenantId());
        criteria.andUserIdEqualTo(deleteRequest.getUserId());
        criteria.andSafariSeqIdIn(deleteRequest.getSafariHisIdList());
        try {
            userSafariHisAtomSV.deleteByExample(example);
            responseHeader = new ResponseHeader(true, "success", "查询失败");
        } catch (Exception e) {
            LOG.error("查询失败", e);
            responseHeader = new ResponseHeader(false, "fail", "查询失败");
        }
        response.setResponseHeader(responseHeader);
        return response;
    }
}
