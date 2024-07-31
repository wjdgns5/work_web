package com.tenco.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
@WebServlet("/create-post")
public class CreatePostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CreatePostServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}
	// post 인 이유 --> DB로 넘겨줘야 해서
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 언어 설정 (글자 깨짐 방지)
		request.setCharacterEncoding("UTF-8");
		// 서버가 수신한 요청 데이터의 인코딩을 설정합니다.
		
		// createPost.jsp 에서 title 과 content에서 값을 추출
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		// db 연결
		try(
				Connection conn = DBUtil.getConnection();
				) {
			String sql = " INSERT INTO POSTS(TITLE, CONTENT) VALUES(?, ?) ";
			PreparedStatement pstmt = conn.prepareStatement(sql); 
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.executeUpdate();
			
			// 성공하면 result.jsp 로 이동하면서 message 키에 create-success 값을들고 이동한다.
			response.sendRedirect("result.jsp?message=create-success");
			
		} catch (Exception e) {
			e.printStackTrace();
			// 실패하면 result.jsp 로 이동하면서 message 키에 create-error 값을 들고 이동한다.
			response.sendRedirect("result.jsp?message=create-error");
		}
	}
}
