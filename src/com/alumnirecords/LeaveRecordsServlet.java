package com.alumnirecords;

import java.io.IOException;
import java.io.PrintWriter;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import javax.servlet.http.*;

import com.mysql.MysqlConnect;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class LeaveRecordsServlet extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest request,HttpServletResponse response) {
		doPost(request,response);
	}
	
	@SuppressWarnings("null")
	@Override
	public void doPost(HttpServletRequest request,HttpServletResponse response) {
		//连接数据库
		MysqlConnect m = new MysqlConnect();
		Connection con = m.getMysqlConnection(3307,"test","root","root");
		int userId = 2;
		String insertSql = "insert into alumni_records(user_id, delete_flag, invited_code, image, name, sex, birthday, mobile, email, address, interests, yearning_city, image_to_inviter, leave_message) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(insertSql);
			ARBean bean = new ARBean();
			Object[] o = bean.getObjectsArray();
			String[] names = bean.getNamesArray();
			List<String> namesList = new ArrayList<String>(Arrays.asList(names));
			
			int index = 0;
			System.out.println(Arrays.toString(o));
			System.out.println(Arrays.toString(names));
			
		
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			Enumeration<String> formData = request.getParameterNames();
			String name;
			String arrayValue;
			ps.setInt(1, userId);
			ps.setInt(2, 2);
			while(formData.hasMoreElements()) {
				name = formData.nextElement();
				index = namesList.indexOf(name);
				if(name.equals("imageToInviter")) {
					arrayValue = Arrays.toString(request.getParameterValues(name));
					ps.setObject(index, arrayValue);
				}else {
					ps.setObject(index, request.getParameter(name));
					System.out.println(index+" "+name+" "+request.getParameter(name));
				}
			}
			int a = ps.executeUpdate();
			m.colseMysqlConnection(con, ps);
			System.out.println(a+"行受影响");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
}
