package com.blog.niko.restserver.rest;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import com.blog.niko.restserver.dao.UserDao;

@Stateless
@Path("/users")
public class UserResource {
	
	@EJB
	private UserDao userDao;


}
