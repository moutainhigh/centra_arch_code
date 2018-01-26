package com.ifudata.ums.system.webtag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;
import java.io.IOException;


public class TextWidthTag extends BodyTagSupport {
	/**
	 * @author jonrey zhanglei11
	 * 控制jsp中td的内容，如果内容超出给定长度则只显示给定长度，然后显示给定的显示符，没有显示符的默认显示省略号
	 */
	private static final long serialVersionUID = 7533694302558799757L;

	private String value;
	
	private int length;
	
	private String character;
	
	public TextWidthTag(){
		
		//title = value;
	}
	
	//
	@SuppressWarnings("static-access")
	public int doStartTag() throws JspException{
	      return SKIP_BODY;
	}

	@SuppressWarnings("static-access")
	public int doEndTag() throws JspException{
	      JspWriter out = pageContext.getOut();
	      StringBuffer displayText =new StringBuffer();
	      //String sum = begin + end;
	      try {
		      if (value != null && !value.equalsIgnoreCase("")) {
				
		    	  if (value.length()>length) {
			    	  displayText.append(value.substring(0, length));
			    	  
			    	  if (character !=null && !character.equalsIgnoreCase("")) {
			    		  displayText.append(character);
					}else {
						
						  displayText.append("....");
						
					}
			    	  
			    	//title = value;
					out.print(displayText);
					//out.print(title);
					
				}else {
					displayText.append(value);
					out.print(displayText);
				}
		      }
	      }catch (IOException e) {
				e.printStackTrace();
		}  
	      
	      return EVAL_PAGE;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	

	public String getCharacter() {
		return character;
	}

	public void setCharacter(String character) {
		this.character = character;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	
	
	
	
}
