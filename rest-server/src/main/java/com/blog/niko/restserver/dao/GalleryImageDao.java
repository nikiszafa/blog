package com.blog.niko.restserver.dao;

import java.util.List;

import com.blog.niko.restserver.domain.GalleryImage;

public interface GalleryImageDao {

	public void addGalleryImage(GalleryImage galleryImage);

	public void deleteGalleryImage(int imageId);

	public List<GalleryImage> getGalleryImages();

}
