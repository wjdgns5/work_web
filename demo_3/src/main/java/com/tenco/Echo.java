package com.tenco;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

// Servlet : Server (서버) + let (허락하다, 허용)
// Servlet : Server (서버) + Applet (Application + let) ?? 잘모르겟음
@WebServlet(name = "echo", urlPatterns = {"/echo"})
public class Echo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Echo() {
        super();
    }
    
    @Override
    public void init() throws ServletException {
    	// 	클라이언트로부터 최초로 서블릿 요청이 있을 때 실행 
    	// 기능 구현 : 초기화 작업
    	// 실행 횟수 : 1회
    	System.out.println("Echo 서블릿 클래스가 --> 컴파일 --> .class 파일로 변환");
    	System.out.println("init() 메서드는 인스턴스화 될 때 딱 한번 호출 되는 메서드");
    }
   

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		// 객체를 재사용하는 방식
	}
	
	// POST 요청시 동작 하는 메서드
	// 주소 설계
	// http://localhost:8080/demo_3/echo
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("안녕 서버측 콘솔에서 출력을 합니다.");
	}
	
	@Override
	public void destroy() {
		// 서블릿 객체가 메모리에서 삭제될 때 실행(서비스나 서버 중지 시)
		// 기능 구현 : 실제 서블릿이 처리해야 하는 작업 
		// 실행 횟수 1회
		System.out.println("메모리에서 내려갈 때 호출 되는 메서드");
	}

}
