package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.entity.Comment;
import com.util.ConnectionUtil;

public class CommentDao {
	ConnectionUtil connUtil = new ConnectionUtil();
	
	public int addComment(String userEmail,String userName,String content,Integer jokeId) throws SQLException{
		Connection con = connUtil.getConnection();
		String sql = "insert comment(email,name,content,jokeid) values(?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, userEmail);
		ps.setString(2, userName);
		ps.setString(3, content);
		ps.setInt(4, jokeId);
		int result = ps.executeUpdate();
		if(con!=null){
			con.close();
		}
		if(ps!=null){
			ps.close();
		}
		return result;
	}
	public ArrayList<Comment> getCommentsById(Integer jokeId) throws SQLException{
		Connection  con = connUtil.getConnection();
		String sql = "select * from comment where jokeid=?";
		PreparedStatement ps = con.prepareStatement(sql);
		String  jokeID = Integer.toString(jokeId);
		ps.setString(1, jokeID);
		ResultSet rs = ps.executeQuery();
		ArrayList<Comment> comments = new ArrayList<Comment>();
		while(rs.next()){
			String userEmail = rs.getString("email");
			String userName = rs.getString("name");
			String content = rs.getString("content");
			Comment comment = new Comment(userEmail,userName,content, jokeId); 
			comments.add(comment);
		}
		if(con!=null){
			con.close();
		}
		if(ps!=null){
			ps.close();
		}
		return comments;
	}
	
}
