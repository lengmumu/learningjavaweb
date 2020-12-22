package com.alumnirecords;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;

import com.mysql.MysqlUtil;
import com.mysql.jdbc.Connection;

/**
 * Servlet implementation class ValidateManager
 */
@WebServlet("/alumnirecordsviews/manager/ValidateManagerLogin")
public class ValidateManager extends HttpServlet {
    public ValidateManager() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		login(request,response);
	}
	
	public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String message = "";
			MysqlUtil m = new MysqlUtil();
			m.init("java:comp/env/jdbc/mysql");
			String musername = request.getParameter("musername");
			String mpassword = request.getParameter("mpassword");
			String[] params = {musername,mpassword};
			System.out.println(Arrays.toString(params));
			if(musername.isEmpty() || mpassword.isEmpty()) {
				message="对不起，您输入的数据存在空值";
				request.setAttribute("login.message", message);
				request.getRequestDispatcher("/alumnirecordsviews/loginFail.jsp").forward(request,response);
			}
			String sql = "select * from ar_managers where musername=? && mpassword=?";
			List list = m.query(sql, params);
			if(list.size()==0) {
				message = "对不起，你所输入的用户名或密码不正确";
				request.setAttribute("login.message", message);
				request.getRequestDispatcher("/alumnirecordsviews/loginFail.jsp").forward(request,response);
			}else {
				request.getSession().setAttribute("login.manager.username",musername);
				response.sendRedirect(request.getContextPath()+"/alumnirecordsviews/manager/manageRecords.jsp");
			}
		}catch(Exception e) {
			e.printStackTrace();
			request.setAttribute("login.message","服务器异常，请联系管理员");
			request.getRequestDispatcher("/alumnirecordsviews/loginFail.jsp").forward(request,response);
		}
	}

}
