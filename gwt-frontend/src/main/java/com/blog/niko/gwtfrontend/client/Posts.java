package com.blog.niko.gwtfrontend.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Widget;

public class Posts extends Composite {

	interface PostsUiBinder extends UiBinder<Widget, Posts> {
	}

	private static PostsUiBinder uiBinder = GWT.create(PostsUiBinder.class);

	@UiField(provided = true)
	FlexTable table;

	public Posts() {
		setupTable();
		initWidget(uiBinder.createAndBindUi(this));

	}

	private void setupTable() {
		table = new FlexTable();
		table.setText(0, 0, "Title");
		table.setText(0, 1, "Autor");
		table.setText(0, 2, "Date");
		table.setText(0, 3, "Post");

		table.getColumnFormatter().setWidth(0, "10%");
		table.getColumnFormatter().setWidth(1, "10%");
		table.getColumnFormatter().setWidth(2, "10%");
		table.getColumnFormatter().setWidth(3, "70%");

		table.getRowFormatter().addStyleName(0, "tableHeader");
		table.getRowFormatter().addStyleName(1, "tableHeader");

		table.insertRow(1);

	}

	public void insertPost(String Title, String Autor, String date, String Post) {

		int row = table.getRowCount();
		table.setText(row, 0, Title);
		table.setText(row, 1, Autor);
		table.setText(row, 2, date);
		table.setText(row, 3, Post);

	}

}
