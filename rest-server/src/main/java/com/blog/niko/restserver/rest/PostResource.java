package com.blog.niko.restserver.rest;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.blog.niko.restserver.dao.PostDao;
import com.blog.niko.restserver.dao.exceptions.IDNotFoundException;
import com.blog.niko.restserver.domain.Post;

@Stateless
@Path("/posts")
public class PostResource {

	@EJB
	PostDao postDao;

	@GET
	@Path("/ping")
	public Response ping() {
		return Response.ok().entity("Service online").build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllPosts() {
		return Response.ok(postDao.getPosts()).build();
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addPost(final Post post) {
		postDao.addPost(post);
		return Response.ok(post).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id:[0-9]+}")
	public Response getPostById(final @PathParam("id") int id) throws IDNotFoundException {

		Post post = postDao.getPost(id);

		if (post != null) {
			return Response.ok(post).build();
		}

		throw new IDNotFoundException();

	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("{id:[0-9]+}")
	public Response updatePost(final @PathParam("id") int postId, Post post) {
		postDao.updatePost(post, postId);
		return Response.ok(post).build();

	}

}
