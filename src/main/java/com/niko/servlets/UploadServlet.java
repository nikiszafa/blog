package com.niko.servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.niko.beans.GalleryImage;
import com.niko.dao.GalleryImageDao;

@WebServlet("/UploadServlet")
@MultipartConfig()
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	GalleryImageDao galleryImageDao;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Part filePart = request.getPart("file");
		String fileName = filePart.getSubmittedFileName();

		filePart.write(getServletContext().getRealPath("") + "\\img\\" + fileName);
		
		String imageDescription = request.getParameter("imageDescription");
		String imagePath = "\\blog\\img\\" + fileName;
		
		GalleryImage galleryImage = new GalleryImage(imageDescription, imagePath, fileName);
		galleryImageDao.addGalleryImage(galleryImage);
		
		response.sendRedirect("/blog/GalleryServlet");;

	}

}