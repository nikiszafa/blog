package com.blog.niko.gwtfrontend.server;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.inject.Inject;

import com.blog.niko.gwtfrontend.beans.CardBean;
import com.blog.niko.gwtfrontend.client.CardService;
import com.blog.niko.gwtfrontend.domain.Card;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class CardServiceImpl extends RemoteServiceServlet implements CardService {

	@Inject
	CardBean cardBean;

	private static Logger rootLogger = Logger.getLogger("");

	private static final long serialVersionUID = 1L;

	private List<Card> cards = new ArrayList<Card>();

	@Override
	public List<Card> getCards() {
		rootLogger.log(Level.SEVERE, "IN GET POSTS: ");

		cards = cardBean.getCards();

		return cards;
	}

	@Override
	public Boolean addCard(Card card) {
		cardBean.addCard(card);
		return true;
	}

	@Override
	public Boolean deleteCard(int id) {
		cardBean.deleteCard(id);
		return true;
	}

}
