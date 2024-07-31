package com.temo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/servlet")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MyServlet() {
        super();
    }
    
    @Override
    public void init() throws ServletException {
    	super.init();
    	System.out.println("Servlet is being initialized");
    }
    // http://localhost:8080/temo_2/servlet
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		response.getWriter().println("<html><body><h1>Servlet Lifecycle Example</h1></body></html>");
		System.out.println("Handling GET request");
	}
	
	@Override
	public void destroy() {
		System.out.println("destory");
		super.destroy();
	}

	

}
