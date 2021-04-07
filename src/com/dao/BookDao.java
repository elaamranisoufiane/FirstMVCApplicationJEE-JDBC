package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.books.Book;

public class BookDao {
	private String JDBCurl = "jdbc:mysql://localhost:3306/bookstore";
	private String JDBCusername = "root";
	private String JDBCpassword = "";
	private Connection JDBCConnection = null;
	private ArrayList<Book> bookList;

	public BookDao() {
		super();

	}

	public void connect() throws SQLException, ClassNotFoundException {

		if (JDBCConnection == null || JDBCConnection.isClosed()) {
			Class.forName("com.mysql.cj.jdbc.Driver");
			JDBCConnection = DriverManager.getConnection(JDBCurl, JDBCusername, JDBCpassword);
			System.out.println("Connection istablished to Mysql database ");
		}

	}

	public void disconnect() throws SQLException {
		if (JDBCConnection != null || !JDBCConnection.isClosed()) {
			JDBCConnection.close();
			System.out.println("connected is closed !");
		}
	}

	public ArrayList<Book> showAllItems() throws ClassNotFoundException, SQLException {
		this.connect();
		String sql = "SELECT * FROM books";
		Statement stm;
		bookList = new ArrayList<Book>();
		try {
			stm = JDBCConnection.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				bookList.add(new Book(rs.getInt("id"), rs.getString("title"), rs.getString("author"),
						rs.getDouble("price")));
			}
			stm.close();
			rs.close();
			this.disconnect();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bookList;
	}

	public void insertItem(Book book) throws ClassNotFoundException, SQLException {
		this.connect();
		String sql = "insert into books(title,author,price) values(?,?,?)";
		try {
			PreparedStatement stm = JDBCConnection.prepareStatement(sql);
			stm.setString(1, book.getTitle());
			stm.setString(2, book.getAuthor());
			stm.setDouble(3, book.getPrice());
			stm.executeUpdate();
			stm.close();
			this.disconnect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void delete(int id) throws ClassNotFoundException, SQLException{
		this.connect();
		String sql = "DELETE FROM books WHERE id=?";
		try {
			PreparedStatement stm = JDBCConnection.prepareStatement(sql);
			stm.setInt(1, id);
			stm.executeUpdate();
			stm.close();
			this.disconnect();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

}
