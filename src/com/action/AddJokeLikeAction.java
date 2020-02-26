package com.action;


import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.server.JokeServer;

public class AddJokeLikeAction extends ActionSupport{

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
		if(jokeServer.addLikeById(jokeId)){
			result = true;
		}
		HttpServletResponse resp = ServletActionContext.getResponse() ;
		
		resp.setCharacterEncoding("utf-8") ;
		resp.getWriter().print(result) ;
		return null;
	}
	
	public void setJokeId(int jokeId){
		this.jokeId = jokeId;
	}
	public Integer getJokeId(){
		return jokeId;
	}
}
