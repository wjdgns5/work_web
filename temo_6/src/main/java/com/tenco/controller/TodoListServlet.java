package com.tenco.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

@WebServlet("/todolist")
public class TodoListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TodoListServlet() {
        super();
    }
    
    // GET 방식
    // http://localhost:8080/temo/todolist
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		
		// HTML 파일 읽기
		String htmlFilePath = "/todoListPage.html";
		InputStream inputStream = getServletContext().getResourceAsStream(htmlFilePath);
		
		if(inputStream == null) {
			PrintWriter pw = response.getWriter();
			// html 이름 바꿔주면 됨 todoListPage1.html
			pw.print("<html><body>해당 파일을 찾을 수 없음 404</body></html>");
		}
		InputStreamReader in = new InputStreamReader(inputStream);
		BufferedReader reader = new BufferedReader(in);
		
		StringBuffer htmlContent = new StringBuffer();
		String line;
		
		while ( (line = reader.readLine())!= null ) {
			htmlContent.append(line);
		}
		reader.close();
		
		PrintWriter pw = response.getWriter();
		pw.write(htmlContent.toString());
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
