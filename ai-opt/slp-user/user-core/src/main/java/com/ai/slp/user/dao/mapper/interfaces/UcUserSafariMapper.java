package com.ai.slp.user.dao.mapper.interfaces;

import com.ai.slp.user.dao.mapper.bo.UcUserSafari;
import com.ai.slp.user.dao.mapper.bo.UcUserSafariCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UcUserSafariMapper {
    int countByExample(UcUserSafariCriteria example);

    int deleteByExample(UcUserSafariCriteria example);

    int insert(UcUserSafari record);

    int insertSelective(UcUserSafari record);

    List<UcUserSafari> selectByExample(UcUserSafariCriteria example);

    int updateByExampleSelective(@Param("record") UcUserSafari record, @Param("example") UcUserSafariCriteria example);

    int updateByExample(@Param("record") UcUserSafari record, @Param("example") UcUserSafariCriteria example);
}