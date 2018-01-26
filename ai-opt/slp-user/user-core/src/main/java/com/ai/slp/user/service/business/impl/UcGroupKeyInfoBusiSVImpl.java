package com.ai.slp.user.service.business.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.PageInfo;
import com.ai.opt.base.vo.PageInfoResponse;
import com.ai.opt.sdk.components.sequence.util.SeqUtil;
import com.ai.opt.sdk.constants.ExceptCodeConstants;
import com.ai.opt.sdk.util.CollectionUtil;
import com.ai.opt.sdk.util.DateUtil;
import com.ai.opt.sdk.util.StringUtil;
import com.ai.slp.user.api.keyinfo.param.CmCustFileExtVo;
import com.ai.slp.user.api.keyinfo.param.InsertCustFileExtRequest;
import com.ai.slp.user.api.keyinfo.param.InsertGroupKeyInfoRequest;
import com.ai.slp.user.api.keyinfo.param.QueryCustFileExtRequest;
import com.ai.slp.user.api.keyinfo.param.QueryCustFileExtResponse;
import com.ai.slp.user.api.keyinfo.param.QueryGroupInfoRequest;
import com.ai.slp.user.api.keyinfo.param.QueryGroupInfoResponse;
import com.ai.slp.user.api.keyinfo.param.SearchGroupKeyInfoRequest;
import com.ai.slp.user.api.keyinfo.param.SearchGroupKeyInfoResponse;
import com.ai.slp.user.api.keyinfo.param.SearchGroupUserInfoResponse;
import com.ai.slp.user.api.keyinfo.param.UcGroupKeyInfoVo;
import com.ai.slp.user.api.keyinfo.param.UpdateCustFileExtRequest;
import com.ai.slp.user.api.keyinfo.param.UpdateGroupKeyInfoRequest;
import com.ai.slp.user.dao.mapper.bo.CmCustFileExt;
import com.ai.slp.user.dao.mapper.bo.CmCustFileExtCriteria;
import com.ai.slp.user.dao.mapper.bo.UcGroupKeyInfo;
import com.ai.slp.user.dao.mapper.bo.UcGroupKeyInfoCriteria;
import com.ai.slp.user.service.atom.interfaces.ICustFileAtomSV;
import com.ai.slp.user.service.atom.interfaces.IUcGroupKeyInfoAtomSV;
import com.ai.slp.user.service.business.interfaces.IUcGroupKeyInfoBusiSV;
import com.ai.slp.user.util.DateUtils;

@Service
@Transactional
public class UcGroupKeyInfoBusiSVImpl implements IUcGroupKeyInfoBusiSV{

    @Autowired
    private IUcGroupKeyInfoAtomSV ucGroupKeyInfoAtomSV;
    
    @Autowired
    private ICustFileAtomSV custFileAtomSV;
    
    @Override
    public int insertGroupKeyInfo(InsertGroupKeyInfoRequest request)
            throws SystemException, BusinessException {
        UcGroupKeyInfo record = new UcGroupKeyInfo();
        BeanUtils.copyProperties(request, record);
        record.setCreateTime(DateUtils.currTimeStamp());
        return ucGroupKeyInfoAtomSV.insert(record);
    }

    @Override
    public int updateGroupKeyInfo(UpdateGroupKeyInfoRequest request)
            throws SystemException, BusinessException {
        UcGroupKeyInfoCriteria example = new UcGroupKeyInfoCriteria();
        UcGroupKeyInfoCriteria.Criteria criteria = example.createCriteria();
        criteria.andTenantIdEqualTo(request.getTenantId());
        criteria.andUserIdEqualTo(request.getUserId());
        
        UcGroupKeyInfo record = new UcGroupKeyInfo();
        BeanUtils.copyProperties(request, record);
        record.setUpdateTime(DateUtils.currTimeStamp());
        return ucGroupKeyInfoAtomSV.updateByExampleSelective(record, example);
    }

    @Override
    public SearchGroupKeyInfoResponse searchGroupKeyInfo(SearchGroupKeyInfoRequest request)
            throws SystemException, BusinessException {
        UcGroupKeyInfoCriteria example = new UcGroupKeyInfoCriteria();
        UcGroupKeyInfoCriteria.Criteria criteria = example.createCriteria();
        criteria.andTenantIdEqualTo(request.getTenantId());
        if(!StringUtil.isBlank(request.getCustName()))
           criteria.andCustNameEqualTo(request.getCustName());
        
        if(!StringUtil.isBlank(request.getUserId()))
           criteria.andUserIdEqualTo(request.getUserId());
        
        List<UcGroupKeyInfo> list = ucGroupKeyInfoAtomSV.selectByExample(example);
        
        SearchGroupKeyInfoResponse response = new SearchGroupKeyInfoResponse();
        if(!CollectionUtil.isEmpty(list)){
            BeanUtils.copyProperties(list.get(0), response);
            return response;
        }
        return null;
    }

    @Override
    public void insertCustFileExt(InsertCustFileExtRequest request)
            throws SystemException, BusinessException {
        
        for(CmCustFileExtVo cmCustFileExtVo:request.getList()){
            CmCustFileExt cmCustFileExt = new CmCustFileExt();
            BeanUtils.copyProperties(cmCustFileExtVo, cmCustFileExt);
            cmCustFileExt.setInfoExtId(SeqUtil.getNewId("CM_CUST_FILE_EXT$INFO_EXT$ID", 18));
            cmCustFileExt.setCreateTime(DateUtil.getSysDate());
            custFileAtomSV.insert(cmCustFileExt);
        }
    }

    @Override
    public QueryCustFileExtResponse QueryCustFileExt(QueryCustFileExtRequest request)
            throws SystemException, BusinessException {
        CmCustFileExtCriteria example = new CmCustFileExtCriteria();
        CmCustFileExtCriteria.Criteria criteria = example.createCriteria();
        criteria.andTenantIdEqualTo(request.getTenantId());
        criteria.andUserIdEqualTo(request.getUserId());
        
        QueryCustFileExtResponse response = new QueryCustFileExtResponse();
        List<CmCustFileExt> list = custFileAtomSV.selectByExample(example);
        List<CmCustFileExtVo> custFileList = new ArrayList<CmCustFileExtVo>();
        if(!list.isEmpty()){
            for (CmCustFileExt cmCustFileExt : list) {
            CmCustFileExtVo cmCustFileExtVo = new CmCustFileExtVo();
            BeanUtils.copyProperties(cmCustFileExt, cmCustFileExtVo); 
            custFileList.add(cmCustFileExtVo);
            }
        }
        response.setList(custFileList);
        return response;
    }

    @Override
    public PageInfoResponse<UcGroupKeyInfoVo> QueryGroupInfo(QueryGroupInfoRequest request)
            throws SystemException, BusinessException {
        
        PageInfoResponse<UcGroupKeyInfoVo> pageInfo = new PageInfoResponse<UcGroupKeyInfoVo>();
        
        UcGroupKeyInfoCriteria example = new UcGroupKeyInfoCriteria();
        
        UcGroupKeyInfoCriteria.Criteria criteria = example.createCriteria();
        
        if (StringUtil.isBlank(request.getTenantId())) {
            throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "获取参数失败:租户ID不能为空");
        }
        
        if (StringUtil.isBlank(request.getCustName())) {
            throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "获取参数失败:企业名称不能为空");
        }
        
        criteria.andTenantIdEqualTo(request.getTenantId());
        request.setCustName("%"+request.getCustName()+"%");
       
        /**
         * 设置总页数
         */
        int count = ucGroupKeyInfoAtomSV.selectCountGroupKeyInfo(request);
        pageInfo.setCount(count);
        
        int pageNo = request.getPageNo();
        int pageSize = request.getPageSize();
        int startPage = (pageNo-1)*pageSize;
        int endPage = pageSize;
        
        List<UcGroupKeyInfoVo> list = ucGroupKeyInfoAtomSV.searchGroupKeyInfo(request,startPage,endPage);
        /**
        * 设置页数和每页条数
        */
        pageInfo.setPageNo(request.getPageNo());
        pageInfo.setPageSize(request.getPageSize());
        /**
         * 设置结果集
         */
        pageInfo.setResult(list);
        /**
         * 设置总页数
         */
        int pageCount = count/pageSize+(count%pageSize>0 ? 1 : 0);
        pageInfo.setPageCount(pageCount);
        return pageInfo;
    }

    @Override
    public void updateCustFileExt(UpdateCustFileExtRequest request)
            throws SystemException, BusinessException {
        CmCustFileExt cmCustFileExt = new CmCustFileExt();
        
        for (CmCustFileExtVo cmCustFileExtVo : request.getList()) {
            CmCustFileExtCriteria example = new CmCustFileExtCriteria();
            CmCustFileExtCriteria.Criteria criteria = example.createCriteria();
            
            criteria.andTenantIdEqualTo(cmCustFileExtVo.getTenantId());
            criteria.andUserIdEqualTo(cmCustFileExtVo.getUserId());
            criteria.andInfoItemEqualTo(cmCustFileExtVo.getInfoItem());
            BeanUtils.copyProperties(cmCustFileExtVo, cmCustFileExt);
            cmCustFileExt.setUpdateTime(DateUtils.currTimeStamp());
            custFileAtomSV.updateByExampleSelective(cmCustFileExt, example);
        }
    }

    @Override
    public SearchGroupUserInfoResponse searchGroupUserInfo(SearchGroupKeyInfoRequest groupKeyInfo)
            throws SystemException, BusinessException {
        
        if(StringUtil.isBlank(groupKeyInfo.getTenantId())){
            throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "租户ID不能为空");
        }
        
        if (StringUtil.isBlank(groupKeyInfo.getUserId())) {
            throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "账户ID不能为空");
        }
        
        SearchGroupUserInfoResponse response = ucGroupKeyInfoAtomSV.searchGroupUserInfo(groupKeyInfo);
        
        return response;
    }
}
