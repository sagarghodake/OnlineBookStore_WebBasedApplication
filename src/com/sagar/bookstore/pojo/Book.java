package com.shashank.bookstore.pojo;

// this class object only represent the data
// there is no any business logic
// plain class that why it known as Plain old java object.
public class Book
{
	private int bookId;
	private String bookName;
	private String bookAuthor;
	private String bookPublisher;
	private double bookPrice;
	private String bookDescription;
	
	// To create a object book in different form we need constructors.
	//Empty book;
	public Book() {
	}

	// create book without an Id
	// use with insert query
	public Book(String bookName, String bookAuthor, String bookPublisher, double bookPrice, String bookDescription) {
		super();
		this.bookName = bookName;
		this.bookAuthor = bookAuthor;
		this.bookPublisher = bookPublisher;
		this.bookPrice = bookPrice;
		this.bookDescription = bookDescription;
	}

	//create a book with all attributes i.e id also.
	// used with update and select queries.
	public Book(int bookId, String bookName, String bookAuthor, String bookPublisher, double bookPrice,
			String bookDescription) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookAuthor = bookAuthor;
		this.bookPublisher = bookPublisher;
		this.bookPrice = bookPrice;
		this.bookDescription = bookDescription;
	}

	
	
	// to Convert object into string to pritn console.
	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookName=" + bookName + ", bookAuthor=" + bookAuthor + ", bookPublisher="
				+ bookPublisher + ", bookPrice=" + bookPrice + ", bookDescription=" + bookDescription + "]";
	}

	// To manipulate existing object we need setters and getters.
	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public String getBookPublisher() {
		return bookPublisher;
	}

	public void setBookPublisher(String bookPublisher) {
		this.bookPublisher = bookPublisher;
	}

	public double getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(double bookPrice) {
		this.bookPrice = bookPrice;
	}

	public String getBookDescription() {
		return bookDescription;
	}

	public void setBookDescription(String bookDescription) {
		this.bookDescription = bookDescription;
	}
	
	
	
	
	
}
