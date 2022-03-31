package com.niko.blog.restserver.domain
;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name="cards")
public class Card implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="card_id")
	private int cardId; 
	
	@Column(name="card_imgpath")
	private String imgPath;
	
	@Column(name="card_title")
	private String title;
	
	@Column(name = "card_content")
	private String content;
	
	@Column(name="card_buttontext")
	private String buttonText;
	
	@Column(name="card_buttonLink")
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
