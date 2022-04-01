package com.blog.niko.restclient;

import java.util.List;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.blog.niko.domain.GalleryImage;

public interface GalleryImageService {
	
	public void addGalleryImage(GalleryImage galleryImage);
	
	public List<GalleryImage> getGalleryImages();
	
	public void deleteGalleryImage(int galleryImageId);

}
