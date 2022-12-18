package com.masai.Service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Dto.UserLoginDTO;
import com.masai.Repository.UserDao;
import com.masai.Repository.UserSessionDao;
import com.masai.exception.LoginException;
import com.masai.model.CurrentUserSession;
import com.masai.model.User;

import net.bytebuddy.utility.RandomString;

@Service
public class UserLoginServiceImpl implements UserLoginService {
	@Autowired
	private UserSessionDao userSessionDao;

	@Autowired
	private UserDao userDao;

	@Override
	public CurrentUserSession logIntoUserAccount(UserLoginDTO dto) throws LoginException {
		User existingUser = userDao.findByMobilenumber(dto.getMobileNumber());

		if (existingUser == null)
			throw new LoginException("Please Enter a valid mobile number");

		CurrentUserSession validUserSessionOpt = userSessionDao.findByEmail(existingUser.getEmail_id());

		if (validUserSessionOpt!=null) {

			throw new LoginException("User already Logged In with this number");
		}

		if (existingUser.getPassword().equals(dto.getPassword())) {

			String key = RandomString.make(6);

			CurrentUserSession currentUserSession = new CurrentUserSession(existingUser.getEmail_id(), key,
					LocalDateTime.now());

			userSessionDao.save(currentUserSession);

			return currentUserSession;
		} else
			throw new LoginException("Please Enter a valid password!");
	}

	@Override
	public String logOutFromUserAccount(String key) throws LoginException {
CurrentUserSession validUserSession = userSessionDao.findByUuid(key);
		
		if(validUserSession == null) {
			throw new LoginException("User Not Logged In with this number");
			
		}
		
		userSessionDao.delete(validUserSession);
		
		return "User Logged Out !";
	}

}
