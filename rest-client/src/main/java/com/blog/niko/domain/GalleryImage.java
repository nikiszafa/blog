package com.blog.niko.domain;

public class GalleryImage {


	private int imageId;

	private String galleryImageDescription;

	private String galleryImagePath;

	private boolean galleryImageIsVisibleString = true;
	
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
