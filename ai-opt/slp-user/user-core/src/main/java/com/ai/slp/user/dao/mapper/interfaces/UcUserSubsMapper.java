package com.ai.slp.user.dao.mapper.interfaces;

import com.ai.slp.user.dao.mapper.bo.UcUserSubs;
import com.ai.slp.user.dao.mapper.bo.UcUserSubsCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UcUserSubsMapper {
    int countByExample(UcUserSubsCriteria example);

    int deleteByExample(UcUserSubsCriteria example);

    int insert(UcUserSubs record);

    int insertSelective(UcUserSubs record);

    List<UcUserSubs> selectByExample(UcUserSubsCriteria example);

    int updateByExampleSelective(@Param("record") UcUserSubs record, @Param("example") UcUserSubsCriteria example);

    int updateByExample(@Param("record") UcUserSubs record, @Param("example") UcUserSubsCriteria example);
}