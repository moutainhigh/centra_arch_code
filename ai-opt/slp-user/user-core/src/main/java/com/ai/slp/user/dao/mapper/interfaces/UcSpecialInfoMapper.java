package com.ai.slp.user.dao.mapper.interfaces;

import com.ai.slp.user.dao.mapper.bo.UcSpecialInfo;
import com.ai.slp.user.dao.mapper.bo.UcSpecialInfoCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UcSpecialInfoMapper {
    int countByExample(UcSpecialInfoCriteria example);

    int deleteByExample(UcSpecialInfoCriteria example);

    int insert(UcSpecialInfo record);

    int insertSelective(UcSpecialInfo record);

    List<UcSpecialInfo> selectByExample(UcSpecialInfoCriteria example);

    int updateByExampleSelective(@Param("record") UcSpecialInfo record, @Param("example") UcSpecialInfoCriteria example);

    int updateByExample(@Param("record") UcSpecialInfo record, @Param("example") UcSpecialInfoCriteria example);
}