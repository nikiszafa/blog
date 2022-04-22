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
import com.google.gwt.user.client.ui.VerticalPanel;

public class MainModule implements EntryPoint {

	private static Logger rootLogger = Logger.getLogger("");

	private PostServiceAsync postSvc = GWT.create(PostService.class);
	private CardServiceAsync cardSvc = GWT.create(CardService.class);
	
//	private VerticalPanel TabModule = new VerticalPanel();
//	private VerticalPanel mainPanel = new VerticalPanel();
//	private VerticalPanel cardPanel = new VerticalPanel();
//	private VerticalPanel loginPanel = new VerticalPanel();
//	private VerticalPanel adminPanel = new VerticalPanel();
	TabPanel tabPanel = new TabPanel();

	public void onModuleLoad() {

		AppController appController = new AppController();

		tabPanel.setWidth("100%");

//		Login login = new Login();
//		loginPanel.add(login);

//		FormAddPost formAddPost = new FormAddPost();
//		FormAddCard formAddCard = new FormAddCard();
		AdminPanel admin = new AdminPanel();
//		admin.table.setWidget(1, 0, formAddPost);
//		admin.table.setWidget(1, 1, formAddCard);
//
//		adminPanel.add(admin);

//		tabPanel.add(mainPanel, "Blog");
//		tabPanel.add(cardPanel, "About me");
//		tabPanel.add(loginPanel, "Login");
//		tabPanel.add(adminPanel, "Admin");
//		tabPanel.selectTab(0);

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

	private void deletePost(int id) {
		if (postSvc == null) {
			postSvc = GWT.create(PostService.class);
		}

		AsyncCallback<Boolean> callback = new AsyncCallback<Boolean>() {

			@Override
			public void onFailure(Throwable caught) {
				rootLogger.log(Level.SEVERE, "Delete ERROR" + caught);

			}

			@Override
			public void onSuccess(Boolean result) {
				rootLogger.log(Level.SEVERE, "Delete Success" + result);
//				refreshTable();
			}
		};

		postSvc.deletePost(id, callback);

	}

	private void updateTable(List<Post> result) {

		Posts home = new Posts();

		for (Post post : result) {
			home.insertPost(post);
		}

		//mainPanel.add(home);
		tabPanel.blogPanel.add(home);

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

		//cardPanel.add(cards);
		tabPanel.aboutPanel.add(cards);

	}
}
