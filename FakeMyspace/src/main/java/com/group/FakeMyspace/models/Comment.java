package com.group.FakeMyspace.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import javax.validation.constraints.NotBlank;


@Entity
@Table(name="comments")
public class Comment {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	private String content;
	@Column(updatable=false)
	private Date createAt;
	private Date updatedAt;
	
	
	@PrePersist
	protected void onCreate() {
		this.createAt = new Date();
	}
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}
	
	
	
	
	//================ Relationship =================//
	
	//===== M2M Users&Comments =====//
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(
			name="user_comment",
			joinColumns = @JoinColumn(name="comment_id"),
			inverseJoinColumns = @JoinColumn(name="user_id")
			)
	private List<User> creator;

	
	
	
	//================ Constructor =================//
	public Comment() {
	
	}
	
	
	
	//================ Getter&Setter =================//
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public Date getCreateAt() {
		return createAt;
	}
	
	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
	
	public Date getUpdatedAt() {
		return updatedAt;
	}
	
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	public List<User> getCreator() {
		return creator;
	}
	
	public void setCreator(List<User> creator) {
		this.creator = creator;
	}
	
	
	
	
	
	
}

