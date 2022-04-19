package com.blog.niko.gwtfrontend.client;

import java.util.List;

import com.blog.niko.gwtfrontend.domain.Post;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface PostServiceAsync {

	void getPosts(AsyncCallback<List<Post>> callback);

}
