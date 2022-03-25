package com.niko.servlets;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.niko.beans.GalleryImage;
import com.niko.dao.GalleryImageDao;

@WebServlet("/GalleryServlet")
public class GalleryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	GalleryImageDao galleryImageDao;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<GalleryImage> galleryImages = galleryImageDao.getGalleryImages();
				
		request.setAttribute("galleryImages", galleryImages);
		
		request.getRequestDispatcher("/html/gallery.jsp").forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
	}

}
