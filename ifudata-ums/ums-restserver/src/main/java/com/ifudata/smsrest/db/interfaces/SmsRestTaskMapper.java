package com.ifudata.smsrest.db.interfaces;

import com.ifudata.smsrest.db.mapper.bo.SmsRestTask;
import com.ifudata.smsrest.db.mapper.bo.SmsRestTaskCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SmsRestTaskMapper {
    int countByExample(SmsRestTaskCriteria example);

    int deleteByExample(SmsRestTaskCriteria example);

    int deleteByPrimaryKey(Integer taskSerial);

    int insert(SmsRestTask record);

    int insertSelective(SmsRestTask record);

    List<SmsRestTask> selectByExample(SmsRestTaskCriteria example);

    SmsRestTask selectByPrimaryKey(Integer taskSerial);

    int updateByExampleSelective(@Param("record") SmsRestTask record, @Param("example") SmsRestTaskCriteria example);

    int updateByExample(@Param("record") SmsRestTask record, @Param("example") SmsRestTaskCriteria example);

    int updateByPrimaryKeySelective(SmsRestTask record);

    int updateByPrimaryKey(SmsRestTask record);
}