package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.entity.Result;
import com.util.ConnectionUtil;

public class SearchDao {
	ConnectionUtil connUtil = new ConnectionUtil();
	public List<Result> searchResults(String flag) throws SQLException{
		Connection con = connUtil.getConnection();
		String sql = "select id from music where name like ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, '%'+flag+'%');
		ResultSet rs = ps.executeQuery();
		List<Result> results = new ArrayList<Result>();
		while(rs.next()){
			Result result = new Result();
			result.setContentId(rs.getInt("id"));
			result.setType("music");
			results.add(result);
		}
		sql = "select id from joke where content like ?";
		ps = con.prepareStatement(sql);
		ps.setString(1, '%'+flag+'%');
		rs = ps.executeQuery();
		while(rs.next()){
			Result result = new Result();
			result.setContentId(rs.getInt("id"));
			result.setType("joke");
			results.add(result);
		}
		return results;
	}

}
