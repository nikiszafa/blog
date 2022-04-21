package com.blog.niko.gwtfrontend.client;

import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.blog.niko.gwtfrontend.domain.Post;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.datepicker.client.DatePicker;

public class FormAddPost extends Composite {

	private static FormAddPostUiBinder uiBinder = GWT.create(FormAddPostUiBinder.class);

	@UiTemplate("FormAddPost.ui.xml")
	interface FormAddPostUiBinder extends UiBinder<Widget, FormAddPost> {
	}

	public FormAddPost() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiField
	TextBox titleBox;

	@UiField
	TextBox autorBox;

	@UiField
	TextBox contentBox;

	@UiField
	TextBox imageBox;

	@UiField
	DatePicker dateBox;

	@UiHandler("buttonSubmit")
	void onClick(ClickEvent e) {

		Date date = new Date(dateBox.getValue().getTime());
		Post post = new Post(titleBox.getValue(), contentBox.getValue(), autorBox.getValue(), date,
				imageBox.getValue());

		addPost(post);

	}

	private PostServiceAsync postSvc = GWT.create(PostService.class);
	private static Logger rootLogger = Logger.getLogger("");

	private void addPost(Post post) {
		if (postSvc == null) {
			postSvc = GWT.create(PostService.class);
		}

		AsyncCallback<Boolean> callback = new AsyncCallback<Boolean>() {

			@Override
			public void onFailure(Throwable caught) {
				rootLogger.log(Level.SEVERE, "Error add post " + caught);

			}

			@Override
			public void onSuccess(Boolean result) {
				Window.alert("Post added");

			}

		};

		postSvc.addPost(post, callback);

	}

}
