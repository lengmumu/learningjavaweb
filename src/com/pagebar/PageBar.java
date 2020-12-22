package com.pagebar;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PageBar
 */
@WebServlet("/PageBar")
public class PageBar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getParameter("method");
		int pageNum = request.getParameter("pagenum") == null?1:Integer.parseInt(request.getParameter("pagenum"));
		System.out.println(request.getHeader("Referer")+"页码值"+method);
		PageBarDaoImp p = new PageBarDaoImp("alumni_records");
		p.init("java:comp/enc/jdbc/mysql");
		List list = null;
		switch(method) {
		case "first":		list = p.getFirstPage();break;
		case "last":		list = p.getLastPage();break;
		case "previous":	list = p.getPrevious();break;
		case "next":		list = p.getNext();break;
		case "getpage":		list = p.getPage(pageNum);break;
		}
		request.setAttribute("list", list);
		request.getRequestDispatcher("/alumnirecordsviews/manager/manageRecords.jsp").forward(request,response);
		
	}

}
