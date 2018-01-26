package com.ifudata.smsrest.manager.impl;

import com.ifudata.smsrest.manager.ISmsResult;
import com.ifudata.smsrest.db.interfaces.SmsResultMapper;
import com.ifudata.smsrest.db.mapper.bo.SmsResult;
import com.ifudata.smsrest.db.mapper.bo.SmsResultCriteria;
import com.ifudata.smsrest.db.mapper.bo.SmsResultHis;
import com.ifudata.smsrest.db.mapper.bo.SmsResultHisCriteria;
import com.ifudata.smsrest.util.DateUtils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Iterator;
import java.util.List;

/**
 * Created by lvsj on 2015/9/27.
 */
public class SmsResultService implements ISmsResult {
	private static Log log = LogFactory.getLog(SmsResultService.class);
	private SqlSessionTemplate sqlSessionTemplate;
	@Autowired
	private SmsResultMapper smsResultMapper;

	// ISysSequenceCredit sysSequence;
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true, timeout = 20)
	public List<SmsResult> getSmsResult(SmsResultCriteria criteria) {
		return smsResultMapper.selectByExample(criteria);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = true, timeout = 20)
	public List<SmsResult> getSmsResultTimeout(SmsResultCriteria criteria) {
		return smsResultMapper.selectByExampleTimeout(criteria);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = true, timeout = 20)
	public List<SmsResultHis> getSmsResultHis(String str, SmsResultHisCriteria criteria) {
		return smsResultMapper.selectByExampleHis(criteria);
	}
	
	@Override
	@Transactional(rollbackFor = Exception.class)
	public Integer updateSmsResult(SmsResult rec, SmsResultCriteria criteria) throws Exception {
		int nRet = smsResultMapper.updateByExampleSelective(rec, criteria);
		if (nRet <= 0) {
			throw new Exception("更新异常" + "跟新为:" + rec.toString() + "更新条件:" + criteria.toString());
		}
		return nRet;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public Integer updateSmsResultHis(String str, SmsResultHis rec, SmsResultHisCriteria criteria) throws Exception {
		int nRet = smsResultMapper.updateByExampleHisSelective(str, rec, criteria);
		if (nRet <= 0) {
			throw new Exception("更新异常" + "跟新为:" + rec.toString() + "更新条件:" + criteria.toString());
		}
		return nRet;
	}
	
	@Override
	@Transactional(rollbackFor = Exception.class)
	public Integer updateSmsResultTimeout(SmsResult rec, SmsResultCriteria criteria) throws Exception {
		int nRet = smsResultMapper.updateByExampleSelectiveTimeout(rec, criteria);
		if (nRet <= 0) {
			throw new Exception("更新异常" + "跟新为:" + rec.toString() + "更新条件:" + criteria.toString());
		}
		return nRet;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public Integer insertSmsResult(List<SmsResult> recs) throws Exception {
		int nCount = recs.size();
		int nc = 0;
		Iterator<SmsResult> iterator = recs.iterator();
		while (iterator.hasNext()) {
			int nRet = insertSmsResult(iterator.next());
			if (nRet <= 0) {
				break;
			}
			iterator.remove();
			nc++;
		}
		if (nc < nCount) {
			throw new Exception("插入结果表数目不对" + recs.toString());
		}
		return nc;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public Integer insertSmsResultTimeout(List<SmsResult> recs) throws Exception {
		int nCount = recs.size();
		int nc = 0;
		Iterator<SmsResult> iterator = recs.iterator();
		while (iterator.hasNext()) {
			int nRet = insertSmsResultTimeout(iterator.next());
			if (nRet <= 0) {
				break;
			}
			iterator.remove();
			nc++;
		}
		if (nc < nCount) {
			throw new Exception("插入结果表数目不对" + recs.toString());
		}
		return nc;
	}

	@Transactional(rollbackFor = Exception.class)
	public Integer insertSmsResult(SmsResult recs) throws Exception {

		int nRet = smsResultMapper.insert(recs);
		if (nRet <= 0) {
			throw new Exception("插入结果表不成功" + recs.toString());
		}
		return nRet;
	}

	@Transactional(rollbackFor = Exception.class)
	public Integer insertSmsResultTimeout(SmsResult recs) throws Exception {

		int nRet = smsResultMapper.insertTimeout(recs);
		if (nRet <= 0) {
			throw new Exception("插入结果表不成功" + recs.toString());
		}
		return nRet;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public Integer moveSmsResult(SmsResult rec) throws Exception {
		String currmonth = DateUtils.getCurrMonth();
		// 插入到历史表
		int nRet = smsResultMapper.insertToBackup(currmonth, rec);
		if (nRet <= 0) {
			throw new Exception("备份不成功");
		}
		nRet = deleteSmsResult(rec);
		return nRet;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public Integer moveSmsResult(List<SmsResult> rec) throws Exception {
		int i = 0;
		Iterator<SmsResult> iterator = rec.iterator();
		while (iterator.hasNext()) {
			int nRet = moveSmsResult(iterator.next());
			if (nRet > 0) {
				i++;
			} else {
				break;
			}
		}
		return i;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public Integer moveSmsResultTimeout(SmsResult rec) throws Exception {
		// String currmonth = DateUtils.getCurrMonth();
		// 插入到timeout表
		int nRet = smsResultMapper.insertToTimeout(rec);
		if (nRet <= 0) {
			throw new Exception("转移到timeout表不成功");
		}
		// 删除sms_result表里的记录!!!
		nRet = deleteSmsResult(rec);
		return nRet;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public Integer moveSmsResultTimeout(List<SmsResult> rec) throws Exception {
		int i = 0;
		Iterator<SmsResult> iterator = rec.iterator();
		while (iterator.hasNext()) {
			int nRet = moveSmsResultTimeout(iterator.next());
			if (nRet > 0) {
				i++;
			} else {
				break;
			}
		}
		return i;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public Integer moveSmsResultTimeoutToBackup(SmsResult rec) throws Exception {
		String currmonth = DateUtils.getCurrMonth();
		int nRet = smsResultMapper.insertToBackup(currmonth, rec);
		if (nRet <= 0) {
			throw new Exception("转移到" + currmonth + "表不成功");
		}
		// 删除sms_result_timeout表里的记录!!!
		nRet = deleteSmsResultTimeout(rec);
		return nRet;
	}

	@Transactional(rollbackFor = Exception.class)
	public Integer deleteSmsResult(SmsResult rec) throws Exception {
		SmsResultCriteria criteria = new SmsResultCriteria();
		criteria.clear();
		criteria.createCriteria().andResSeqEqualTo(rec.getResSeq());

		int nRet = smsResultMapper.deleteByExample(criteria);
		if (nRet <= 0) {
			//todo zhanghy6 使用其它方式删除
			criteria.clear();
			criteria.createCriteria().andGsmcontentEqualTo(rec.getGsmcontent())
									 .andServicetypeEqualTo(rec.getServicetype())
									 .andPhoneEqualTo(rec.getPhone())
									 .andSrcNameEqualTo(rec.getSrcName())
									 .andTemplateIdEqualTo(rec.getTemplateId());
			nRet = smsResultMapper.deleteByExample(criteria);
			if (nRet <= 0) {
				//throw new DeleteException("删除失败Verifyid[" + rec.getVerifyid() + "]");
				log.error("删除失败Verifyid[" + rec.getVerifyid() + "]");
			}
			
			throw new Exception("删除失败getResSeq[" + rec.getResSeq() + "]");
		}
		return nRet;
	}

	@Transactional(rollbackFor = Exception.class)
	public Integer deleteSmsResultTimeout(SmsResult rec) throws Exception {
		SmsResultCriteria criteria = new SmsResultCriteria();
		criteria.clear();
		criteria.createCriteria().andResSeqEqualTo(rec.getResSeq());

		int nRet = smsResultMapper.deleteByExampleTimeout(criteria);
		if (nRet <= 0) {
			throw new Exception("删除失败getResSeq[" + rec.getResSeq() + "]");
		}
		return nRet;
	}

	@Override
	public SqlSessionTemplate getSqlSessionTemplate() {
		return sqlSessionTemplate;
	}

	@Override
	public void setSqlSessionTemplate(SqlSessionTemplate session) {
		this.sqlSessionTemplate = session;
	}

	@Override
	public List<SmsResultHis> getSmsResultHis(String str, String srcName) {
		// TODO Auto-generated method stub
		SmsResultHisCriteria criteria = new SmsResultHisCriteria();
		criteria.clear();
		criteria.currmonth = str;
		criteria.setLimitStart(0);
		criteria.setLimitEnd(100);
		//此处为rest服务获取回执  时间 缺省为空 获取之后更新为获取时间 以后就不再获取
		criteria.createCriteria().andReportingTimeIsNull().andSrcNameEqualTo(srcName);
		//criteria.createCriteria().andSrcNameEqualTo(srcName);
		List<SmsResultHis> nRet = smsResultMapper.selectByExampleHis(criteria);
		return nRet;
	}
}
