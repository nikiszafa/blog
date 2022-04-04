package com.blog.niko.restserver.rest;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.blog.niko.restserver.dao.CardDao;
import com.blog.niko.restserver.dao.exceptions.IDNotFoundException;
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
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllCards() {

		return Response.ok(cardDao.getCards()).build();

	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addCard(final Card card) {
		cardDao.addCard(card);
		return Response.ok(card).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id:[0-9]+}")
	public Response getCardById(final @PathParam("id") int id) throws IDNotFoundException {

		Card card = cardDao.getCard(id);

		if (card != null) {
			return Response.ok(card).build();
		}
		
		throw new IDNotFoundException();

	}
	
	@POST
	@Path("{id}")
	public Response deleteCard(final @PathParam("id") int id) {
		cardDao.deleteCard(id);
		return Response.ok(id).build();
	}

}