package com.blog.niko.restclient;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.blog.niko.domain.GalleryImage;

@ApplicationScoped
public class GalleryImageServiceImpl implements GalleryImageService {

	private static final String API_URL = "http://localhost:8080/application";
	private static final String GALLERY_ENDPOINT = API_URL + "/api/galleryimages";

	private Client client;

	private List<GalleryImage> galleryImages = new ArrayList<GalleryImage>();

	@PostConstruct
	public void initialise() {
		client = ClientBuilder.newClient();
	}

	@Override
	public void addGalleryImage(GalleryImage galleryImage) {
		WebTarget target = client.target(GALLERY_ENDPOINT);
		target.request(MediaType.APPLICATION_JSON).post(Entity.json(galleryImage));
	}

	@Override
	public List<GalleryImage> getGalleryImages() {
		WebTarget target = client.target(GALLERY_ENDPOINT);
		Response response = target.request(MediaType.APPLICATION_JSON).get();
		galleryImages = response.readEntity(new GenericType<ArrayList<GalleryImage>>() {
		});
		return galleryImages;
	}

	@Override
	public void deleteGalleryImage(int galleryImageId) {
		WebTarget target = client.target("http://localhost:8080/application/api/galleryimages/{id}").resolveTemplate("id", galleryImageId);
		target.request(MediaType.APPLICATION_JSON).post(Entity.json(""));
		
	}

}
