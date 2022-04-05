package com.blog.niko.restclient;

import java.util.List;

import com.blog.niko.domain.GalleryImage;

public interface GalleryImageService {
	
	public void addGalleryImage(GalleryImage galleryImage);
	
	public List<GalleryImage> getGalleryImages();
	
	public void deleteGalleryImage(int galleryImageId);

}
