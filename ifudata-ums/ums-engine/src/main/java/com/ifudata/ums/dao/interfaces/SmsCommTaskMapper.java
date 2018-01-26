package com.ifudata.ums.dao.interfaces;

import com.ifudata.ums.dao.mapper.bo.SmsCommTask;
import com.ifudata.ums.dao.mapper.bo.SmsCommTaskCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SmsCommTaskMapper {
    int countByExample(SmsCommTaskCriteria example);

    int deleteByExample(SmsCommTaskCriteria example);

    int deleteByPrimaryKey(Integer commTaskSerial);

    int insert(SmsCommTask record);

    int insertSelective(SmsCommTask record);

    List<SmsCommTask> selectByExample(SmsCommTaskCriteria example);

    SmsCommTask selectByPrimaryKey(Integer commTaskSerial);

    int updateByExampleSelective(@Param("record") SmsCommTask record, @Param("example") SmsCommTaskCriteria example);

    int updateByExample(@Param("record") SmsCommTask record, @Param("example") SmsCommTaskCriteria example);

    int updateByPrimaryKeySelective(SmsCommTask record);

    int updateByPrimaryKey(SmsCommTask record);
}