package com.ifudata.ums.api.applybatch.param;



import com.ifudata.centra.base.vo.PageInfo;

import java.io.Serializable;


public class OrdSendStatusRequest implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6611221317641460745L;
	/**
	 * 文件名
	 */
	private String fileName;
	/**
	 * 分页信息
	 */
	private PageInfo<SendStatusInfo> pageInfo;
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public PageInfo<SendStatusInfo> getPageInfo() {
		return pageInfo;
	}
	public void setPageInfo(PageInfo<SendStatusInfo> pageInfo) {
		this.pageInfo = pageInfo;
	}

}
