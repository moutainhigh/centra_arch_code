package com.ifudata.ums.service.business.impl;

import com.ifudata.centra.base.vo.PageInfo;
import com.ifudata.ums.api.applybatch.param.OrdSendStatusRequest;
import com.ifudata.ums.api.applybatch.param.SendStatusInfo;
import com.ifudata.ums.dao.mapper.bo.UmsSendStatus;
import com.ifudata.ums.service.atom.interfaces.IUmsSendStatusSV;
import com.ifudata.ums.service.business.interfaces.IUmsFreeBackSV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UmsFreeBackSVImpl implements IUmsFreeBackSV {

	@Autowired
	private IUmsSendStatusSV iUmsSendStatusSV ;
	/**
	 * 根据批次号查询各号码的发送状态
	 * @param request 请求信息
	 * @param batchId 批次号
	 * @return PageInfo<SendStatusInfo> 分页信息
	 * @author wangyongxin
 	*/
	@Override
	public PageInfo<SendStatusInfo> getPageInfo(OrdSendStatusRequest request, Long batchId)
			throws Exception {
		List<UmsSendStatus> beans = iUmsSendStatusSV.getBeans(request, batchId);
		PageInfo<SendStatusInfo> pageInfo = request.getPageInfo();
		List<SendStatusInfo> list = beanToVo(beans);
		pageInfo.setResult(list);
		pageInfo.setCount(iUmsSendStatusSV.getBeansCount(request,batchId));
		return pageInfo;
	}

	private List<SendStatusInfo> beanToVo(List<UmsSendStatus> beans){
		List<SendStatusInfo> infos =new ArrayList<SendStatusInfo>();
		for (UmsSendStatus bean : beans) {
			SendStatusInfo info =new SendStatusInfo();
			info.setBatchId(bean.getBatchId());
			info.setPhoneNum(bean.getPhoneNum());
			info.setReportFlag(bean.getReportFlag());
			info.setReportRecFlag(bean.getReportRecFlag());
			info.setReportRecResult(bean.getReportRecResult());
			info.setReportTime(bean.getReportTime());
			info.setSendFlag(bean.getSendFlag());
			info.setSendTime(bean.getSendTime());
			info.setSmsContent(bean.getSmsContent());
			System.out.println(info.getSendTime());
			infos.add(info);
		}
		return infos;
	}
}
