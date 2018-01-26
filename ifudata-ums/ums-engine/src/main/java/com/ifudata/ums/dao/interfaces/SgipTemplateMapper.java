package com.ifudata.ums.dao.interfaces;


import com.ifudata.ums.dao.mapper.bo.SgipTemplate;
import com.ifudata.ums.dao.mapper.bo.SgipTemplateCriteria;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SgipTemplateMapper {
    int countByExample(SgipTemplateCriteria example);

    int deleteByExample(SgipTemplateCriteria example);

    int insert(SgipTemplate record);

    int insertSelective(SgipTemplate record);

    List<SgipTemplate> selectByExample(SgipTemplateCriteria example);

    int updateByExampleSelective(@Param("record") SgipTemplate record, @Param("example") SgipTemplateCriteria example);

    int updateByExample(@Param("record") SgipTemplate record, @Param("example") SgipTemplateCriteria example);
}