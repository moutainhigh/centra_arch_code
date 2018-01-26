package com.ifudata.smsrest.db.interfaces;


import com.ifudata.smsrest.db.mapper.bo.SmsResult;
import com.ifudata.smsrest.db.mapper.bo.SmsResultCriteria;
import com.ifudata.smsrest.db.mapper.bo.SmsResultHis;
import com.ifudata.smsrest.db.mapper.bo.SmsResultHisCriteria;

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
    
    List<SmsResultHis> selectByExampleHis(SmsResultHisCriteria example);
    
    int updateByExampleSelective(@Param("record") SmsResult record, @Param("example") SmsResultCriteria example);
    int updateByExampleHisSelective(@Param("currmonth") String currmonth, @Param("record") SmsResultHis record, @Param("example") SmsResultHisCriteria example);
    int updateByExampleSelectiveTimeout(@Param("record") SmsResult record, @Param("example") SmsResultCriteria example);

    int updateByExample(@Param("record") SmsResult record, @Param("example") SmsResultCriteria example);
    int updateByExampleTimeout(@Param("record") SmsResult record, @Param("example") SmsResultCriteria example);
    int updateByExampleHis(@Param("currmonth") String currmonth, @Param("record") SmsResultHis record, @Param("example") SmsResultHisCriteria example);
}