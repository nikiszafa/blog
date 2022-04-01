package com.blog.niko.beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import com.blog.niko.domain.Post;
import com.blog.niko.restclient.PostServiceImpl;

@RequestScoped
public class PostBean {

	@Inject
	private PostServiceImpl postService;

	private List<Post> posts;

	@PostConstruct
	public void initialize() {
		posts = postService.getPosts();
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void addPost(Post post) {
		postService.addPost(post);
	}
	
	public void deletePost(int postId) {
		postService.deletePost(postId);
	}
}
