package com.tenco.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/select")
public class SelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SelectServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			String dbUrl = "jdbc:mysql://localhost:3306/demo5?serverTimezone=Asia/Seoul";
			
				Connection conn = DriverManager.getConnection(dbUrl, "root", "asd123");
				String sql = " SELECT * FROM users ";
				
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs =  pstmt.executeQuery();
				
				List< Map<String, String>> userList = new ArrayList<>();
				while(rs.next()) {
					Map<String, String> userMap = new HashMap();
					userMap.put("id", rs.getString("id"));
					userMap.put("name", rs.getString("name"));
					userMap.put("email", rs.getString("email"));
					
					userList.add(userMap);
					
				}
				
				request.setAttribute("userList", userList);
				
				// 서블릿에서 다른 JSP 파일로 데이터를 전달할 수 있다.
				// WAS 내부에서 새로운 request 생성을 시킬 수 있다, (단 외부에서(클라이언트) 모름)
				request.getRequestDispatcher("resultSet.jsp").forward(request, response);
				
				
				
				pstmt.close();
				conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
