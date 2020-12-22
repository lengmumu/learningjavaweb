package com.alumnirecords;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.MysqlUtil;

/**
 * Servlet implementation class ManageRecords
 */
@WebServlet("/alumnirecordsviews/manager/ManageRecords")
public class ManageRecords extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MysqlUtil m = null;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		try {
	    	MysqlUtil m = new MysqlUtil();
	    	m.init("java:comp/env/jdbc/mysql");
	    	
			if(request.getParameter("method").equals("edit")) {
				edit(request,response,m);
			}else if(request.getParameter("method").equals("delete")) {
				delete(request,response,m);
			}else if(request.getParameter("method").equals("loginout")) {
				session.setAttribute("login.manager.username", "");
			}
			session.setAttribute("message", "操作成功");
			response.sendRedirect(request.getContextPath()+"/alumnirecordsviews/manager/tip.jsp");
		}catch(Exception e) {
			session.setAttribute("message", "操作失败");
			response.sendRedirect(request.getContextPath()+"/alumnirecordsviews/manager/tip.jsp");
		}
			
	}
	public void edit(HttpServletRequest request, HttpServletResponse response,MysqlUtil m) throws ServletException, IOException{
		Object[] params = {request.getParameter("user_id"),
				request.getParameter("invited_code"),
				request.getParameter("image"),
				request.getParameter("name"),
				request.getParameter("sex"),
				request.getParameter("birthday"),
				request.getParameter("mobile"),
				request.getParameter("email"),
				request.getParameter("address"),
				request.getParameter("interests"),
				request.getParameter("yearning_city"),
				request.getParameter("image_to_inviter"),
				request.getParameter("leave_message"),
				request.getParameter("id")
		};
		String sql = "update alumni_records set user_id=?, invited_code=?, image=?, name=?, sex=?, birthday=?, mobile=?, email=?, address=?, interests=?, yearning_city=?, image_to_inviter=?, leave_message=? where id=?";
		m.update(sql, params);
	}
	public void delete(HttpServletRequest request, HttpServletResponse response,MysqlUtil m) throws ServletException, IOException{
		Object[] id = {request.getParameter("id")};
		m.delete("delete from alumni_records where id=?", id);
	}
}
