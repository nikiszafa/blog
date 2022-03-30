package com.niko.rest;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.niko.beans.Post;
import com.niko.dao.PostDao;
import com.niko.dao.UserDao;

@Path("/posts")
public class PostResource {

	@EJB
	PostDao postDao;
	
	WeatherService weatherService;

	@GET
	@Path("/ping")
	public Response ping() {		
		weatherService.getWeather();
		return Response.ok().entity("Service online").build();
	}
	
	@GET
	@Path("/getposts")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPosts() {
		return Response.ok(postDao.getPosts()).build();
	}
	
	@GET
	@Path("/getpost/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPost(@PathParam("id") int id) {
		return Response.ok(postDao.getPost(id)).build();
	}
	
	@POST
	@Path("/addpost")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createPost(Post post) {
		postDao.addPost(post);	
		return Response.ok(post).build();

	}
	
	@DELETE
	@Path("/deletepost/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deletePost(@PathParam("id") int id) {
		Post post = postDao.getPost(id);
		postDao.deletePost(id);
		return Response.ok(post).build();
	}
	
	

}
