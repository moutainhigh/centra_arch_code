package com.ifudata.ums.demo.controller;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ifudata.ums.system.base.BaseController;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="upload")
public class UploadController extends BaseController {
	private Logger logger = Logger.getLogger(UploadController.class);
	@RequestMapping(value = "/toUploadImage")
	public String toUploadImage(HttpServletRequest request,HttpServletResponse response) throws Exception{
	    return "/demo/demoUpload";
	}
    @RequestMapping(value = "/uploadImage")
	public void uploadImage(HttpServletRequest request,HttpServletResponse response) throws Exception{
	    logger.debug("-------------start-------------");
	    List<FileItem> items = null;
        String fileName = null;
        FileItem item = null;
        // 设置请求编码方式
        FileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        try {
            items = upload.parseRequest(request);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("页面停留时间过长获取请求失败，请重新刷新页面" + e.getCause());
        } 
        Iterator<FileItem> iter_check = items.iterator();
        /* 1.校验上传文件名称 */
        if (iter_check.hasNext()) {
            item = (FileItem) iter_check.next();
            if (item.isFormField()) {
            } else {
                fileName = item.getName();
                fileName = fileName.substring(fileName.lastIndexOf("\\") + 1);
                System.out.println("图片名称："+fileName);
            }
        } else {
            logger.debug("获取文件失败");
        }
        InputStream inputStream = null;
        FileOutputStream fileOut = null;
        try{
            String realPath = request.getSession().getServletContext().getRealPath("");
            inputStream = item.getInputStream();
            System.out.println(realPath+"\\test.jpg");
            fileOut = new FileOutputStream(realPath+"\\test.jpg");
            int b = 0;
            while((b=inputStream.read())!=-1 ){
                fileOut.write(b);
            }
            fileOut.flush();
            this.responseSuccess(response, "成功！", null);
        }catch(Exception e){
            logger.debug(e);
            this.responseError(response,e.toString(),e);
        }finally{
            if(inputStream!=null){
                inputStream.close();
            }
            if(fileOut!=null){
                fileOut.close();
            }
        }
	}
}
