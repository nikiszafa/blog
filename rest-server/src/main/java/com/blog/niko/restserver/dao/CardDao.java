package com.blog.niko.restserver.dao;

import java.util.List;

import com.blog.niko.restserver.domain.Card;

public interface CardDao {
	
	void addCard(Card card);
	
	void deleteCard(int cardId);
	
	List<Card> getCards();

}
