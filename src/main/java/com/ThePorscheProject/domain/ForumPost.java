package com.ThePorscheProject.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "forumPosts")
public class ForumPost {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer forumPostId;
	private String forumPostContent;
	
	public ForumPost() {
		
	}

	public Integer getForumPostId() {
		return forumPostId;
	}

	public void setForumPostId(Integer forumPostId) {
		this.forumPostId = forumPostId;
	}

	public String getForumPostContent() {
		return forumPostContent;
	}

	public void setForumPostContent(String forumPostContent) {
		this.forumPostContent = forumPostContent;
	}
	

}

