package com.blog.niko.gwtfrontend.client;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.blog.niko.gwtfrontend.domain.Card;
import com.blog.niko.gwtfrontend.domain.Post;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TabPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class MainModule implements EntryPoint {

	private static Logger rootLogger = Logger.getLogger("");

	private PostServiceAsync postSvc = GWT.create(PostService.class);
	private CardServiceAsync cardSvc = GWT.create(CardService.class);

	private VerticalPanel mainPanel = new VerticalPanel();
	private VerticalPanel cardPanel = new VerticalPanel();

	public void onModuleLoad() {

		TabPanel tabPanel = new TabPanel();

		tabPanel.add(mainPanel, "Blog");
		tabPanel.add(cardPanel, "About me");
		tabPanel.selectTab(0);

		refreshCardTable();
		refreshTable();
		RootPanel.get("gwtContainer").add(tabPanel);

	}

	private void refreshTable() {
		if (postSvc == null) {
			postSvc = GWT.create(PostService.class);
		}

		AsyncCallback<List<Post>> callback = new AsyncCallback<List<Post>>() {

			@Override
			public void onFailure(Throwable caught) {

			}

			@Override
			public void onSuccess(List<Post> result) {
				updateTable(result);

			}
		};

		postSvc.getPosts(callback);

	}

	private void updateTable(List<Post> result) {

		Posts home = new Posts();

		for (Post post : result) {
			home.insertPost(post);
		}

		mainPanel.add(home);

	}

	private void refreshCardTable() {
		if (cardSvc == null) {
			cardSvc = GWT.create(CardService.class);
		}

		AsyncCallback<List<Card>> callback = new AsyncCallback<List<Card>>() {

			@Override
			public void onFailure(Throwable caught) {
				rootLogger.log(Level.SEVERE, "ERROR" + caught);

			}

			@Override
			public void onSuccess(List<Card> result) {
				updateCardTable(result);
				rootLogger.log(Level.SEVERE, "SUCCESS");

			}
		};

		cardSvc.getCards(callback);
	}

	private void updateCardTable(List<Card> result) {

		Cards cards = new Cards();

		for (Card card : result) {
			cards.insertCard(card);
		}

		cardPanel.add(cards);

	}
}
