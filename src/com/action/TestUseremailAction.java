package com.action;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.server.UserServer;

public class TestUseremailAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String userEmail; 

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		boolean result = false;
		UserServer userServer = new UserServer();
		if(userServer.testUserEmail(userEmail)){
			result = true;
		}
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		response.getWriter().print(result);
		return null;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

}
