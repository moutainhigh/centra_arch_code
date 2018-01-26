package com.ai.slp.user.service.atom.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ai.slp.user.dao.mapper.bo.CmCustFileExt;
import com.ai.slp.user.dao.mapper.bo.CmCustFileExtCriteria;

public interface ICustFileAtomSV {

    int insert(CmCustFileExt record);

    int updateByExampleSelective(@Param("record") CmCustFileExt record, @Param("example") CmCustFileExtCriteria example);
    
    List<CmCustFileExt> selectByExample(CmCustFileExtCriteria example);
    
}
