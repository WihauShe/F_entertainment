package com.entity;


public class Joke{
	public Joke(){

	}
	public Joke(Integer id,String content,Integer like,String userEmail){
		this.id = id;
		this.content = content;
		this.like = like;
		this.userEmail = userEmail;
	}
	private Integer id;
	private String content;
	private Integer like;
	private String userEmail;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Integer getLike() {
		return like;
	}
	public void setLike(Integer like) {
		this.like = like;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	
}