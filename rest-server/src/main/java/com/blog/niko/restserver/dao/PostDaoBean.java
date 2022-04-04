package com.blog.niko.restserver.dao;

import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;

import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;


import com.blog.niko.restserver.domain.Post;

@Stateful
public class PostDaoBean implements PostDao{

	@PersistenceContext(unitName = "primary", type = PersistenceContextType.EXTENDED)
	private EntityManager entityManager;

	public void addPost(Post post) {
		System.out.println("EM POST");
		entityManager.persist(post);

	}

	public void deletePost(int postId) {

		Post post = entityManager.find(Post.class, postId);
		entityManager.remove(post);

	}

	public List<Post> getPosts() {
		return entityManager.createQuery("from Post order by postId desc").getResultList();
	}

	public Post getPost(int postId) {
		return entityManager.find(Post.class, postId);
	}
	
	public void updatePost(Post post, int postId) {
		Post postOrigin = entityManager.find(Post.class, postId);
		postOrigin.setAuthor(post.getAuthor());
		postOrigin.setPostContent(post.getPostContent());
		postOrigin.setPostImg(post.getPostImg());
		postOrigin.setPostTitle(post.getPostTitle());
		postOrigin.setPublishDate(post.getPublishDate());
		entityManager.merge(postOrigin);
	}

}
