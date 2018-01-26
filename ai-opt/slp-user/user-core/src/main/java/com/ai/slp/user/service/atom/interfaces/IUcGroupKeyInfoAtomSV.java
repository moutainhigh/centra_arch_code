package com.ai.slp.user.service.atom.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ai.slp.user.api.keyinfo.param.QueryGroupInfoRequest;
import com.ai.slp.user.api.keyinfo.param.SearchGroupKeyInfoRequest;
import com.ai.slp.user.api.keyinfo.param.SearchGroupUserInfoResponse;
import com.ai.slp.user.api.keyinfo.param.UcGroupKeyInfoVo;
import com.ai.slp.user.dao.mapper.bo.UcGroupKeyInfo;
import com.ai.slp.user.dao.mapper.bo.UcGroupKeyInfoCriteria;

public interface IUcGroupKeyInfoAtomSV {
    
    int countByExample(UcGroupKeyInfoCriteria example);

    int insert(UcGroupKeyInfo record);

    List<UcGroupKeyInfo> selectByExample(UcGroupKeyInfoCriteria example);

    int updateByExampleSelective(@Param("record") UcGroupKeyInfo record, @Param("example") UcGroupKeyInfoCriteria example);
    
    SearchGroupUserInfoResponse searchGroupUserInfo(SearchGroupKeyInfoRequest groupKeyInfo);
    
    List<UcGroupKeyInfoVo> searchGroupKeyInfo(QueryGroupInfoRequest groupKeyInfo,int startPage,int endPage);
    
    int selectCountGroupKeyInfo (QueryGroupInfoRequest groupKeyInfo);
}
