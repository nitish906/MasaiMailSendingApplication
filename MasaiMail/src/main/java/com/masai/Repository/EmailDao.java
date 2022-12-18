package com.masai.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.Email;

public interface EmailDao extends JpaRepository<Email, String>{
	

}
