package com.books;

public class Book {
	private int id;
	private String title;
	private String author;
	private double price;

	public Book(int id, String title, String author, double d) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.price = d;
	}

	public Book(String title, String author, double price) {
		super();
		this.title = title;
		this.author = author;
		this.price = price;
	}

	public Book() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(double d) {
		this.price = d;
	}

}
