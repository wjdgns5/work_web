package com.tenco.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class UserDAOImpl implements UserDAO {
	
	private DataSource dataSource;
	
	public UserDAOImpl() {
		
		InitialContext ctx;
		try {
			ctx = new InitialContext();
			dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/MyDB");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	} // 생성자
	
	
	@Override
	public UserDTO addUser(UserDTO userDTO) {
		
		String sql = " INSERT INTO users(username, password, email) VALUES (?, ?, ?) ";
		
		try(Connection conn = dataSource.getConnection();) {
			conn.setAutoCommit(false);
			
			try(PreparedStatement pstmt = conn.prepareStatement(sql);) {
				pstmt.setString(1, userDTO.getUsername());
				pstmt.setString(2, userDTO.getPassword());
				pstmt.setString(3, userDTO.getEmail());
				
				pstmt.executeUpdate();
				conn.commit();
				
			} catch (Exception e) {
				conn.rollback();
				e.printStackTrace();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return userDTO;
	} // end of addUser()

	@Override
	public UserDTO getUserById(int id) {
		String sql = " select * from users where id = ? ";
		
		try(Connection conn = dataSource.getConnection();) {
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return null;
	}

	@Override
	public UserDTO getUserByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserDTO> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDTO getUserUpdate(UserDTO userDTO, int printcipalId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDTO getUserDelete(UserDTO userDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
}
