package com.shashank.bookstore.dao;

import java.util.List;

import com.shashank.bookstore.pojo.Cart;

public interface CartDao 
{
	boolean addToCart(Cart cart);
	List<Cart> showCart(String custEmailId); // for customer View
	List<Cart> showAllCart(); // for Admin View 
	
	boolean clearCart(String custEmailId);
	boolean deleteCartItem(int cartId);
	boolean updateCartQuantity(int cartId, int cartQuantity);
	
}
