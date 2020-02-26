package com.action;

import com.entity.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.server.UserServer;

public class UpdateUserAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String userName;
	private String userSex;
	private String birthDate;
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		User user = (User)ActionContext.getContext().getSession().get("user");
		user.setUserName(userName);
		user.setUserSex(userSex);
		user.setBirthDate(birthDate);
		UserServer userServer = new UserServer();
		if(userServer.updateUser(user)){
			return SUCCESS;
		}else {
			return ERROR;
		}
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
	
	
}
