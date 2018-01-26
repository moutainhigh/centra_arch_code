package com.ifudata.centra.base.vo;

import java.util.Collections;
import java.util.Set;

/**
 * 服务返回set基本信息<br>
 * Date: 2016年7月21日 <br>
 * 
 */
public class BaseSetResponse<T> extends BaseResponse{
	private static final long serialVersionUID = 1L;
	
	private Set<T> result = Collections.emptySet();

	public Set<T> getResult() {
		return result;
	}

	public void setResult(Set<T> result) {
		this.result = result;
	}
	
}
