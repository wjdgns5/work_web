package com.tenco.controller;

import java.io.IOException;
import java.util.List;

import com.tenco.models.User;
import com.tenco.repository.UserDAOImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/user/*")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAOImpl userDAOImpl;
    
    public UserController() {
    	userDAOImpl = new UserDAOImpl();
    }
	
    // http://localhost:8080/jstl/user/list?id=123&name=길동
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 전체 URL 문자를 반환 할려면
		String fullURL = request.getRequestURL().toString();
		System.out.println("fullURL : " + fullURL);
		
		// URL의 쿼리 문자열을 반환 합니다. (쿼리 문자열이 없으면 NULL을 반환합니다.)
		String queryString = request.getQueryString();
		System.out.println("queryString : " + queryString);
		
		// 컨텍스트 루트 경로를 반환받고 싶다면
		String contextPath = request.getContextPath();
		System.out.println("contextPath : " +contextPath);
		
		// URL 마지막 경로(엔드포인트)를 반환 받고 싶다면 
		
		// ex ) mvc/list
		String pathInfo = request.getPathInfo();
		System.out.println("pathInfo : " + pathInfo);
		
		switch (pathInfo) {
		case "/list":
			userListPage(request, response);
			break;

		default:
			break;
		}
		
	}

	private void userListPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<User> userList = userDAOImpl.getAUsers();
		request.setAttribute("userList", userList);
	
		// UserDAOImpl getAllUsers() 메서드를 호출
		request.getRequestDispatcher("/WEB-INF/user/userList2.jsp").forward(request, response);
		// /WEB-INF/user/userList.jsp
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
