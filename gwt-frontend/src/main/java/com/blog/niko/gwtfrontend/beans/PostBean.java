package com.blog.niko.gwtfrontend.beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import com.blog.niko.gwtfrontend.domain.Post;
import com.blog.niko.gwtfrontend.restclient.PostRestServiceImpl;

@RequestScoped
public class PostBean {

	@Inject
	private PostRestServiceImpl postRestService;

	private List<Post> posts;

	@PostConstruct
	public void initialize() {
		posts = postRestService.getPosts();
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void addPost(Post post) {
		postRestService.addPost(post);
	}
	
	public void deletePost(int postId) {
		postRestService.deletePost(postId);
	}
}
