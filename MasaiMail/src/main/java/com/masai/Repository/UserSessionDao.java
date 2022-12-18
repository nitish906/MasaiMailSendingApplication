package com.masai.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.CurrentUserSession;

public interface UserSessionDao extends JpaRepository<CurrentUserSession, String> {
	
	
	public CurrentUserSession findByUuid(String uuid);
	
	public CurrentUserSession findByEmail(String email);
}
