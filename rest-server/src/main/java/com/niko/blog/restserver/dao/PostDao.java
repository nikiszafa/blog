package com.niko.blog.restserver.dao;

import java.util.List;

import com.niko.blog.restserver.domain.Post;

public interface PostDao {
	
	void addPost(Post post);
	void deletePost(int postId);
	List<Post> getPosts();
	Post getPost(int postId);
	

}
