package com.blog.niko.gwtfrontend.domain;

import java.io.Serializable;

public class Card implements Serializable {

	private static final long serialVersionUID = 1L;

	private int cardId;

	private String imgPath;

	private String title;

	private String content;

	private String buttonText;

	private String buttonLink;

	public Card(String imgPath, String title, String content, String buttonText, String buttonLink) {
		super();
		this.imgPath = imgPath;
		this.title = title;
		this.content = content;
		this.buttonText = buttonText;
		this.buttonLink = buttonLink;
	}

	public Card() {

	}

	public int getCardId() {
		return cardId;
	}

	public void setCardId(int cardId) {
		this.cardId = cardId;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getButtonText() {
		return buttonText;
	}

	public void setButtonText(String buttonText) {
		this.buttonText = buttonText;
	}

	public String getButtonLink() {
		return buttonLink;
	}

	public void setButtonLink(String buttonLink) {
		this.buttonLink = buttonLink;
	}

}
