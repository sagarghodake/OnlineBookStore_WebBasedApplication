package com.shashank.bookstore.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shashank.bookstore.dao.OrderDao;
import com.shashank.bookstore.dao.impl.OrderDaoImpl;
import com.shashank.bookstore.pojo.Order;

/**
 * Servlet implementation class OrderController
 */
@WebServlet("/orderC")
public class OrderController extends HttpServlet {
	
	HttpSession session;
	String action;
	
	Order order;
	OrderDao orderDao = new OrderDaoImpl();
	
	List<Order> orderlist;
	
	String custEmailId;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		session = request.getSession();
		action = request.getParameter("action");
		custEmailId=(String)session.getAttribute("customer");
		
		if(action!=null && action.equalsIgnoreCase("placeorder"))
		{
		/*	
			// if Cart Item Quantity is not updated in database 
			// i.e AJAX was not implemented 
			String cartQuantity [] = request.getParameterValues("cartQuantity");;
			String bookPrice [] = request.getParameterValues("bookPrice");
			double totalPrice=0;
			for (int i = 0; i < bookPrice.length; i++) 
			{
				totalPrice = totalPrice + (Integer.parseInt(cartQuantity[i]) * Double.parseDouble(bookPrice[i]));
			}
			System.out.println("Total Price :- "+totalPrice);
		*/	
			double totalPrice1 = orderDao.getTotalAmount(custEmailId);
			
			order = orderDao.placeOrder(custEmailId, totalPrice1);
			
			if(order!=null)
			{
				request.setAttribute("order", order);
				request.setAttribute("msg", "Your Order has been placed Successfully...");
				request.getRequestDispatcher("order.jsp").forward(request, response);
			}
			else
			{
				request.setAttribute("errormsg", "Your Order is not Placed<br/> Please Try Again...");
				request.getRequestDispatcher("cartlist.jsp").forward(request, response);
			}
			
		}
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		session = request.getSession();
		action = request.getParameter("action");
		
		if(action!=null && action.equalsIgnoreCase("showmyorders"))
		{
			custEmailId = (String)session.getAttribute("customer");
			orderlist = orderDao.getMyOrders(custEmailId);
			session.setAttribute("orderlist", orderlist);
			response.sendRedirect("orderlist.jsp");
			
		}
		else if(action!=null && action.equalsIgnoreCase("showallorders"))
		{
			orderlist = orderDao.getAllOrders();
			session.setAttribute("orderlist", orderlist);
			response.sendRedirect("orderlist.jsp");
		}
	}

}
