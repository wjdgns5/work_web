package com.tenco.tboard.repository.interfaces;

import java.util.List;

import com.tenco.tboard.model.User;

public interface UserRepository {
	
	public abstract int addUser(User user);
	public abstract void deleteUser(int id);
	public abstract User getUserByusername(String username);
	public abstract User getUserByusernameAndPassword(String username, String password);
	public abstract List<User> getAllUsers();
}
