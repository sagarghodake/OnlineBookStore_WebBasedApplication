package com.shashank.bookstore.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shashank.bookstore.dao.BookDao;
import com.shashank.bookstore.dao.impl.BookDaoImpl;
import com.shashank.bookstore.pojo.Book;

@WebServlet(urlPatterns = { "/","/bookC" })
public class BookController extends HttpServlet 
{
	String action;
	HttpSession session;
	
	BookDao bookDao = new BookDaoImpl();
	List<Book>booklist = null;
	Book book =null;
	boolean flag;
	int bookId;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		session = request.getSession();
		action = request.getParameter("action");
		
		if(action!=null && action.equalsIgnoreCase("Add"))
		{
			book = new Book();  // Empty book object
			book.setBookName(request.getParameter("bookName"));
			book.setBookPublisher(request.getParameter("bookPublisher"));
			book.setBookAuthor(request.getParameter("bookAuthor"));
			book.setBookPrice(Double.parseDouble(request.getParameter("bookPrice")));
			book.setBookDescription(request.getParameter("bookDescription"));
			
			flag = bookDao.save(book);
			if(flag)
			{
				request.setAttribute("msg", "Book is Added Successfully....");
				booklist = bookDao.getAll(); // after updating specific book session booklist must update.
				session.setAttribute("booklist", booklist);
				request.getRequestDispatcher("booklist.jsp").forward(request, response);
			}
			else
			{
				request.setAttribute("errormsg", "Book is Not Added ");
				request.getRequestDispatcher("bookform.jsp").forward(request, response);
			}
			
		}
		
		else if(action!=null && action.equalsIgnoreCase("Update"))
		{
			/*
			bookId = Integer.parseInt(request.getParameter("bookId"));
			bookName=request.getParameter("bookName");
			*/
			// I don't want declare variable to retrieve the value form request.
			book = new Book();  // Empty book object
			book.setBookId(Integer.parseInt(request.getParameter("bookId")));
			book.setBookName(request.getParameter("bookName"));
			book.setBookPublisher(request.getParameter("bookPublisher"));
			book.setBookAuthor(request.getParameter("bookAuthor"));
			book.setBookPrice(Double.parseDouble(request.getParameter("bookPrice")));
			book.setBookDescription(request.getParameter("bookDescription"));
			flag = bookDao.update(book);
			
			if(flag)
			{
				request.setAttribute("msg", "Book is Updated Successfully....<br/>Book Id "+book.getBookId());
				booklist = bookDao.getAll(); // after updating specific book session booklist must update.
				session.setAttribute("booklist", booklist);
				request.getRequestDispatcher("booklist.jsp").forward(request, response);
			}
			else
			{
				request.setAttribute("errormsg", "Book is Not Update ");
				request.getRequestDispatcher("bookform.jsp").forward(request, response);
			}
			
			
		}
		
		
	}
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		session = request.getSession();
		action = request.getParameter("action");
		
		
		if(action!=null && action.equalsIgnoreCase("delete"))
		{
			bookId = Integer.parseInt(request.getParameter("bookId"));
			
			flag = bookDao.delete(bookId);
			
			if(flag)
			{
				// after we need to update the booklist of session.
				booklist = bookDao.getAll();
				session.setAttribute("booklist", booklist);
				
				request.setAttribute("msg", "Book is Deleted Successfully... <br/>BookId:- "+bookId);
			}
			else
			{
				request.setAttribute("erorrmsg", "Book is Not Deleted <br/>BookId:- "+bookId);
			}
			request.getRequestDispatcher("booklist.jsp").forward(request, response);
		}
		else if(action!=null && action.equalsIgnoreCase("edit"))
		{
			bookId = Integer.parseInt(request.getParameter("bookId"));
			book = bookDao.getById(bookId);
			request.setAttribute("action", "Update");
			request.setAttribute("bookObj", book);
			request.getRequestDispatcher("bookform.jsp").forward(request, response);
			
			
		}
		else if(action!=null && action.equalsIgnoreCase("showlist"))
		{
			booklist = bookDao.getAll();
			
			session.setAttribute("booklist", booklist);
			
			// new request will send to jsp which also contain booklist because 
			//session 
			response.sendRedirect("booklist.jsp");
		}
		else if(action!=null && action.equalsIgnoreCase("searchbypublisher"))
		{
			String bookPublisher = request.getParameter("publisher");
			booklist = bookDao.getByPublisher(bookPublisher);
			
			session.setAttribute("booklist", booklist);
			
			// new request will send to jsp which also contain booklist because 
			//session 
			response.sendRedirect("booklist.jsp");
		}
		else
		{
			Set<String> publishers = bookDao.getPublishers(); 
			session.setAttribute("publishers", publishers);
			response.sendRedirect("index.jsp");
		}
		
	}
}
