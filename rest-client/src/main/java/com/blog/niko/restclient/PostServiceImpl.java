package com.blog.niko.restclient;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.blog.niko.domain.Post;

@ApplicationScoped
public class PostServiceImpl implements PostService {

	private static final String API_URL = "http://localhost:8080/application";
	private static final String POSTS_ENDPOINT = API_URL + "/api/posts/";

	private List<Post> posts = new ArrayList<Post>();

	private Client client;

	@PostConstruct
	public void initialise() {
		client = ClientBuilder.newClient();
	}

	@PreDestroy
	public void destroy() {
		client.close();
	}

	@Override
	public void addPost(Post post) {
		WebTarget target = client.target(POSTS_ENDPOINT);
		Response response = target.request(MediaType.APPLICATION_JSON).post(Entity.json("{}"));
		System.out.println(response.readEntity(String.class));
	}

	@Override
	public void deletePost(int postId) {
		WebTarget target = client.target("http://localhost:8080/application/api/posts/{id}").resolveTemplate("id", postId);
		Response response = target.request(MediaType.APPLICATION_JSON).post(Entity.json(""));
		System.out.println("RESPONSE" + response.readEntity(String.class));

	}

	@Override
	public List<Post> getPosts() {
		WebTarget target = client.target(POSTS_ENDPOINT);
		Response response = target.request(MediaType.APPLICATION_JSON).get();
		posts = response.readEntity(new GenericType<ArrayList<Post>>() {
		});
		return posts;

	}

	@Override
	public Post getPost(int postId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updatePost(Post post, int id) {
		// TODO Auto-generated method stub

	}

}
