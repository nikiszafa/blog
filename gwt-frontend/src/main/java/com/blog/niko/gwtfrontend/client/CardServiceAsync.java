package com.blog.niko.gwtfrontend.client;

import java.util.List;

import com.blog.niko.gwtfrontend.domain.Card;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface CardServiceAsync {

	void getCards(AsyncCallback<List<Card>> callback);

	void deleteCard(int id, AsyncCallback<Boolean> callback);

	void addCard(Card card, AsyncCallback<Boolean> callback);

}
