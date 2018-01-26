package com.ai.slp.user.dao.mapper.interfaces;

import com.ai.slp.user.dao.mapper.bo.UcUserPhonebooks;
import com.ai.slp.user.dao.mapper.bo.UcUserPhonebooksCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UcUserPhonebooksMapper {
    int countByExample(UcUserPhonebooksCriteria example);

    int deleteByExample(UcUserPhonebooksCriteria example);

    int deleteByPrimaryKey(String telNo);

    int insert(UcUserPhonebooks record);

    int insertSelective(UcUserPhonebooks record);
    
    int insertList(List<UcUserPhonebooks> record);

    List<UcUserPhonebooks> selectByExample(UcUserPhonebooksCriteria example);

    UcUserPhonebooks selectByPrimaryKey(String telNo);

    int updateByExampleSelective(@Param("record") UcUserPhonebooks record, @Param("example") UcUserPhonebooksCriteria example);

    int updateByExample(@Param("record") UcUserPhonebooks record, @Param("example") UcUserPhonebooksCriteria example);

    int updateByPrimaryKeySelective(UcUserPhonebooks record);

    int updateByPrimaryKey(UcUserPhonebooks record);
}