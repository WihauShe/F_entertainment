package com.server;

import java.util.ArrayList;

import com.dao.CommentDao;
import com.entity.Comment;

public class CommentServer {
	CommentDao commentDao = new CommentDao();
	public boolean addComment(Comment comment){
		String userEmail = comment.getUserEmail();
		String userName = comment.getUserName();
		String content = comment.getContent();
		Integer jokeId = comment.getJokeId();
		boolean result = false;
		try {
			result = commentDao.addComment(userEmail, userName, content, jokeId)>0;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return result;
	}
	public ArrayList<Comment> getCommentsById(Integer jokeId){
		ArrayList<Comment> comments = new ArrayList<Comment>();
		try {
			comments = commentDao.getCommentsById(jokeId);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return comments;
	}
}
