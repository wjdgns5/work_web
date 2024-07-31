package com.tenco.tboard.controller;

import java.io.IOException;
import java.sql.PreparedStatement;

import com.tenco.tboard.model.Comment;
import com.tenco.tboard.model.User;
import com.tenco.tboard.repository.CommnetRepositoryImpl;
import com.tenco.tboard.repository.interfaces.CommentRepository;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/comment/*")
public class CommentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CommentRepository commentRepository;
       
    public CommentController() {
        super();
    }
    
    @Override
    public void init() throws ServletException {
    	commentRepository = new CommnetRepositoryImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getPathInfo();
		System.out.println("doGet action : " +action);
		
		switch (action) {
		case "/add":
			request.getRequestDispatcher("/WEB-INF/views/user/signin.jsp").forward(request, response);
			break;

		default:
			break;
		}
		
	}
	// ///////////////////////////////////////////////////
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getPathInfo();
		System.out.println("doPost action : " +action);
		
		HttpSession session = request.getSession(false);
		if(session == null || session.getAttribute("principal")== null) {
			response.sendRedirect(request.getContextPath() +"/user/signin");
		}
		
		switch (action) {
		case "/add":
			addCommit(request, response, session);
			break;

		default:
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			break;
		}
	}

	private void addCommit(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		// 현재 로그인한 사용자의 ID
		User user = (User)session.getAttribute("principal");
		System.out.println("principal : " + user);
		if(user != null) {
			request.setAttribute("userID", user.getId());
		}
		
		String content = "";
		
		
		
	}
}
