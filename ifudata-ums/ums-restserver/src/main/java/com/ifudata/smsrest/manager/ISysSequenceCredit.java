package com.ifudata.smsrest.manager;

import org.mybatis.spring.SqlSessionTemplate;

import java.util.List;


/**
 * Created by lvsj on 2015/9/27.
 */
public interface ISysSequenceCredit {
    List<Long> getSequence(String name, int nCount) throws Exception;
    Long getSequence(String name) throws Exception;
    SqlSessionTemplate getSqlSessionTemplate();
    void setSqlSessionTemplate(SqlSessionTemplate session);
}
