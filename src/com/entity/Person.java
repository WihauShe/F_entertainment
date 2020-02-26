package com.entity;

public class Person {
	private String userEmail;
	private String signature;
	private String userStatus;
	
	public Person(String userEmail,String signature){
		this.userEmail = userEmail;
		this.signature = signature;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
	public String getUserStatus() {
		return userStatus;
	}
	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}
	
	
}
