package com.blog.niko.gwtfrontend.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("loginService")
public interface LoginService extends RemoteService{
	
	boolean isValidUser(String login, String password);
	
	
	
	

}
