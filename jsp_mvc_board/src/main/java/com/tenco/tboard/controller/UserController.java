package com.tenco.tboard.controller;

import java.io.IOException;
import java.io.PrintWriter;

import com.tenco.tboard.model.User;
import com.tenco.tboard.repository.UserRepositoryImpl;
import com.tenco.tboard.repository.interfaces.UserRepository;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/user/*")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// UserController --> UserRepository
	
	private UserRepository userRepository;
	   
    public UserController() {
        super();
    }
    
    @Override
    public void init() throws ServletException {
    	userRepository = new UserRepositoryImpl();
    } // end of init()

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getPathInfo(); // 마지막 엔드 포인트만 여기에 담긴다.
		System.out.println();
		System.out.println("doGet : " +action);
		
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
			// http://localhost:8080/t-board/user/logout
			handleLogout(request, response);
			break;

		default:
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			break;
		} // end of switch
	} // end of doGet(HttpServletRequest request, HttpServletResponse response)
	
	/**
	 * 로그아웃 기능 처리
	 * @param request
	 * @param response
	 * @throws IOException
	 * // http://localhost:8080/t-board/user/logout 
	 */
	private void handleLogout(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 로그아웃 기능은 세션을 무력화 하면 된다.
		HttpSession session = request.getSession(); // 세션 추출
		session.invalidate(); // 세션 무효화 , 로그아웃 됨
		
		response.sendRedirect(request.getContextPath() + "/user/signin");
		System.out.println("로그아웃 getContextPath() : " + request.getContextPath() );
	} // end of handleLogout(HttpServletRequest request, HttpServletResponse response)

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getPathInfo(); // 마지막 엔드 포인트만 여기에 담긴다.
		System.out.println("doPost : " +action);
		
		switch (action) {
		// 회원가입 기능 처리
		// http://localhost:8080/t-board/user/signup
		case "/signup":
			handleSignup(request, response);
			break;
		
		case "/signin":
			// 로그인 기능 처리
			// http://localhost:8080/t-board/user/signin
			handleSignin(request, response);
			break;

		default:
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			break;
		} // end of switch
		
	} // end of doPost(HttpServletRequest request, HttpServletResponse response)

	
	/**
	 * 로그인 기능 처리
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void handleSignin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User principal = userRepository.getUserByusernameAndPassword(username, password);
		
		if(principal != null && principal.getPassword().equals(password)) {
			HttpSession session = request.getSession();
			session.setAttribute("principal", principal);
			
			// 302 (브라우저 갔다가) --> 바로 서블릿 클래스(BoardController) -- (JSP 내부이동)
			System.out.println("로그인 완료");
			response.sendRedirect(request.getContextPath() + "/board/list");
		} else {
			request.setAttribute("errorMessage", "잘못된 요청입니다.");
			request.getRequestDispatcher("/WEB-INF/views/user/signin.jsp").forward(request, response);
		} // end of if - else
		
	} // end of handleSignin(HttpServletRequest request, HttpServletResponse response)

	private void handleSignup(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 데이터 추출
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		
		// 데이터 유효성 검사는 생략
		
		User user = User.builder()
				.username(username)
				.password(password)
				.email(email)
				.build();
		
		System.out.println(user);
		
		 int result = userRepository.addUser(user);
		 System.out.println("result : " +user);
		 
		 if(result != 0) {
			 response.sendRedirect(request.getContextPath() +"/user/signin");
			 
		 } else {
			 // 예외 처리
			 // TODO 경고 메세지 내려 주기
			 System.out.println("회원가입 실패");
			 
			response.setContentType("text/html");
			response.setCharacterEncoding("UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script> alert('잘못된 요청입니다.'); history.back(); </script>");
			// history.back(); 뒤로 돌아가기 
		 }
	} // end of handleSignup(HttpServletRequest request, HttpServletResponse response)

} // end of UserController
