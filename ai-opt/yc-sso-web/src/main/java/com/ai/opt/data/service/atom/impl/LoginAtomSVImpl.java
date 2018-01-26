package com.ai.opt.data.service.atom.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.data.api.user.param.ContinueLoginLogResponse;
import com.ai.opt.data.dao.mapper.bo.LoginLog;
import com.ai.opt.data.dao.mapper.bo.LoginLogCriteria;
import com.ai.opt.data.dao.mapper.bo.UcContinueLoginLog;
import com.ai.opt.data.dao.mapper.bo.UcContinueLoginLogCriteria;
import com.ai.opt.data.dao.mapper.bo.UcMembers;
import com.ai.opt.data.dao.mapper.bo.UcMembersCriteria;
import com.ai.opt.data.dao.mapper.bo.UcMembersCriteria.Criteria;
import com.ai.opt.data.dao.mapper.factory.MapperFactory;
import com.ai.opt.data.dao.mapper.interfaces.LoginLogMapper;
import com.ai.opt.data.dao.mapper.interfaces.UcContinueLoginLogMapper;
import com.ai.opt.data.dao.mapper.interfaces.UcMembersMapper;
import com.ai.opt.data.service.atom.interfaces.ILoginAtomSV;
import com.ai.opt.data.util.UCDateUtils;
import com.ai.opt.sdk.components.sequence.util.SeqUtil;
import com.ai.opt.sdk.util.BeanUtils;
import com.ai.opt.sdk.util.CollectionUtil;
import com.ai.opt.sdk.util.StringUtil;

@Component
public class LoginAtomSVImpl implements ILoginAtomSV {

    @Override
    public UcMembers queryByUserName(UcMembers ucMembers) {

    	UcMembersCriteria conditon = new UcMembersCriteria();
    	UcMembersCriteria.Criteria criteria = conditon.or();
        if (!StringUtil.isBlank(ucMembers.getMobilephone())) {
            criteria.andMobilephoneEqualTo(ucMembers.getMobilephone());
            criteria.andEnablestatusEqualTo("1");
        }
        if (!StringUtil.isBlank(ucMembers.getEmail())) {
            criteria.andEmailEqualTo(ucMembers.getEmail());
            criteria.andEnablestatusEqualTo("1");
        }
        if (!StringUtil.isBlank(ucMembers.getUsername())) {
            criteria.andUsernameEqualTo(ucMembers.getUsername());
            criteria.andEnablestatusEqualTo("1");
        }
//        // 登录标记为1
////        criteria.andLoginFlagEqualTo("1");
//        // 删除标记为0
//        
//        criteria.andDelFlagEqualTo("0");

        UcMembersMapper ucMembersMapper = MapperFactory.getUcMembersMapper();
        List<UcMembers> list = ucMembersMapper.selectByExample(conditon);
        if (!CollectionUtil.isEmpty(list)) {
            return list.get(0);
        }
        return null;
    }

	@Override
	public UcMembers queryByUserNamePhoneEmail(String loginname) throws SystemException {
		UcMembersCriteria example = new UcMembersCriteria();
        if (!StringUtil.isBlank(loginname)) {
        	Criteria orUsername = example.or();
			orUsername.andUsernameEqualTo(loginname);
			orUsername.andEnablestatusEqualTo("1");
			Criteria orMobile = example.or();
			orMobile.andMobilephoneEqualTo(loginname);
			orMobile.andEnablestatusEqualTo("1");
			Criteria orEmail = example.or();
			orEmail.andEmailEqualTo(loginname);
			orEmail.andEnablestatusEqualTo("1");
        }

        UcMembersMapper ucMembersMapper = MapperFactory.getUcMembersMapper();
        List<UcMembers> list = ucMembersMapper.selectByExample(example);
        if (!CollectionUtil.isEmpty(list)) {
            return list.get(0);
        }
        return null;
	}

	@Override
	public String insertThirdUser(UcMembers ucMembers) throws BusinessException, SystemException {
		
		//必填
		ucMembers.setPassword("");
		if(StringUtil.isBlank(ucMembers.getEmail())){
			ucMembers.setEmail(""); 
		}
		ucMembers.setEmailcheck(0); 
		ucMembers.setMyid("");
		ucMembers.setMyidkey("");
		ucMembers.setRegip("0");
		Integer regdate =(int)UCDateUtils.getSystime() ;
		ucMembers.setRegdate(regdate);
		ucMembers.setLastloginip("0");
		ucMembers.setLastlogintime(regdate);
		ucMembers.setSalt("");
		ucMembers.setSecques("");
		if(StringUtil.isBlank(ucMembers.getMobilephone())){
			ucMembers.setMobilephone("");
		}
		ucMembers.setSystemsource("0");
		//ucMembers.setThirduid("");
		//ucMembers.setUsersource("");
		ucMembers.setLoginmode("0");
		ucMembers.setLoginway("0");
		//设置为已激活
		ucMembers.setEnablestatus("1");
		ucMembers.setCreatetime(regdate+"");
		if(StringUtil.isBlank(ucMembers.getDomainName())){
			ucMembers.setDomainName("CN");
		}
		ucMembers.setModifydate(0);
		ucMembers.setLogincount(0);
		ucMembers.setLoginsystem("0");
		
		
		int insertCount = MapperFactory.getUcMembersMapper().insert(ucMembers);
		if(insertCount>0){
			
			Integer newId = queryUidofThirdUser(ucMembers.getUsersource(),ucMembers.getThirduid());
		
			return String.valueOf(newId);
		}else{
			return null;
		}
	}

	@Override
	public UcMembers queryThirdUser(String usersource, String thirduid) throws BusinessException, SystemException {
		UcMembers result=null;
		UcMembersCriteria example=new UcMembersCriteria();
		Criteria c=example.or();
		c.andUsersourceEqualTo(usersource).andThirduidEqualTo(thirduid);
		List<UcMembers> list=MapperFactory.getUcMembersMapper().selectByExample(example);
		if(!CollectionUtil.isEmpty(list)){
			result=list.get(0);
		}
		return result;
	}
	private Integer queryUidofThirdUser(String usersource, String thirduid) throws BusinessException, SystemException {
		Integer result=null;
		UcMembersCriteria example=new UcMembersCriteria();
		Criteria c=example.or();
		c.andUsersourceEqualTo(usersource).andThirduidEqualTo(thirduid);
		List<UcMembers> list=MapperFactory.getUcMembersMapper().selectByExample(example);
		if(!CollectionUtil.isEmpty(list)){
			result=list.get(0).getUid();
		}
		return result;
	}

	@Override
	public String saveUserByMobileLogin(UcMembers ucMembers) throws BusinessException, SystemException {

		//必填
		ucMembers.setUsersource("");
		ucMembers.setThirduid("");
		ucMembers.setUsername(ucMembers.getMobilephone());
		ucMembers.setPassword("");
		if(StringUtil.isBlank(ucMembers.getEmail())){
			ucMembers.setEmail(""); 
		}
		ucMembers.setEmailcheck(0); 
		ucMembers.setMyid("");
		ucMembers.setMyidkey("");
		ucMembers.setRegip("0");
		Integer regdate =(int)UCDateUtils.getSystime() ;
		ucMembers.setRegdate(regdate);
		ucMembers.setLastloginip("0");
		ucMembers.setLastlogintime(regdate);
		ucMembers.setSalt("");
		ucMembers.setSecques("");
		if(StringUtil.isBlank(ucMembers.getMobilephone())){
			ucMembers.setMobilephone("");
		}else {
			ucMembers.setMobilephone(ucMembers.getMobilephone());
		}
		ucMembers.setSystemsource("0");
		//ucMembers.setThirduid("");
		//ucMembers.setUsersource("");
		ucMembers.setLoginmode("0");
		ucMembers.setLoginway("0");
		//设置为已激活
		ucMembers.setEnablestatus("1");
		ucMembers.setCreatetime(regdate+"");
		if(StringUtil.isBlank(ucMembers.getDomainName())){
			ucMembers.setDomainName("CN");
		}
		ucMembers.setModifydate(0);
		ucMembers.setLogincount(0);
		ucMembers.setLoginsystem("0");
		
		
		int insertCount = MapperFactory.getUcMembersMapper().insert(ucMembers);
		if(insertCount>0){
			UcMembers queryByUserNamePhoneEmail = queryByUserNamePhoneEmail(ucMembers.getMobilephone());
			return String.valueOf(queryByUserNamePhoneEmail.getUid());
		}else{
			return null;
		}
	}

	@Override
	public String insertLoginlog(LoginLog loginLog) throws BusinessException, SystemException {
		String id = SeqUtil.getNewId("SYS$LOGINLOG$ID", 8);
		loginLog.setId(id);
		MapperFactory.getLoginLogMapper().insert(loginLog);
		return id;
	}
	
	@Override
	public String updateUcMembers(UcMembers ucMembers) throws BusinessException, SystemException{
		
		//根据主键更新最后登陆时间 
		int primaryKeySelective = MapperFactory.getUcMembersMapper().updateByPrimaryKeySelective(ucMembers);
		
		return ucMembers.getUid().toString();
	}

	@Override
	public int queryLoginLogByExample(LoginLog loginLog) throws BusinessException, SystemException {
		
		int num = 0;
		if (StringUtil.isBlank(loginLog.getUserId().toString())) {
			throw new BusinessException("UserID不能为空");
		}else if (StringUtil.isBlank(loginLog.getLoginDate().toString())) {
			throw new BusinessException("LoginDate不能为空");
		}
		LoginLogCriteria example = new LoginLogCriteria();
		LoginLogCriteria.Criteria c=example.or();
		c.andUserIdEqualTo(loginLog.getUserId()).andLoginDateEqualTo(loginLog.getLoginDate());
		LoginLogMapper loginLogMapper = MapperFactory.getLoginLogMapper();
		List<LoginLog> list = loginLogMapper.selectByExample(example);
		
		if(!CollectionUtil.isEmpty(list)){
			num = list.size();
		}
		
		return num;
	}

	@Override
	public String insertUcContinueLoginLog(UcContinueLoginLog continueLoginLog)
			throws BusinessException, SystemException {
		//生成主键
		String id = SeqUtil.getNewId("SYS$UCMEMBERSOPERATION$ID", 8);
		continueLoginLog.setId(id);
		UcContinueLoginLogMapper continueLoginLogMapper = MapperFactory.getUcContinueLoginLogMapper();
		continueLoginLogMapper.insert(continueLoginLog);
		
		return id;
	}
	
	@Override
	public String updateContinueLoginLog(UcContinueLoginLog continueLoginLog)
			throws BusinessException, SystemException {
		if (StringUtil.isBlank(continueLoginLog.getUid().toString())) {
			throw new BusinessException("UserID不能为空");
		}
		UcContinueLoginLogMapper continueLoginLogMapper = MapperFactory.getUcContinueLoginLogMapper();
		continueLoginLogMapper.updateByPrimaryKeySelective(continueLoginLog);
		
		return continueLoginLog.getId();
	}

	@Override
	public ContinueLoginLogResponse queryContinueLoginLogByExample(UcContinueLoginLog continueLoginLog)
			throws BusinessException, SystemException {
		
		if (StringUtil.isBlank(continueLoginLog.getUid().toString())) {
			throw new BusinessException("UserID不能为空");
		}
		
		UcContinueLoginLogCriteria example = new UcContinueLoginLogCriteria();
		UcContinueLoginLogCriteria.Criteria c=example.or();
		c.andUidEqualTo(continueLoginLog.getUid());
		UcContinueLoginLogMapper continueLoginLogMapper = MapperFactory.getUcContinueLoginLogMapper();
		List<UcContinueLoginLog> list = continueLoginLogMapper.selectByExample(example);
		if(!CollectionUtil.isEmpty(list)){
			UcContinueLoginLog ucContinueLoginLog = list.get(0);
			ContinueLoginLogResponse response = new ContinueLoginLogResponse();
			BeanUtils.copyProperties(response, ucContinueLoginLog);
			return response;
		}
		
		return null;
	}

	/**
	 * 查询连续登陆天数
	 *
	 * @param uid
	 * @return
	 * @throws BusinessException
	 * @throws SystemException
	 * @author Gavin
	 * @UCUSER
	 */
	@Override
	public UcContinueLoginLog queryContinueLoginLogByUid(Integer uid) throws BusinessException, SystemException {
		UcContinueLoginLogCriteria example = new UcContinueLoginLogCriteria();
		UcContinueLoginLogCriteria.Criteria c=example.createCriteria();
		c.andUidEqualTo(uid);
		List<UcContinueLoginLog> list = MapperFactory.getUcContinueLoginLogMapper().selectByExample(example);
		return CollectionUtil.isEmpty(list)?null:list.get(0);
	}

}
