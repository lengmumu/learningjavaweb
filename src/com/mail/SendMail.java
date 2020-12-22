package com.mail;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

/**
 * Servlet implementation class SendMail
 */
@WebServlet("/mail/SendMail")
public class SendMail extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SimpleEmail email = new SimpleEmail();
		email.setHostName("smtp.qq.com");
		email.setAuthentication("1379822587@qq.com", "lpjybzlzanzqfebc");
		email.setCharset("UTF-8");
		try {

			email.addTo(request.getParameter("to"));
			email.setFrom(request.getParameter("from"));
			email.setSubject(request.getParameter("subject"));
			email.setMsg(request.getParameter("content"));
			
			email.send();
			System.out.println("邮件发送成功");
		} catch (EmailException e) {
			System.out.println("邮件发送失败");
			e.printStackTrace();
		}
		
	}

}
