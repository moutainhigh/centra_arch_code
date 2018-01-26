package com.ifudata.ums.dao.interfaces;


import com.ifudata.ums.dao.mapper.bo.SmsResult;
import com.ifudata.ums.dao.mapper.bo.SmsResultCriteria;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SmsResultMapper {
    int countByExample(SmsResultCriteria example);
    int countByExampleTimeout(SmsResultCriteria example);
    int deleteByExample(SmsResultCriteria example);
    int deleteByExampleTimeout(SmsResultCriteria example);

    int insert(SmsResult record);
    int insertTimeout(SmsResult record);

    int insertSelective(SmsResult record);
    int insertSelectiveTimeout(SmsResult record);
    
    int insertToBackup(@Param("currmonth") String currmonth, @Param("record") SmsResult record);
    int insertToTimeout(@Param("record") SmsResult record);
    
    List<SmsResult> selectByExample(SmsResultCriteria example);
    List<SmsResult> selectByExampleTimeout(SmsResultCriteria example);

    int updateByExampleSelective(@Param("record") SmsResult record, @Param("example") SmsResultCriteria example);
    int updateByExampleSelectiveTimeout(@Param("record") SmsResult record, @Param("example") SmsResultCriteria example);

    int updateByExample(@Param("record") SmsResult record, @Param("example") SmsResultCriteria example);
    int updateByExampleTimeout(@Param("record") SmsResult record, @Param("example") SmsResultCriteria example);
}