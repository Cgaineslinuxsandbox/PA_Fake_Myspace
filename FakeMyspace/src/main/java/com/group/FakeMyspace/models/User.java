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
		private String email;
		@Size(min=8)
		private String password;
		@Transient
		private String passwordConfirm;
		@Column(updatable=false)
		private Date createAt;
		private Date updatedAt;
		
		@OneToMany(mappedBy="owner", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
        private List<Friend> friends;
		
		@OneToOne(fetch=FetchType.LAZY)
        private Friend amigo;
		
		@OneToOne(fetch=FetchType.LAZY)
        private Message messageReceived;
		
		@OneToMany(mappedBy="sender", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
        private Message messageSent;
		
		 @ManyToMany(fetch=FetchType.LAZY)
		    @JoinTable(
				name="user_comments",
				joinColumns = @JoinColumn(name="user_id"),
				inverseJoinColumns = @JoinColumn(name="comment_id")
			)
        private List<Comment> comment;
		
		public User() {
			//leave this empty
		}

		@PrePersist
		protected void onCreate() {
			this.createAt = new Date();
		}
		@PreUpdate
		protected void onUpdate() {
			this.updatedAt = new Date();
		}

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
}