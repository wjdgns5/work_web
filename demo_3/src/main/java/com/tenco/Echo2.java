package com.tenco;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "echo2", urlPatterns = {"/echo2"}) // 요청을 응답을 처리하는 클래스 
public class Echo2 extends HttpServlet {
	
	public Echo2() {
		super(); // 상위 생성자 
	}
	// http:// <-- 프로토콜 요청
	// http://localhost:8080 <-- 서버 컴퓨터의 호스트 주소
	
	
	// get 요청 방식
	// http://localhost:8080/demo_3/echo2
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// request -> req(
		System.out.println("doGet 메서드 호출 확인 ");
		// 자바.io 객체 (스트림을 통해 데이터를 넣을 예정)
		
		PrintWriter pw = resp.getWriter();
		// pw.print("안녕 반가워 ~ abc");
		
		pw.print("<!DOCTYPE html>");
		pw.print("<html>");
		pw.print("<head>");
		pw.print("<meta charset=\"UTF-8\">");
		pw.print("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
		pw.print("<title>Document</title>");
		pw.print("</head>");
		pw.print("<body>");
		pw.print("<section>");
		pw.print(" <p style=\"color: red;\">Hello First Servlet 반가워</p>");
		pw.print("</section>");
		pw.print("</body>");
		pw.print("</html>");
		
		resp.setContentType("text/html; charset=utf-8"); // html 형식 uft-8 
		
	}
	
	// post 요청 방식
	// http://localhost:8080/deom_3/echo2
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
	
	
	
	

}
