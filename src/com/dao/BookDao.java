package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.JdbcConnection;

public class BookDao {
	private String JDBCurl = "jdbc:mysql://localhost:3306/bookstore";
	private String JDBCusername = "root";
	private String JDBCpassword = "";
	private Connection JDBCConnection;

	public void connect() throws SQLException, ClassNotFoundException{
		if (JDBCConnection == null || JDBCConnection.isClosed()) {
			Class.forName("com.mysql.cj.jdbc.Driver");
			JDBCConnection = DriverManager.getConnection(JDBCurl, JDBCusername, JDBCpassword);
			System.out.println("Connection istablished to Mysql database ");
		}
	}

	public void disconnect() throws SQLException {
     if (JDBCConnection != null || !JDBCConnection.isClosed()) {
		JDBCConnection.close(); 
	}
	}

}
