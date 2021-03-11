package com.shashank.bookstore.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shashank.bookstore.dao.CustomerDao;
import com.shashank.bookstore.dao.impl.CustomerDaoImpl;
import com.shashank.bookstore.pojo.Customer;

@WebServlet("/customerC")
public class CustomerController extends HttpServlet {

	HttpSession session;
	String action;
	
	Customer cust;
	List<Customer> custlist;
	
	CustomerDao custDao = new CustomerDaoImpl();
	boolean flag = false;
	private String custEmailId;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		session = request.getSession();
		action = request.getParameter("action");
		
		if(action!= null && action.equalsIgnoreCase("Register"))
		{
			cust = new Customer(); //Empty object of Customer
			cust.setCustFName(request.getParameter("custFName"));
			cust.setCustLName(request.getParameter("custLName"));
			cust.setCustEmailId(request.getParameter("custEmailId"));
			cust.setCustMobileNo(request.getParameter("custMobileNo"));
			cust.setCustPassword(request.getParameter("custPassword"));
			cust.setCustAddress(request.getParameter("custAddress"));
			
			flag = custDao.save(cust);
			
			if(flag)
			{
				request.setAttribute("msg", "Your Registration is Successfull<br/> Now You can Access App after login ");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
			else
			{
				request.setAttribute("msg", "Your Registration is Failed<br/> Please Try Again after sometime. ");
				request.getRequestDispatcher("customerform.jsp").forward(request, response);
			}
		}
		
		else if(action!=null && action.equalsIgnoreCase("EmailVarification"))
		{
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			custEmailId = request.getParameter("custEmailId");
			
			cust = custDao.getByEmailId(custEmailId);
			
			if(cust!=null)
			{
				out.print("<br/><span style='color:red'>Email Id is Already Exists...</span>");
			}
			else
			{
				out.print("<br/><span style='color:green'>Email Id is Accepted...</span>");
			}
			out.close();
			
		}
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		session = request.getSession();
		action = request.getParameter("action");
		
		if(action!=null && action.equalsIgnoreCase("showprofile"))
		{
			custEmailId = (String)session.getAttribute("customer");
			cust = custDao.getByEmailId(custEmailId);
			request.setAttribute("custObj",cust);
			System.out.println(cust);
			request.getRequestDispatcher("profile.jsp").forward(request, response);;
			
			
		}
		
	}
	

}
