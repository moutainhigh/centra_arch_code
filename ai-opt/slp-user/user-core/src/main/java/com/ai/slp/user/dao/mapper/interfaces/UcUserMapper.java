package com.ai.slp.user.dao.mapper.interfaces;

import com.ai.slp.user.dao.mapper.bo.UcUser;
import com.ai.slp.user.dao.mapper.bo.UcUserCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UcUserMapper {
    int countByExample(UcUserCriteria example);

    int deleteByExample(UcUserCriteria example);

    int insert(UcUser record);

    int insertSelective(UcUser record);

    List<UcUser> selectByExample(UcUserCriteria example);

    int updateByExampleSelective(@Param("record") UcUser record, @Param("example") UcUserCriteria example);

    int updateByExample(@Param("record") UcUser record, @Param("example") UcUserCriteria example);
}