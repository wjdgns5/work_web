package com.tenco.tboard.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtilBasic {
	
	private static final String DB_URL =
			"jdbc:mysql://localhost:3306/db_tboard?useSSL=false&serverTimezone=Asia/Seoul";
	
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "asd123";
	
	static {
		// 드라이버 구현체
		try {
			Class.forName("com.mysql.cj.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("DB 드라이버 로딩 실패");
			e.printStackTrace();
		} // end of try - catch
	} // end of static
	
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
	} // end of getConnection()
	
} // end of DBUtilBasic