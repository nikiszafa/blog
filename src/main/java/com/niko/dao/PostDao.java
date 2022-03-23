package com.niko.dao;

import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;

import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import com.niko.beans.Post;

@Stateful
public class PostDao {

	@PersistenceContext(unitName = "primary", type = PersistenceContextType.EXTENDED)
	private EntityManager entityManager;

	public void addPost(Post post) {

		
		//Dlaczego to nie dziala????
//		try {
//			entityManager.getTransaction().begin();
			entityManager.persist(post);
//			entityManager.getTransaction().commit();
//		} catch (Exception e) {
//			entityManager.getTransaction().rollback();
//		}

	}
	
	public void deletePost(int postId) {
		
		//Dlaczego to nie dziala????
//		try {
//			entityManager.getTransaction().begin();
			Post post = entityManager.find(Post.class, postId);
			entityManager.remove(post);
//			entityManager.getTransaction().commit();
//		} catch (Exception e) {
//			entityManager.getTransaction().rollback();
//		}
	}
	
	public List<Post> getPosts() {
		return entityManager.createQuery("from Post order by postId desc").getResultList();
	}

}
