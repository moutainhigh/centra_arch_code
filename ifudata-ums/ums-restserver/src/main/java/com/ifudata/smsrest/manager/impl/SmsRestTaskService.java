package com.ifudata.smsrest.manager.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.ifudata.smsrest.manager.ISmsRestTask;
import com.ifudata.smsrest.db.interfaces.SmsRestTaskMapper;
import com.ifudata.smsrest.db.mapper.bo.SmsRestTask;
import com.ifudata.smsrest.db.mapper.bo.SmsRestTaskCriteria;
/**
 *
 * 2015年10月16日下午2:51:57 
 *
 */
public class SmsRestTaskService implements ISmsRestTask {

	private static Log log = LogFactory.getLog(SmsRestTaskService.class);
	@Autowired
	private SmsRestTaskMapper smsRestTaskMapper;
	private SqlSessionTemplate sqlSessionTemplate;
	@Override
	@Transactional(rollbackFor = Exception.class)
	public Integer insertSmsRestTask(List<SmsRestTask> sctlist) throws Exception {
		// TODO Auto-generated method stub
		int count = 0;
		for (SmsRestTask sct : sctlist) {
			log.debug("******** 进入保存SMSCommTask方法  将要保存的SmsCommTask信息 " + sct.toString() + " ********");
			if (smsRestTaskMapper.insert(sct) <= 0) {
				throw new Exception("插入结果表不成功   " + sct.toString());
			} else {
				count++;
			}

		}
		if (count < sctlist.size()) {
			throw new Exception("插入结果表数目不对   " + sctlist.toString());
		}
		return count;
	}

	public SqlSessionTemplate getSqlSessionTemplate() {
		return sqlSessionTemplate;
	}

	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	@Override
	public List<SmsRestTask> getSmsRestTask(List<String> serviceTypeList) throws Exception {
		SmsRestTaskCriteria criteria = new SmsRestTaskCriteria();
		
		criteria.createCriteria().andSvcTypeIn(serviceTypeList)
								.andRegionIdEqualTo("Z");
		criteria.setLimitStart(0);
		criteria.setLimitEnd(100);
		
		criteria.createCriteria().andOptTimeIsNull();

		List<SmsRestTask> records = smsRestTaskMapper.selectByExample(criteria);
		return records;
	}

	@Override
	public Integer updateSmsRestTask(SmsRestTask rec, SmsRestTaskCriteria criteria) throws Exception {
		int nRet = smsRestTaskMapper.updateByExampleSelective(rec, criteria);
		if (nRet <= 0) {
			throw new Exception("更新异常" + "跟新为:" + rec.toString() + "更新条件:" + criteria.toString());
		}
		return nRet;
	}

	@Override
	public Integer updateByPrimaryKey(SmsRestTask rec) throws Exception {
		int nRet = smsRestTaskMapper.updateByPrimaryKey(rec);
		if (nRet <= 0) {
			throw new Exception("更新异常" + "跟新为:" + rec.toString());
		}
		return nRet;
	}

}
