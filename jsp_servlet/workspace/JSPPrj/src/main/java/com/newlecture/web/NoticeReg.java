package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/notice-reg")
public class NoticeReg extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		response.setCharacterEncoding("UTF-8");//보내는거 UTF-8이다
		response.setContentType("text/html; charset=UTF-8");//html이고 UTF-8로 해석해라
		//request.setCharacterEncoding("UTF-8");//읽어온 것을 UTF-8
		
		PrintWriter out = response.getWriter();
		
		//int cnt = Integer.parseInt(request.getParameter("cnt"));// default 값 설정 안되어 있음 hello?cnt=3안주면 error
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
	
		out.println(title);
		out.println(content);

	}
}
