package com.ai.slp.user.api.keyinfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.BaseResponse;
import com.ai.opt.base.vo.PageInfoResponse;
import com.ai.opt.base.vo.ResponseHeader;
import com.ai.slp.user.api.keyinfo.interfaces.IUcKeyInfoSV;
import com.ai.slp.user.api.keyinfo.param.InsertCustFileExtRequest;
import com.ai.slp.user.api.keyinfo.param.InsertCustKeyInfoRequest;
import com.ai.slp.user.api.keyinfo.param.InsertGroupKeyInfoRequest;
import com.ai.slp.user.api.keyinfo.param.QueryCustFileExtRequest;
import com.ai.slp.user.api.keyinfo.param.QueryCustFileExtResponse;
import com.ai.slp.user.api.keyinfo.param.QueryGroupInfoRequest;
import com.ai.slp.user.api.keyinfo.param.SearchCustKeyInfoRequest;
import com.ai.slp.user.api.keyinfo.param.SearchCustKeyInfoResponse;
import com.ai.slp.user.api.keyinfo.param.SearchGroupKeyInfoRequest;
import com.ai.slp.user.api.keyinfo.param.SearchGroupKeyInfoResponse;
import com.ai.slp.user.api.keyinfo.param.SearchGroupUserInfoResponse;
import com.ai.slp.user.api.keyinfo.param.UcGroupKeyInfoVo;
import com.ai.slp.user.api.keyinfo.param.UpdateCustFileExtRequest;
import com.ai.slp.user.api.keyinfo.param.UpdateCustKeyInfoRequest;
import com.ai.slp.user.api.keyinfo.param.UpdateGroupKeyInfoRequest;
import com.ai.slp.user.constants.ExceptCodeConstants;
import com.ai.slp.user.service.business.interfaces.IUcCustKeyInfoBusiSV;
import com.ai.slp.user.service.business.interfaces.IUcGroupKeyInfoBusiSV;
import com.alibaba.dubbo.config.annotation.Service;

@Component
@Service(validation = "true")
public class UcKeyInfoSVImpl implements IUcKeyInfoSV {

    @Autowired
    private IUcCustKeyInfoBusiSV ucCustKeyInfoBusiSV;

    @Autowired
    private IUcGroupKeyInfoBusiSV ucGroupKeyInfoBusiSV;

    @Override
    public BaseResponse insertCustKeyInfo(InsertCustKeyInfoRequest request)
            throws SystemException, BusinessException {
        BaseResponse response = new BaseResponse();
        ResponseHeader responseHeader = null;
        try {
            ucCustKeyInfoBusiSV.insertCustKeyInfo(request);
            responseHeader = new ResponseHeader(true, ExceptCodeConstants.SUCCESS, "操作成功");
        } catch (Exception e) {
            responseHeader = new ResponseHeader(false, ExceptCodeConstants.FAILD, "操作失败");
        }
        response.setResponseHeader(responseHeader);
        return response;

    }

    @Override
    public BaseResponse updateCustKeyInfo(UpdateCustKeyInfoRequest request)
            throws SystemException, BusinessException {
        BaseResponse response = new BaseResponse();
        ResponseHeader responseHeader = null;
        try {
            ucCustKeyInfoBusiSV.updateCustKeyInfo(request);
            responseHeader = new ResponseHeader(true, ExceptCodeConstants.SUCCESS, "操作成功");
        } catch (Exception e) {
            responseHeader = new ResponseHeader(false, ExceptCodeConstants.FAILD, "操作失败");
        }
        response.setResponseHeader(responseHeader);
        return response;
    }

    @Override
    public SearchCustKeyInfoResponse searchCustKeyInfo(SearchCustKeyInfoRequest request)
            throws SystemException, BusinessException {
        ResponseHeader responseHeader = null;
        SearchCustKeyInfoResponse response = new SearchCustKeyInfoResponse();
        try {
            response = ucCustKeyInfoBusiSV.searchCustKeyInfo(request);
            responseHeader = new ResponseHeader(true, ExceptCodeConstants.SUCCESS, "操作成功");
        } catch (Exception e) {
            responseHeader = new ResponseHeader(false, ExceptCodeConstants.FAILD, "操作失败");
        }
        response.setResponseHeader(responseHeader);
        return response;
    }

    @Override
    public BaseResponse insertGroupKeyInfo(InsertGroupKeyInfoRequest request)
            throws SystemException, BusinessException {
        BaseResponse response = new BaseResponse();
        ResponseHeader responseHeader = null;
        try {
            ucGroupKeyInfoBusiSV.insertGroupKeyInfo(request);
            responseHeader = new ResponseHeader(true, ExceptCodeConstants.SUCCESS, "操作成功");
        } catch (Exception e) {
            responseHeader = new ResponseHeader(false, ExceptCodeConstants.FAILD, "操作失败");
        }
        response.setResponseHeader(responseHeader);
        return response;

    }

    @Override
    public BaseResponse updateGroupKeyInfo(UpdateGroupKeyInfoRequest request)
            throws SystemException, BusinessException {
        BaseResponse response = new BaseResponse();
        ResponseHeader responseHeader = null;
        try {
            ucGroupKeyInfoBusiSV.updateGroupKeyInfo(request);
            responseHeader = new ResponseHeader(true, ExceptCodeConstants.SUCCESS, "操作成功");
        } catch (Exception e) {
            responseHeader = new ResponseHeader(false, ExceptCodeConstants.FAILD, "操作失败");
        }
        response.setResponseHeader(responseHeader);
        return response;
    }

    @Override
    public SearchGroupKeyInfoResponse searchGroupKeyInfo(SearchGroupKeyInfoRequest request)
            throws SystemException, BusinessException {
        ResponseHeader responseHeader = null;
        SearchGroupKeyInfoResponse response = new SearchGroupKeyInfoResponse();

        try {
            response = ucGroupKeyInfoBusiSV.searchGroupKeyInfo(request);
            if (response != null) {
                responseHeader = new ResponseHeader(true, ExceptCodeConstants.SUCCESS, "数据查询成功");
            } else {
                response = new SearchGroupKeyInfoResponse();
                responseHeader = new ResponseHeader(true, ExceptCodeConstants.NO_RESULT, "数据不存在");
            }
        } catch (Exception e) {
            responseHeader = new ResponseHeader(false, ExceptCodeConstants.FAILD, "操作失败");
        }
        response.setResponseHeader(responseHeader);
        return response;
    }

    @Override
    public BaseResponse insertCustFileExt(InsertCustFileExtRequest request)
            throws SystemException, BusinessException {
        BaseResponse baseResponse = new BaseResponse();
        ResponseHeader responseHeader = null;

        try {
            ucGroupKeyInfoBusiSV.insertCustFileExt(request);
            responseHeader = new ResponseHeader(true, ExceptCodeConstants.SUCCESS, "操作成功");
        } catch (Exception e) {
            responseHeader = new ResponseHeader(false, ExceptCodeConstants.FAILD, "操作失败");
        }
        baseResponse.setResponseHeader(responseHeader);
        return baseResponse;
    }

    @Override
    public QueryCustFileExtResponse queryCustFileExt(QueryCustFileExtRequest request)
            throws SystemException, BusinessException {
        ResponseHeader responseHeader = null;
        QueryCustFileExtResponse response = new QueryCustFileExtResponse();
        try {
            response = ucGroupKeyInfoBusiSV.QueryCustFileExt(request);
            responseHeader = new ResponseHeader(true, ExceptCodeConstants.SUCCESS, "操作成功");
        } catch (Exception e) {
            responseHeader = new ResponseHeader(false, ExceptCodeConstants.FAILD, "操作失败");
        }
        response.setResponseHeader(responseHeader);
        return response;

    }

    @Override
    public PageInfoResponse<UcGroupKeyInfoVo> queryGroupInfo(QueryGroupInfoRequest request)
            throws SystemException, BusinessException {
        ResponseHeader responseHeader = null;
        PageInfoResponse<UcGroupKeyInfoVo> response = new PageInfoResponse<UcGroupKeyInfoVo>();
        try {
            response = ucGroupKeyInfoBusiSV.QueryGroupInfo(request);
            responseHeader = new ResponseHeader(true, ExceptCodeConstants.SUCCESS, "操作成功");
        } catch (Exception e) {
            responseHeader = new ResponseHeader(false, ExceptCodeConstants.FAILD, "操作失败");
        }
        response.setResponseHeader(responseHeader);
        return response;
    }

    @Override
    public BaseResponse updateCustFileExt(UpdateCustFileExtRequest request)
            throws SystemException, BusinessException {
        ResponseHeader responseHeader = null;
        BaseResponse response = new BaseResponse();
        try {
            ucGroupKeyInfoBusiSV.updateCustFileExt(request);
            responseHeader = new ResponseHeader(true, ExceptCodeConstants.SUCCESS, "操作成功");
        } catch (Exception e) {
            responseHeader = new ResponseHeader(false, ExceptCodeConstants.FAILD, "操作失败");
        }
        response.setResponseHeader(responseHeader);
        return response;
    }

    @Override
    public SearchGroupUserInfoResponse searchGroupUserInfo(SearchGroupKeyInfoRequest request)
            throws SystemException, BusinessException {
        
        ResponseHeader responseHeader = null;
        SearchGroupUserInfoResponse response = new SearchGroupUserInfoResponse();

        try {
            response = ucGroupKeyInfoBusiSV.searchGroupUserInfo(request);
            if (response != null) {
                responseHeader = new ResponseHeader(true, ExceptCodeConstants.SUCCESS, "数据查询成功");
            } else {
                response = new SearchGroupUserInfoResponse();
                responseHeader = new ResponseHeader(true, ExceptCodeConstants.NO_RESULT, "数据不存在");
            }
        } catch (Exception e) {
            responseHeader = new ResponseHeader(false, ExceptCodeConstants.FAILD, "操作失败");
        }
        response.setResponseHeader(responseHeader);
        return response;
        
    }

}
