package com.blog.niko.servlets;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.blog.niko.beans.GalleryImageBean;
import com.blog.niko.domain.GalleryImage;

@WebServlet("/UploadServlet")
@MultipartConfig()
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	GalleryImageBean galleryImageBean;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			Path path = Paths.get(getServletContext().getRealPath("") + "\\img\\");

			Files.createDirectories(path);

			System.out.println("Directory is created!");

		} catch (IOException e) {

			System.err.println("Failed to create directory!" + e.getMessage());

		}

		Part filePart = request.getPart("file");
		String fileName = filePart.getSubmittedFileName();

		filePart.write(getServletContext().getRealPath("") + "\\img\\" + fileName);

		String imageDescription = request.getParameter("imageDescription");
		String imagePath = "\\client\\img\\" + fileName;

		GalleryImage galleryImage = new GalleryImage(imageDescription, imagePath, fileName);
		galleryImageBean.addGalleryImage(galleryImage);

		response.sendRedirect("/client/GalleryServlet");

	}

}