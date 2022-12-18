package com.masai.Service;

import com.masai.exception.UserException;
import com.masai.model.User;

public interface UserService {

	public User addUser(User user)throws UserException;
	
}
