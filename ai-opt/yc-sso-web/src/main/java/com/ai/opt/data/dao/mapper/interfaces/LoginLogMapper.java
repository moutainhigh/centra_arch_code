package com.ai.opt.data.dao.mapper.interfaces;

import java.util.List;

import com.ai.opt.data.dao.mapper.bo.LoginLog;
import com.ai.opt.data.dao.mapper.bo.LoginLogCriteria;
import org.apache.ibatis.annotations.Param;


public interface LoginLogMapper {
    int countByExample(LoginLogCriteria example);

    int deleteByExample(LoginLogCriteria example);

    int insert(LoginLog record);

    int insertSelective(LoginLog record);

    List<LoginLog> selectByExample(LoginLogCriteria example);

    int updateByExampleSelective(@Param("record") LoginLog record, @Param("example") LoginLogCriteria example);

    int updateByExample(@Param("record") LoginLog record, @Param("example") LoginLogCriteria example);
}