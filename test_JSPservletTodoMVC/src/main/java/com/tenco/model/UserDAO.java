package com.tenco.model;

import java.util.List;

public interface UserDAO {
	
	public abstract int addUser(UserDTO userDTO); // 유저 추가
	
	 UserDTO getUserById(int id); // 사용자 id로 조회
	
	public abstract UserDTO getUserByUsername(String username);
	
	public abstract List<UserDTO> getAllUsers();
	
	public abstract int updateUser(UserDTO user, int printcipalId);
	
	public abstract int deleteUser(int id);
}
