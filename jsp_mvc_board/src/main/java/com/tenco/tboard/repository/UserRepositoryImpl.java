package com.tenco.tboard.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.tenco.tboard.model.User;
import com.tenco.tboard.repository.interfaces.UserRepository;
import com.tenco.tboard.util.DBUtil;

public class UserRepositoryImpl implements UserRepository {
	// 구현 메서드로 수정하면 된다.
	
	private static final String INSERT_USER_SQL =
			" INSERT INTO users (username, password, email) VALUES(?, ?, ?) ";
	
	private static final String DELETE_USER_SQL =
			" DELETE FROM users WHERE id = ? ";
	
	private static final String SELECT_USER_BY_USERNAME = 
			" SELECT * FROM users WHERE username = ? ";
	
	private static final String SELECT_USER_BY_USERNAME_AND_PASSWORD = 
			" SELECT * FROM users WHERE username = ? AND password = ? ";
	
	private static final String SELECT_ALL_USERS =
			" SELECT * FROM users ";
	
	
	@Override
	public int addUser(User user) {
		
		int rowCount = 0;
		
		try(Connection conn = DBUtil.getConnection()) {
			conn.setAutoCommit(false); // 트랜잭션 시작
			// username 중복 확인 필요
			// email 중복 확인 필요 
			try(PreparedStatement pstmt = conn.prepareStatement(INSERT_USER_SQL)) {
				pstmt.setString(1, user.getUsername());
				pstmt.setString(2, user.getPassword());
				pstmt.setString(3, user.getEmail());
				rowCount = pstmt.executeUpdate();
				
				conn.commit(); // 트랜잭션 끝
			} catch (Exception e) {
				conn.rollback(); // 오류 발생 시 롤백
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rowCount;
	} // end of  addUser(User user)

	@Override
	public void delete(int id) {
		
		try(Connection conn = DBUtil.getConnection()) {
			conn.setAutoCommit(false); // 트랜잭션 시작
			try(PreparedStatement pstmt = conn.prepareStatement(DELETE_USER_SQL)) {
				pstmt.setInt(1, id);
				pstmt.executeUpdate();
				conn.commit(); // 트랜잭션 끝
			} catch (Exception e) {
				conn.rollback(); // 오류 발생 시 롤백
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	} // end of delete(int id)

	@Override
	public User getUserByusername(String username) {
		User user = null;
		
		try(Connection conn = DBUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(SELECT_USER_BY_USERNAME)) {
			
			pstmt.setString(1, username); // username : 파라미터 타입 이라고 한다.
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				user = User.builder()
						.id(rs.getInt("id"))
						.username(rs.getString("username"))
						.password(rs.getString("password"))
						.email(rs.getString("email"))
						.createdAt(rs.getTimestamp("created_at"))
						.build();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return user;
	} // end of getUserByusername(String username)

	@Override
	public User getUserByusernameAndPassword(String username, String password) {
		
		User user = null;
		
		try(Connection conn = DBUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(SELECT_USER_BY_USERNAME_AND_PASSWORD)) {
			
			pstmt.setString(1, username); // username : 파라미터 타입 이라고 한다.
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				user = User.builder()
						.id(rs.getInt("id"))
						.username(rs.getString("username"))
						.password(rs.getString("password"))
						.email(rs.getString("email"))
						.createdAt(rs.getTimestamp("created_at"))
						.build();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return user;
	} // end of getUserByusernameAndPassword(String username, String password)

	@Override
	public List<User> getAllUsers() {
		List<User> userList = new ArrayList<User>();
		
		try(Connection conn = DBUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(SELECT_ALL_USERS)) {
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				User user = User.builder()
						.id(rs.getInt("id"))
						.username(rs.getString("username"))
						.password(rs.getString("password"))
						.email(rs.getString("email"))
						.createdAt(rs.getTimestamp("created_at"))
						.build();
				userList.add(user);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return userList;
	} // end of getAllUsers()
	
} // end of UserRepositoryImpl
