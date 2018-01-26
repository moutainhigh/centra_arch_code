package com.ifudata.ic.data.dao.mapper.interfaces;

import java.util.List;

import com.ifudata.ic.data.dao.mapper.bo.SysUserCriteria;
import org.apache.ibatis.annotations.Param;

import com.ifudata.ic.data.dao.mapper.bo.SysUser;

public interface SysUserMapper {
    int countByExample(SysUserCriteria example);

    int deleteByExample(SysUserCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    List<SysUser> selectByExample(SysUserCriteria example);

    SysUser selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SysUser record, @Param("example") SysUserCriteria example);

    int updateByExample(@Param("record") SysUser record, @Param("example") SysUserCriteria example);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);
}