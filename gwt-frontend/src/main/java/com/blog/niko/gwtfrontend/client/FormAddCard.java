package com.blog.niko.gwtfrontend.client;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.blog.niko.gwtfrontend.domain.Card;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class FormAddCard extends Composite {

	private static FromAddCardUiBinder uiBinder = GWT.create(FromAddCardUiBinder.class);

	@UiTemplate("FormAddCard.ui.xml")
	interface FromAddCardUiBinder extends UiBinder<Widget, FormAddCard> {
	}

	public FormAddCard() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiField
	TextBox titleBox;

	@UiField
	TextBox imgBox;

	@UiField
	TextArea contentBox;

	@UiField
	TextBox buttonTextBox;

	@UiField
	TextBox buttonLinkBox;

	@UiHandler("buttonSubmit")
	void onClick(ClickEvent e) {

		Card card = new Card(imgBox.getValue(), titleBox.getValue(), contentBox.getValue(), buttonTextBox.getValue(),
				buttonLinkBox.getValue());

		addCard(card);

	}

	private CardServiceAsync cardSvc = GWT.create(CardService.class);
	private static Logger rootLogger = Logger.getLogger("");

	private void addCard(Card card) {
		if (cardSvc == null) {
			cardSvc = GWT.create(CardService.class);
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

		cardSvc.addCard(card, callback);

	}

}