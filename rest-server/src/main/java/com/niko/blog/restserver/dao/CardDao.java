package com.niko.blog.restserver.dao;

import java.util.List;

import com.niko.blog.restserver.domain.Card;

public interface CardDao {
	
	void addCard(Card card);
	
	void deleteCard(int cardId);
	
	List<Card> getCards();

}
