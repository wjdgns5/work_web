package com.tenco.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/session-test")
public class SessionTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public SessionTestServlet() {
        super();
    }
    
    // 주소 설계 - http://localhost:8080/temo/session-test
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session = request.getSession();
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
	
		PrintWriter pw = response.getWriter();
		pw.print("당신에 세션 아이디는 : " + session.getId());
		
		// 세션 무효화 버튼
		pw.print("<form action='/session-test' method='POST'>");
		pw.print("<button type='submit' >세션 종료 (로그아웃)</button>");
		pw.print("</form>");	
			
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("doPost 실행 확인");
		
		HttpSession session = request.getSession(false);
		
		if(session != null) {
			session.invalidate();
		}
		
		response.sendRedirect("session-test");
			
	}

}
