package com.blog.niko.gwtfrontend.server;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.inject.Inject;

import com.blog.niko.gwtfrontend.beans.PostBean;
import com.blog.niko.gwtfrontend.client.PostService;
import com.blog.niko.gwtfrontend.domain.Post;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class PostServiceImpl extends RemoteServiceServlet implements PostService {

	@Inject
	PostBean postBean;

	private static Logger rootLogger = Logger.getLogger("");

	private static final long serialVersionUID = 1L;

	private List<Post> posts = new ArrayList<Post>();

	@Override
	public List<Post> getPosts() {
		rootLogger.log(Level.SEVERE, "IN GET POSTS: ");

		posts = postBean.getPosts();

		return posts;
	}

	@Override
	public boolean deletePost(int i) {
		rootLogger.log(Level.SEVERE, "IN DELETE POST");

		postBean.deletePost(i);

		return true;
	}

	@Override
	public boolean addPost(Post post) {

		rootLogger.log(Level.SEVERE, "IN ADD POST");

		postBean.addPost(post);

		return false;
	}

}
