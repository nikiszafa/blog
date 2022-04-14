package com.blog.niko.gwtfrontend.client;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("getPosts")
public interface PostService extends RemoteService {

	List<Post> getPosts();

}
