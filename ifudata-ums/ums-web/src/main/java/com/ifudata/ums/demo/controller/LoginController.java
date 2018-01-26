package com.ifudata.ums.demo.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ifudata.ums.system.base.BaseController;
import com.ifudata.ums.system.config.Constants;
import com.ifudata.ums.system.util.StringUtil;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 
 * Title: ums-CRM <br>
 * Description: 登录控制类<br>
 * Date: 2014年2月27日 <br>
 * Copyright (c) 2014 ifudata <br>
 * 
 * @author moubd
 */
@Controller
@RequestMapping(value="login")
public class LoginController extends BaseController {
	@RequestMapping(value="login")
	public String login(HttpServletRequest request, HttpServletResponse response) throws Exception{
		return "demo/login";
	}
	/**
	 * 校验用户名、密码，如果验证正确，则登录主页；否则通过json返回错误信息。
	 * @param request
	 * @param response
	 * @throws Exception
	 * @author moubd
	 */
	@RequestMapping(value="logon")
	public void logon(HttpServletRequest request, HttpServletResponse response) throws Exception{
		System.out.println(request.getParameter("userCode"));
		String timestamp = request.getParameter("timestamp");
        String validateC = (String) request.getSession().getAttribute("validateCode_"+timestamp);         
        String veryCode = request.getParameter("veryCode"); 
		JSONObject json = new JSONObject();
		String userCode = request.getParameter("userCode");
		String password = request.getParameter("password");
		json.put("result", "failure");
		//status 0:所有信息都正确 1：验证码为空 2：验证码错误 3：用户名或密码为空 4:用户名或密码错误
		if(veryCode==null||"".equals(veryCode)){         
            json.put("status", Constants.LoginReturnMessage.VERIFY_CODE_IS_BLANK);         
        }else{         
            if(validateC.equalsIgnoreCase(veryCode)){         
            	if(!StringUtil.isBlank(userCode) && !StringUtil.isBlank(password)){
        			if("admin".equals(userCode) && "aaaaaa".equals(password)){
        				json.put("status", Constants.LoginReturnMessage.SUCCESS);
        				System.out.println("登录成功！");
        				json.put("result", "success");
        			}else{
        				json.put("status", Constants.LoginReturnMessage.USERCODE_OR＿PASSWD_IS_ERROR);
        			}
        		}else{
        			json.put("status", Constants.LoginReturnMessage.USERCODE_OR_PASSWD_IS_BLANk);
        		}
            }else{         
            	json.put("status", Constants.LoginReturnMessage.VERIFY_CODE_IS_BLANK);         
            }         
        }
		PrintWriter printWriter = null;
		try {
			printWriter = response.getWriter();
			printWriter.write(json.toString());
            printWriter.flush();
            //LoadOperSession.loadOperInfo(session, userCode);
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
	        printWriter.close();
		}
       
	}
	
	@RequestMapping(value="/validateCode",method=RequestMethod.POST)
    public void validateCode(HttpServletRequest request, HttpServletResponse response)         
            throws Exception {         
        response.setContentType("text/html;charset=utf-8");   
        String timestamp = request.getParameter("timestamp");
        String validateC = (String) request.getSession().getAttribute("validateCode_"+timestamp);         
        String veryCode = request.getParameter("veryCode");         
        JSONObject json = new JSONObject();
        if(veryCode==null||"".equals(veryCode)){         
            json.put("status", Constants.LoginReturnMessage.VERIFY_CODE_IS_BLANK);         
        }else{         
            if(validateC.equalsIgnoreCase(veryCode)){         
            	json.put("status", Constants.LoginReturnMessage.SUCCESS);         
            }else{         
            	json.put("status", Constants.LoginReturnMessage.VERIFY_CODE_IS_ERROR);         
            }         
        }         
        PrintWriter printWriter = null;
        try {
            printWriter = response.getWriter();
            printWriter.write(json.toString());
            printWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            printWriter.close();
        }
    }
	@RequestMapping(value="/validateUserCode")
    public void validateUserCode(HttpServletRequest request, HttpServletResponse response)         
            throws Exception {         
        String userCode = request.getParameter("userCode");
        String message = "";
        boolean flag = true;
        if(userCode==null||"".equals(userCode)){         
            flag = false;
            message = "不能为空！";
        }else{         
            if(!userCode.equals("admin")){         
            	flag = false;
                message = "用户不存在！";         
            }         
        }    
        if(flag){
        	this.responseSuccess(response, message, null);
        }else{
        	this.responseFailed(response, message, null);
        }
    }
}
