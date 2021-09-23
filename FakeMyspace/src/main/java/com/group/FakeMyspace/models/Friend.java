package com.group.FakeMyspace.models;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
//@TypeConverter(name="booleanToInteger", boolean = Integer.class)   <-Try to convery boolean to int
@Table(name="friends")
public class Friend {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
//	@Convert("booleanToInteger")
	private boolean topEight;
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
	
	//===== M21 User&Frienfds =====//
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User owner;
	
	//===== 121 Friend&User =====//
	@OneToOne(mappedBy="oneFriend", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private User oneUser;

	
	
	
	//================ Constructor =================//
	public Friend() {
	
	}


	
	//================ Getter&Setter =================//

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isTopEight() {
		return topEight;
	}

	public void setTopEight(boolean topEight) {
		this.topEight = topEight;
	}


	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public User getOneUser() {
		return oneUser;
	}

	public void setOneUser(User oneUser) {
		this.oneUser = oneUser;
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




//	
//	public boolean isApprove() {
//		return approve;
//	}
//	
//	public void setApprove(boolean approve) {
//		this.approve = approve;
//	}
//	

	

	
	

}


