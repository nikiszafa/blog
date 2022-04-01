package com.blog.niko.restserver.dao.exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class IDExceptionNotFoundManager implements ExceptionMapper<IDNotFoundException>{
	
	@Override
	public Response toResponse(IDNotFoundException exception) {
		return Response.status(Response.Status.NO_CONTENT).build();
	}

}
