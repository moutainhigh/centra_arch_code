package com.ai.slp.user.dao.mapper.interfaces;

import com.ai.slp.user.dao.mapper.bo.UcStateChg;
import com.ai.slp.user.dao.mapper.bo.UcStateChgCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UcStateChgMapper {
    int countByExample(UcStateChgCriteria example);

    int deleteByExample(UcStateChgCriteria example);

    int insert(UcStateChg record);

    int insertSelective(UcStateChg record);

    List<UcStateChg> selectByExample(UcStateChgCriteria example);

    int updateByExampleSelective(@Param("record") UcStateChg record, @Param("example") UcStateChgCriteria example);

    int updateByExample(@Param("record") UcStateChg record, @Param("example") UcStateChgCriteria example);
}