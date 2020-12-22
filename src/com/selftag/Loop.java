package com.selftag;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class Loop extends TagSupport {
	private static final long serialVersionUID = 1461754930638199147L;
	private int times;
	public void setTimes(int times) {
		this.times = times;
	}
	
	public int doStartTag() {
		return EVAL_BODY_INCLUDE;
	}
	public int doAfterBody() {
		if(times>1) {
			times--;
			return EVAL_BODY_AGAIN;
		}else {
			return SKIP_BODY;
		}
	}
	public int doEndTag() throws JspTagException{		
		return EVAL_PAGE;
	}
}
