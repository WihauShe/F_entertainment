package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	public Connection getConnection() throws SQLException{

		String driver="com.mysql.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/entertainment";
		String user="test";
		String password="1234";

		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection con=DriverManager.getConnection(url,user,password);
		return con;		
	}
}
