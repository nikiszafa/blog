package com.blog.niko.restserver.dao;

import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import com.blog.niko.restserver.domain.GalleryImage;


@Stateful
public class GalleryImageDaoBean implements GalleryImageDao{

	@PersistenceContext(unitName = "primary", type = PersistenceContextType.EXTENDED)
	private EntityManager entityManager;
	

	public void addGalleryImage(GalleryImage galleryImage) {
		entityManager.persist(galleryImage);
	}

	public void deleteGalleryImage(int imageId) {
		GalleryImage galleryImage = entityManager.find(GalleryImage.class, imageId);
		entityManager.remove(galleryImage);
	}

	public List<GalleryImage> getGalleryImages() {
		return entityManager.createQuery("from GalleryImage").getResultList();
	}

}