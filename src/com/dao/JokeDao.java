package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.entity.Joke;

import com.util.ConnectionUtil;

public class JokeDao {
	ConnectionUtil connutil = new ConnectionUtil();
	
	public Joke getJokeById(int id) throws SQLException{
		Connection con = connutil.getConnection();
		String sql = "select * from joke where id=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		Joke joke = null;
		while(rs.next()){
			String content = rs.getString("content");
			Integer like = rs.getInt("like");
			String userEmail = rs.getString("email");
			joke = new Joke(id,content,like,userEmail);
		}
		if(con!=null){
			con.close();
		}
		if(ps!=null){
			ps.close();
		}
		if(rs!=null){
			rs.close();
		}
		return joke;
	}
	public Integer addLikeById(Integer jokeId) throws SQLException{
		Connection con = connutil.getConnection();
		String sql = "update joke set `like`=`like`+1 where id = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, jokeId);
		int result = ps.executeUpdate();
		if(con!=null){
			con.close();
		}
		if(ps!=null){
			ps.close();
		}
		return result;
	}
	public Integer addJoke(String content,String userEmail)throws SQLException{
		Connection con = connutil.getConnection();
		String sql = "insert joke(content,email) values(?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, content);
		ps.setString(2, userEmail);
		int result = ps.executeUpdate();
		if(con!=null){
			con.close();
		}
		if(ps!=null){
			ps.close();
		}
		return result;
	}
	public Integer deleteJokeById(Integer jokeId) throws SQLException{
		Connection con = connutil.getConnection();
		String sql = "delete from joke where id =?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, jokeId);
		int result = ps.executeUpdate();
		if(con!=null){
			con.close();
		}
		if(ps!=null){
			ps.close();
		}
		return result;
	}
	public ArrayList<Joke> getJokeList() throws SQLException{
		Connection con = connutil.getConnection();
		String sql = "select * from joke";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		ArrayList<Joke> jokeList = new ArrayList<Joke>();
		while(rs.next()){
			Integer id = rs.getInt("id");
			String content = rs.getString("content");
			Integer like = rs.getInt("like");
			String userEmail = rs.getString("email");
			Joke joke = new Joke(id,content,like,userEmail);
			jokeList.add(joke);
		}
		if(con!=null){
			con.close();
		}
		if(ps!=null){
			ps.close();
		}
		if(rs!=null){
			rs.close();
		}
		return jokeList;
	}
}
