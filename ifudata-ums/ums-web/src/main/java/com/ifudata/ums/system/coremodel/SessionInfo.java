/*
package com.ifudata.ums.system.coremodel;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.PageContext;

import com.ifudata.crm.system.config.Constants;
import com.ifudata.ums.crm.api.commons.staffmaintain.param.GnDepartVo;
import com.ifudata.ums.crm.api.commons.staffmaintain.param.GnStaffVo;

public class SessionInfo {
	

	public static GnStaffVo getOperInfo(PageContext pageContext) {
		return (GnStaffVo) pageContext.getSession().getAttribute(Constants.SESSION_OPER);
	}


	public static GnStaffVo getOperInfo(HttpServletRequest request) {
		Object obj = request.getSession().getAttribute(Constants.SESSION_OPER);
		if(obj != null){
			return (GnStaffVo) obj;
		}
		return null;
		
	}
	
	public static void setOperInfo(HttpSession session,GnStaffVo operInfo){
	    if(session!=null)
	        session.setAttribute(Constants.SESSION_OPER,operInfo);
    }

	public static GnStaffVo getOperInfo(HttpSession session){
	    if(session!=null)
	        return (GnStaffVo)session.getAttribute(Constants.SESSION_OPER);
	    return null;
	}


	*/
/**
	 * 判断session是否失效
	 * 
	 * @param request
	 * @return
	 * @author liwenxian
	 *//*

	public static boolean isSessionExp(HttpServletRequest request){
	    GnStaffVo gnStaffVo = getOperInfo(request);
		return gnStaffVo==null;
	}
	*/
/**
     * 判断session是否失效
     * 
     * @param session
     * @return
     * @author liwenxian
     *//*

    public static boolean isSessionExp(HttpSession session){
        GnStaffVo gnStaffVo = getOperInfo(session);
        return gnStaffVo==null;
    }
	 */
/**
     * 获取操作员级别
     * 
     * @param session
     * @return
     * @author liwenxian
     *//*

    public static String getOperLevel(HttpSession session){
        GnStaffVo staffVO = getOperInfo(session);
        if(staffVO != null && staffVO.getGnDepartVo() != null){
            return staffVO.getGnDepartVo().getDepartLevel()+"";
        }
        return "-1";
    }
	 */
/**
     * 获取操作员级别
     * 
     * @param staffVO
     * @return
     * @author liwenxian
     *//*

    public static String getOperLevel(GnStaffVo staffVO){
        if(staffVO != null && staffVO.getGnDepartVo() != null){
            return staffVO.getGnDepartVo().getDepartLevel()+"";
        }
        return "-1";
    }
    */
/**
     * 获取部门VO
     * 
     * @param session
     * @return
     * @author liwenxian
     *//*

    public static GnDepartVo getDepartVo(HttpSession session){
        GnStaffVo staffVO = getOperInfo(session);
        if(staffVO != null && staffVO.getGnDepartVo() != null){
            return staffVO.getGnDepartVo();
        }
        return null;
    }
	
}
*/
