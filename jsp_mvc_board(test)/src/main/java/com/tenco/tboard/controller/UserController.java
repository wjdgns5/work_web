package com.tenco.tboard.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.tenco.tboard.repository.UserRepositoryImpl;
import com.tenco.tboard.repository.interfaces.UserRepository;

@WebServlet("/user/*")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserRepository userRepository;
       
    public UserController() {
        super();
    }
    
    @Override
    public void init() throws ServletException {
    	userRepository = new UserRepositoryImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getPathInfo();
		System.out.println("doGet : " + action);
		
		switch (action) {
		// http://localhost:8080/t-board/user/signup
		case "/signup":
			request.getRequestDispatcher("/WEB-INF/views/user/signup.jsp").forward(request, response);
			break;
			
		case "/signin":
		// http://localhost:8080/t-board/user/signin
			request.getRequestDispatcher("/WEB-INF/views/user/signin.jsp").forward(request, response);
			break;
			
		case "/logout":
			handleLogout(request, response);
			
		default:
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			break;
		}
	}
	
	/**
	 * 로그아웃 기능 처리
	 * @param request
	 * @param response
	 */
	private void handleLogout(HttpServletRequest request, HttpServletResponse response) {
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
