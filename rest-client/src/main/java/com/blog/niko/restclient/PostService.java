package com.blog.niko.restclient;

import java.util.List;

import com.blog.niko.domain.Post;

public interface PostService {
	
	void addPost(Post post);
	void deletePost(int postId);
	List<Post> getPosts();
	Post getPost(int postId);
	void updatePost(Post post, int id);
	

}
