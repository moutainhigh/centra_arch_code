package com.ai.slp.user.dao.mapper.interfaces;

import com.ai.slp.user.dao.mapper.bo.UcApiInfo;
import com.ai.slp.user.dao.mapper.bo.UcApiInfoCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UcApiInfoMapper {
    int countByExample(UcApiInfoCriteria example);

    int deleteByExample(UcApiInfoCriteria example);

    int insert(UcApiInfo record);

    int insertSelective(UcApiInfo record);

    List<UcApiInfo> selectByExample(UcApiInfoCriteria example);

    int updateByExampleSelective(@Param("record") UcApiInfo record, @Param("example") UcApiInfoCriteria example);

    int updateByExample(@Param("record") UcApiInfo record, @Param("example") UcApiInfoCriteria example);
}