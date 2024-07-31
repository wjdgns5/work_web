package com.tenco;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
 * HttpServlet 클래스를 상속 받아서 내가 정의한 클래스가 선언 된다.
 * why?  --> HTTP 프로토콜을 통한 Request, response 처리를 할 수 있기 때문이다.
 * 
 * URL 매핑에 대한 개념을 알아보자.
 * 클라이언트가 특정 URL을 요청했을 때 해당 URL에 대응하는 서블릿을
 * 실행하도록 설정하는 것을 의미한다.
 * 
 * URL 매핑 방법 - 2가지 방법을 알아보았다.
 * 1. @WebServlet("/hello-servlet2")
 * 2. web.xml 파일의 url-pattern 으로 쓸수있다.
 */

// @WebServlet("/hello-servlet2")
@WebServlet(urlPatterns = "/example", loadOnStartup = 1) 
// loadOnStartup : web.xml에서 <load-on-startup>1</load-on-startup> 으로 되며
// loadOnStartup : 컨테이너 실행 시 서블릿이 로드되는 순서 지정
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	// 생성자
    public HelloServlet() {
        super();
        System.out.println("생성자가 호출 됨");
    } // 필요없으면 지워도 된다.

    // 해당 서블릿 클래스가 인스턴스가 될 때 단 한번 실행 하는 메서드이다.
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init() 메서드가 호출 됨");
	}
	
	// 메모리에서 내려가기 직전에 호출 되는 메서드이다.
	public void destroy() {
		System.out.println("destory : 호출");
	}
	
	// GET 요청으로 들어 올 때 동작 된다.
	// 주소 설계 - http://localhost:8080/hello/hello-servlet
	// /루트/url-mapping 이런 느낌?
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// MIME TYPE - 인터넷 세상에서 데이터의 유형을 나타내는 표준 방식
		
		// 내가 던지는 컨텐트 타입은 텍스트 형식이고 html 형식이야 
		response.setContentType("text/html");
		
		// 내가 던지는 인코딩은 UTF-8 이야 
		response.setCharacterEncoding("UTF-8");
		
		// 스트림을 어디에서 뽑아야 될까?
		// 문자열 형식으로 데이터를 출력한다.
		response.getWriter().write("<html> <body> <h1>HELLO</h1> </body> </html>");
	}
	

	// POST 요청으로 들어 올 때 동작 된다.
	// 주소 설계 - http://localhost:8080/hello/hello-servlet
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 문제 --> POST 요청이 들어오는 것을 확인하고
		// 응용해서 데이터 또는 html 형식으로 응답처리 하세요.
		
		System.out.println("post 되나?");
		// super.doPost(request, response);
	
		
	}

}
