package com.ifudata.smsrest.manager;

import com.ifudata.smsrest.db.mapper.bo.SmsResult;
import com.ifudata.smsrest.db.mapper.bo.SmsResultCriteria;
import com.ifudata.smsrest.db.mapper.bo.SmsResultHis;
import com.ifudata.smsrest.db.mapper.bo.SmsResultHisCriteria;

import org.mybatis.spring.SqlSessionTemplate;
import java.util.List;

/**
 * Created by lvsj on 2015/9/27.
 */
public interface ISmsResult {
    List<SmsResult> getSmsResult(SmsResultCriteria criteria);
    List<SmsResult> getSmsResultTimeout(SmsResultCriteria criteria);
    List<SmsResultHis> getSmsResultHis(String str, String srcName);
    Integer updateSmsResult(SmsResult rec, SmsResultCriteria criteria) throws Exception;
    Integer updateSmsResultHis(String str, SmsResultHis rec, SmsResultHisCriteria criteria) throws Exception;
    Integer updateSmsResultTimeout(SmsResult rec, SmsResultCriteria criteria) throws Exception;
    Integer insertSmsResult(SmsResult recs) throws Exception;
    Integer insertSmsResult(List<SmsResult> recs) throws Exception;
    Integer insertSmsResultTimeout(List<SmsResult> recs) throws Exception;
    Integer deleteSmsResult(SmsResult rec) throws Exception;
    Integer moveSmsResult(List<SmsResult> rec) throws Exception;
    Integer moveSmsResult(SmsResult rec) throws Exception;
    //超时的先转移到timeout表中 防止积压
    Integer moveSmsResultTimeout(List<SmsResult> rec) throws Exception;
    Integer moveSmsResultTimeout(SmsResult rec) throws Exception;
    Integer moveSmsResultTimeoutToBackup(SmsResult rec) throws Exception;
    SqlSessionTemplate getSqlSessionTemplate();
    void setSqlSessionTemplate(SqlSessionTemplate session);
}
