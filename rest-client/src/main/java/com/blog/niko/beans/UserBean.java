package com.blog.niko.beans;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import com.blog.niko.restclient.UserServiceImpl;

@RequestScoped
public class UserBean {

	@Inject
	private UserServiceImpl userService;

	public String validateUser(String username, String password) {
		return userService.validateUser(username, password);

	}

}
