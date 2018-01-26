package com.ifudata.ums.manager;

import com.ifudata.ums.exception.FindSeqenceException;
import com.ifudata.ums.exception.UpdateException;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.List;


/**
 * Created by lvsj on 2015/9/27.
 */
public interface ISysSequenceCredit {
    List<Long> getSequence(String name, int nCount) throws UpdateException,FindSeqenceException,Exception;
    Long getSequence(String name) throws UpdateException,FindSeqenceException,Exception;
    SqlSessionTemplate getSqlSessionTemplate();
    void setSqlSessionTemplate(SqlSessionTemplate session);
}
