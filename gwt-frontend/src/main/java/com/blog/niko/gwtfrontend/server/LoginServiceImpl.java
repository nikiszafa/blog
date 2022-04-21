package com.blog.niko.gwtfrontend.server;

import java.util.logging.Logger;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.blog.niko.gwtfrontend.beans.LoginBean;
import com.blog.niko.gwtfrontend.client.LoginService;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class LoginServiceImpl extends RemoteServiceServlet implements LoginService {


	private static final long serialVersionUID = 1L;

	@Inject
	LoginBean loginBean;

	private static Logger rootLogger = Logger.getLogger("");

	@Override
	public boolean isValidUser(String login, String password) {

		if (loginBean.validateUser(login, password)) {
			HttpServletRequest httpServletRequest = this.getThreadLocalRequest();
			HttpSession session = httpServletRequest.getSession(true);
			session.setAttribute("login", login);

			return true;
		} else {
			return false;
		}

	}

}
