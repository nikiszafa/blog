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

import com.blog.niko.restserver.dao.GalleryImageDao;
import com.blog.niko.restserver.domain.GalleryImage;

@Stateless
@Path("galleryimages")
public class GalleryImageResource {

	@EJB
	GalleryImageDao galleryImageDao;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getGalleryImages() {
		return Response.ok(galleryImageDao.getGalleryImages()).build();
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addGalleryImage(final GalleryImage galleryImage) {
		galleryImageDao.addGalleryImage(galleryImage);
		return Response.ok(galleryImage).build();
	}

	@POST
	@Path("{id:[0-9]+}")
	public Response deleteGalleryImage(final @PathParam("id") int id) {
		galleryImageDao.deleteGalleryImage(id);
		return Response.ok().build();
	}

}
