package com.shashank.bookstore.dao;

import java.util.List;
import java.util.Set;

import com.shashank.bookstore.pojo.Book;

public interface BookDao
{
	boolean save(Book book);
	boolean update(Book book);
	boolean delete(int bookId);
	
	List<Book> getAll();
	Book getById(int bookId);

	List<Book> getByName(String bookName);
	List<Book> getByAuthor(String bookAuthor);
	List<Book> getByPublisher(String bookPublisher);
	

	Set<String> getPublishers();
	Set<String> getAuthors();
}	
