package com.niko.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.niko.beans.Card;
import com.niko.beans.Post;
import com.niko.beans.User;

public class ApplicationDao {

	// get all posts

	public List<Post> getPosts(Connection connection){
		Post post = null;
		List<Post> posts = new ArrayList<Post>();
		
		try {
			String sql = "SELECT * FROM post ORDER BY post_id DESC";
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet set = statement.executeQuery();
			
			while(set.next()) {
				post = new Post();
				post.setPostId(set.getInt("post_id"));
				post.setPostTitle(set.getString("post_title"));
				post.setPostContent(set.getString("post_content"));
				post.setAuthor(set.getString("post_author"));
				post.setPublishDate(set.getDate("post_publish_date"));
				post.setVisible(set.getBoolean("post_is_visible"));
				post.setPostImg(set.getString("post_img"));
				posts.add(post);
			}

		} catch (SQLException exception) {
			exception.printStackTrace();
		}
		
		return posts;
	}
	
	public int addPost(Post post, Connection connection) {
		int rowsAffected = 0;
		
		try {
			String insertQuery = "INSERT INTO post(post_title, post_content, post_author, post_publish_date, post_is_visible, post_img) VALUES(?,?,?,?,?,?)";
		
			PreparedStatement statement = connection.prepareStatement(insertQuery);
			statement.setString(1, post.getPostTitle());
			statement.setString(2, post.getPostContent());
			statement.setString(3, post.getAuthor());
			statement.setDate(4, post.getPublishDate());
			statement.setBoolean(5, post.isVisible());
			statement.setString(6, post.getPostImg());
			rowsAffected = statement.executeUpdate();		
		
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
		
		return rowsAffected;
	}
	
	public int deletePost(int postId, Connection connection) {
		int rowsAffected = 0;

		try {
			String deleteQuery = "DELETE FROM post WHERE post_id =?";
		
			PreparedStatement statement = connection.prepareStatement(deleteQuery);
			statement.setInt(1, postId);

			rowsAffected = statement.executeUpdate();		
		
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
		return rowsAffected;
	}
	
	public List<Card> getCards(Connection connection){
		Card card = null;
		List<Card> cards = new ArrayList<Card>();
		
		try {
			String sql = "SELECT * FROM cards ORDER BY card_id DESC";
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet set = statement.executeQuery();
			
			while(set.next()) {
				card = new Card();
				card.setCardId(set.getInt("card_id"));
				card.setTitle(set.getString("card_title"));
				card.setImgPath(set.getString("card_imgpath"));
				card.setContent(set.getString("card_content"));
				card.setButtonText(set.getString("card_buttontext"));
				card.setButtonLink(set.getString("card_buttonLink"));
				cards.add(card);
			}

		} catch (SQLException exception) {
			exception.printStackTrace();
		}
		
		return cards;
	}
	
	public int addCard(Card card, Connection connection) {
		int rowsAffected = 0;
		
		try {
			String insertQuery = "INSERT INTO cards(card_imgpath, card_title, card_content, card_buttontext, card_buttonLink) VALUES(?,?,?,?,?)";
		
			PreparedStatement statement = connection.prepareStatement(insertQuery);
			statement.setString(1, card.getImgPath());
			statement.setString(2, card.getTitle());
			statement.setString(3, card.getContent());
			statement.setString(4, card.getButtonText());
			statement.setString(5, card.getButtonLink());
			
			rowsAffected = statement.executeUpdate();		
		
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
		
		return rowsAffected;
	}
	
	public int deleteCard(int cardId, Connection connection) {
		int rowsAffected = 0;

		try {
			String deleteQuery = "DELETE FROM cards WHERE card_id =?";
		
			PreparedStatement statement = connection.prepareStatement(deleteQuery);
			statement.setInt(1, cardId);

			rowsAffected = statement.executeUpdate();		
		
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
		return rowsAffected;
	}
	
	public boolean validateUser(String username, String password, Connection connection) {
		boolean isValidUser = false;
		
		try {
			String sql = "SELECT * FROM users WHERE user_username=? AND user_password=?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, username);
			statement.setString(2, password);
			
			ResultSet set = statement.executeQuery();
			while(set.next()) {
				isValidUser = true;
			}
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
		return isValidUser;
	}
	
	public User getProfileDetails(String username, Connection connection) {
		User user = null;
		
		try {
			String sql = "SELECT * FROM users WHERE user_username=?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, username);
			
			ResultSet set = statement.executeQuery();
			while(set.next()) {
				user = new User();
				user.setUsername(set.getString("user_username"));
				user.setFirstName(set.getString("user_first_name"));
				user.setLastName(set.getString("user_last_name"));
				user.setAge(set.getInt("user_age"));
				user.setRole(set.getString("user_role"));
			}
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
		return user;
	}

}
