package com.blog.niko.restserver.dao;

import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import com.blog.niko.restserver.domain.Card;

@Stateful
public class CardDaoBean implements CardDao{

	
	@PersistenceContext(unitName = "primary", type = PersistenceContextType.EXTENDED)
	private EntityManager entityManager;

	public void addCard(Card card) {

		entityManager.persist(card);

	}
	
	public void deleteCard(int cardId) {

		Card card = entityManager.find(Card.class, cardId);
		entityManager.remove(card);

	}
	
	public List<Card> getCards() {
		return entityManager.createQuery("from Card").getResultList();

	}
}
