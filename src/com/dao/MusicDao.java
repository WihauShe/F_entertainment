package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.entity.Music;
import com.util.ConnectionUtil;

public class MusicDao {
	ConnectionUtil connUtil = new ConnectionUtil();
	public Integer addLikeById(Integer id) throws SQLException{
		Connection con = connUtil.getConnection();
		String sql = "update music set `like`=`like`+1 where id=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, id);
		Integer result = ps.executeUpdate();
		if(con!=null){
			con.close();
		}
		if(ps!=null){
			ps.close();
		}
		return result;
	}
	public Music getMusicById(int id) throws SQLException{
		Connection con = connUtil.getConnection();
		String sql = "select * from music where id=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		Music music = null;
		while(rs.next()){
			String name = rs.getString("name");
			String path = rs.getString("path");
			Integer like = rs.getInt("like");
			String userEmail = rs.getString("email");
			music = new Music(id, name, path, like, userEmail);
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
		return music;
	}
	public Integer addMusic(String name,String path,String userEmail) throws SQLException{
		Connection con = connUtil.getConnection();
		String sql = "insert into music(name,path,email) values(?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, name);
		ps.setString(2, path);
		ps.setString(3, userEmail);
		Integer result = ps.executeUpdate();
		if(con!=null){
			con.close();
		}
		if(ps!=null){
			ps.close();
		}
		return result;
	}
	public Integer deleteMusicById(Integer id) throws SQLException{
		Connection con = connUtil.getConnection();
		String sql = "delete from music where id=?";
		PreparedStatement ps = con.prepareStatement(sql);
		String Id = Integer.toString(id);
		ps.setString(1, Id);
		Integer result = ps.executeUpdate();
		if(con!=null){
			con.close();
		}
		if(ps!=null){
			ps.close();
		}
		return result;
	}
	public ArrayList<Music> getMusicList() throws SQLException{
		Connection con = connUtil.getConnection();
		String sql = "select * from music";
		PreparedStatement ps = con.prepareStatement(sql);
		ArrayList<Music> musicList = new ArrayList<Music>();
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			Integer id = rs.getInt("id");
			String name = rs.getString("name");
			String path = rs.getString("path");
			Integer like = rs.getInt("like");
			String userEmail = rs.getString("email");
			Music music = new Music(id, name, path, like, userEmail);
			musicList.add(music);
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
		return musicList;
	}
}
