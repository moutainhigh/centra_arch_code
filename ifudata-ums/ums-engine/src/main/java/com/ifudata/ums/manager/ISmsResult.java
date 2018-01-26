package com.ifudata.ums.manager;

import com.ifudata.ums.exception.DeleteException;
import com.ifudata.ums.exception.InsertException;
import com.ifudata.ums.exception.UpdateException;
import com.ifudata.ums.dao.mapper.bo.SmsResult;

import com.ifudata.ums.dao.mapper.bo.SmsResultCriteria;
import org.mybatis.spring.SqlSessionTemplate;
import java.util.List;

/**
 * Created by lvsj on 2015/9/27.
 */
public interface ISmsResult {
    List<SmsResult> getSmsResult(SmsResultCriteria criteria);
    List<SmsResult> getSmsResultTimeout(SmsResultCriteria criteria);
    Integer updateSmsResult(SmsResult rec, SmsResultCriteria criteria) throws UpdateException;
    Integer updateSmsResultTimeout(SmsResult rec, SmsResultCriteria criteria) throws UpdateException;
//    Integer updateSmsResult(SmsResult rec) throws UpdateException;
    Integer insertSmsResult(SmsResult recs) throws InsertException;
    Integer insertSmsResult(List<SmsResult> recs) throws InsertException;
    Integer insertSmsResultTimeout(List<SmsResult> recs) throws InsertException;
    Integer deleteSmsResult(SmsResult rec) throws DeleteException;
    Integer moveSmsResult(List<SmsResult> rec) throws InsertException,DeleteException;
    Integer moveSmsResult(SmsResult rec) throws InsertException,DeleteException;
    //超时的先转移到timeout表中 防止积压
    Integer moveSmsResultTimeout(List<SmsResult> rec) throws InsertException,DeleteException;
    Integer moveSmsResultTimeout(SmsResult rec) throws InsertException,DeleteException;
    Integer moveSmsResultTimeoutToBackup(SmsResult rec) throws InsertException,DeleteException;
    SqlSessionTemplate getSqlSessionTemplate();
    void setSqlSessionTemplate(SqlSessionTemplate session);

}
