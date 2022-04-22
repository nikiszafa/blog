package com.blog.niko.gwtfrontend.client;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.blog.niko.gwtfrontend.events.EventBus;
import com.blog.niko.gwtfrontend.events.ValidateEvent;
import com.blog.niko.gwtfrontend.events.ValidateEventHandler;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class AppController implements ValidateEventHandler {

	private LoginServiceAsync loginSvc = GWT.create(LoginService.class);
	private static Logger rootLogger = Logger.getLogger("");

	public AppController() {
		EventBus.getInstance().addHandler(ValidateEvent.TYPE, this);
	}

	@Override
	public void onValidate(ValidateEvent event) {
		
		rootLogger.log(Level.SEVERE, "IN ON VALIDATE");
		validateUser(event.getLogin(), event.getPassword());

	}

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

				} else {
					Window.alert("INVALID CREDENTIALS");
				}

			}
		};

		loginSvc.isValidUser(login, password, callback);

	}

}
