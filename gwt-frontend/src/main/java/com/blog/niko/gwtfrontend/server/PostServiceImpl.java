package com.blog.niko.gwtfrontend.server;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.blog.niko.gwtfrontend.client.Post;
import com.blog.niko.gwtfrontend.client.PostService;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class PostServiceImpl extends RemoteServiceServlet implements PostService {

	private static Logger rootLogger = Logger.getLogger("");

	private static final long serialVersionUID = 1L;

	private static final String API_URL = "http://localhost:8080/application";
	private static final String POSTS_ENDPOINT = API_URL + "/api/posts/";
	private List<Post> posts = new ArrayList<Post>();
	private Client client;

	@Override
	public List<Post> getPosts() {
		rootLogger.log(Level.SEVERE, "IN GET POSTS: ");

//		WebTarget target = client.target(POSTS_ENDPOINT);
//		rootLogger.log(Level.SEVERE, "TARGET REQUEST: ");
//		Response response = target.request(MediaType.APPLICATION_JSON).get();
//		rootLogger.log(Level.SEVERE, "READ ENTITY: ");
//		posts = response.readEntity(new GenericType<ArrayList<Post>>() {
//		});
//		rootLogger.log(Level.SEVERE, "RETURN GET ");

		java.util.Date utilDate = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		Post post = new Post("Test", "Essa", "Niko", sqlDate, "essa");
		rootLogger.log(Level.SEVERE, "IN GET POSTS: ");
		posts.add(post);
		return posts;
	}

}
