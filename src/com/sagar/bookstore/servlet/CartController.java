package com.shashank.bookstore.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shashank.bookstore.dao.CartDao;
import com.shashank.bookstore.dao.impl.CartDaoImpl;
import com.shashank.bookstore.pojo.Cart;

/**
 * Servlet implementation class CartController
 */
@WebServlet("/cartC")
public class CartController extends HttpServlet
{
	HttpSession session;
	private String custEmailId;
	private int bookId;
	private Cart cart;
	
	CartDao cartDao = new CartDaoImpl();
	boolean flag;
	private String action;
	
	List<Cart> cartlist;
	private int cartId,cartQuantity;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		action = request.getParameter("action");
		System.out.println(action);
		session = request.getSession();
		custEmailId = (String)session.getAttribute("customer");
		
		if(action!=null && action.equals("addtocart"))
		{
			if(custEmailId !=null)
			{
				bookId = Integer.parseInt(request.getParameter("bookId"));
				System.out.println("Add to cart bookid:- "+bookId+"\ncustomer EmailId- "+custEmailId);
				
				cart = new Cart(bookId, custEmailId, 1);
				
				flag = cartDao.addToCart(cart);
				
				if(flag)
				{
					request.setAttribute("msg","Book is Added into Your cart Successfully...<br/>Book Id :- "+bookId);
				}
				else
				{
					request.setAttribute("msg","Book is Not  Added into Your cart <br/>Please Try Again....");
				}
				request.getRequestDispatcher("booklist.jsp").forward(request, response);
				
			}
			else
			{
				request.setAttribute("msg", "Please Login before add to cart... ");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}	
		}
		else if(action!=null && action.equals("showmycart"))
		{
			if(custEmailId!=null)
			{
				cartlist = cartDao.showCart(custEmailId);
				session.setAttribute("cartlist", cartlist);
				response.sendRedirect("cartlist.jsp");
			}
		}
		else if(action!=null && action.equalsIgnoreCase("delete"))
		{
			if(custEmailId!=null)
			{
				cartId = Integer.parseInt(request.getParameter("cartId"));
				flag = cartDao.deleteCartItem(cartId);
						
				if(flag)
				{
					cartlist = cartDao.showCart(custEmailId);
					session.setAttribute("cartlist", cartlist);
					
					request.setAttribute("msg", "Book is Deleted form Cart Successfully... <br/>cart Item Id:- "+cartId);
				}
				else
				{
					request.setAttribute("erorrmsg", "Book is Not Deleted <br/>cart Iteam id :- "+cartId);
				}
				request.getRequestDispatcher("cartlist.jsp").forward(request, response);
			}
		}
	}


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		session = request.getSession();
		action = request.getParameter("action");
		
		if(action!=null && action.equalsIgnoreCase("updateCartQty"))
		{
			response.setContentType("text/html");
			cartId = Integer.parseInt(request.getParameter("cartId"));
			cartQuantity = Integer.parseInt(request.getParameter("cartQuantity"));
			
			flag = cartDao.updateCartQuantity(cartId,cartQuantity);
			
			if(flag==true) 
			{
				custEmailId = (String)session.getAttribute("customer");
				cartlist = cartDao.showCart(custEmailId);
				session.setAttribute("cartlist", cartlist);
				response.getWriter().print("Cart is updated...");
			}
		}
	}
}
