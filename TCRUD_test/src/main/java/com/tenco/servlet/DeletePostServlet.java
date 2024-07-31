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

import com.mysql.cj.protocol.Resultset;

@WebServlet("/delete-post")
public class DeletePostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeletePostServlet() {
        super();
    }
    
    // 삭제하기 위해서는 db에 있는 데이터를 가져와야 한다.
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		// 클라이언트에게 다시 보내는 응답의 인코딩을 설정합니다.
		response.setContentType("text/html");
		
		
		// 삭제를 하기 위해서는 form에서 데이터를 받아야 하는데 제목과 내용만으로는 삭제하는
		// 파일을 알기 어렵기에 pk값인 id를 hidden으로 숨겨서 삭제하기 편하게 할려고 한다.
		String id = request.getParameter("boardId");
		System.out.println("id : " + id); // 동작 확인
		
		// db 연결 
		try(
				Connection conn = DBUtil.getConnection();
				) {
			String sql = " DELETE FROM posts WHERE id = ? ";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(id));
			pstmt.executeUpdate();
			
			response.sendRedirect("result.jsp?message=delete-success");
			
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("result.jsp?message=error");
		}
	}
}
