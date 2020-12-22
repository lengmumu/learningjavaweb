package com.pagebar;

import java.util.List;

public interface PageBarDao {
	//获取总记录数
	public int totalNumber();
	//获取特定页面的记录
	public List getPage(int page);
	//获取下一页
	public List getNext();
	//获取上一页
	public List getPrevious();
	//获取首页
	public List getFirstPage();
	//获取尾页
	public List getLastPage();
	//指定每页显示条数
	public void setEveryPageNumber(int number);
	
}
