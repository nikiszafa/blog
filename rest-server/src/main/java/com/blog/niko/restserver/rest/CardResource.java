package com.blog.niko.restserver.rest;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import com.blog.niko.restserver.dao.CardDao;
import com.blog.niko.restserver.domain.Card;

@Stateless
@Path("/cards")
public class CardResource {

	@EJB
	private CardDao cardDao;
	
	@GET
	@Path("/ping")
	public Response ping() {		
		return Response.ok().entity("Service online").build();
	}

	@GET
	public Response getAllCards() {

		return Response.ok(cardDao.getCards()).build();

	}

	@POST
	public Response addCard(final Card card) {
		cardDao.addCard(card);
		return Response.ok(card).build();
	}

}