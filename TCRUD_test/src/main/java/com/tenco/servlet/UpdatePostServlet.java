package com.tenco.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

@WebServlet("/update-post")
public class UpdatePostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdatePostServlet() {
        super();
    }
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		// 서버가 수신한 요청 데이터의 인코딩을 설정합니다.
		
		String id = request.getParameter("boardId");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		System.out.println("title 의 값 : " +title);
		System.out.println("boardId 의 값 : " +id);
		System.out.println("content 의 값 : " +content);
		
		try(
				Connection conn = DBUtil.getConnection();
				) {
			String sql = " UPDATE posts SET title = ?, content = ? WHERE id = ? ";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setInt(3, Integer.parseInt(id));
			pstmt.executeUpdate();
			
			response.sendRedirect("result.jsp?message=update-success");
	
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("result.jsp?message=error");
		}
		
	}

}
