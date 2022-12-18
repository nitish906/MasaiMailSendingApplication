package com.masai.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Service.UserService;
import com.masai.exception.UserException;
import com.masai.model.User;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	@PostMapping("/users")
	public ResponseEntity<User> registerUser(@Valid @RequestBody User user) throws UserException {
		
		User savedUser= userService.addUser(user);
		
		return new ResponseEntity<User>(savedUser,HttpStatus.CREATED);
	}
	
	
}
