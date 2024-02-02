package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/add2")
public class addexemple2 extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setCharacterEncoding("UTF-8");//보내는거 UTF-8이다
		response.setContentType("text/html; charset=UTF-8");//html이고 UTF-8로 해석해라
		//request.setCharacterEncoding("UTF-8");//읽어온 것을 UTF-8
		
		//PrintWriter out = response.getWriter();
		String[] num_= request.getParameterValues("num");
		
		
		int result = 0;
		
		for(int i = 0; i<num_.length; i++)
		{
			int num = Integer.parseInt(num_[i]);
			result += num;
			
		}
		
		response.getWriter().printf("result is %d\n", result);
	}

}
