package com.niko.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import com.niko.beans.Post;

@Stateless
public class PostDao {
	@PersistenceContext
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("primary");
	EntityManager entityManager = entityManagerFactory.createEntityManager();

	public void addPost(Post post) {

		try {
			entityManager.getTransaction().begin();
			entityManager.persist(post);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
		}

	}
	
	public void deletePost(int postId) {
		try {
			entityManager.getTransaction().begin();
			Post post = entityManager.find(Post.class, postId);
			entityManager.remove(post);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
		}
	}
	
	public List<Post> getPosts() {
		return entityManager.createQuery("from Post order by postId desc").getResultList();
	}

}
