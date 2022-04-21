package com.blog.niko.gwtfrontend.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Widget;

public class AdminPanel extends Composite {

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
		table.getRowFormatter().addStyleName(1, "tableHeader");
		
		table.insertRow(1);

	}

}
