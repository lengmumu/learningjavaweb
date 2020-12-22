package com.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ManagerFilter implements Filter {
	String url="/";
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;
		HttpSession session = request.getSession();
		String flag = (String) session.getAttribute("login.manager.username"); 
		String uri = request.getRequestURI();
		int isLogin = uri.indexOf("Login");
		System.out.println(isLogin+"什么情况"+uri+flag); 
		if(isLogin != -1) {
			chain.doFilter(arg0,arg1);
		}
		else if(flag.isEmpty()) {
			response.sendRedirect(request.getContextPath()+url);
		}else{
			chain.doFilter(arg0,arg1);
		};
		
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		// TODO Auto-generated method stub
		url = config.getInitParameter("url");
	}

}
