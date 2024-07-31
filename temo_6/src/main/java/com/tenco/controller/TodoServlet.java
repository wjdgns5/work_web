package com.tenco.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.jsp.tagext.TryCatchFinally;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

// http://localhost:8080/temo/todo-insert
@WebServlet("/todo-insert")
public class TodoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TodoServlet() {
        super();
    }
    
    // 정적 초기화 블록 - 단 한번 호출
    static {
    	try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			// 컴파일 타임에 직접적인 참조 없이 런타임에 동적으로 클래스를 로드하기 위함이다
		} catch (Exception e) {
			// TODO: handle exception
		}
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		System.out.println("TODO-INSERT POST 호출 된다.");
		
		// HTTP 메세지에서 데이터  추출하기 
		// form 에서 name 속성이 있어야 값을 추출할 수 있다.
		
		String title = request.getParameter("title");
		String description = request.getParameter("description");
		
		System.out.println("title : " + title);
		System.out.println("description : " + description);
		
		// 데이터베이스 연동 코드를 작성해야 한다.
	    String jdbcURL = "jdbc:mysql://localhost:3306/db_todo?serverTimezone=Asia/Seoul";
	    String username = "root";
	    String password = "asd123";
	    
	    String insertTodoSQL = " INSERT INTO tb_todo(title, description) VALUES (?, ?) ";
	    
	    try(
	    		Connection conn = DriverManager.getConnection(jdbcURL, username, password);
				PreparedStatement pstmt = conn.prepareStatement(insertTodoSQL)
	    		) {
			
	    	pstmt.setString(1, title);
	    	pstmt.setString(2, description);
	    	int rowCount = pstmt.executeUpdate();
	    	System.out.println("rowCount : " + rowCount);
	    } catch (SQLException e) {
			// TODO Auto-generated catch block
	    	PrintWriter pw = response.getWriter();
	    	pw.print("Error : " +e.getMessage() );
			e.printStackTrace();
			return;
		}
	   
	   PrintWriter pw = response.getWriter();
	   pw.print("Todo added succedssfully");
	
	}

}
