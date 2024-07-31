package com.tenco.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet("/read-posts")
public class ReadPostsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ReadPostsServlet() {
        super();
    }
    // 자원에 대한 요청은 GET 방식이다.
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 응답 처리 MINE TYPE 설정
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		
		try(
			Connection conn = DBUtil.getConnection();
				) {
			String sql = " SELECT * FROM posts ORDER BY created_at DESC ";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			// request 와 response에 값 담아서 보낸다.
			request.setAttribute("resultSet", rs);
			request.getRequestDispatcher("readPosts.jsp").forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	
}
