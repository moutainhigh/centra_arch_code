package com.ai.slp.user.api.bankinfo.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.BaseResponse;
import com.ai.opt.base.vo.ResponseHeader;
import com.ai.slp.user.api.bankinfo.interfaces.IUcBankInfoSV;
import com.ai.slp.user.api.bankinfo.param.InsertBankInfoRequest;
import com.ai.slp.user.api.bankinfo.param.QueryBankInfoRequest;
import com.ai.slp.user.api.bankinfo.param.QueryBankInfoResponse;
import com.ai.slp.user.api.bankinfo.param.QueryBankInfoSingleRequest;
import com.ai.slp.user.api.bankinfo.param.QueryBankInfoSingleResponse;
import com.ai.slp.user.api.bankinfo.param.UpdateBankInfoRequest;
import com.ai.slp.user.service.business.interfaces.IUcBankInfoBusiSV;
import com.alibaba.dubbo.config.annotation.Service;

@Component
@Service
public class UcBankInfoSVImpl implements IUcBankInfoSV {

    @Autowired
    private IUcBankInfoBusiSV ucBankInfoBusiSV;

    static final Log LOG = LogFactory.getLog(UcBankInfoSVImpl.class);
    
    @Override
    public BaseResponse insertBankInfo(InsertBankInfoRequest bankInfoRequest)
            throws BusinessException, SystemException {
        BaseResponse baseResponse=new BaseResponse();
        ResponseHeader responseHeader =null;
        try{
          ucBankInfoBusiSV.insertBankInfo(bankInfoRequest);
         responseHeader = new ResponseHeader(true, "success", "操作成功");
        }catch(Exception e){
            LOG.error("添加失败", e);
            responseHeader = new ResponseHeader(false, "fail", "操作失败");
        }
        baseResponse.setResponseHeader(responseHeader);
        return baseResponse;
    }

    @Override
    public QueryBankInfoResponse queryBankInfo(QueryBankInfoRequest bankInfoRequest)
            throws BusinessException, SystemException {
          return ucBankInfoBusiSV.queryBankInfo(bankInfoRequest);
    }

    @Override
    public BaseResponse updateBankInfo(UpdateBankInfoRequest bankInfoRequest)
            throws BusinessException, SystemException {
        BaseResponse baseResponse=new BaseResponse();
        ResponseHeader responseHeader =null;
        try{
           ucBankInfoBusiSV.UpdateBankInfo(bankInfoRequest);
         responseHeader = new ResponseHeader(true, "success", "操作成功");
        }catch(Exception e){
            LOG.error("添加失败", e);
            responseHeader = new ResponseHeader(false, "fail", "操作失败");
        }
        baseResponse.setResponseHeader(responseHeader);
        return baseResponse;
    }

    @Override
    public QueryBankInfoSingleResponse queryBankInfoSingle(QueryBankInfoSingleRequest bankInfoRequest)
            throws BusinessException, SystemException {
        ResponseHeader responseHeader =null;
        QueryBankInfoSingleResponse response=null;
        try{
           response = ucBankInfoBusiSV.queryBankInfoSingle(bankInfoRequest);
           responseHeader = new ResponseHeader(true, "success", "操作成功");
        }catch(Exception e){
            LOG.error("添加失败", e);
            responseHeader = new ResponseHeader(false, "fail", "操作失败");
        }
        response.setResponseHeader(responseHeader);
        return response;
    }

}
