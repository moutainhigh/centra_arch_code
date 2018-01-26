package com.ifudata.smsrest.db.interfaces;


import com.ifudata.smsrest.db.mapper.bo.SysSequenceCredit;
import com.ifudata.smsrest.db.mapper.bo.SysSequenceCreditCriteria;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysSequenceCreditMapper {
    int countByExample(SysSequenceCreditCriteria example);

    int deleteByExample(SysSequenceCreditCriteria example);

    int deleteByPrimaryKey(String sequenceName);

    int insert(SysSequenceCredit record);

    int insertSelective(SysSequenceCredit record);

    List<SysSequenceCredit> selectByExample(SysSequenceCreditCriteria example);

    SysSequenceCredit selectByPrimaryKey(String sequenceName);

    int updateByExampleSelective(@Param("record") SysSequenceCredit record, @Param("example") SysSequenceCreditCriteria example);

    int updateByExample(@Param("record") SysSequenceCredit record, @Param("example") SysSequenceCreditCriteria example);

    int updateByPrimaryKeySelective(SysSequenceCredit record);

    int updateByPrimaryKey(SysSequenceCredit record);
}