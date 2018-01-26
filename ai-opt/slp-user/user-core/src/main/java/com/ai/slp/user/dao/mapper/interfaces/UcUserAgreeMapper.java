package com.ai.slp.user.dao.mapper.interfaces;

import com.ai.slp.user.dao.mapper.bo.UcUserAgree;
import com.ai.slp.user.dao.mapper.bo.UcUserAgreeCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UcUserAgreeMapper {
    int countByExample(UcUserAgreeCriteria example);

    int deleteByExample(UcUserAgreeCriteria example);

    int insert(UcUserAgree record);

    int insertSelective(UcUserAgree record);

    List<UcUserAgree> selectByExample(UcUserAgreeCriteria example);

    int updateByExampleSelective(@Param("record") UcUserAgree record, @Param("example") UcUserAgreeCriteria example);

    int updateByExample(@Param("record") UcUserAgree record, @Param("example") UcUserAgreeCriteria example);
}