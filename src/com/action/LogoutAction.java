package com.action;

import java.util.Map;

import com.entity.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LogoutAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		Map<String,Object> session = ActionContext.getContext().getSession();
		User user = (User)session.get("user");
		if(user==null){
			return LOGIN;
		}else{
			session.remove("user");
			return SUCCESS;
		}
	}
	
	
}
