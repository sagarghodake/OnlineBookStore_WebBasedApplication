package com.shashank.bookstore.pojo;

public class Cart
{
	private int cartId;
	private int bookId;
	private String custEmailId;
	private int cartQuantity;
	private Book book; // it hold entire book details which added in our Cart.

	// Cart Empty
	public Cart() {
	}
	//Cart with cartId and book Object. // use with Addtocart

	public Cart(int bookId, String custEmailId, int cartQuantity) {
		super();
		this.bookId = bookId;
		this.custEmailId = custEmailId;
		this.cartQuantity = cartQuantity;
	}
	//Cart with cartid and book // Use with ShowCart
	public Cart(int cartId, int bookId, String custEmailId, int cartQuantity, Book book) {
		super();
		this.cartId = cartId;
		this.bookId = bookId;
		this.custEmailId = custEmailId;
		this.cartQuantity = cartQuantity;
		this.book = book;
	}

	
	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", bookId=" + bookId + ", custEmailId=" + custEmailId + ", cartQuantity="
				+ cartQuantity + ", book=" + book + "]";
	}
	
	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getCustEmailId() {
		return custEmailId;
	}

	public void setCustEmailId(String custEmailId) {
		this.custEmailId = custEmailId;
	}

	public int getCartQuantity() {
		return cartQuantity;
	}

	public void setCartQuantity(int cartQuantity) {
		this.cartQuantity = cartQuantity;
	}
	
	
	
	
}
