package com.utiltool;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServiceParameter
 */
@WebServlet("/ServiceParameter")
public class ServiceParameter extends HttpServlet {
    public ServiceParameter() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		printContent(request, out);
		out.flush();
		out.close();
	}
	
	public void printContent(HttpServletRequest request,PrintWriter out) {
		out.println("服务器名："+request.getServerName()+"<br>");
		out.println("主机地址："+request.getRemoteAddr()+"<br>");
		out.println("主机端口号："+request.getServerPort()+"<br>");
		out.println("主机协议："+request.getProtocol()+"<br>");
		out.println("主机上下文路径："+request.getContextPath()+"<br>");
		out.println("主机协议："+request.getScheme()+"<br>");
		out.println("请求方法："+request.getMethod()+"<br>");
		out.println("URI："+request.getRequestURI()+"<br>");
	}

}
