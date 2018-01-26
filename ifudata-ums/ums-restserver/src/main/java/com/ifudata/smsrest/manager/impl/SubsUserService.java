package com.ifudata.smsrest.manager.impl;

import java.util.List;

//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.ifudata.smsrest.db.interfaces.SubsUserMapper;
import com.ifudata.smsrest.db.mapper.bo.SubsUser;
import com.ifudata.smsrest.db.mapper.bo.SubsUserCriteria;
import com.ifudata.smsrest.manager.ISubsUser;

public class SubsUserService  implements ISubsUser {
//	private static Log log = LogFactory.getLog(SubsUserService.class);
	private SqlSessionTemplate sqlSessionTemplate;
	@Autowired
	private SubsUserMapper subsUserMapper;
	@Override
	public List<SubsUser> getSubsUser(SubsUserCriteria criteria) {
		return subsUserMapper.selectByExample(criteria);
	}

	@Override
	public SqlSessionTemplate getSqlSessionTemplate() {
		return sqlSessionTemplate;
	}

	@Override
	public void setSqlSessionTemplate(SqlSessionTemplate session) {
		this.sqlSessionTemplate = session;
	}
}
