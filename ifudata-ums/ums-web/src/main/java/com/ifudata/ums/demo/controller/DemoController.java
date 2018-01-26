package com.ifudata.ums.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ifudata.centra.base.vo.PageInfo;
import com.ifudata.ums.common.Page;
import com.ifudata.ums.demo.model.DemoObject;
import com.ifudata.ums.system.base.BaseController;
import com.ifudata.ums.system.util.StringUtil;
import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/demo")
public class DemoController extends BaseController {
	private Logger logger=Logger.getLogger(DemoController.class);
	/**结果集*/
	private static List<DemoObject> results= new ArrayList<DemoObject>();
	@RequestMapping(value = "/hello")
	public String hello(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return "demo/hello";
	}
	@RequestMapping(value="/list")
	public String list(HttpServletRequest request,HttpServletResponse response) throws Exception{
		request.setAttribute("results", results);
		return "demo/demoList";
	}
	@RequestMapping(value="/listpaging")
	public void listPagingDate(HttpServletRequest request, HttpServletResponse response) throws Exception {
		logger.debug("-----------------------listpaging");
		try {
			//Get the request parameter
			String sEcho= request.getParameter("sEcho");
			String iDisplayLength= request.getParameter("iDisplayLength");
			String iDisplayStart= request.getParameter("iDisplayStart");
			String param = request.getParameter("param");
			Map<String, String> paramMap= StringUtil.transformParam(param);
			String sName = paramMap.get("NAME");
			String sCode = paramMap.get("CODE");
			int index = Integer.valueOf(iDisplayStart) / Integer.valueOf(iDisplayLength) + 1;
			//Get the result
			List<DemoObject>  results = searchDB(new String[]{sName, sCode});
			
			//Paging the result
			Page<DemoObject> page = new Page<DemoObject>(results);
			page.setPageRecord(Integer.valueOf(iDisplayLength));
			List<DemoObject> showResult = page.getPage(index);

			//Convert the result to JSON
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("iTotalRecords", page.getTotalRecords());
			jsonObject.put("iTotalDisplayRecords", page.getTotalRecords());
			jsonObject.put("sEcho", Integer.valueOf(sEcho));
			
			JSONArray jsArray = new JSONArray(showResult);
			jsonObject.put("aaData", jsArray);
			responseSuccess(response, "success", jsonObject);
		} catch (Exception e) {
			//e.printStackTrace();
			responseError(response, e.toString(), e);
		}
		
	}
	
	@RequestMapping(value="/pageList")
	public String page(@ModelAttribute PageInfo<DemoObject> pageInfo, HttpServletRequest request, HttpServletResponse response) throws Exception{
		List<DemoObject> list=new ArrayList<DemoObject>();
		for(int i=0;i<10;i++){
			DemoObject object=new DemoObject();
			object.setId(String.valueOf(i));
			object.setName("张三"+i);
			object.setEmail("23243454"+i+"@qq.com");
			list.add(object);
		}
			String pageNoStr = request.getParameter("pageNo"); 
	        int pageNo = 1; 
	        int pageSize = 2; 
	        if(pageNoStr != null && !pageNoStr.equals("")){ 
	            pageNo = Integer.parseInt(pageNoStr); 
	        } 
			pageInfo.setCount(list.size());
			pageInfo.setPageSize(pageSize);
			pageInfo.setResult(list.subList((pageNo - 1) * pageSize, (pageNo - 1) * pageSize+pageSize));		
			request.setAttribute("pageInfo", pageInfo);
		return "demo/pageList";
	}
	
	@RequestMapping(value="/remove")
	public void remove(String deletedId,HttpServletRequest request,HttpServletResponse response) {
		try {
			String[] ids = deletedId.split(":");
			for (int i = 0; i < results.size(); i++) {
				DemoObject obj = results.get(i);
				for (String id : ids){
					if (obj.getId().equalsIgnoreCase(id)) {
						results.remove(i);
					}
				}
			}
			responseSuccess(response, "删除成功", null);
		} catch (Exception e) {
			//e.printStackTrace();
			responseError(response, e.toString(), e);
		}
        
	}
	@RequestMapping(value = "/toAdd")
	public String toAdd(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return "demo/add";
	}
	@RequestMapping(value = "/add",method=RequestMethod.POST)
	public void add(@ModelAttribute DemoObject demoObject,HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			demoObject.setId(results.size()+1+"");
			results.add(demoObject);
			responseSuccess(response, "添加成功", null);
		} catch (RuntimeException e) {
			//e.printStackTrace();
			responseError(response, e.toString(), e);
		} catch (Exception e) {
			//e.printStackTrace();
			responseError(response, e.toString(), e);
		}
	}
	@RequestMapping(value = "/toUpdate")
	public String toUpdate(int id,HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			DemoObject demoObject = null;
			for (DemoObject object : results){
				if (object.getId().equalsIgnoreCase(String.valueOf(id))){
					demoObject = object;
				}
			}
			request.setAttribute("demoObject", demoObject);
		} catch (Exception e) {
			//e.printStackTrace();
			markException("异常简单描述",e);
			throw e;
		}
		return "demo/update";
	}
	@RequestMapping(value = "/update",method=RequestMethod.POST)
	public void update(@ModelAttribute DemoObject demoObject,HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			for (int i = 0; i < results.size(); i++) {
				DemoObject oldDemoObject=results.get(i);
				if (oldDemoObject.getId().equals(demoObject.getId())) {
					results.remove(i);
					break;
				}
			}
			results.add(demoObject);
			responseSuccess(response, "修改成功", null);
		} catch (RuntimeException e) {
			//e.printStackTrace();
			responseError(response, e.toString(), e);
		} catch (Exception e) {
			//e.printStackTrace();
			responseError(response, e.toString(), e);
		}
	}
	@RequestMapping(value = "/error")
	public String error(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			logger.debug("-----------------------error");
			int i=1/0;
		} catch (Exception e) {
			//e.printStackTrace();
			markException("异常简单描述",e);
			throw e;
		}
		return "demo/hello";
	}
	
	//
	private static List<DemoObject> searchDB(String[] values) {
		List<DemoObject> array = pagingDataDB();
		List<DemoObject> result = new ArrayList();
		
		if (values[0].length() <= 0 && values[1].length() <= 0){
			return array;
		}
		for (int i = 0 ; i < array.size(); i++){
			DemoObject object = array.get(i);
			if (values[0].length() > 0 && values[1].length() > 0){
				if (object.getName().equals(values[0]) && object.getCode().equals(values[1])){
					result.add(object);
				}
			}else{
				if (object.getName().equals(values[0]) || object.getCode().equals(values[1])){
					result.add(object);
				}
			}
		}
		
		return result;
	}
	
	private static List<DemoObject> pagingDataDB() {
		List<DemoObject> array = new ArrayList<DemoObject>();
		for (int i = 0; i < results.size(); i++){
			DemoObject demoObject = results.get(i);
			array.add(demoObject);
		}
		return array;
	}
	
	@RequestMapping(value = "/ename")
	public void ename(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			String name=request.getParameter("name");
			for (int i = 0; i < results.size(); i++) {
				String nameString = results.get(i).getName();
				if (name.equalsIgnoreCase(nameString)) {
					responseFalse(response);
					break;
				}
			}
			responseTrue(response);
		} catch (RuntimeException e) {
			//e.printStackTrace();
			responseError(response, e.toString(), e);
		} catch (Exception e) {
			//e.printStackTrace();
			responseError(response, e.toString(), e);
		}
	}
}
