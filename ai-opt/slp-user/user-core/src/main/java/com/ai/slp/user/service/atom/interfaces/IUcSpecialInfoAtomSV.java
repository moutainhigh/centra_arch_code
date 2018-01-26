package com.ai.slp.user.service.atom.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ai.slp.user.dao.mapper.bo.UcSpecialInfo;
import com.ai.slp.user.dao.mapper.bo.UcSpecialInfoCriteria;

public interface IUcSpecialInfoAtomSV {

    int deleteByExample(UcSpecialInfoCriteria example);

    int insert(UcSpecialInfo record);

    List<UcSpecialInfo> selectByExample(UcSpecialInfoCriteria example);
    
    int updateByExampleSelective(@Param("record") UcSpecialInfo record, @Param("example") UcSpecialInfoCriteria example);
}
