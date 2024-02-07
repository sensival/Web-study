<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

//response.setCharacterEncoding("UTF-8");
//response.setContentType("text/html; charset=UTF-8");-> 설정 노필요

//PrintWriter out = response.getWriter(); -> out 이미 있으니 선언 노필요


String temp = request.getParameter("cnt");

int cnt = 100;

if(temp != null && !temp.equals(""))
	cnt = Integer.parseInt(temp);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% for(int i=0; i<cnt; i++) {%>
	뀨 Hello Servlet!!<br />
	<%} %>
</body>
</html>