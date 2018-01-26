package com.ai.slp.user.dao.mapper.interfaces;

import com.ai.slp.user.dao.mapper.bo.UcTelGroup;
import com.ai.slp.user.dao.mapper.bo.UcTelGroupCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UcTelGroupMapper {
    int countByExample(UcTelGroupCriteria example);

    int deleteByExample(UcTelGroupCriteria example);

    int deleteByPrimaryKey(String telGroupId);

    int insert(UcTelGroup record);

    int insertSelective(UcTelGroup record);

    List<UcTelGroup> selectByExample(UcTelGroupCriteria example);

    UcTelGroup selectByPrimaryKey(String telGroupId);

    int updateByExampleSelective(@Param("record") UcTelGroup record, @Param("example") UcTelGroupCriteria example);

    int updateByExample(@Param("record") UcTelGroup record, @Param("example") UcTelGroupCriteria example);

    int updateByPrimaryKeySelective(UcTelGroup record);

    int updateByPrimaryKey(UcTelGroup record);
}