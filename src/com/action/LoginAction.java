package com.action;


import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.entity.Joke;
import com.entity.Music;
import com.entity.Report;
import com.entity.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.server.JokeServer;
import com.server.MusicServer;
import com.server.PersonServer;
import com.server.ReportServer;
import com.server.UserServer;

public class LoginAction extends ActionSupport  implements ModelDriven<User>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private User user = new User();
	
	@Override
	public String execute() throws Exception{
		String result = "";
		UserServer userServer = new UserServer();
		PersonServer personServer = new PersonServer();
		String userEmail = user.getUserEmail();
		String userPassword = user.getUserPassword();
		String password = userServer.getPwdByEmail(userEmail);
		if(userPassword.equals(password)&&!userPassword.equals("")){
			if(userServer.getCreditByEmail(userEmail)<0){
				result =  "nocredit";
			}else if(personServer.getStatusByEmail(userEmail).equals("user")){
				String userName = userServer.getUserNameByEmail(userEmail);
				user.setUserName(userName);
				ActionContext.getContext().getSession().put("user", user);
				result =  "user";
			}else if(personServer.getStatusByEmail(userEmail).equals("admin")){
				String userName = userServer.getUserNameByEmail(userEmail);
				user.setUserName(userName);
				ActionContext.getContext().getSession().put("user", user);
				result =  "admin";
			}else{
				return null;
			}
		}else {
			result = "error";
		}
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		response.getWriter().print(result);
		return null;
	}
	
	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}

	

}
