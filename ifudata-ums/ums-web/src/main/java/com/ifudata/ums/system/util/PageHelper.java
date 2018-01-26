package com.ifudata.ums.system.util;

import com.ifudata.centra.base.vo.PageInfo;

import java.io.Serializable;


//PageHelper为了接受JQuery Datatables插件的分页的基本信息
//字段iDisplayStart表示从第多少条开始显示
//字段iDisplayLength表示一页显示多少条
//使用方法：
// public xx xxx(@ModelAtrributes PageHelper pageHelper...){
//   PageInfo pageInfo = pageHelper.convertPageInfo();
//}
public class PageHelper<T> implements Serializable {

	private static final long serialVersionUID = 8357915649274799148L;
	//
	private int iDisplayStart;
	private int iDisplayLength;

	public int getiDisplayStart() {
		return iDisplayStart;
	}

	public void setiDisplayStart(int iDisplayStart) {
		this.iDisplayStart = iDisplayStart;
	}

	public int getiDisplayLength() {
		return iDisplayLength;
	}

	public void setiDisplayLength(int iDisplayLength) {
		this.iDisplayLength = iDisplayLength;
	}
	
	public PageInfo<T> convertPageInfo(){
		PageInfo<T>  pageInfo = new PageInfo<T>();
		int pageNo = iDisplayStart / iDisplayLength + 1;
		pageInfo.setPageNo(pageNo);
		pageInfo.setPageSize(iDisplayLength);
		return pageInfo;
	}
}
