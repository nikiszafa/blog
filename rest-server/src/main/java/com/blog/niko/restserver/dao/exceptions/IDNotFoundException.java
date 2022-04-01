package com.blog.niko.restserver.dao.exceptions;


public class IDNotFoundException extends Exception {

	private String message;

	public IDNotFoundException() {
		this.message = "ID not found";
	}

	public IDNotFoundException(String message) {
		this.message = message;
	}

}
