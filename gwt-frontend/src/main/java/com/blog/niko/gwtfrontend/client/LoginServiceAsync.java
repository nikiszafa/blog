package com.blog.niko.gwtfrontend.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface LoginServiceAsync {

	void isValidUser(String login, String password, AsyncCallback<Boolean> callback);

}
