package com.blog.niko.restserver.rest;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.blog.niko.restserver.dao.UserDao;
import com.blog.niko.restserver.domain.User;

@Stateless
@Path("/users")
public class UserResource {

	@EJB
	private UserDao userDao;

	@GET
	@Path("{login}/{password}")
	public Response validateUser(@PathParam("login") String login, @PathParam("password") String password) {

		boolean isValid = userDao.validateUser(login, password);

		return Response.ok(isValid).build();

	}

	@GET
	@Path("{username}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getProfileDetails(@PathParam("username") String username) {
		User user = userDao.getProfileDetails(username);
		return Response.ok(user).build();

	}

}
