package com.ai.opt.data.dao.mapper.factory;


import javax.annotation.PostConstruct;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.opt.data.dao.mapper.interfaces.LoginLogMapper;
import com.ai.opt.data.dao.mapper.interfaces.UcContinueLoginLogMapper;
import com.ai.opt.data.dao.mapper.interfaces.UcMembersMapper;





@Component
public class MapperFactory {

    private static SqlSessionTemplate sqlSessionTemplate;
    
    @Autowired
    private SqlSessionTemplate st;

    @PostConstruct
    void init() {
        setSqlSessionTemplate(st);
    }
    
    public static SqlSessionTemplate getSqlSessionTemplate() {
        return sqlSessionTemplate;
    }

    public static void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        MapperFactory.sqlSessionTemplate = sqlSessionTemplate;
    }

  

    public static UcMembersMapper getUcMembersMapper() {
        return sqlSessionTemplate.getMapper(UcMembersMapper.class);
    }
    
    
    public static LoginLogMapper getLoginLogMapper() {
    	return sqlSessionTemplate.getMapper(LoginLogMapper.class);
    }
    
    
    public static UcContinueLoginLogMapper getUcContinueLoginLogMapper() {
    	return sqlSessionTemplate.getMapper(UcContinueLoginLogMapper.class);
    }

    
}
