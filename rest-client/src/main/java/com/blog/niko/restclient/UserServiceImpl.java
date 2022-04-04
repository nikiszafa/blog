package com.blog.niko.restclient;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.blog.niko.domain.User;

@ApplicationScoped
public class UserServiceImpl implements UserService {

	private static final String API_URL = "http://localhost:8080/application";
	private static final String USERS_ENDPOINT = API_URL + "/api/users/{username}/{password}";

	private Client client;

	@PostConstruct
	public void initialise() {
		client = ClientBuilder.newClient();
	}

	@Override
	public String validateUser(String username, String password) {
		WebTarget target = client.target(USERS_ENDPOINT).resolveTemplate("username", username)
				.resolveTemplate("password", password);
		Response response = target.request(MediaType.APPLICATION_JSON).get();
		String isValid;
		isValid = response.readEntity(String.class);
		return isValid;

	}

	@Override
	public User getProfileDetails(String username) {
		WebTarget target = client.target("http://localhost:8080/application/api/users/{username}")
				.resolveTemplate("username", username);
		Response response = target.request(MediaType.APPLICATION_JSON).get();
		User user = response.readEntity(User.class);
		return user;

	}

}
