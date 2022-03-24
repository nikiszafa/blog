package com.niko.dao;

import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import com.niko.beans.Card;

//Czy to jest odpowiedni rodzaj???
@Stateful
public class CardDao {

	@PersistenceContext(unitName = "primary", type = PersistenceContextType.EXTENDED)
	private EntityManager entityManager;

	// Dlaczego tak nie dziala???
//	@EJB
//	EntityManagerProvider entityManagerProvider;
//
//	EntityManager entityManager = entityManagerProvider.getEntityManager();

	public void addCard(Card card) {

		entityManager.persist(card);

//		try {
//			entityManager.getTransaction().begin();
//			entityManager.persist(card);
//			entityManager.getTransaction().commit();
//		} catch (Exception e) {
//			entityManager.getTransaction().rollback();
//		}
	}

	public void deleteCard(int cardId) {

		Card card = entityManager.find(Card.class, cardId);
		entityManager.remove(card);

		// Dlaczego to nie dziala????
//		try {
//			entityManager.getTransaction().begin();
//			Card card = entityManager.find(Card.class, cardId);
//			entityManager.remove(card);
//			entityManager.getTransaction().commit();
//		} catch (Exception e) {
//			entityManager.getTransaction().rollback();
//		}
	}

	public List<Card> getCards() {
		return entityManager.createQuery("from Card").getResultList();

	}
}
