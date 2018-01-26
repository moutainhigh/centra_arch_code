
package com.ifudata.ums.service.http.youku.util;

class jsonseq {
	private static long MIN_SEQ = 0;
	
	private static long MAX_SEQ = 999999999;
	
	private static long CUR_SEQ = MIN_SEQ;
	
	public static synchronized long getSeq()
	{
		if(CUR_SEQ == MAX_SEQ)
		{
			CUR_SEQ = MIN_SEQ;
		}
		return CUR_SEQ++;
	}
	
}
