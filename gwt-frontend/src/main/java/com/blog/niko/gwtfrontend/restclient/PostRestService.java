package com.blog.niko.gwtfrontend.restclient;

import java.util.List;

import com.blog.niko.gwtfrontend.domain.Post;


public interface PostRestService {
	
	void addPost(Post post);
	void deletePost(int postId);
	List<Post> getPosts();
	Post getPost(int postId);
	void updatePost(Post post, int id);
	

}
