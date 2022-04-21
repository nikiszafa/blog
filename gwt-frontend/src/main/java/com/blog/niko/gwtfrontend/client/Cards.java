package com.blog.niko.gwtfrontend.client;

import com.blog.niko.gwtfrontend.domain.Card;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Widget;

public class Cards extends Composite {

	interface CardsUiBinder extends UiBinder<Widget, Cards> {
	}

	private static CardsUiBinder uiBinder = GWT.create(CardsUiBinder.class);

	@UiField(provided = true)
	FlexTable table;

	public Cards() {
		setupTable();
		initWidget(uiBinder.createAndBindUi(this));
	}

	private void setupTable() {
		table = new FlexTable();

		table.setText(0, 0, "Title");
		table.setText(0, 1, "Content");
		table.setText(0, 2, "Button");
		table.setText(0, 3, "Image");

		table.getColumnFormatter().setWidth(0, "10%");
		table.getColumnFormatter().setWidth(1, "40%");
		table.getColumnFormatter().setWidth(2, "10%");
		table.getColumnFormatter().setWidth(3, "40%");

		table.getRowFormatter().addStyleName(0, "tableHeader");
		table.getRowFormatter().addStyleName(1, "tableHeader");

		table.insertRow(1);

	}

	public void insertCard(Card card) {

		Image img = new Image(card.getImgPath());
		img.setSize("50%", "50%");

		Button btn = new Button();

		int row = table.getRowCount();
		table.setText(row, 0, card.getTitle());
		table.setText(row, 1, card.getContent());
		table.setWidget(row, 2, btn);
		table.setWidget(row, 3, img);

		table.getRowFormatter().addStyleName(row, "tableContent");

		if (row % 2 == 0) {
			table.getRowFormatter().addStyleName(row, "tableContentEven");
		}

	}
}