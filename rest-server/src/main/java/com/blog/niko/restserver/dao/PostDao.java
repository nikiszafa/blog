package com.blog.niko.restserver.dao;

import java.util.List;

import com.blog.niko.restserver.domain.Post;

public interface PostDao {
	
	void addPost(Post post);
	void deletePost(int postId);
	List<Post> getPosts();
	Post getPost(int postId);
	void updatePost(Post post, int id);
	

}
