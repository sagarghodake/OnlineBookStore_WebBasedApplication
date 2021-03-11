package com.shashank.bookstore.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shashank.bookstore.dao.LoginDao;
import com.shashank.bookstore.dao.impl.LoginDaoImpl;


@WebServlet("/loginC")
public class LoginController extends HttpServlet
{
	HttpSession session;
	String action;
	
	LoginDao loginDao = new LoginDaoImpl();
	boolean flag;
	
	String usertype,username,password;
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		action = request.getParameter("action");
		System.out.println(action);
		if(action !=null && action.equalsIgnoreCase("login"))
		{
			usertype = request.getParameter("usertype");
			username = request.getParameter("username");
			password = request.getParameter("password");
			System.out.println(usertype);
			if(usertype!=null && usertype.equalsIgnoreCase("Customer"))
			{
				flag = loginDao.isCustomer(username, password);
				if(flag)
				{
					request.setAttribute("msg","Customer Login Successfull.....");
					session = request.getSession(true); // it will create a new session for customer.
					session.setAttribute("customer", username);
					request.getRequestDispatcher("index.jsp").forward(request, response);
				}
				else
				{
					request.setAttribute("errormsg","Customer Login Failed.....<br/>Please Try Again...");
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}
			}
			else if(usertype!=null && usertype.equalsIgnoreCase("Admin"))
			{
				flag = loginDao.isAdmin(username, password);
				if(flag)
				{
					request.setAttribute("msg","Admin Login Successfull.....");
					session = request.getSession(true); // it will create a new session for .
					session.setAttribute("admin", username);
					request.getRequestDispatcher("index.jsp").forward(request, response);
				}
				else
				{
					request.setAttribute("errormsg","Admin Login Failed.....<br/>Please Try Again...");
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}
			}
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		action = request.getParameter("action");
		System.out.println(action);
		if(action !=null && action.equalsIgnoreCase("logout"))
		{
			session = request.getSession(false); // get the existing session of user.
			session.invalidate();
			request.setAttribute("msg","Logout Successfull.....");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}

}
