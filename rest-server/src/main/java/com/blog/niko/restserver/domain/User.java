package com.blog.niko.restserver.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_id")
	private int userId;
	
	@Column(name="user_password")
	private String password;
	
	@Column(name="user_username")
	private String username;
	
	@Column(name="user_first_name")
	private String firstName;
	
	@Column(name="user_last_name")
	private String lastName;
	
	@Column(name="user_age")
	private int age;
	
	@Column(name="user_role")
	private String role;
	
	
	
	public User(String password, String username, String firstName, String lastName, int age, String role) {
		super();
		this.password = password;
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.role = role;
	}
	
	public User() {
		
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	

}
