package com.entity;


public class User{
	public User(){

	}
	public User(String userEmail,String userPassword,String userName,String userSex,String birthDate){
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.userName = userName;
		this.userSex = userSex;
		this.birthDate = birthDate;
	}
	private String userEmail;
	private String userPassword;
	private String userName;
	private String userSex;
	private String birthDate;
	private int userCredit;
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserSex() {
		return userSex;
	}
	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public int getUserCredit() {
		return userCredit;
	}
	public void setUserCredit(int userCredit) {
		this.userCredit = userCredit;
	}

	


	
}