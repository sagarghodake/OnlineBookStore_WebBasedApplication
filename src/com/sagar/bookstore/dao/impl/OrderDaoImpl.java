package com.shashank.bookstore.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.shashank.bookstore.dao.OrderDao;
import com.shashank.bookstore.pojo.Book;
import com.shashank.bookstore.pojo.Cart;
import com.shashank.bookstore.pojo.Order;
import com.shashank.bookstore.utility.DBConnection;

public class OrderDaoImpl implements OrderDao
{
	Connection con = DBConnection.getConn();
	PreparedStatement ps = null;
	PreparedStatement ps2 = null;
	ResultSet rs = null;

	String sqlQuery=null;
	String sqlQuery2=null;
	
	@Override
	public double getTotalAmount(String custEmailId) 
	{
		sqlQuery="select sum(b.bookPrice*c.cartQuantity) as totalAmount from book_ct2425 b inner join cart_ct2425 c on(b.bookId=c.bookId) where custEmailId=?";
		try {
			ps = con.prepareStatement(sqlQuery);
			ps.setString(1, custEmailId);
			
			rs = ps.executeQuery();
			
			if(rs.next())
			{
				double amount = rs.getDouble("totalAmount");
				return amount;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public Order placeOrder(String custEmailId, double totalAmount) {
		sqlQuery = "insert into order_ct2425 (custEmailId,orderDate,totalAmount,orderStatus) values(?,?,?,?)";
		
		try
		{
			ps = con.prepareStatement(sqlQuery);
			ps.setString(1, custEmailId);
			
			//Formating date need to remove millisec
			DateTimeFormatter datetimeformate = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
			String orderDate = LocalDateTime.now().format(datetimeformate);
			ps.setTimestamp(2, Timestamp.valueOf(orderDate)); // Convert java date into sql formate.
			
			ps.setDouble(3, totalAmount);
			
			ps.setString(4, "Proccessing");
			
			int i = ps.executeUpdate();
		//	System.out.println(ps);
			if(i>0)
			{
				sqlQuery2="select * from order_ct2425 where custEmailId=? and orderDate=? ";
				ps2 = con.prepareStatement(sqlQuery2);
				
				ps2.setString(1, custEmailId);
				ps2.setTimestamp(2, Timestamp.valueOf(orderDate));
				
				rs = ps2.executeQuery();
				
				if(rs.next())
				{	
					List<Cart> orderedCartIteams = this.getOrderDetails(rs.getInt(1));
											// Orderid			CustemailId			Ostatus   		//LocalDateTime                   totalAmount
					Order order = new Order(rs.getInt(1), rs.getString(2), rs.getString(5), rs.getTimestamp(3).toLocalDateTime(), rs.getDouble(4),orderedCartIteams);
					return order;
				}
			}	
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Order> getAllOrders() {
		List<Order> orderlist = new ArrayList<Order>();
		sqlQuery = "select * from order_ct2425 ";
		try {
			ps = con.prepareStatement(sqlQuery);
			
			rs = ps.executeQuery();
			
			while (rs.next())
			{
				// Create object using setters and getters.
				Order order = new Order();
				order.setOrderId(rs.getInt(1));
				order.setCustEmailId(rs.getString(2));
				order.setOrderDate(rs.getTimestamp(3).toLocalDateTime());
				order.setTotalAmount(rs.getDouble(4));
				order.setOrderStatus(rs.getString(5));
				
				List<Cart> orderedCartItems = this.getOrderDetails(order.getOrderId());
				order.setOrderedCartItems(orderedCartItems);
				
				
				orderlist.add(order);
			}
			return orderlist;
			
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Order> getMyOrders(String custEmailId) 
	{	
		List<Order> orderlist = new ArrayList<Order>();
		sqlQuery = "select * from order_ct2425 where custEmailId=?";
		try {
			ps = con.prepareStatement(sqlQuery);
			ps.setString(1, custEmailId);
			
			rs = ps.executeQuery();
			
			while (rs.next())
			{
				// Create object using setters and getters.
				Order order = new Order();
				order.setOrderId(rs.getInt(1));
				order.setCustEmailId(rs.getString(2));
				order.setOrderDate(rs.getTimestamp(3).toLocalDateTime());
				order.setTotalAmount(rs.getDouble(4));
				order.setOrderStatus(rs.getString(5));
				
				List<Cart> orderedCartItems = this.getOrderDetails(order.getOrderId());
				order.setOrderedCartItems(orderedCartItems);
				
				
				orderlist.add(order);
			}
			return orderlist;
			
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean cancleOrder(int orderId) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public List<Cart> getOrderDetails(int orderId) throws SQLException 
	{
		List<Cart> orderedCartItems = new ArrayList<Cart>();
		sqlQuery="select * from orderdetails_ct2425 where orderId=?";
		PreparedStatement ps = con.prepareStatement(sqlQuery);
		ps.setInt(1, orderId);
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next())
		{
			Cart cart = new Cart();
			cart.setCartId(rs.getInt(2));
			cart.setBookId(rs.getInt(4));
			cart.setCartQuantity(rs.getInt(5));
			cart.setCustEmailId(rs.getString(3));
			Book book = new BookDaoImpl().getById(cart.getBookId());
			cart.setBook(book);
			orderedCartItems.add(cart);
		}
		return orderedCartItems;
	}

}
