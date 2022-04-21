package com.blog.niko.gwtfrontend.beans;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import com.blog.niko.gwtfrontend.restclient.LoginRestServiceImpl;

@RequestScoped
public class LoginBean {

	@Inject
	private LoginRestServiceImpl loginRestService;

	public boolean validateUser(String username, String password) {
		return Boolean.parseBoolean(loginRestService.validateUser(username, password));

	}

}
