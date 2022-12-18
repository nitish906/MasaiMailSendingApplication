package com.masai.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Repository.UserDao;
import com.masai.exception.UserException;
import com.masai.model.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	
	
	@Override
	public User addUser(User user) throws UserException {
		
		User user3 = userDao.findByEmail_id(user.getEmail_id());
		
		if(user3!= null) {
		throw new UserException("Already present with this email");
		}
		User user2 = userDao.save(user);
		return user2;
	}

	
	
}
