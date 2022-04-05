package com.blog.niko.beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import com.blog.niko.domain.GalleryImage;
import com.blog.niko.restclient.GalleryImageServiceImpl;

@RequestScoped
public class GalleryImageBean {

	@Inject
	private GalleryImageServiceImpl galleryImageService;

	private List<GalleryImage> galleryImages;

	@PostConstruct
	public void initialize() {
		galleryImages = galleryImageService.getGalleryImages();
	}

	public List<GalleryImage> getGalleryImages() {
		return galleryImages;
	}

	public void addGalleryImage(GalleryImage galleryImage) {
		galleryImageService.addGalleryImage(galleryImage);
	}

	public void deleteGalleryImage(int imageId) {
		galleryImageService.deleteGalleryImage(imageId);
	}
}
