package com.blog.niko.restserver.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "galleryimage")
public class GalleryImage {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "gallery_image_id")
	private int imageId;

	@Column(name = "gallery_image_description")
	private String galleryImageDescription;

	@Column(name = "gallery_image_path")
	private String galleryImagePath;

	@Column(name = "gallery_image_isVisible")
	private boolean galleryImageIsVisibleString = true;
	
	@Column(name = "gallery_file_name")
	private String galleryFileName;

	public int getImageId() {
		return imageId;
	}

	public void setImageId(int imageId) {
		this.imageId = imageId;
	}

	public String getGalleryImageDescription() {
		return galleryImageDescription;
	}

	public void setGalleryImageDescription(String galleryImageDescription) {
		this.galleryImageDescription = galleryImageDescription;
	}

	public String getGalleryImagePath() {
		return galleryImagePath;
	}

	public void setGalleryImagePath(String galleryImagePath) {
		this.galleryImagePath = galleryImagePath;
	}

	public boolean getGalleryImageIsVisibleString() {
		return galleryImageIsVisibleString;
	}

	public void setGalleryImageIsVisibleString(Boolean galleryImageIsVisibleString) {
		this.galleryImageIsVisibleString = galleryImageIsVisibleString;
	}
	
	public String getGalleryFileName() {
		return galleryFileName;
	}

	public void setGalleryFileName(String galleryFileName) {
		this.galleryFileName = galleryFileName;
	}

	public GalleryImage(String galleryImageDescription, String galleryImagePath, String galleryFileName) {
		super();
		this.galleryImageDescription = galleryImageDescription;
		this.galleryImagePath = galleryImagePath;
		this.galleryFileName = galleryFileName;
	}

	public GalleryImage() {

	}

}
