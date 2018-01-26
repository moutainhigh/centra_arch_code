package com.ai.slp.user.service.business.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.BaseResponse;
import com.ai.opt.base.vo.ResponseHeader;
import com.ai.opt.sdk.util.BeanUtils;
import com.ai.slp.user.api.ucStateChg.param.QueryStateChgRequest;
import com.ai.slp.user.api.ucStateChg.param.QueryStateChgResponse;
import com.ai.slp.user.api.ucStateChg.param.UcStateChgParamsRequest;
import com.ai.slp.user.dao.mapper.bo.UcStateChg;
import com.ai.slp.user.dao.mapper.bo.UcStateChgCriteria;
import com.ai.slp.user.service.atom.interfaces.IUcStateChgAtomSV;
import com.ai.slp.user.service.business.interfaces.IUcStateChgBusiSV;

@Service
@Transactional
public class UcStateChgBusiSVImpl implements IUcStateChgBusiSV {

    @Autowired
    private IUcStateChgAtomSV ucStateChgAtomSV;

    static final Log LOG = LogFactory.getLog(UcStateChgBusiSVImpl.class);

    @Override
    public BaseResponse insertUcStateChgBusiInfo(UcStateChgParamsRequest ucStateChgParam) {

        BaseResponse reponse = new BaseResponse();
        ResponseHeader responseHeader;
        UcStateChg ucStateChg = new UcStateChg();
        BeanUtils.copyProperties(ucStateChg, ucStateChgParam);
        try {
            ucStateChgAtomSV.insertUcStateChgBusiInfo(ucStateChg);
            responseHeader = new ResponseHeader(true, "success", "添加成功");
        } catch (Exception e) {
            LOG.error("用户状态添加失败", e);
            responseHeader = new ResponseHeader(false, "fail", "添加失败");
        }
        reponse.setResponseHeader(responseHeader);
        return reponse;
    }

    @Override
    public BaseResponse updateUcStateChgBusiInfo(UcStateChgParamsRequest ucStateChgParam) {
        BaseResponse reponse = new BaseResponse();
        ResponseHeader responseHeader;
        try {
            UcStateChg ucStateChg = new UcStateChg();
            BeanUtils.copyProperties(ucStateChg, ucStateChgParam);
            UcStateChgCriteria criteria = new UcStateChgCriteria();
            criteria.or().andUserIdEqualTo(ucStateChgParam.getUserId());
            ucStateChgAtomSV.updateUcStateChgBusiInfo(ucStateChg, criteria);
            responseHeader = new ResponseHeader(true, "success", "添加成功");
        } catch (Exception e) {
            responseHeader = new ResponseHeader(false, "fail", "更新失败");
            LOG.error("修改失败", e);
        }
        reponse.setResponseHeader(responseHeader);
        return reponse;
    }

    @Override
    public QueryStateChgResponse queryStateChg(QueryStateChgRequest stateChgRequest)
            throws BusinessException, SystemException {
        UcStateChgCriteria example = new UcStateChgCriteria();
        UcStateChgCriteria.Criteria criteria = example.createCriteria();
        criteria.andTenantIdEqualTo(stateChgRequest.getTenantId());
        criteria.andUserIdEqualTo(stateChgRequest.getUserId());
        criteria.andStateChgIdEqualTo(stateChgRequest.getStateChgId());

        QueryStateChgResponse response = new QueryStateChgResponse();
        ResponseHeader responseHeader;
        UcStateChg ucStateChg = new UcStateChg();
        try {
            ucStateChg = ucStateChgAtomSV.selectByExample(example).get(0);
            responseHeader = new ResponseHeader(true, "success", "添加成功");
        } catch (Exception e) {
            responseHeader = new ResponseHeader(false, "fail", "查询失败");
            LOG.error("获取失败", e);
        }
        BeanUtils.copyProperties(ucStateChg, response);
        response.setResponseHeader(responseHeader);
        return response;
    }

}
