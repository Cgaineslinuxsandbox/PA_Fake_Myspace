package com.group.FakeMyspace.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
@Entity
@Table(name="users")
public class User {


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	private String name;
	@NotBlank
	private String gender;
	@NotBlank
	private String location;
	@NotBlank
	private String quote;
	@NotNull
	private int age;
	@NotBlank
	private String email;
	
	
	//FOR USER PROFILE PICTURE//
	private String image_url;
	//FOR USER PROFILE PICTURE//
	
	
	
	
	@Size(min=8)
	private String password;
	@Transient
	private String passwordConfirm;
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
	
	//===== 12M User&Frienfds =====//
	@OneToMany(mappedBy="owner", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<Friend> friend;
	
	//===== 121 Friend&User =====//
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="friend_id")
	private Friend oneFriend;
	
	
	//===== 121 User&Blurb =====//
	@OneToOne(mappedBy="owner", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private Blurb blurb;
	
	
	//===== 12M User&Messages =====//
	@OneToMany(mappedBy="sender", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<Message> messageSent;
	
	//===== 121 Message&User =====//
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="message_id")
	private Message messageReceived;
	
	
	//===== M2M Users&Comments =====//
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(
			name="user_comment",
			joinColumns = @JoinColumn(name="user_id"),
			inverseJoinColumns = @JoinColumn(name="comment_id")
			)
	private List<Comment> comment;
	
	
	
	
	//================ Constructor =================//
	public User() {
		//leave this empty
	}
	
	
	
	//================ Getter&Setter =================//
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPasswordConfirm() {
		return passwordConfirm;
	}
	
	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
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
	
	public List<Friend> getFriend() {
		return friend;
	}
	
	public void setFriend(List<Friend> friend) {
		this.friend = friend;
	}
	
	public Friend getOneFriend() {
		return oneFriend;
	}
	
	public void setOneFriend(Friend oneFriend) {
		this.oneFriend = oneFriend;
	}
	
	public List<Message> getMessageSent() {
		return messageSent;
	}
	
	public void setMessageSent(List<Message> messageSent) {
		this.messageSent = messageSent;
	}
	
	public Message getMessageReceived() {
		return messageReceived;
	}
	
	public void setMessageReceived(Message messageReceived) {
		this.messageReceived = messageReceived;
	}
	
	public List<Comment> getComment() {
		return comment;
	}
	
	public void setComment(List<Comment> comment) {
		this.comment = comment;
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getLocation() {
		return location;
	}
	
	public void setLocation(String location) {
		this.location = location;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	public String getQuote() {
		return quote;
	}
	public void setQuote(String quote) {
		this.quote = quote;
	}
	
	public String getImage_url() {
		return image_url;
	}
	
	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}
	public Blurb getBlurb() {
		return blurb;
	}
	public void setBlurb(Blurb blurb) {
		this.blurb = blurb;
	}

	
	




		public List<Friend> getFriends() {
			return friends;
		}

		public void setFriends(List<Friend> friends) {
			this.friends = friends;
		}

		public Friend getAmigo() {
			return amigo;
		}

		public void setAmigo(Friend amigo) {
			this.amigo = amigo;
		}

		public Message getMessageReceived() {
			return messageReceived;
		}

		public void setMessageReceived(Message messageReceived) {
			this.messageReceived = messageReceived;
		}

		public Message getMessageSent() {
			return messageSent;
		}

		public void setMessageSent(Message messageSent) {
			this.messageSent = messageSent;
		}

		public List<Comment> getComment() {
			return comment;
		}

		public void setComment(List<Comment> comment) {
			this.comment = comment;
		}

		public Friend getAccepted() {
			return accepted;
		}

		public void setAccepted(Friend accepted) {
			this.accepted = accepted;
		}
}