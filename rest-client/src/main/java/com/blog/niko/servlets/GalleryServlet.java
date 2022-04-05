package com.blog.niko.servlets;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blog.niko.beans.GalleryImageBean;
import com.blog.niko.domain.GalleryImage;

@WebServlet("/GalleryServlet")
public class GalleryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Inject
	GalleryImageBean galleryImageBean;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<GalleryImage> galleryImages = galleryImageBean.getGalleryImages();
				
		request.setAttribute("galleryImages", galleryImages);
		
		request.getRequestDispatcher("/html/gallery.jsp").forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
	}

}
