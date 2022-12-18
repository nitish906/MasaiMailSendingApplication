package com.masai.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.User;


public interface UserDao extends JpaRepository<User, String>{

	public User findByEmail_id(String email_id);
	
	public User findByMobilenumber(String mobilenumber);
}
