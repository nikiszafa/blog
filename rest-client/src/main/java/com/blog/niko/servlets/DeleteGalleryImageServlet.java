package com.blog.niko.servlets;

import java.io.File;
import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DeleteGalleryImageServlet")
public class DeleteGalleryImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int imageId = Integer.parseInt(request.getParameter("imageId"));
		String imageName = request.getParameter("imageName");
		
		File file = new File(getServletContext().getRealPath("") + "\\img\\" + imageName);
		file.delete();
		
		//galleryImageDao.deleteGalleryImage(imageId);
		
		response.sendRedirect("/blog/GalleryServlet");
		
	}

}
