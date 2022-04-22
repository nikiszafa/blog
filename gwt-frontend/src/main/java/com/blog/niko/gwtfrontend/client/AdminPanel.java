package com.blog.niko.gwtfrontend.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasHorizontalAlignment.HorizontalAlignmentConstant;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.Widget;

public class AdminPanel extends Composite {

	private FormAddPost formAddPost = new FormAddPost();
	private FormAddCard formAddCard = new FormAddCard();

	private static AdminPanelUiBinder uiBinder = GWT.create(AdminPanelUiBinder.class);

	interface AdminPanelUiBinder extends UiBinder<Widget, AdminPanel> {
	}

	@UiField(provided = true)
	FlexTable table;

	public AdminPanel() {
		setupTable();
		initWidget(uiBinder.createAndBindUi(this));
	}

	private void setupTable() {

		table = new FlexTable();

		table.setText(0, 0, "Add Post");
		table.setText(0, 1, "Add Card");

		table.getRowFormatter().addStyleName(0, "tableHeader");

		table.setWidget(1, 0, formAddPost);
		table.setWidget(1, 1, formAddCard);

		table.getCellFormatter().setVerticalAlignment(1, 1, HasVerticalAlignment.ALIGN_TOP);
		table.getCellFormatter().setVerticalAlignment(1, 0, HasVerticalAlignment.ALIGN_TOP);

		table.getCellFormatter().setHorizontalAlignment(1, 1, HasHorizontalAlignment.ALIGN_CENTER);
		table.getCellFormatter().setHorizontalAlignment(1, 0, HasHorizontalAlignment.ALIGN_CENTER);

	}

}
