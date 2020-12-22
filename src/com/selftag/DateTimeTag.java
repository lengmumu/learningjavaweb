package com.selftag;

import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.util.Date;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class DateTimeTag extends TagSupport {
	private static final long serialVersionUID = 77864530649731423L;
	private String pattern = "yyyy年MM月dd日 hh时mm分ss秒";
	private Date date = new Date();
	
	public void setPattern(String pattern) {
		this.pattern = pattern;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	//只有拥有给方法，标签体中的html标签才有输出
	public int doStartTag() {
		return EVAL_BODY_INCLUDE;
	}
	public int doEndTag() throws JspTagException{
		DateFormat df = DateFormat.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		if(date == null) date = new Date();
		JspWriter jspOut = pageContext.getOut();
		try {
			jspOut.println(df.format(date));
			jspOut.println(sdf.format(date));
		} catch (IOException e) {
			throw new JspTagException(e);
		}
		
		return EVAL_PAGE;
	}
}
