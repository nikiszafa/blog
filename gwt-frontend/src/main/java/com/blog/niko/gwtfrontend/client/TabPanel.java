package com.blog.niko.gwtfrontend.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class TabPanel extends Composite {

	private Login login = new Login();
	private AdminPanel admin = new AdminPanel();

	private static TabPanelUiBinder uiBinder = GWT.create(TabPanelUiBinder.class);

	interface TabPanelUiBinder extends UiBinder<Widget, TabPanel> {
	}

	public TabPanel() {
		initWidget(uiBinder.createAndBindUi(this));
		loginPanel.add(login);
		adminPanel.add(admin);
	}

	@UiField
	VerticalPanel blogPanel;

	@UiField
	VerticalPanel aboutPanel;

	@UiField
	VerticalPanel loginPanel;

	@UiField
	VerticalPanel adminPanel;

}
