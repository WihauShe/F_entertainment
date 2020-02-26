package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.entity.Report;
import com.util.ConnectionUtil;

public class ReportDao {
	ConnectionUtil connUtil = new ConnectionUtil();
	public Integer addReport(Integer contentId,String type) throws SQLException{
		Connection con = connUtil.getConnection();
		String sql = "insert into report(contentid,type) values(?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, contentId);
		ps.setString(2, type);
		Integer result = ps.executeUpdate();
		if(con!=null){
			con.close();
		}
		if(ps!=null){
			ps.close();
		}
		return result;
	}
	public Integer deleteReportById(Integer id) throws SQLException{
		Connection con = connUtil.getConnection();
		String sql = "delete from report where id=?";
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
	public Report getReportById(int id) throws SQLException{
		Connection con = connUtil.getConnection();
		String sql = "select * from report where id=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, id);
		Report report = null;
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			Integer contentId = rs.getInt("contentId");
			String type = rs.getString("type");
			report = new Report(id, contentId, type);
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
		return report;
	}
	public ArrayList<Report> getReportList() throws SQLException{
		Connection con = connUtil.getConnection();
		ArrayList<Report> reportList = new ArrayList<Report>();
		String sql = "select * from report";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			Report report = new Report();
			Integer id = rs.getInt("id");
			Integer contentId = rs.getInt("contentId");
			String type = rs.getString("type");
			report.setId(id);
			report.setContentId(contentId);
			report.setType(type);
			reportList.add(report);
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
		return reportList;
	}
}
