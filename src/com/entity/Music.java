package com.entity;

public class Music {
	private Integer id;
	private String name;
	private String path;
	private Integer like;
	private String userEmail;
	
	public Music(){
		
	}
	public Music(Integer id,String name,String path,Integer like,String userEmail){
		this.id = id;
		this.name = name;
		this.path = path;
		this.setLike(like);
		this.userEmail = userEmail;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
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
