package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.util.ConnectionUtil;

public class PersonDao {
	ConnectionUtil connutil = new ConnectionUtil();
	
	public int insertPerson(String userEmail,String signature) throws SQLException{
		Connection con = connutil.getConnection();
		String sql = "insert into person(email,signature) values(?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, userEmail);
		ps.setString(2, signature);
		int result = ps.executeUpdate();
		if(con!=null){
			con.close();
		}
		if(ps!=null){
			ps.close();
		}
		return result;
	}
	public String getSigByEmail(String userEmail) throws SQLException{
		Connection con = connutil.getConnection();
		String signature="";
		String sql = "select signature from person where email=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, userEmail);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			signature = rs.getString("signature");
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
		return signature;
	}
	public int updateSigByEmail(String userEmail,String signature) throws SQLException{
		Connection con = connutil.getConnection();
		String sql = "update person set signature =? where email=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, signature);
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
	public String getStatusByEmail(String userEmail) throws SQLException{
		Connection con = connutil.getConnection();
		String userStatus="";
		String sql = "select status from person where email=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, userEmail);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			userStatus = rs.getString("status");
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
		return userStatus;
	}
}
