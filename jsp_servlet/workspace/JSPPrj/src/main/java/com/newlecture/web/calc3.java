package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/calc3")
public class calc3 extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext application = request.getServletContext();
		HttpSession session = request.getSession();
		Cookie[] cookies = request.getCookies();
	
		response.setCharacterEncoding("UTF-8");//보내는거 UTF-8이다
		response.setContentType("text/html; charset=UTF-8");//html이고 UTF-8로 해석해라
		//request.setCharacterEncoding("UTF-8");//읽어온 것을 UTF-8
		
		//PrintWriter out = response.getWriter();
		String v_ = request.getParameter("v");
		String op = request.getParameter("operator");
		
		int v = 0;
		
		if(!v_.equals("")) v = Integer.parseInt(v_);// 
		
		if(op.equals("="))
		{
			//int x = (Integer)application.getAttribute("value");
			//int x = (Integer)session.getAttribute("value");
			int x = 0;
			for(Cookie c : cookies) {
				if(c.getName().equals("value")) {
					x = Integer.parseInt(c.getValue());
					break;
				}
			}
			
			int y = v;
			
			String operator = "";
			for(Cookie c : cookies) {
				if(c.getName().equals("op")) {
					operator = c.getValue();
					break;
				}
			}
			
			//String operator = (String)application.getAttribute("op");
			//String operator = (String)session.getAttribute("op");
			int result = 0;
					
			if(operator.equals("+"))
				result = x + y;
			else
				result = x - y;
			
			response.getWriter().printf("result is %d\n", result);	
		}
		
		else 
		{	
			//application.setAttribute("value", v);
			//application.setAttribute("op", op);
			//session.setAttribute("value", v);
			//session.setAttribute("op", op);
			Cookie valueCookie = new Cookie("value", String.valueOf(v));
			Cookie opCookie = new Cookie("op", op);
			valueCookie.setPath("/calc2");
			valueCookie.setMaxAge(60*60*24);
			opCookie.setPath("/calc2");
			opCookie.setMaxAge(60*60*24);
			response.addCookie(valueCookie);
			response.addCookie(opCookie);
			
			response.sendRedirect("calc2.html");
		}
		
		
				
		
	}

}
