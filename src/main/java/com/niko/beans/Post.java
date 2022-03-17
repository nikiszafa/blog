package com.niko.beans;

import java.sql.Date;

public class Post {
	
	private int postId;
	private String postTitle;
	private String postContent;
	private String author;
	private Date publishDate;
	private boolean isVisible=true;
	private String postImg;
	
	
	
	public Post() {
		
	}
	
	public Post(String postTitle, String postContent, String author, Date publishDate, String postImg) {
		super();
		this.postTitle = postTitle;
		this.postContent = postContent;
		this.author = author;
		this.publishDate = publishDate;
		this.postImg = postImg;
	}
	public int getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}
	public String getPostTitle() {
		return postTitle;
	}
	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}
	public String getPostContent() {
		return postContent;
	}
	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Date getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}
	public boolean isVisible() {
		return isVisible;
	}
	public void setVisible(boolean isVisible) {
		this.isVisible = isVisible;
	}

	public String getPostImg() {
		return postImg;
	}

	public void setPostImg(String postImg) {
		this.postImg = postImg;
	}
	
	
	
	

	
}
