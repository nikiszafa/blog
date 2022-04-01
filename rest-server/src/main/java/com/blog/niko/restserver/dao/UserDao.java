package com.blog.niko.restserver.dao;

import com.blog.niko.restserver.domain.User;

public interface UserDao {

	public boolean validateUser(String username, String password);
	
	public User getProfileDetails(String username);
	
	
}
