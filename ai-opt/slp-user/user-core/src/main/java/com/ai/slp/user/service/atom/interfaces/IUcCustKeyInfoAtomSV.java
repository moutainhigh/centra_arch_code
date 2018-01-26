package com.ai.slp.user.service.atom.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ai.slp.user.dao.mapper.bo.UcCustKeyInfo;
import com.ai.slp.user.dao.mapper.bo.UcCustKeyInfoCriteria;

public interface IUcCustKeyInfoAtomSV {

    int insert(UcCustKeyInfo record);

    List<UcCustKeyInfo> selectByExample(UcCustKeyInfoCriteria example);

    int updateByExampleSelective(@Param("record") UcCustKeyInfo record, @Param("example") UcCustKeyInfoCriteria example);
}
