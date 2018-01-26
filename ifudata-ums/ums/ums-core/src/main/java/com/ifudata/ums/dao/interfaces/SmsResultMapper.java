package com.ifudata.ums.dao.interfaces;

import com.ifudata.ums.dao.mapper.bo.SmsResult;
import com.ifudata.ums.dao.mapper.bo.SmsResultCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SmsResultMapper {
    int countByExample(SmsResultCriteria example);

    int deleteByExample(SmsResultCriteria example);

    int insert(SmsResult record);

    int insertSelective(SmsResult record);

    List<SmsResult> selectByExample(SmsResultCriteria example);

    int updateByExampleSelective(@Param("record") SmsResult record, @Param("example") SmsResultCriteria example);

    int updateByExample(@Param("record") SmsResult record, @Param("example") SmsResultCriteria example);
}