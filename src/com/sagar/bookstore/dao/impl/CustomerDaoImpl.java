package com.shashank.bookstore.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shashank.bookstore.dao.CustomerDao;
import com.shashank.bookstore.pojo.Customer;
import com.shashank.bookstore.utility.DBConnection;

public class CustomerDaoImpl implements CustomerDao
{
	Connection con = DBConnection.getConn();
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	String sqlQuery;

	@Override
	public boolean save(Customer customer) {
		
		sqlQuery = "insert into customer_ct2425 (custFName,custLName,custEmailId,custMobileNo,custPassword,custAddress) values(?,?,?,?,?,?)";
		
		try {
			ps = con.prepareStatement(sqlQuery);
			ps.setString(1, customer.getCustFName());
			ps.setString(2, customer.getCustLName());
			ps.setString(3, customer.getCustEmailId());
			ps.setString(4, customer.getCustMobileNo());
			ps.setString(5, customer.getCustPassword());
			ps.setString(6, customer.getCustAddress());
			
			int i = ps.executeUpdate();
			if(i>0)
			{
				return true;
			}
			
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(Customer cust) {
		sqlQuery="update customer_ct2425 set custFName=?,custLName=?,custEmailId=?,custMobileNo=?,custPassword=?,custAddress=? where custId=?";
		
		try {
			ps = con.prepareStatement(sqlQuery);

			ps.setString(1, cust.getCustFName());
			ps.setString(2, cust.getCustLName());
			ps.setString(3, cust.getCustEmailId());
			ps.setString(4, cust.getCustMobileNo());
			ps.setString(5, cust.getCustPassword());
			ps.setString(6, cust.getCustAddress());
			ps.setInt(7, cust.getCustId());
			int i  = ps.executeUpdate();
			if (i > 0)
				return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		return false;
	}

	@Override
	public boolean delete(int custId) {
		sqlQuery="delete from customer_ct2425 where custId=?";
		try {
			ps = con.prepareStatement(sqlQuery);
			ps.setInt(1, custId);
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
	public List<Customer> getAll() {
		sqlQuery="select * from customer_ct2425";
		List<Customer> custlist = new ArrayList<Customer>();
		
		try {
			ps = con.prepareStatement(sqlQuery);
			rs = ps.executeQuery();

			while (rs.next()) {
				Customer cust = new Customer();
				cust.setCustId(rs.getInt(1));
				cust.setCustFName(rs.getString(2));
				cust.setCustLName(rs.getString(3));
				cust.setCustEmailId(rs.getString(4));
				cust.setCustMobileNo(rs.getString(5));
				cust.setCustPassword(rs.getString(6));
				cust.setCustAddress(rs.getString(7));

				custlist.add(cust);
			}

			if (custlist.isEmpty()) {
				return null;
			} else {
				return custlist;
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Customer getById(int custId) {
		sqlQuery="select * from customer_ct2425 where custId=?";
		sqlQuery = "select * from customer where custId=?";
		try {
			ps = con.prepareStatement(sqlQuery);
			ps.setInt(1, custId);
			rs = ps.executeQuery();

			while (rs.next()) {
				Customer cust = new Customer();
				cust.setCustId(rs.getInt(1));
				cust.setCustFName(rs.getString(2));
				cust.setCustLName(rs.getString(3));
				cust.setCustEmailId(rs.getString(4));
				cust.setCustMobileNo(rs.getString(5));
				cust.setCustPassword(rs.getString(6));
				cust.setCustAddress(rs.getString(7));

				return cust;
			}

			

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Customer getByEmailId(String custEmailId) {
		
		sqlQuery="select * from customer_ct2425 where custEmailId=?";
		try {
			ps = con.prepareStatement(sqlQuery);
			ps.setString(1, custEmailId);
			rs = ps.executeQuery();

			while (rs.next()) {
				Customer cust = new Customer();
				cust.setCustId(rs.getInt(1));
				cust.setCustFName(rs.getString(2));
				cust.setCustLName(rs.getString(3));
				cust.setCustEmailId(rs.getString(4));
				cust.setCustMobileNo(rs.getString(5));
				cust.setCustPassword(rs.getString(6));
				cust.setCustAddress(rs.getString(7));

				return cust;
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;

	}

}
