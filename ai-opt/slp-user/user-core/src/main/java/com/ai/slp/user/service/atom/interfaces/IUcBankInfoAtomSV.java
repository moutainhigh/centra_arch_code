package com.ai.slp.user.service.atom.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ai.slp.user.dao.mapper.bo.UcBankInfo;
import com.ai.slp.user.dao.mapper.bo.UcBankInfoCriteria;

public interface IUcBankInfoAtomSV {
    int insert(UcBankInfo record);

    int updateByExampleSelective(@Param("record") UcBankInfo record, @Param("example") UcBankInfoCriteria example);
    
    List<UcBankInfo> selectByExample(UcBankInfoCriteria example);
    
    int countByExample(UcBankInfoCriteria example);

}
