package com.tenco.model;

import java.util.List;

public interface UserDAO {
	
	// 유저 추가 기능
	UserDTO addUser(UserDTO userDTO);
	// insert into todos(user_id, title, description, due_date, completed) values(?, ?, ?, ?, ?)
	
	// 유저 아이디 검색
	UserDTO getUserById(int id);
	// select * from todos where id = ?
	
	// 유저 이름 검색
	UserDTO getUserByUsername(String username);
	// select * from todos where username = ?
	
	// 유저 리스트 전체 검색
	List<UserDTO> getAllUsers();
	// select * from users;
	
	// 유저 정보 업데이트
	UserDTO getUserUpdate(UserDTO userDTO, int printcipalId);
	// update users set password = ?, email = ? where id = ?
	
	// 유저 정보 삭제
	UserDTO getUserDelete(UserDTO userDTO);
	// delete from users where id = ? 
	
}
