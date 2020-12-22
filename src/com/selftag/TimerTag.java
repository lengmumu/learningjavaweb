package com.selftag;

import javax.servlet.jsp.tagext.TagSupport;

import java.io.IOException;

import javax.servlet.jsp.*;

public class TimerTag extends TagSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 878541116698244734L;
	private long start;
	private long end;
	
	public int doStartTag() {
		start = System.currentTimeMillis();	
		return EVAL_BODY_INCLUDE;
	}
	
	public int doEndTag() throws JspTagException {
		end = System.currentTimeMillis();
		long elapsed = end-start;
		try {
			JspWriter out = pageContext.getOut();
			out.println("runningtime:"+elapsed+"ms");
			System.out.print("有执行吗");
		}catch(IOException e) {
			throw new JspTagException(e);
		}
		return EVAL_PAGE;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
