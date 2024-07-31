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

@WebServlet("/view-post")
public class DetailPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DetailPostServlet() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 상세보기
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("boardId");
		
		try(
				Connection conn = DBUtil.getConnection()
				) {
			String sql = " SELECT * FROM posts WHERE id = ? ";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(id));
			ResultSet rs = pstmt.executeQuery(); 
			
			request.setAttribute("resultSet", rs);
			request.getRequestDispatcher("detailPost.jsp").forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("result.jsp?message=error");
		}
		
	}

}
