package com.blog.niko.restclient;

import java.util.List;

import com.blog.niko.domain.Card;

public interface CardService {
	
	void addCard(Card card);

	void deleteCard(int cardId);

	List<Card> getCards();

	Card getCard(int cardId);
}
