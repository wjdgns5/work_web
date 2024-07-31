package com.temo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "echo3", urlPatterns = {"/echo3"})
public class Echo2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Echo2() {
        super();
    }
    // http://localhost:8080/temo_3/echo3
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// request -> req(
				System.out.println("doGet 메서드 호출 확인 ");
				// 자바.io 객체 (스트림 통해 데이터를 넣을 예정) 
				PrintWriter pw = response.getWriter(); 
				
				response.setContentType("text/html; charset=utf-8");
				
//				pw.print("<!DOCTYPE html>");
//				pw.print("<html lang=\"en\">");
//				pw.print("<head>");
//				pw.print("    <meta charset=\"UTF-8\">");
//				pw.print(" <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
//				pw.print("    <title>Document</title>");
//				pw.print("</head>");
//				pw.print("<body>");
//				pw.print("<section>");
//				pw.print("<p style=\"color: red;\" >Hello First Srvlet 반가워</p>");
//				pw.print("</section>");
//				pw.print("</body>");
//				pw.print("</html>");
				
				pw.print("""
						<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
        <p>구름 !!</p>
        <p>clo</p>
    
</body>
</html>
						""");
		
	}
	
	// http://localhost:8080/temo_3/echo3
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
