package com.mysql;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSetMetaData;
import com.mysql.jdbc.Statement;

public class MysqlConnect {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MysqlConnect m = new MysqlConnect();
		Connection con = m.getMysqlConnection(3307,"test","root","root");
		
		//插入数据
//				try {
//					String insertSql = "insert into ar_users values(?,?,?)";
//					PreparedStatement ps = (PreparedStatement) con.prepareStatement(insertSql);
//					ps.setInt(1,2);
//					ps.setString(2, "yimeilin");
//					ps.setString(3, "yimeilin123456");
//					ps.executeUpdate();
				
		//查找所有数据
		String selectSql = "select * from alumni_records";
		ResultSet rs = m.getMysqlQuery(con, selectSql);
		m.getMysqlTableData(rs);
		m.getMysqlTableInfo(rs);
		
				
		
		//关闭数据库
		m.colseMysqlConnection(con, rs,null);
//		m.colseMysqlConnection(con, ps);
//				} catch (SQLException e) {
//					e.printStackTrace();
//		}
		
		
	}
	
	public Connection getMysqlConnection(int port,String database,String username,String password){
		Connection con = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:"+port+"/"+database;
			System.out.println(url);
			con = (Connection) DriverManager.getConnection(url,username,password);
			
		}catch(ClassNotFoundException e){
			System.out.println("数据库连接出错，请检查getMysqlConnection方法");
		}catch(SQLException e){
			System.out.println("数据库连接出错，请检查getMysqlConnection方法");
		}
		return con;
	}

		// 对数据库进行防注入的插入语句
		// insert into dept(`dept_name`,`dept_loc`) values (?,?)
		// 索引值从1开始
		public int getMysqlQuery(int beginIndex, String[] array,Connection con,String sql){
			int i = 0;
			try{
				// 创建语句对象
				PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(sql);
				for(i=beginIndex;i<array.length;i++){
					preparedStatement.setObject(i+1, array[i]);
				}
				i = preparedStatement.executeUpdate();
				System.out.println(i+"行受影响");
			}catch(SQLException e){
				System.out.println(sql+"!!!该sql语句出现错误");
			}
			return i;
		}

		// 对数据库进行查询
		// select * from dept order by dept_no;
		// select * from dept where dept_no=1;
		public ResultSet getMysqlQuery(Connection con,String sql){
			ResultSet resultSet = null;
			try{
				Statement statement = (Statement) con.createStatement();
				resultSet = statement.executeQuery(sql);
			}catch(SQLException e){
				System.out.println(sql+"!!!该sql语句出现错误");
			}
			return resultSet;
		}

		// 对数据库进行更新和删除
		// update dept set dept_name=concat(`prefix`+dept_name) where dept_no>2 
		// delete from dept where dept_no>3 
		public void getMysqlUpdate(Connection con,String sql){
			try{	
				PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(sql);
				int i = preparedStatement.executeUpdate();
				System.out.println(i+"行受影响");
			}catch(SQLException e){
				System.out.println(sql+"!!!该sql语句出现错误");
			}
		}
		
		//获取表格列信息,获取列信息序号从1开始
		public void getMysqlTableInfo(ResultSet rs){
			try{
				ResultSetMetaData resultSetMetaData = (ResultSetMetaData) rs.getMetaData();
				int columnCount = resultSetMetaData.getColumnCount();
				System.out.println("列序号\t 列名\t 数据类型");
				for(int i=1;i<=columnCount;i++){
					System.out.println(
						i+"\t"+
						resultSetMetaData.getColumnName(i)+"\t"+
						resultSetMetaData.getColumnTypeName(i)
					);
				}
			}catch(SQLException e) {
				System.out.println("展示出错，getMysqlTableInfo");
				e.printStackTrace();
			}
//			rs.close();
		}
		
		//获取表格所有数据
		public void getMysqlTableData(ResultSet rs){
			Object o = null;
			ResultSetMetaData resultSetMetaData;
			try{
				resultSetMetaData = (ResultSetMetaData) rs.getMetaData();
				int columnCount = resultSetMetaData.getColumnCount();
				for(int i=1;i<=columnCount;i++) System.out.print(resultSetMetaData.getColumnName(i)+"\t");
				System.out.println();
				while(rs.next()) {
					for(int i=1;i<=columnCount;i++) {
						o = rs.getObject(i);
						System.out.print(o+"\t");
					}
					System.out.println();
				}
			}catch(SQLException e) {
				System.out.println("展示所有表格信息出错，getMysqlTableData");
				e.printStackTrace();
			}
		}

		public void colseMysqlConnection(Connection con,ResultSet resultSet,Statement statement){
			// 结果集关闭
			try{
				if(resultSet != null){
					resultSet.close();
					resultSet = null;
				}
			}catch(Exception e){
				System.out.println("resultSet关闭异常");
				e.printStackTrace();
			}

		// sql语句对象关闭
		try{
			if(statement != null){
				statement.close();
				statement = null;
			}
		}catch(Exception e){
			System.out.println("statement关闭异常");
			e.printStackTrace();
		}

		//数据库连接对象关闭
		try{
			if(con != null){
				con.close();
				con = null;
			}
		}catch(Exception e){
			System.out.println("con关闭异常");
			e.printStackTrace();
		}
		}
		
		public void colseMysqlConnection(Connection con,PreparedStatement statement){
		// sql语句对象关闭
		try{
			if(statement != null){
				statement.close();
				statement = null;
			}
		}catch(Exception e){
			System.out.println("statement关闭异常");
			e.printStackTrace();
		}

		//数据库连接对象关闭
		try{
			if(con != null){
				con.close();
				con = null;
			}
		}catch(Exception e){
			System.out.println("con关闭异常");
			e.printStackTrace();
		}
		}


}
