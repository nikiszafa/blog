package com.niko.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import com.niko.beans.Card;

@Stateless
public class CardDao {
	
	@PersistenceContext
	private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("primary");
	private EntityManager entityManager = entityManagerFactory.createEntityManager();

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
	
	public List<Card> getCards() {
		return entityManager.createQuery("from Card").getResultList();
	}
}
