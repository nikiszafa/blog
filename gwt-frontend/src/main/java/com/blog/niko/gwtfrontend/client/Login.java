package com.blog.niko.gwtfrontend.client;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class Login extends Composite {

	private static LoginUiBinder uiBinder = GWT.create(LoginUiBinder.class);

	@UiTemplate("Login.ui.xml")
	interface LoginUiBinder extends UiBinder<Widget, Login> {
	}

	public Login() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiField
	TextBox loginBox;

	@UiField
	TextBox passwordBox;

	@UiField
	Label completionLabel1;

	@UiField
	Label completionLabel2;

	@UiHandler("buttonSubmit")
	void doClickSubmit(ClickEvent event) {
		validateUser(loginBox.getValue(), passwordBox.getValue());
		loginBox.setValue("");
		passwordBox.setValue("");

	}

	@UiHandler("passwordBox")
	void handlePasswordChange(ValueChangeEvent<String> event) {

	}

	String getLogin() {
		return loginBox.getValue();
	}

	String getPassword() {
		return passwordBox.getValue();
	}

	// TODO
	// To nie moze tutaj raczej byc:

	private LoginServiceAsync loginSvc = GWT.create(LoginService.class);
	private static Logger rootLogger = Logger.getLogger("");

	private void validateUser(String login, String password) {
		if (loginSvc == null) {
			loginSvc = GWT.create(LoginService.class);
		}

		AsyncCallback<Boolean> callback = new AsyncCallback<Boolean>() {

			@Override
			public void onFailure(Throwable caught) {
				rootLogger.log(Level.SEVERE, "Login " + caught);

			}

			@Override
			public void onSuccess(Boolean result) {
				if (result) {
					Window.alert("LOGIN success");
					MainModule mainModule = new MainModule();
					
				} else {
					Window.alert("INVALID CREDENTIALS");
				}

			}
		};

		loginSvc.isValidUser(login, password, callback);

	}

}
