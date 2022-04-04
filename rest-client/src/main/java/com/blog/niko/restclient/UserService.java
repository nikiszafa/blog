package com.blog.niko.restclient;

import com.blog.niko.domain.User;

public interface UserService {

	String validateUser(String username, String password);

	public User getProfileDetails(String username);

}
