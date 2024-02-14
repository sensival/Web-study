package com.newlecture.web.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/notice/detail")
public class NoticeDetailController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 int id = Integer.parseInt(request.getParameter("id"));


		// MySQL 서버 정보
		String url = "jdbc:mysql://192.168.249.129:3306/expdb1"; // 데이터베이스 URL
		String sql = "SELECT * FROM NOTICE WHERE ID=?";
		//MySQL 드라이버 로드
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String username = "root"; // MySQL 사용자 이름
			String password = "112233qqwwee!"; // MySQL 암호

			// 연결 객체 초기화
			Connection con = null;
			//데이터베이스에 연결
			con = DriverManager.getConnection(url, username, password);

			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();


			rs.next(); 
			String title = rs.getString("TITLE") ;
			String writerId = rs.getString("WRITER_ID");
			String content = rs.getString("CONTENT");
			Date regdate = rs.getDate("REGDATE");
			String hit = rs.getString("HIT");
			String files =rs.getString("FILES");
			
			request.setAttribute("title", title);
			request.setAttribute("writerId", writerId);
			request.setAttribute("content", content);
			request.setAttribute("regdate", regdate);
			request.setAttribute("hit", hit);
			request.setAttribute("files", files);
			
			rs.close();
			st.close();
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//forward
		request.getRequestDispatcher("/notice/detail.jsp")
		.forward(request, response);
		//response의 인코딩방식 등 공유 가능

		
	}

}
