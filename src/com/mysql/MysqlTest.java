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
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSetRow;

public class MysqlTest{
	public static void main(String[] args) {
//		MysqlUtil m = new MysqlUtil();
//		m.init();
//		Object[] params = {1};
//		m.query("select * from ar_managers where id=?",params);
		Connection con = null;
		QueryRunner qr;
		try {
			

//			Context context = new InitialContext();
//			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc/mysql");
//			qr = new QueryRunner(dataSource);
			
			con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3307/test","root","root");
			qr = new QueryRunner();
//			Object[] params = {"admin","admin123456"};
//			List list = qr.insert(con,"insert into ar_managers(`musername`,`mpassword`) values (?,?)",new MapListHandler(),params);

//			Object[] params2 = {};
//			List list2 = qr.query(con,"select * from ar_managers where musername='admin'&& mpassword='admin567'",new MapListHandler(),params2);
//			Map map = null;
//			map = (Map) list2.get(0);
			
//			Object[] params3 = {"admin"};
//			int affect = qr.update(con,"delete from ar_managers where musername=?",params3);
			int affect = Integer.parseInt((qr.query(con,"select count(*) from alumni_records",new ScalarHandler())).toString());
			DbUtils.close(con);
			System.out.println(affect%10);
		}catch(Exception e) {e.printStackTrace();}
	}
//	Connection con = null;
//	QueryRunner qr;
//	public void init(){
//		try {
//			DbUtils.loadDriver("com.mysql.jdbc.Driver");
////			使用数据源方式连接数据库出现问题
////			Context context = new InitialContext();
////			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc/mysql");
////			qr = new QueryRunner(dataSource);
//			con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3307/test","root","root");
//			qr = new QueryRunner();
////			qr.insert("insert into ar_musers(`musername`,`mpassword`) values (?,?)", rsh)
////		} catch (NamingException e) {
////			e.printStackTrace();
//		}catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
//	
//	public void query(String sql,Object[] array) {
//		try {
//			List list = qr.query(con,sql, array,new MapListHandler());
//			DbUtils.close(con);
//			Map map = null;
//			for(int i=0;i<list.size();i++) {
//				map = (Map) list.get(i);
//				System.out.println(map.get("musername"));
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
//	
//	public void insert(String sql,Object[] array) {
//		try {
//			qr.insert(sql, new MapListHandler(), array);
//			DbUtils.close(con);
//			Map map = null;
//			for(int i=0;i<list.size();i++) {
//				map = (Map) list.get(i);
//				System.out.println(map.get("musername"));
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
}
