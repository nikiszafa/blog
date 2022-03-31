package com.niko.blog.restserver.dao;

import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;

import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import com.niko.blog.restserver.domain.Post;

@Stateful
public class PostDaoBean implements PostDao{

	@PersistenceContext(unitName = "primary", type = PersistenceContextType.EXTENDED)
	private EntityManager entityManager;

	public void addPost(Post post) {

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

}
