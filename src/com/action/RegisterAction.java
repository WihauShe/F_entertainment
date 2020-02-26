package com.action;

import com.entity.Person;
import com.entity.User;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.server.PersonServer;
import com.server.UserServer;

public class RegisterAction extends ActionSupport implements ModelDriven<User>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private User user = new User();

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		UserServer userServer = new UserServer();
		PersonServer personServer = new PersonServer();
		User newUser = new User();
		newUser = user;
		if(userServer.registerUser(newUser)){
			personServer.insertSig(new Person(user.getUserEmail(),""));
			return SUCCESS;
		}else {
			return ERROR;
		}
	}
	
	
	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}

}
