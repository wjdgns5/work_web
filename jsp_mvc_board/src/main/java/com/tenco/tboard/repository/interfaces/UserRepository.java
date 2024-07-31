package com.tenco.tboard.repository.interfaces;

import java.util.List;

import com.tenco.tboard.model.User;

public interface UserRepository {
	
	int addUser(User user);
	void delete(int id);
	User getUserByusername(String username);
	User getUserByusernameAndPassword(String username, String password);
	List<User> getAllUsers();
	
} // end of UserRepository
