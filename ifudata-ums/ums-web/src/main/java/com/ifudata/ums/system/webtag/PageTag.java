package com.ifudata.ums.system.webtag;
import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;

public class PageTag extends BodyTagSupport {
	private int pageSize = 10; // 每页要显示的记录数 
    private int pageNo = 1; // 页号 
    private int recordCount; // 总记录数 
    private String url; // 目的地URL 
    
    public void setPageSize(int pageSize) { 
        this.pageSize = pageSize; 
    } 

    public void setPageNo(int pageNo) { 
        this.pageNo = pageNo; 
    } 

    public void setRecordCount(int recordCount) { 
        this.recordCount = recordCount; 
    } 

    public void setUrl(String url) { 
        this.url = url; 
    } 

	// 主要的逻辑 
    @Override 
    public int doStartTag() throws JspException { 
        if(recordCount == 0){ 
            return super.doStartTag(); 
        } 
         
        // 总页数 
        int pageCount = (recordCount + pageSize - 1) / pageSize; 

        // 页号越界处理 
        if (pageNo > pageCount) { 
            pageNo = pageCount; 
        } 
        if (pageNo < 1) { 
            pageNo = 1; 
        } 
         
        StringBuilder sb = new StringBuilder(); 
         
        sb.append("<form name='pageController' id='pageController' action='' method='post'>\r\n") 
          .append("<input type='hidden' id='pageNo' name='pageNo' value='" + pageNo + "' />\r\n"); 
         
        //------------------------------------ 获取所有請求中的参数 
        HttpServletRequest request = (HttpServletRequest) pageContext.getRequest(); 
        Enumeration<String> enumeration = request.getParameterNames(); 
        String name = null; 
        String value = null; 
        //把请求中的所有参数当作隐藏表单域在页面中写出) 
        while (enumeration.hasMoreElements()) { 
            name =  enumeration.nextElement(); 
            value = request.getParameter(name); 

            // 去除页号 
            if (name.equals("pageNo")) { 
                if (null != value && !"".equals(value)) { 
                    pageNo = Integer.parseInt(value); 
                } 
                continue; 
            } 
            sb.append("<input type='hidden' name='") 
              .append(name) 
              .append("' value='") 
              .append(value) 
              .append("'/>\r\n"); 
        } 
        //---------------------------------------------------- 
        if (pageNo == 1) {
            sb.append("<a href='javascript:void(0)'>上一页</a>\r\n"); 

        } else { 
            sb.append("<a href='#' onclick='turnOverPage(").append((pageNo - 1)).append(")'>上一页</a>\r\n"); 
        } 
        int showPage=8;
        if(pageCount<=showPage){
            for (int i = 1; i <= pageCount; i++) { 
                if (i == pageNo) { 
                    sb.append("<a href='javascript:void(0)' style='background-color: #269afd;color:#fff;' onclick='turnOverPage(").append(i).append(")'>").append(i).append("</a>\r\n"); 
                } else { 
                	sb.append("<a href='javascript:void(0)' onclick='turnOverPage(").append(i).append(")'>").append(i).append("</a>\r\n");
                } 
            }
        }else{
        	if(pageNo <= (showPage/2+1)){
        		for (int i = 1; i <= showPage; i++) {
                    if (i == pageNo) { 
                        sb.append("<a href='javascript:void(0)' style='background-color: #269afd;color:#fff;' onclick='turnOverPage(").append(i).append(")'>").append(i).append("</a>\r\n"); 
                    } else { 
                    	sb.append("<a href='javascript:void(0)' onclick='turnOverPage(").append(i).append(")'>").append(i).append("</a>\r\n");
                    } 
				}
        	}else if(pageNo > (pageCount - showPage/2)){
				int start = pageCount - showPage+1;
				for (int i = start; i <= pageCount; i++) {
                    if (i == pageNo) { 
                        sb.append("<a href='javascript:void(0)' style='background-color: #269afd;color:#fff;' onclick='turnOverPage(").append(i).append(")'>").append(i).append("</a>\r\n"); 
                    } else { 
                    	sb.append("<a href='javascript:void(0)' onclick='turnOverPage(").append(i).append(")'>").append(i).append("</a>\r\n");
                    } 
				}
        	}else{
				int start = pageNo - showPage/2;
				int end = pageNo + showPage/2-1;
				if (pageCount < end) {
					end = pageCount;
				}
				for (int i = start; i <= end; i++) {
                    if (i == pageNo) { 
                        sb.append("<a href='javascript:void(0)' style='background-color: #269afd;color:#fff;' onclick='turnOverPage(").append(i).append(")'>").append(i).append("</a>\r\n"); 
                    } else { 
                    	sb.append("<a href='javascript:void(0)' onclick='turnOverPage(").append(i).append(")'>").append(i).append("</a>\r\n");
                    } 
				}
        	}
        }
        
        if (pageNo == pageCount) { 
            sb.append("<a href='javascript:void(0)'>下一页</a>"); 
        } else { 
            sb.append("<a href='#' onclick='turnOverPage(").append((pageNo + 1)).append(")'>下一页</a>\r\n"); 
        } 
        sb.append( "共" + pageCount + "页\r\n"); 
        sb.append("&nbsp;&nbsp;第  <input type='text' name='inputPageNo' id='inputPageNo' style='width: 40px;'/>页\r\n"); 
        sb.append("<input type='button' style='padding: 0 10px;background: #0e97ff;border:1px solid #0e97ff;border-radius: 5px;color:#fff;font-size:12px;line-height: 24px;cursor:pointer;' onclick='turnOverPage()' value='跳转'/>\r\n"); 
        sb.append("</form>\r\n"); 
         
        // 生成提交表单的JS 
        sb.append("<script language='javascript'>\r\n"); 
        sb.append("  //翻页函数\t\n"); 
        sb.append("  function turnOverPage(no){\r\n"); 
        sb.append("    var form = document.pageController;\r\n"); 
        sb.append("    var re = /^[1-9]+[0-9]*]*$/;\r\n"); 
        sb.append(" if(no==null){  \r\n"); 
        sb.append("   no=document.getElementById('inputPageNo').value; \r\n"); 
        sb.append("    if(no==null||no==''||(!re.test(no))||no>").append(pageCount).append("){return;}\r\n"); 
        sb.append("  }else{ \r\n"); 
        sb.append("    //页号越界处理\r\n"); 
        sb.append("    if(no").append(">").append(pageCount).append(") {\r\n"); 
        sb.append("        no=").append(pageCount).append(";\r\n"); 
        sb.append("    }\r\n"); 
        sb.append("    if(no").append("< 1){\r\n"); 
        sb.append("        no=1;\r\n"); 
        sb.append("    }\r\n");         
        sb.append("   }\r\n"); 
        sb.append("    form.").append("pageNo").append(".value=no;\r\n"); 
        sb.append("    form.action='").append(url).append("';\r\n"); 
        sb.append("    form.submit();\r\n"); 
        sb.append("  }\r\n"); 
        sb.append("</script>\r\n"); 
         
        try { 
            pageContext.getOut().println(sb.toString()); 
        } catch (IOException e) { 
            e.printStackTrace(); 
        } 
         
        return super.doStartTag(); 
    } 


}
