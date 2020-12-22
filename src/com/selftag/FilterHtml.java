package com.selftag;

import java.io.IOException;

import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;

import com.utiltool.StringUtil;

public class FilterHtml extends BodyTagSupport {

	private static final long serialVersionUID = -1916032808806925685L;
	
	public int doAfterBody() throws JspTagException{
		try {
			BodyContent bc = getBodyContent();
			String input = bc.getString();
			JspWriter out = bc.getEnclosingWriter();
			String newContent = StringUtil.filterHtml(input);
			out.print(newContent);
		}catch(IOException e) {
			throw new JspTagException(e);
		}
		return EVAL_BODY_INCLUDE;
	}
}
