package com.group.FakeMyspace.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="pictures")
public class Picture {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String image_url;
	
	@DateTimeFormat(pattern="yyy-MM-DD HH:mm:ss")
	private Date createdAt = new Date();
	
	
	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date(); 
	}

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="us_id")
	private User user;
	
	
	
	
	

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getImage_url() {
		return image_url;
	}


	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}


	public Date getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public Picture(String image_url, User user) {
		this.image_url = image_url;
		this.user = user;
	}


	public Picture() {
		
	}
	
	
	
}
