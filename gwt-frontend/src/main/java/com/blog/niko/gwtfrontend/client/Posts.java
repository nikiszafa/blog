package com.blog.niko.gwtfrontend.client;

import com.blog.niko.gwtfrontend.domain.Post;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Image;
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
		table.setText(0, 4, "Image");

		table.getColumnFormatter().setWidth(0, "10%");
		table.getColumnFormatter().setWidth(1, "10%");
		table.getColumnFormatter().setWidth(2, "10%");
		table.getColumnFormatter().setWidth(3, "35%");
		table.getColumnFormatter().setWidth(4, "35%");

		table.getRowFormatter().addStyleName(0, "tableHeader");
		table.getRowFormatter().addStyleName(1, "tableHeader");

		table.insertRow(1);

	}

	public void insertPost(Post post) {
		
		Image img = new Image(post.getPostImg());
		img.setSize("50%", "50%");	

		int row = table.getRowCount();
		table.setText(row, 0, post.getPostTitle());
		table.setText(row, 1, post.getAuthor());
		table.setText(row, 2, post.getPublishDate().toString());
		table.setText(row, 3, post.getPostContent());
		table.setWidget(row, 4, img);
		
		table.getRowFormatter().addStyleName(row, "tableContent");
		
		if(row%2==0) {
			table.getRowFormatter().addStyleName(row, "tableContentEven");
		}
	}

}
