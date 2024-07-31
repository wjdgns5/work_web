package com.tenco.Repo.interfaces.user;

import com.tenco.model.user.UserDTO;

public interface UserRepository {

	UserDTO userLogin(int id, String password);
	
}
