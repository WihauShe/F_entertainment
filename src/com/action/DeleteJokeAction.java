package com.action;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.entity.Joke;
import com.opensymphony.xwork2.ActionSupport;
import com.server.JokeServer;
import com.server.UserServer;

public class DeleteJokeAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int jokeId;

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		boolean result = false;
		JokeServer jokeServer = new JokeServer();
		UserServer userServer = new UserServer();
		Joke joke = jokeServer.getJokeById(jokeId);
		if(jokeServer.deleteJokeById(jokeId)){
			userServer.minusCreditByEmail(joke.getUserEmail());
			result = true;
		}
		HttpServletResponse resp = ServletActionContext.getResponse() ;
		
		resp.setCharacterEncoding("utf-8") ;
		resp.getWriter().print(result) ;
		return null;
	}

	public int getJokeId() {
		return jokeId;
	}

	public void setJokeId(int jokeId) {
		this.jokeId = jokeId;
	}
	
}
