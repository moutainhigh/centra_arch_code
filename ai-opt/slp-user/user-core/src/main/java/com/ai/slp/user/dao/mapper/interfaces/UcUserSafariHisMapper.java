package com.ai.slp.user.dao.mapper.interfaces;

import com.ai.slp.user.dao.mapper.bo.UcUserSafariHis;
import com.ai.slp.user.dao.mapper.bo.UcUserSafariHisCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UcUserSafariHisMapper {
    int countByExample(UcUserSafariHisCriteria example);

    int deleteByExample(UcUserSafariHisCriteria example);

    int insert(UcUserSafariHis record);

    int insertSelective(UcUserSafariHis record);

    List<UcUserSafariHis> selectByExample(UcUserSafariHisCriteria example);

    int updateByExampleSelective(@Param("record") UcUserSafariHis record, @Param("example") UcUserSafariHisCriteria example);

    int updateByExample(@Param("record") UcUserSafariHis record, @Param("example") UcUserSafariHisCriteria example);
}