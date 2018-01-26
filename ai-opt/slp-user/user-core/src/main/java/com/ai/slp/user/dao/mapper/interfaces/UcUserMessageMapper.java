package com.ai.slp.user.dao.mapper.interfaces;

import com.ai.slp.user.dao.mapper.bo.UcUserMessage;
import com.ai.slp.user.dao.mapper.bo.UcUserMessageCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UcUserMessageMapper {
    int countByExample(UcUserMessageCriteria example);

    int deleteByExample(UcUserMessageCriteria example);

    int insert(UcUserMessage record);

    int insertSelective(UcUserMessage record);

    List<UcUserMessage> selectByExample(UcUserMessageCriteria example);

    int updateByExampleSelective(@Param("record") UcUserMessage record, @Param("example") UcUserMessageCriteria example);

    int updateByExample(@Param("record") UcUserMessage record, @Param("example") UcUserMessageCriteria example);
}