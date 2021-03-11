package com.shashank.bookstore.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import com.shashank.bookstore.dao.BookDao;
import com.shashank.bookstore.dao.CartDao;
import com.shashank.bookstore.pojo.Book;
import com.shashank.bookstore.pojo.Cart;
import com.shashank.bookstore.utility.DBConnection;

public class CartDaoImpl implements CartDao 
{
	Connection con = DBConnection.getConn();
	
	PreparedStatement ps =null;
	ResultSet rs =null;
	
	String sqlQuery = null;

	@Override
	public boolean addToCart(Cart cart) 
	{
		sqlQuery = "insert into cart_ct2425 (custEmailId,bookId,cartQuantity) values (?,?,?)";
			
		try {
			ps = con.prepareStatement(sqlQuery);
			ps.setString(1, cart.getCustEmailId());
			ps.setInt(2, cart.getBookId());
			ps.setInt(3, cart.getCartQuantity());
			
			int i = ps.executeUpdate();
			
			if(i>0)
				return true;
		}
		catch(SQLIntegrityConstraintViolationException e)
		{
			System.out.println("Please Enter the Valid Data");			
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Cart> showCart(String custEmailId)
	{
		List<Cart> cartlist = new ArrayList<Cart>();
		sqlQuery = "select * from cart_ct2425 where custEmailId=?";
		try {
			ps = con.prepareStatement(sqlQuery);
			ps.setString(1, custEmailId);
			
			rs = ps.executeQuery();
			while(rs.next())
			{
				int bookId = rs.getInt(3);
				Book book = new BookDaoImpl().getById(bookId);
				// here we call getById method by Un refernece object.
				
									// cartId		bookId			EmailId		//cartQuantity //book class object 
				Cart cart = new Cart(rs.getInt(1), rs.getInt(3), rs.getString(2), rs.getInt(4), book);
				
				cartlist.add(cart);
			}
			return cartlist;
			
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<Cart> showAllCart() {
		
		return null;
	}

	@Override
	public boolean clearCart(String custEmailId) {
		sqlQuery="delete from cart_ct2425 where custEmailId=?";
		try {
			ps = con.prepareStatement(sqlQuery);
			ps.setString(1, custEmailId);
			int i = ps.executeUpdate();
			if (i > 0) {
				return true;
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteCartItem(int cartId) {
		
		return false;
	}

	@Override
	public boolean updateCartQuantity(int cartId, int cartQuantity) {
		sqlQuery="update cart_ct2425 set cartQuantity=? where cartId=?";
		try {
			ps = con.prepareStatement(sqlQuery);
			ps.setInt(1, cartQuantity);
			ps.setInt(2, cartId);
			int i = ps.executeUpdate();
			System.out.println(ps);
			if (i > 0) {
				return true;
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return false;
	}

}
