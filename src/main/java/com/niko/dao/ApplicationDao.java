package com.niko.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import com.niko.beans.Card;
import com.niko.beans.Post;
import com.niko.beans.User;

public class ApplicationDao {

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

	public void addCard(Card card) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(card);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
		}
	}

	public void deleteCard(int cardId) {
		try {
			entityManager.getTransaction().begin();
			Card card = entityManager.find(Card.class, cardId);
			entityManager.remove(card);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
		}
	}

	public boolean validateUser(String username, String password) {
		boolean isValidUser = false;

		javax.persistence.Query query = entityManager.createQuery("from User where username=?1 AND password=?2");
		query.setParameter(1, username);
		query.setParameter(2, password);
		if (!query.getResultList().isEmpty()) {
			isValidUser = true;
		}

		return isValidUser;
	}

	public User getProfileDetails(String username) {
		javax.persistence.Query query = entityManager.createQuery("from User where username=?1");
		query.setParameter(1, username);
		return (User) query.getSingleResult();
	}

	public Post getPost(int postId) {
		return entityManager.find(Post.class, postId);
	}

	public List<Post> getPosts() {
		return entityManager.createQuery("from Post order by postId desc").getResultList();
	}

	public List<Card> getCards() {
		return entityManager.createQuery("from Card").getResultList();
	}

}
