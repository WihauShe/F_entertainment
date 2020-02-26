package com.action;

import com.entity.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.server.PersonServer;
import com.server.UserServer;

public class PersonalSpaceAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private User user;
	private String signature;
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		User puser = null;
		puser = (User)ActionContext.getContext().getSession().get("user");
		if(puser==null){
			return ERROR;
		}
		String userEmail = puser.getUserEmail();
		UserServer userServer = new UserServer();
		PersonServer personServer = new PersonServer();
		setUser(userServer.getUserByEmail(userEmail));
		signature = personServer.getSigByEmail(userEmail);
		return SUCCESS;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}

	
}
