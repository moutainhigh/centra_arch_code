package com.ai.opt.data.dao.mapper.interfaces;

import java.util.List;

import com.ai.opt.data.dao.mapper.bo.UcContinueLoginLog;
import com.ai.opt.data.dao.mapper.bo.UcContinueLoginLogCriteria;
import org.apache.ibatis.annotations.Param;


public interface UcContinueLoginLogMapper {
    int countByExample(UcContinueLoginLogCriteria example);

    int deleteByExample(UcContinueLoginLogCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(UcContinueLoginLog record);

    int insertSelective(UcContinueLoginLog record);

    List<UcContinueLoginLog> selectByExample(UcContinueLoginLogCriteria example);

    UcContinueLoginLog selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") UcContinueLoginLog record, @Param("example") UcContinueLoginLogCriteria example);

    int updateByExample(@Param("record") UcContinueLoginLog record, @Param("example") UcContinueLoginLogCriteria example);

    int updateByPrimaryKeySelective(UcContinueLoginLog record);

    int updateByPrimaryKey(UcContinueLoginLog record);
}