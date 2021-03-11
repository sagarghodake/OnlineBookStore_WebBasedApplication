package com.shashank.bookstore.dao;

import java.util.List;

import com.shashank.bookstore.pojo.Customer;

public interface CustomerDao
{
	boolean save(Customer customer);
	boolean update(Customer customer);
	boolean delete(int custId);
	List<Customer> getAll();
	Customer getById(int custId);
	Customer getByEmailId(String custEmailId);
}
