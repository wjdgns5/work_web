package com.tenco;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

// http://localhost:8080/hello/my-servlet
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public MyServlet() {
        super();
        System.out.println("호출 1");
    }
    
    @Override
    public void init() throws ServletException {
    	super.init();
    	System.out.println("호출 2");
    }
    
    // 클라이언트가 매번 요청을 하는데 매번 호출이 될까?
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	System.out.println("호출 3");
    	System.out.println("서비스 메서드 호출 확인");
    	response.setContentType("text/html; charset=UTF-8");
    	
    	// 부모 클래스 메서드가 호출되어서 알아서 분배해준다.
    	super.service(request, response); 
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// service()의 super.service()의 부모 클래스 메서드가 호출되서 작동된다. 
		System.out.println("호출 4-1");
		System.out.println("doGet 메서드 호출");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("호출 4-2");
		System.out.println("doPost 메서드 호출");
	}
	
	@Override
	public void destroy() {
		System.out.println("destory() 메서드 호출");
	}

}
