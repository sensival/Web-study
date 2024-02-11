package com.newlecture.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/spag")
public class Spag extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num = 0;
		String num_ = request.getParameter("n");
		if(num_ != null && !num_.equals(""))
		num = Integer.parseInt(num_); 
		String result;
		
		if(num%2 != 0)
		{
			result="홀수";
		} 
		else
		{
			result="짝수";
		}
		
		request.setAttribute("result", result);
		
		String[] names = {"newlec","dragon"};
		request.setAttribute("names", names);
		
		Map<String, Object> notice = new HashMap<String, Object>();
		notice.put("id", 1);
		notice.put("title", "EL은 조아요");
		request.setAttribute("notice", notice);
		
		//redirect: 새로운 요청
		//forward: 이어서 작업이어가기
		
		RequestDispatcher dispatcher=
				request.getRequestDispatcher("spag.jsp");
		
		dispatcher.forward(request, response);// spag.jsp에 request, response 전달
	}

}
