package com.blog.niko.restclient;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.blog.niko.domain.Card;

@ApplicationScoped
public class CardServiceImpl implements CardService {

	private static final String API_URL = "http://localhost:8080/application";
	private static final String CARDS_ENDPOINT = API_URL + "/api/cards";

	private Client client;

	private List<Card> cards = new ArrayList<Card>();

	@PostConstruct
	public void initialise() {
		client = ClientBuilder.newClient();
	}

	@Override
	public void addCard(Card card) {
		WebTarget target = client.target(CARDS_ENDPOINT);
		Response response = target.request(MediaType.APPLICATION_JSON).post(Entity.json(card));
		
		

	}

	@Override
	public void deleteCard(int cardId) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Card> getCards() {

		WebTarget target = client.target(CARDS_ENDPOINT);
		Response response = target.request(MediaType.APPLICATION_JSON).get();
		cards = response.readEntity(new GenericType<ArrayList<Card>>() {
		});
		return cards;
	}

	@Override
	public Card getCard(int cardId) {
		// TODO Auto-generated method stub
		return null;
	}

}
