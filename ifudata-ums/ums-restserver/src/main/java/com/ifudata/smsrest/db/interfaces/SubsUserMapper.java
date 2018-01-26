package com.ifudata.smsrest.db.interfaces;

import com.ifudata.smsrest.db.mapper.bo.SubsUser;
import com.ifudata.smsrest.db.mapper.bo.SubsUserCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SubsUserMapper {
    int countByExample(SubsUserCriteria example);

    int deleteByExample(SubsUserCriteria example);

    int deleteByPrimaryKey(Long subsUniqueId);

    int insert(SubsUser record);

    int insertSelective(SubsUser record);

    List<SubsUser> selectByExample(SubsUserCriteria example);

    SubsUser selectByPrimaryKey(Long subsUniqueId);

    int updateByExampleSelective(@Param("record") SubsUser record, @Param("example") SubsUserCriteria example);

    int updateByExample(@Param("record") SubsUser record, @Param("example") SubsUserCriteria example);

    int updateByPrimaryKeySelective(SubsUser record);

    int updateByPrimaryKey(SubsUser record);
}