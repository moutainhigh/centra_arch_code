package com.ai.slp.user.service.business.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.vo.PageInfo;
import com.ai.opt.sdk.dubbo.util.DubboConsumerFactory;
import com.ai.opt.sdk.util.CollectionUtil;
import com.ai.opt.sdk.util.DateUtil;
import com.ai.paas.ipaas.util.StringUtil;
import com.ai.slp.common.api.cache.interfaces.ICacheSV;
import com.ai.slp.common.api.cache.param.SysParam;
import com.ai.slp.common.api.cache.param.SysParamSingleCond;
import com.ai.slp.common.api.servicenum.interfaces.IServiceNumSV;
import com.ai.slp.common.api.servicenum.param.ServiceNum;
import com.ai.slp.user.api.ucuserphonebooks.param.UcTelGroupMantainReq;
import com.ai.slp.user.api.ucuserphonebooks.param.UcUserPhonebooksBatchData;
import com.ai.slp.user.api.ucuserphonebooks.param.UcUserPhonebooksModifyReq;
import com.ai.slp.user.api.ucuserphonebooks.param.UcUserPhonebooksQueryReq;
import com.ai.slp.user.api.ucuserphonebooks.param.UserPhonebook;
import com.ai.slp.user.dao.mapper.bo.UcTelGroup;
import com.ai.slp.user.dao.mapper.bo.UcTelGroupCriteria;
import com.ai.slp.user.dao.mapper.bo.UcUserPhonebooks;
import com.ai.slp.user.dao.mapper.bo.UcUserPhonebooksCriteria;
import com.ai.slp.user.dao.mapper.bo.UcUserPhonebooksCriteria.Criteria;
import com.ai.slp.user.dao.mapper.interfaces.UcTelGroupMapper;
import com.ai.slp.user.dao.mapper.interfaces.UcUserPhonebooksMapper;
import com.ai.slp.user.service.business.interfaces.IUserPhoneBooksBusiSV;
import com.ai.slp.user.util.SequenceUtil;

@Service
@Transactional
public class UserPhoneBooksBusiSVImpl implements IUserPhoneBooksBusiSV {

	@Autowired
	private UcUserPhonebooksMapper ucUserPhonebooksMapper;

	@Autowired
	private UcTelGroupMapper ucTelGroupMapper;

	@Override
	public void addUcTelGroup(UcTelGroupMantainReq req) {
		int count = this.getTelGroupsCount(req.getUserId());
		if (count >= 10) {
			throw new BusinessException("1000", "您最多只能添加10个通讯录组");
		}
		int exists = this.getTelGroupsByName(req.getUserId(), req.getTelGroupName(), null);
		if (exists > 0) {
			throw new BusinessException("1000", "该用户下已经存在同名分组，请更换分组名称");
		}
		UcTelGroup record = new UcTelGroup();
		record.setTelGroupId(SequenceUtil.createTelGroupId());
		record.setTelGroupName(req.getTelGroupName());
		record.setTenantId(req.getTenantId());
		record.setSeq(1);
		record.setCreateTime(DateUtil.getSysDate());
		record.setUpdateTime(DateUtil.getSysDate());
		record.setUserId(req.getUserId());
		ucTelGroupMapper.insert(record);
	}

	@Override
	public void modifyUcTelGroup(UcTelGroupMantainReq req) {
		int exists = this.getTelGroupsByName(req.getUserId(), req.getTelGroupName(), req.getTelGroupId());
		if (exists > 0) {
			throw new BusinessException("1000", "该用户下已经存在同名分组，请更换分组名称");
		}
		UcTelGroup record = new UcTelGroup();
		record.setTelGroupName(req.getTelGroupName());
		record.setUpdateTime(DateUtil.getSysDate());
		UcTelGroupCriteria sql = new UcTelGroupCriteria();
		sql.or().andTelGroupIdEqualTo(req.getTelGroupId());
		ucTelGroupMapper.updateByExampleSelective(record, sql);
	}

	@Override
	public void deleteUcTelGroup(UcTelGroupMantainReq req) {
		// int count = this.getTelGroupPhoneBookCount(req.getTelGroupId());
		UcTelGroupCriteria sql = new UcTelGroupCriteria();
		sql.or().andTelGroupIdEqualTo(req.getTelGroupId());
		ucTelGroupMapper.deleteByExample(sql);
		UcUserPhonebooksCriteria example = new UcUserPhonebooksCriteria();
		Criteria phoneBooksCriteria = example.or();
		phoneBooksCriteria.andTelGroupIdEqualTo(req.getTelGroupId());
		ucUserPhonebooksMapper.deleteByExample(example);
	}

	@Override
	public List<com.ai.slp.user.api.ucuserphonebooks.param.UcTelGroup> getUcTelGroups(String userId) {
		UcTelGroupCriteria sql = new UcTelGroupCriteria();
		sql.or().andUserIdEqualTo(userId);
		List<UcTelGroup> list = ucTelGroupMapper.selectByExample(sql);
		List<com.ai.slp.user.api.ucuserphonebooks.param.UcTelGroup> l = new ArrayList<com.ai.slp.user.api.ucuserphonebooks.param.UcTelGroup>();
		if (!CollectionUtil.isEmpty(list)) {
			for (UcTelGroup g : list) {
				com.ai.slp.user.api.ucuserphonebooks.param.UcTelGroup b = new com.ai.slp.user.api.ucuserphonebooks.param.UcTelGroup();
				BeanUtils.copyProperties(g, b);
				b.setCreateTimeStr(DateUtil.getDateString(g.getCreateTime(), DateUtil.DATETIME_FORMAT));
				b.setUpdateTimeStr(DateUtil.getDateString(g.getUpdateTime(), DateUtil.DATETIME_FORMAT));
				int count = this.getTelGroupPhoneBookCount(g.getTelGroupId());
				b.setCount(count);
				l.add(b);
			}
		}
		return l;
	}

	private int getTelGroupsCount(String userId) {
		UcTelGroupCriteria sql = new UcTelGroupCriteria();
		sql.or().andUserIdEqualTo(userId);
		return ucTelGroupMapper.countByExample(sql);
	}

	private int getTelGroupsByName(String userId, String telGroupName, String TelGroupId) {
		UcTelGroupCriteria sql = new UcTelGroupCriteria();
		UcTelGroupCriteria.Criteria groupsCriteria = sql.or();
		groupsCriteria.andUserIdEqualTo(userId).andTelGroupNameEqualTo(telGroupName);
		if (TelGroupId != null) {
			groupsCriteria.andTelGroupIdNotEqualTo(TelGroupId);
		}
		return ucTelGroupMapper.countByExample(sql);
	}

	private int getTelGroupPhoneBookCount(String telGroupId) {
		UcUserPhonebooksCriteria sql = new UcUserPhonebooksCriteria();
		sql.or().andTelGroupIdEqualTo(telGroupId);
		int count = ucUserPhonebooksMapper.countByExample(sql);
		return count;
	}

	@Override
	public void batchDeleteUserPhonebooks(List<String> recordIds) {
		for (String recordId : recordIds) {
			ucUserPhonebooksMapper.deleteByPrimaryKey(recordId);
		}
	}

	@Override
	public List<String> batchAddUserPhonebooks(Map<String, UcUserPhonebooksBatchData> dataMap) {
		if (dataMap.isEmpty()) {
			return null;
		}
		List<String> errors = new ArrayList<String>();

		UcUserPhonebooksCriteria phoneBookeEample = new UcUserPhonebooksCriteria();
		Criteria checkBookCriteria = phoneBookeEample.createCriteria();
		String telGroupId = dataMap.values().iterator().next().getTelGroupId();
		checkBookCriteria.andTelGroupIdEqualTo(telGroupId);
		Set<Entry<String, UcUserPhonebooksBatchData>> phoneBookesSet = dataMap.entrySet();
		List<String> telMpList = new LinkedList<String>();
		for (Entry<String, UcUserPhonebooksBatchData> phoneBookData : phoneBookesSet) {
			UcUserPhonebooksBatchData value = phoneBookData.getValue();
			String telMp = value.getTelMp();
			telMpList.add(telMp);
		}
		checkBookCriteria.andTelMpIn(telMpList);
		List<UcUserPhonebooks> existsPhoneBooks = ucUserPhonebooksMapper.selectByExample(phoneBookeEample);

		List<UcUserPhonebooks> addPhoneBookesList = new LinkedList<UcUserPhonebooks>();
		if (existsPhoneBooks != null && existsPhoneBooks.size() > 0) {
			Set<String> existsTelMpSet = new HashSet<String>();
			for (UcUserPhonebooks phoneBookData : existsPhoneBooks) {
				existsTelMpSet.add(phoneBookData.getTelMp());
			}
			Set<String> telMpSet = dataMap.keySet();
			for (String telMp : telMpSet) {
				if (!existsTelMpSet.contains(telMp)) {
					UcUserPhonebooks addPhonebooksData = getAddPhonebooksData(dataMap.get(telMp));
					addPhoneBookesList.add(addPhonebooksData);
				} else {
					errors.add("第" + dataMap.get(telMp).getIndexNo() + "条的号码已经存在该分组中");
				}
			}
		} else {
			Set<String> telMpSet = dataMap.keySet();
			for (String telMp : telMpSet) {
				UcUserPhonebooks addPhonebooksData = getAddPhonebooksData(dataMap.get(telMp));
				addPhoneBookesList.add(addPhonebooksData);
			}
		}
		if (addPhoneBookesList.size() > 0) {
			ucUserPhonebooksMapper.insertList(addPhoneBookesList);
		}

		// for (String telMp : dataMap.keySet()) {
		// UcUserPhonebooksBatchData d = dataMap.get(telMp);
		// // 判断号码是否重复在分组里面
		// boolean exists = this.checkTelMpExists(d.getTelMp(),
		// d.getTelGroupId(), null);
		// if (exists) {
		// errors.add("第" + d.getIndexNo() + "条的号码已经存在该分组中");
		// continue;
		// }
		// try {
		// ServiceNum serviceNum = this.getServiceNumInfo(telMp);
		// UcUserPhonebooks record = new UcUserPhonebooks();
		// record.setTelNo(SequenceUtil.createTelNo());
		// record.setBasicOrgId(serviceNum.getBasicOrgCode());
		// record.setProvinceCode(serviceNum.getProvinceCode());
		// record.setCityCode(serviceNum.getCityCode());
		// record.setTelGroupId(d.getTelGroupId());
		// Timestamp time = DateUtil.getSysDate();
		// record.setCreateTime(time);
		// record.setTelMp(d.getTelMp());
		// record.setTelName(d.getTelName());
		// record.setUserId(d.getUserId());
		// record.setTenantId(d.getTenantId());
		// ucUserPhonebooksMapper.insertSelective(record);
		// } catch (Exception ex) {
		// ex.printStackTrace();
		// Log.error("处理失败", ex);
		// errors.add("第" + d.getIndexNo() + "条的号码写入数据库失败");
		// }
		//
		// }
		return errors;

	}

	private UcUserPhonebooks getAddPhonebooksData(UcUserPhonebooksBatchData data) {
		ServiceNum serviceNum = this.getServiceNumInfo(data.getTelMp());
		UcUserPhonebooks record = new UcUserPhonebooks();
		record.setTelNo(SequenceUtil.createTelNo());
		record.setBasicOrgId(serviceNum.getBasicOrgCode());
		record.setProvinceCode(serviceNum.getProvinceCode());
		record.setCityCode(serviceNum.getCityCode());
		record.setTelGroupId(data.getTelGroupId());
		Timestamp time = DateUtil.getSysDate();
		record.setCreateTime(time);
		record.setTelMp(data.getTelMp());
		record.setTelName(data.getTelName());
		record.setUserId(data.getUserId());
		record.setTenantId(data.getTenantId());
		return record;
	}

	private ServiceNum getServiceNumInfo(String telMp) {
		ServiceNum sn = DubboConsumerFactory.getService(IServiceNumSV.class).getServiceNumByPhone(telMp.substring(0, 7));
		if (sn == null) {
			// throw new BusinessException("100000", "根据号码[" + telMp +
			// "]获取不到号段信息");
			sn = new ServiceNum();
			sn.setBasicOrgCode(" ");
			sn.setProvinceCode(" ");
			sn.setCityCode(" ");
		}
		return sn;
	}

	private String getSysParam(String tenantId, String typeCode, String paramCode, String value) {
		SysParamSingleCond singleCond = new SysParamSingleCond(tenantId, typeCode, paramCode, value);
		SysParam p = DubboConsumerFactory.getService(ICacheSV.class).getSysParamSingle(singleCond);
		return p == null ? null : p.getColumnDesc();
	}

	private String getAreaName(String areaCode) {
		if (StringUtil.isBlank(areaCode)) {
			return "未知";
		} else {
			return DubboConsumerFactory.getService(ICacheSV.class).getAreaName(areaCode);
		}
	}

	private boolean checkTelMpExists(String telMp, String telGroupId, String telNo) {
		UcUserPhonebooksCriteria sql = new UcUserPhonebooksCriteria();
		Criteria countCriteria = sql.or();
		countCriteria.andTelMpEqualTo(telMp).andTelGroupIdEqualTo(telGroupId);
		if (telNo != null) {
			countCriteria.andTelNoNotEqualTo(telNo);
		}
		int count = ucUserPhonebooksMapper.countByExample(sql);
		return count > 0 ? true : false;
	}

	@Override
	public void modifyUserPhonebook(UcUserPhonebooksModifyReq req) {

		boolean checkTelMpExists = checkTelMpExists(req.getTelMp(), req.getTelGroupId(), req.getTelNo());
		if (checkTelMpExists) {
			throw new BusinessException("1000", "此号码已经存在该分组中");
		}
		UcUserPhonebooks record = new UcUserPhonebooks();
		ServiceNum serviceNum = this.getServiceNumInfo(req.getTelMp());
		record.setBasicOrgId(serviceNum.getBasicOrgCode());
		record.setProvinceCode(serviceNum.getProvinceCode());
		record.setCityCode(serviceNum.getCityCode());
		record.setTelGroupId(req.getTelGroupId());
		record.setTelName(req.getTelName());
		record.setTelMp(req.getTelMp());
		record.setUpdateTime(DateUtil.getSysDate());
		UcUserPhonebooksCriteria sql = new UcUserPhonebooksCriteria();
		sql.or().andTelNoEqualTo(req.getTelNo());
		ucUserPhonebooksMapper.updateByExampleSelective(record, sql);
	}

	@Override
	public PageInfo<UserPhonebook> queryUserPhonebooks(UcUserPhonebooksQueryReq req) {
		UcUserPhonebooksCriteria ucUserPhonebooksCriteria = new UcUserPhonebooksCriteria();
		Criteria sql = ucUserPhonebooksCriteria.or();
		if (!StringUtil.isBlank(req.getBasicOrgId())) {
			sql.andBasicOrgIdEqualTo(req.getBasicOrgId());
		}
		if (!StringUtil.isBlank(req.getTelMp())) {
			sql.andTelMpLike("%" + req.getTelMp() + "%");
		}
		if (!StringUtil.isBlank(req.getProvinceCode())) {
			sql.andProvinceCodeEqualTo(req.getProvinceCode());
		}
		if (!StringUtil.isBlank(req.getTelName())) {
			sql.andTelNameLike("%" + req.getTelName() + "%");
		}
		if (!StringUtil.isBlank(req.getTelGroupId())) {
			sql.andTelGroupIdEqualTo(req.getTelGroupId());
		}
		int count = ucUserPhonebooksMapper.countByExample(ucUserPhonebooksCriteria);

		ucUserPhonebooksCriteria.setLimitStart((req.getPageNo() - 1) * req.getPageSize());
		ucUserPhonebooksCriteria.setLimitEnd(req.getPageSize());

		List<UserPhonebook> l = new ArrayList<UserPhonebook>();
		List<UcUserPhonebooks> list = ucUserPhonebooksMapper.selectByExample(ucUserPhonebooksCriteria);
		if (!CollectionUtil.isEmpty(list)) {
			for (UcUserPhonebooks b : list) {
				UserPhonebook t = new UserPhonebook();
				BeanUtils.copyProperties(b, t);
				String basicOrgName = this.getSysParam("SLP", "PRODUCT", "BASIC_ORG_ID", b.getBasicOrgId());
				if (StringUtil.isBlank(basicOrgName)) {
					t.setBasicOrgName("未知");
				} else {
					t.setBasicOrgName(basicOrgName);
				}
				t.setProvinceName(this.getAreaName(b.getProvinceCode()));
				l.add(t);
			}
		}
		PageInfo<UserPhonebook> pageInfo = new PageInfo<UserPhonebook>();
		pageInfo.setResult(l);
		pageInfo.setCount(count);
		pageInfo.setPageNo(req.getPageNo());
		pageInfo.setPageSize(req.getPageSize());
		return pageInfo;
	}

	@Override
	public Integer queryGroupPhonebooksCount(String telGroupId) {
		UcUserPhonebooksCriteria ucUserPhonebooksCriteria = new UcUserPhonebooksCriteria();
		Criteria sql = ucUserPhonebooksCriteria.or();
		sql.andTelGroupIdEqualTo(telGroupId);
		return ucUserPhonebooksMapper.countByExample(ucUserPhonebooksCriteria);
	}
}
