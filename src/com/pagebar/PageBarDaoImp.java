package com.pagebar;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;

import com.mysql.MysqlUtil;

public class PageBarDaoImp implements PageBarDao {
	String tableName;
	static int everyPageNumber = 10;
	static int totalNumber;
	static int totalPage = (totalNumber+(everyPageNumber-1))%everyPageNumber;
	int remainder = totalNumber%everyPageNumber;
	int pageSize;
	static int curPage=1;
	List list;
	
	MysqlUtil m;
	private String TOTAL_NUMBER_SQL,GET_PAGE_SQL,NEXT_PAGE_SQL,PREVIOUS_PAGE_SQL,FIRST_PAGE_SQL,LAST_PAGE_SQL1,LAST_PAGE_SQL2;
	
	//指定查询表格,每页默认显示十条记录
	public PageBarDaoImp(String tableName) {
		this.tableName = tableName;
		TOTAL_NUMBER_SQL="select count(*) from "+this.tableName;
	}
	public PageBarDaoImp(String tableName,int everyPageNumber) {
		this.tableName = tableName;
	}
	
	public void init(String jndiString) {
		m = new MysqlUtil();
		m.init(jndiString);
		this.totalNumber();
	}
	
	public List getFirstPage() {
		FIRST_PAGE_SQL = "select * from "+tableName+" order by id asc limit "+everyPageNumber;
		this.curPage = 1;
		System.out.println(FIRST_PAGE_SQL);
		list = (List) m.query(FIRST_PAGE_SQL);
		return list;
	}
	
	public List getLastPage() {
		this.curPage = this.totalPage;
		if(remainder == 0) {
			LAST_PAGE_SQL1 = "select * from "+tableName+" order by id desc limit "+everyPageNumber;
			System.out.println(LAST_PAGE_SQL1);
			list = (List) m.query(LAST_PAGE_SQL1);
		}else {
			LAST_PAGE_SQL2 = "select * from "+tableName+" order by id desc limit "+remainder;
			System.out.println(LAST_PAGE_SQL2);
			list = (List) m.query(LAST_PAGE_SQL2);
		}
		return list;
	}

	@Override
	public int totalNumber() {
		System.out.println(TOTAL_NUMBER_SQL);
		int totalNumber = Integer.parseInt((m.count(TOTAL_NUMBER_SQL)).toString());
		this.totalNumber = totalNumber;
		return totalNumber;
	}

	@Override
	public List getPage(int page) {
		this.pageSize = page;
		this.curPage = page;
		GET_PAGE_SQL="select * from "+tableName+" order by id asc limit "+(pageSize-1)*everyPageNumber+","+everyPageNumber;
		System.out.println(GET_PAGE_SQL);
		list = (List) m.query(GET_PAGE_SQL);
		return list;
	}

	@Override
	public List getNext() {
		NEXT_PAGE_SQL = "select * from "+tableName+" order by id asc limit "+(curPage*everyPageNumber)+","+everyPageNumber;
		System.out.println(NEXT_PAGE_SQL);
		this.curPage++;
		list = (List) m.query(NEXT_PAGE_SQL);
		return list;
	}

	@Override
	public List getPrevious() {
		PREVIOUS_PAGE_SQL = "select * from "+tableName+" order by id asc limit "+(curPage-2)*everyPageNumber+","+everyPageNumber;
		System.out.println(PREVIOUS_PAGE_SQL);
		this.curPage--;
		list = (List) m.query(PREVIOUS_PAGE_SQL);
		return list;
		
	}

	@Override
	public void setEveryPageNumber(int number) {
		this.everyPageNumber = number;		
	}

}
