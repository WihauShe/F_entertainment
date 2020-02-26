package com.action;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.entity.Comment;
import com.entity.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.server.CommentServer;

public class AddCommentAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int jokeId;
	private String context;
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		boolean result = false;
		User user = (User)ActionContext.getContext().getSession().get("user");
		CommentServer commentServer = new CommentServer();
		if(commentServer.addComment(new Comment(user.getUserEmail(),user.getUserName(),context,jokeId)))
			result = true;
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		response.getWriter().print(result);
		return null;
	}
	public int getJokeId() {
		return jokeId;
	}
	public void setJokeId(int jokeId) {
		this.jokeId = jokeId;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	
	
}
