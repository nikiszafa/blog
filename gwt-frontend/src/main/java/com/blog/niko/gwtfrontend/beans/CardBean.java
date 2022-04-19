package com.blog.niko.gwtfrontend.beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import com.blog.niko.gwtfrontend.domain.Card;
import com.blog.niko.gwtfrontend.restclient.CardRestServiceImpl;

@RequestScoped
public class CardBean {
	
	@Inject
	private CardRestServiceImpl cardService;
	
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
