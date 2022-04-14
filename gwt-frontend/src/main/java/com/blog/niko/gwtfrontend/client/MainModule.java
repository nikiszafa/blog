package com.blog.niko.gwtfrontend.client;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.RootPanel;

public class MainModule implements EntryPoint {

	private static Logger rootLogger = Logger.getLogger("");

	private PostServiceAsync postSvc = GWT.create(PostService.class);

	public void onModuleLoad() {
		rootLogger.log(Level.SEVERE, "IN LOAD MODULE: ");

		Posts home = new Posts();
		refreshTable();
		rootLogger.log(Level.SEVERE, "IN REFRESH TAB: ");
		home.insertPost("Test", "NIKO", "dzisiaj",
				"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed odio lacus, sollicitudin in dolor at, consequat volutpat ante. Integer quis consequat turpis, quis porta orci. Proin tincidunt volutpat faucibus. Suspendisse ac nisl purus suspendisse eleifend interdum orci non pharetra.");

		RootPanel.get("gwtContainer").add(home);

	}

	private void refreshTable() {
		if (postSvc == null) {
			postSvc = GWT.create(PostService.class);
		}

		rootLogger.log(Level.SEVERE, "IN REFRESH TAB: ");

		AsyncCallback<List<Post>> callback = new AsyncCallback<List<Post>>() {

			@Override
			public void onFailure(Throwable caught) {
				rootLogger.log(Level.SEVERE, "ERROR ASYNC: " + caught.getMessage());
				rootLogger.log(Level.SEVERE, "ERROR ASYNC2: ", caught);

			}

			@Override
			public void onSuccess(List<Post> result) {
				rootLogger.log(Level.SEVERE, "ASYNC SUCCESS");
				rootLogger.log(Level.SEVERE, result.get(0).getAuthor());

			}
		};

		postSvc.getPosts(callback);

	}
}
