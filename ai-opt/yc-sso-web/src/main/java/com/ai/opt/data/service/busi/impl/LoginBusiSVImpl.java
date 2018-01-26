package com.ai.opt.data.service.busi.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.data.api.user.param.ContinueLoginLogResponse;
import com.ai.opt.data.dao.mapper.bo.LoginLog;
import com.ai.opt.data.dao.mapper.bo.UcContinueLoginLog;
import com.ai.opt.data.dao.mapper.bo.UcMembers;
import com.ai.opt.data.service.atom.interfaces.ILoginAtomSV;
import com.ai.opt.data.service.busi.interfaces.ILoginBusiSV;

@Service
@Transactional
public class LoginBusiSVImpl implements ILoginBusiSV {
    @Autowired
    ILoginAtomSV iLoginAtomSV;

    @Override
    public UcMembers queryByUserName(UcMembers user) throws BusinessException {

        return iLoginAtomSV.queryByUserName(user);

    }

	@Override
	public UcMembers queryByUserNamePhoneEmail(String loginname) throws BusinessException {
		return iLoginAtomSV.queryByUserNamePhoneEmail(loginname);
	}

	@Override
	public String saveThirdUser(UcMembers ucMembers) throws BusinessException, SystemException {
		UcMembers ucDb=iLoginAtomSV.queryThirdUser(ucMembers.getUsersource(), ucMembers.getThirduid());
		if(ucDb!=null){
			return ucDb.getUid().toString();
		}
		return iLoginAtomSV.insertThirdUser(ucMembers);
	}

	@Override
	public UcMembers queryThirdUser(String usersource, String thirduid) throws BusinessException, SystemException {
		return iLoginAtomSV.queryThirdUser(usersource, thirduid);
	}

	@Override
	public String saveUserByMobileLogin(UcMembers ucMembers) throws BusinessException, SystemException {
		return iLoginAtomSV.saveUserByMobileLogin(ucMembers);
	}

	@Override
	public String saveLoginLog(LoginLog loginLog) throws BusinessException, SystemException {
		return iLoginAtomSV.insertLoginlog(loginLog);
	}
	
	@Override
	public String updateUcMembers(UcMembers ucMembers) throws BusinessException, SystemException {
		return iLoginAtomSV.updateUcMembers(ucMembers);
	}

	@Override
	public int queryLoginLog(LoginLog loginLog) throws BusinessException, SystemException {
		return iLoginAtomSV.queryLoginLogByExample(loginLog);
	}
	
	@Override
	public String saveContinueLoginLog(UcContinueLoginLog continueLoginLog) throws BusinessException, SystemException {
		return iLoginAtomSV.insertUcContinueLoginLog(continueLoginLog);
	}
	
	@Override
	public String updateContinueLoginLog(UcContinueLoginLog continueLoginLog) throws BusinessException, SystemException {
		return iLoginAtomSV.updateContinueLoginLog(continueLoginLog);
	}

	@Override
	public UcContinueLoginLog queryContinueLoginLog(Integer uid)
			throws BusinessException, SystemException {
		return iLoginAtomSV.queryContinueLoginLogByUid(uid);
	}

}
