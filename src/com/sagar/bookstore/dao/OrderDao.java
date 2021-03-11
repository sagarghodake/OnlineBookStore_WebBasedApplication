package com.shashank.bookstore.dao;

import java.sql.SQLException;
import java.util.List;

import com.shashank.bookstore.pojo.Cart;
import com.shashank.bookstore.pojo.Order;

public interface OrderDao 
{
	Order placeOrder(String custEmailId,double totalAmount);
	double getTotalAmount(String custEmailId);

	List<Order> getAllOrders();
	List<Order> getMyOrders(String custEmailId);
	
	boolean cancleOrder(int orderId);
	// Use update query to update orderStatus='cancelled'
	
	
	List<Cart> getOrderDetails(int orderId) throws SQLException;
	
}
