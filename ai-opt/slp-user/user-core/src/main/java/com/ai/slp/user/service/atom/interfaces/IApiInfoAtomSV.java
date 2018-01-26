package com.ai.slp.user.service.atom.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ai.slp.user.dao.mapper.bo.UcApiInfo;
import com.ai.slp.user.dao.mapper.bo.UcApiInfoCriteria;

public interface IApiInfoAtomSV {

    int deleteByExample(UcApiInfoCriteria example);

    int insert(UcApiInfo record);

    List<UcApiInfo> selectByExample(UcApiInfoCriteria example);

    int updateByExampleSelective(@Param("record") UcApiInfo record,
            @Param("example") UcApiInfoCriteria example);

    int countByExample(UcApiInfoCriteria example);
}
