package com.blog.niko.gwtfrontend.events;

import com.google.gwt.event.shared.GwtEvent;

public class ValidateEvent extends GwtEvent<ValidateEventHandler> {
	public static final Type<ValidateEventHandler> TYPE = new Type<ValidateEventHandler>();

	private String login;
	private String password;

	public ValidateEvent(String login, String password) {
		this.login = login;
		this.password = password;
	}

	public String getLogin() {
		return login;
	}

	public String getPassword() {
		return password;
	}

	@Override
	public Type<ValidateEventHandler> getAssociatedType() {

		return TYPE;
	}

	@Override
	protected void dispatch(ValidateEventHandler handler) {
		handler.onValidate(this);

	}

}
