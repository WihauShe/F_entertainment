package com.dao;

import java.sql.*;

import com.entity.User;
import com.util.ConnectionUtil;

public class UserDao{
	ConnectionUtil connutil = new ConnectionUtil();
	
	public int addUser(String userEmail,String userPassword,String userName,String userSex,String birthDate) throws SQLException{
		Connection con = connutil.getConnection();
		String sql = "insert into user values(?,?,?,?,?,0)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, userEmail);
		ps.setString(2, userPassword);
		ps.setString(3, userName);
		ps.setString(4, userSex);
		ps.setString(5, birthDate);
		int result = ps.executeUpdate();
		if(con!=null){
			con.close();
		}
		if(ps!=null){
			ps.close();
		}
		return result;
	}
	public int updateUser(String userEmail,String userName,String userSex,String birthDate) throws SQLException{
		Connection con = connutil.getConnection();
		String sql = "update user set name=?,sex=?,birthdate=? where email=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, userName);
		ps.setString(2, userSex);
		ps.setString(3, birthDate);
		ps.setString(4, userEmail);
		int result = ps.executeUpdate();
		if(con!=null){
			con.close();
		}
		if(ps!=null){
			ps.close();
		}
		return result;
	}
	public String getPwdByUserEmail(String userEmail) throws SQLException{
		Connection con = connutil.getConnection();
		String sql = "select password from user where email=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, userEmail);
		ResultSet rs = ps.executeQuery();
		String userPassword = "";
		while(rs.next()){
			userPassword = rs.getString("password");
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
		return userPassword;
	}
	public int changePwdByUserEmail(String userEmail,String userPassword) throws SQLException{
		Connection con = connutil.getConnection();
		String sql = "update user set password=? where email=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, userPassword);
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
	public int getCreditByEmail(String userEmail) throws SQLException{
		Connection con = connutil.getConnection();
		String sql = "select credit from user where email=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, userEmail);
		ResultSet rs = ps.executeQuery();
		int credit = 0;
		while(rs.next()){
			credit = rs.getInt("credit");
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
		return credit;
	}
	public int addCreditByEmail(String userEmail) throws SQLException{
		Connection con = connutil.getConnection();
		String sql = "update user set credit=credit+1 where email=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, userEmail);
		int result = ps.executeUpdate();
		if(con!=null){
			con.close();
		}
		if(ps!=null){
			ps.close();
		}
		return result;
	}
	public int minusCreditByEmail(String userEmail) throws SQLException{
		Connection con = connutil.getConnection();
		String sql = "update user set credit=credit-2 where email=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, userEmail);
		int result = ps.executeUpdate();
		if(con!=null){
			con.close();
		}
		if(ps!=null){
			ps.close();
		}
		return result;
	}
	public String getUserNameByEmail(String userEmail) throws SQLException{
		Connection con = connutil.getConnection();
		String sql = "select name from user where email = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, userEmail);
		ResultSet rs = ps.executeQuery();
		String userName = "";
		while (rs.next()) {
			userName = rs.getString("name");
		}
		return userName;
	}
	public User getUserByEmail(String userEmail) throws SQLException{
		Connection con = connutil.getConnection();
		String sql = "select * from user where email = ?";
		User user = new User();
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, userEmail);
		ResultSet rs = ps.executeQuery();
		String userName = "";
		String userSex = "";
		String birthDate = "";
		Integer credit = -1;
		while (rs.next()) {
			userName = rs.getString("name");
			userSex = rs.getString("sex");
			birthDate = rs.getString("birthdate");
			credit = rs.getInt("credit");
		}
		user.setUserEmail(userEmail);
		user.setUserName(userName);
		user.setUserSex(userSex);
		user.setBirthDate(birthDate);
		user.setUserCredit(credit);
		return user;
	}
	public int testUserEmail(String userEmail) throws SQLException{
		Connection con = connutil.getConnection();
		String sql = "select count(*) from user where email=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, userEmail);
		System.out.println(userEmail);
		int result = 0;
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			result = rs.getInt(1);
		}
		return result;
	}
	
	
	
	
}