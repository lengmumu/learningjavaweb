package com.selftag;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class ListValues extends TagSupport {
	private static final long serialVersionUID = 1L;
	public List listname;
	public int len;
	JspWriter out = pageContext.getOut();
	public int doStartTag() {
		len = listname.size();
		if(len==0) {
			return SKIP_BODY;
		}
		return EVAL_BODY_INCLUDE;
	}
	
	public int doAfterBodyTag() {
		Map map = null;
		for(int i=0;i<len;i++) {
			map = (Map) listname.get(i);
			Set nameSet = map.keySet();
//			for(Map.Entry<String, V> entry:map) {
//				
//			}
//			out.println(map.getKey(i));
		}
		
		return SKIP_BODY;
	}
	
	public int doEndTag() {
		return EVAL_PAGE;
	}
}
