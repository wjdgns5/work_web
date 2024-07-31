package com.tenco.servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	// static 쓰는 이유 모든 곳에서 사용할려고 , final 사용 이유 변경할 이유가 없기 때문에
	private static final String URL = "jdbc:mysql://localhost:3306/demo6?serverTimezone=Asia/Seoul";
	private static final String USER = "root";
	private static final String PASSWORD = "asd123";
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver"); // ClassNotFoundException
		return DriverManager.getConnection(URL, USER, PASSWORD); // SQLException
	}
}
