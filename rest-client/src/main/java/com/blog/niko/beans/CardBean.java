package com.blog.niko.beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import com.blog.niko.domain.Card;
import com.blog.niko.restclient.CardServiceImpl;


@RequestScoped
public class CardBean {
	
	@Inject
	private CardServiceImpl cardService;
	
	private List<Card> cards;
	
	@PostConstruct
	public void initialize() {
		cards = cardService.getCards();
	}
	
	public List<Card> getCards(){
		return cards;
	}
	
	public void addCard(Card card) {
		cardService.addCard(card);
	}
	
	public void deleteCard(int cardId) {
		cardService.deleteCard(cardId);
	}
	

	
	
	
}
