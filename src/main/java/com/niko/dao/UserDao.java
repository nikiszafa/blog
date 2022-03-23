package com.niko.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import com.niko.beans.User;

@Stateless
public class UserDao {

	@PersistenceContext
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("primary");
	EntityManager entityManager = entityManagerFactory.createEntityManager();

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
	
	

}
