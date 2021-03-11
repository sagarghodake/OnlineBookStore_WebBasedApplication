package com.shashank.bookstore.dao;

public interface LoginDao 
{
	boolean isAdmin(String emailIdormobileno,String password);
	boolean isCustomer(String emailIdormobileno,String password);
	boolean changePassword(String adminUsername,String adminOldPassword,String adminNewPassword);
}
