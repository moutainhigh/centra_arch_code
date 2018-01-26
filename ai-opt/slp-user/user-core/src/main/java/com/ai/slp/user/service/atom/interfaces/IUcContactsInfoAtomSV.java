package com.ai.slp.user.service.atom.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ai.slp.user.dao.mapper.bo.UcContactsInfo;
import com.ai.slp.user.dao.mapper.bo.UcContactsInfoCriteria;

public interface IUcContactsInfoAtomSV {

    int countByExample(UcContactsInfoCriteria example);

    int deleteByExample(UcContactsInfoCriteria example);

    int insert(UcContactsInfo record);

    List<UcContactsInfo> selectByExample(UcContactsInfoCriteria example);

    int updateByExampleSelective(@Param("record") UcContactsInfo record,
            @Param("example") UcContactsInfoCriteria example);

}
