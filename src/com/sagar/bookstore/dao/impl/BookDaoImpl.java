package com.shashank.bookstore.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.shashank.bookstore.dao.BookDao;
import com.shashank.bookstore.pojo.Book;
import com.shashank.bookstore.utility.DBConnection;

public class BookDaoImpl implements BookDao
{
	Connection con = DBConnection.getConn(); 
	PreparedStatement ps = null; // It used store sql queries.
	ResultSet rs = null; // It is used store data which retrieve by select query.

	String sqlQuery=null;

	@Override
	public boolean save(Book book)
	{
		sqlQuery="insert into book_ct2425 (bookName,bookAuthor,bookPublisher,bookPrice,bookDescription) values (?,?,?,?,?)";	
		try
		{
			ps = con.prepareStatement(sqlQuery);
			
			// here we set all the columns with proper values i.e replace Question mark with actual values.
			ps.setString(1,book.getBookName());
			ps.setString(2, book.getBookAuthor());
			ps.setString(3, book.getBookPublisher());
			ps.setDouble(4,book.getBookPrice());
			ps.setString(5, book.getBookDescription());
			
			System.out.println(ps);
			/*
			 	preparedStatement interface have 2 method to execute query 
			 	1. executeUpdate()
			 	 	It used for insert update delete(i.e for manipulating the data of database
			 	 	Return type of this method is int 
			 	2. executeQuery()
			 		IT used for select query only (i.e for Retrieve the data from database
			 		Return type is  ResultSet because it return data form table. 
			 */
			
			int i = ps.executeUpdate();
			
			if(i>0)
			{
				return true;
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(Book book)
	{
		sqlQuery ="update book_ct2425 set bookName=?,bookAuthor=?,bookPublisher=?,bookPrice=?,bookDescription=? where bookId=?";
		try
		{
			ps = con.prepareStatement(sqlQuery);
			
			// here we set all the columns with proper values i.e replace Question mark with actual values.
			ps.setString(1,book.getBookName());
			ps.setString(2, book.getBookAuthor());
			ps.setString(3, book.getBookPublisher());
			ps.setDouble(4,book.getBookPrice());
			ps.setString(5, book.getBookDescription());
			ps.setInt(6, book.getBookId());
			
			System.out.println(ps);
			
			int i = ps.executeUpdate();
			
			if(i>0)
			{
				return true;
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(int bookId) 
	{
		sqlQuery="delete from book_ct2425 where bookId=?";
		
		try {
			ps = con.prepareStatement(sqlQuery);
			ps.setInt(1, bookId);
						
			int i = ps.executeUpdate();
			
			if(i>0)
			{
				return true;
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public List<Book> getAll()
	{
		sqlQuery = "select * from book_ct2425";
		List<Book> booklist = new ArrayList<>();
		try {
			ps = con.prepareStatement(sqlQuery);
			
			rs = ps.executeQuery();
			
			while(rs.next()) // it will check is there any row present in rs or not
			{
				/*
				 	// using Setters 
					Book book = new Book();
					book.setBookId(rs.getInt(1));
					//set reset of Properties of book Object
				*/
				// without using setters.
				Book book = new Book(rs.getInt(1),
						             rs.getString(2),
						             rs.getString(3), 
						             rs.getString(4), 
						             rs.getDouble(5), 
						             rs.getString(6));
				booklist.add(book);
			}
			return booklist;
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public Book getById(int bookId) 
	{
		sqlQuery="select * from book_ct2425 where bookId=?";
		
		try {
			ps = con.prepareStatement(sqlQuery);
			ps.setInt(1, bookId);
			
			rs = ps.executeQuery();
			
			if(rs.next())  // we use if statement because we get only one row if id is present in table otherwise return 0 row 
			{
				Book book = new Book(rs.getInt(1), rs.getString("bookName"), rs.getString(3), rs.getString(4), rs.getDouble(5), rs.getString(6));
				return book;
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Book> getByName(String bookName) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<Book> getByAuthor(String bookAuthor) {
		return null;
	}

	@Override
	public List<Book> getByPublisher(String bookPublisher) {
		sqlQuery="select * from book_ct2425 where bookPublisher=?";
		List<Book> booklist = new ArrayList<>();
		
		try {
			ps = con.prepareStatement(sqlQuery);
			ps.setString(1, bookPublisher);
			
			rs = ps.executeQuery();
			System.out.println(ps);
			while(rs.next())  // we use if statement because we get only one row if id is present in table otherwise return 0 row 
			{
				Book book = new Book(rs.getInt(1), rs.getString("bookName"), rs.getString(3), rs.getString(4), rs.getDouble(5), rs.getString(6));
				
				booklist.add(book);
			}
			return booklist;
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args) 
	{
		/*
	
		Book book = new Book("Core Java ", "R.S. Mehata", "Coder ", 250.75, "Best Book of Jvaa");
		
		BookDao bookDao = new BookDaoImpl();
		boolean flag = bookDao.save(book);
		if(flag)
			System.out.println("Book is Save Successfully...");
		
	
		
		Book book = new Book(1,"Core Java ", "R.S. Mehata", "Coder Technologies ", 250.75, "Best Book for Core Java");
		
		BookDao bookDao = new BookDaoImpl();
		boolean flag = bookDao.update(book);
		if(flag)
			System.out.println("Book is updated Successfully...");
		else
			System.out.println("Book is Not update...");
			
	
		Book book = new Book("Core Java ", "R.S. Mehata", "Coder ", 250.75, "Best Book of Jvaa");
		Book book1 = new Book("Advance Java ", "R.S. Mehata", "Coder Technologies ", 350.75, "Best Book for Servlet and JSP");
		Book book2 = new Book("Core Python ", "S.R. Mehata", "SQuAD", 275.75, "Nice Book ");	
		Book book3 = new Book("Django", "A.K", "VS Coder", 450.75, "Best for Web application in Python");
		
		BookDao bookDao = new BookDaoImpl();
		boolean flag = bookDao.save(book);
		flag = bookDao.save(book1);
		flag = bookDao.save(book2);
		flag = bookDao.save(book3);
	
		
		BookDao bookDao = new BookDaoImpl();
		
		boolean flag = bookDao.delete(2);
		if(flag)
			System.out.println("Book is Deleted Successfully...");
		else
			System.out.println("Book is Not delete...");
		
	 
		BookDao bookDao = new BookDaoImpl();
		List<Book> blist = bookDao.getAll();
		
		if(blist!=null &&  !blist.isEmpty())
		{
		
			 // 1. By Anonymous Class.   JDK1.7
			Consumer<Book> obj = new Consumer<Book>() {
			
				@Override
				public void accept(Book book) {
					System.out.println(book);
					System.out.println("--------------------------------------------------------------------------------------------");
				}
			};
			blist.forEach(obj);
		
			// 2. LamdaExpression from JDK1.8
			// Here we  override accept method using lambdaExpresion
			Consumer<Book> obj =(book)-> {
					System.out.println(book);
					System.out.println("____________________________________________________________________________________________________");
				};
			blist.forEach(obj);
			
		
			// 3.Method Reference 
			Consumer<Book> obj = System.out::println;
			blist.forEach(obj);
		}	
	
	*/		
		BookDao bookDao = new BookDaoImpl();
		Book book = bookDao.getById(3);
		if(book!=null) {
			System.out.println("Book is Found..");
			System.out.println("------------------------------Book---------------------------");	
			System.out.println(book);
		}else
			System.out.println("Book Not Found for Given id ");
	}

	@Override
	public Set<String> getPublishers() {
		sqlQuery="select bookPublisher from book_ct2425";
		
		Set<String> publisherlist = new HashSet<>();
		try {	
			ps = con.prepareStatement(sqlQuery);
		
			rs = ps.executeQuery();
				
			while(rs.next())
			{
				publisherlist.add(rs.getString("bookPublisher"));
			}
			return publisherlist;
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public Set<String> getAuthors() {
		// TODO Auto-generated method stub
		return null;
	}

}
