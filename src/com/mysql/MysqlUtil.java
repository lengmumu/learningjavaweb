package com.mysql;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSetRow;

public class MysqlUtil{
	private QueryRunner qr;
	public void init(String jndiString){
		try {
			DbUtils.loadDriver("com.mysql.jdbc.Driver");
//			使用数据源方式连接数据库只能在web容器中使用
			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc/mysql");
			qr = new QueryRunner(dataSource);
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	//如果有需要直接传递QueryRunner
	public QueryRunner getInitQr(String jndiString){
		try {
			DbUtils.loadDriver("com.mysql.jdbc.Driver");
//			使用数据源方式连接数据库只能在web容器中使用
			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup(jndiString);
			qr = new QueryRunner(dataSource);
		} catch (NamingException e) {
			e.printStackTrace();
		}
		return qr;
	}
	
//	查询数据
	public List query(String sql,Object[] params) {
		List list = null;
		try {
			list = qr.query(sql,new MapListHandler(),params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("已查找数据："+sql);
		return list;
	}
	
//	查询数据库所有记录,不用传参
	public List query(String sql) {
		List list = null;
		try {
			list = qr.query(sql,new MapListHandler());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("已查找数据："+sql);
		return list;
	}
	
//	查询数据库所有记录,返回总数
	public Object count(String sql) {
		Object total = null;
		try {
			total = qr.query(sql,new ScalarHandler());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("已查找数据："+sql);
		return total;
	}
	
//	插入数据:插入成功返回影响数据条数
	public int insert(String sql,Object[] params) {
		List list = null;
		int number = 0;
		try {
			list = qr.query(sql,new MapListHandler(),params);
			number = list.size();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return number;
	}
	
//	更新数据
	public int update(String sql,Object[] params) {
		int affect = 0;
		try {
			System.out.println(params.length);
			affect = qr.update(sql,params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("已更新"+affect+"数据:"+sql);
		return affect;
	}
	
//	删除数据
	public int delete(String sql,Object[] params) {
		int affect = 0;
		try {
			affect = qr.update(sql,params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("已删除"+affect+"条记录");
		return affect;
	}
}
