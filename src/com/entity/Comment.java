package com.entity;

public class Comment{
	public Comment(){

	}
	public Comment(String userEmail,String userName,String content,Integer jokeId){
		this.userEmail=userEmail;
		this.userName = userName;
		this.content = content;
		this.jokeId = jokeId;
	}
	private Integer id;
	private String userEmail;
	private String userName;
	private String content;
	private Integer jokeId;
	
	public Integer getId() {
		return id;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public String getUserName() {
		return userName;
	}
	public String getContent() {
		return content;
	}
	public Integer getJokeId() {
		return jokeId;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void setJokeId(Integer jokeId) {
		this.jokeId = jokeId;
	}
	

	
}