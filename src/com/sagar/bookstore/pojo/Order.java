package com.shashank.bookstore.pojo;

import java.time.LocalDateTime;
import java.util.List;

public class Order 
{
	private int orderId;
	private String custEmailId,orderStatus;
	private LocalDateTime orderDate;
	private double totalAmount;
	
	private List<Cart> OrderedCartItems;
	
	//Empty constructor
	//It used initialize object with default values.
	public Order() {
	}
	
	public Order(int orderId, String custEmailId, String orderStatus, LocalDateTime orderDate, double totalAmount,
			List<Cart> orderedCartItems) {
		super();
		this.orderId = orderId;
		this.custEmailId = custEmailId;
		this.orderStatus = orderStatus;
		this.orderDate = orderDate;
		this.totalAmount = totalAmount;
		OrderedCartItems = orderedCartItems;
	}
	
	

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", custEmailId=" + custEmailId + ", orderStatus=" + orderStatus
				+ ", orderDate=" + orderDate + ", totalAmount=" + totalAmount + ", OrderedCartItems=" + OrderedCartItems
				+ "]";
	}

	public List<Cart> getOrderedCartItems() {
		return OrderedCartItems;
	}

	public void setOrderedCartItems(List<Cart> orderedCartItems) {
		OrderedCartItems = orderedCartItems;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getCustEmailId() {
		return custEmailId;
	}

	public void setCustEmailId(String custEmailId) {
		this.custEmailId = custEmailId;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public LocalDateTime getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	
	
	
}
