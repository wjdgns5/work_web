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
    // 데이터를 DB에서 가져와야 한다.
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 글자 설정
		response.setCharacterEncoding("UTF-8");
		// MINE TYPE 설정
		response.setContentType("text/html");
		
		// DB 연결 시도
		try(
				Connection conn = DBUtil.getConnection();
				) {
			String sql = " SELECT * FROM posts ORDER BY created_at DESC ";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			request.setAttribute("resultSet", rs); // sql 연산한 것을 키- 값으로 셋팅
			request.getRequestDispatcher("readPost.jsp").forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}


}
