package com.oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class OracleTest {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = (Connection) DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:mldn","scott","tiger");
		System.out.println("连接成功");
		
		
	}

}
