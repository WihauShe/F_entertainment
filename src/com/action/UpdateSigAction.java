package com.action;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.entity.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.server.PersonServer;

public class UpdateSigAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String signature;
	

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		boolean result = false;
		User user = (User)ActionContext.getContext().getSession().get("user");
		PersonServer personServer = new PersonServer();
		if(personServer.updateSigByEmail(user.getUserEmail(), signature)){
			result = true;
		}
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		response.getWriter().print(result);
		return null;
	}


	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}
	
}
