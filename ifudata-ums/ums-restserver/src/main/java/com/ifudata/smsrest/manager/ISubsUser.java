package com.ifudata.smsrest.manager;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import com.ifudata.smsrest.db.mapper.bo.SubsUser;
import com.ifudata.smsrest.db.mapper.bo.SubsUserCriteria;

public interface ISubsUser {
    List<SubsUser> getSubsUser(SubsUserCriteria criteria);
    SqlSessionTemplate getSqlSessionTemplate();
    void setSqlSessionTemplate(SqlSessionTemplate session);
}
