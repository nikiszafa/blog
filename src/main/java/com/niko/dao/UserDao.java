package com.niko.dao;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;

import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import com.niko.beans.User;

//Czy to jest odpowiedni rodzaj???
@Stateful
public class UserDao {

	@PersistenceContext(unitName = "primary", type = PersistenceContextType.EXTENDED)
	private EntityManager entityManager;

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
