package com.blog.niko.gwtfrontend.restclient;

import java.util.List;

import com.blog.niko.gwtfrontend.domain.Card;


public interface CardRestService {
	
	void addCard(Card card);

	void deleteCard(int cardId);

	List<Card> getCards();

	Card getCard(int cardId);
}
