package com.shashank.bookstore.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.shashank.bookstore.dao.LoginDao;
import com.shashank.bookstore.utility.DBConnection;

public class LoginDaoImpl implements LoginDao 
{

	Connection con = DBConnection.getConn(); 
	PreparedStatement ps = null; // It used store sql queries.
	ResultSet rs = null; // It is used store data which retrieve by select query.

	String sqlQuery=null;

	@Override
	public boolean isAdmin(String emailIdormobileno, String password) {
		
		sqlQuery="select * from admin_ct2425 where (adminEmailId=? or adminMobileNo=?) && adminPassword=?";
		try {
				ps = con.prepareStatement(sqlQuery);
				ps.setString(1, emailIdormobileno);
				ps.setString(2, emailIdormobileno);
				ps.setString(3, password);
				
				System.out.println(ps);
				rs  = ps.executeQuery();
			
				return rs.next();
			
			}catch (Exception e)
			{
				e.printStackTrace();
			}
			
			return false;
	}

	@Override
	public boolean isCustomer(String emailIdormobileno, String password) {
		
		sqlQuery="select * from customer_ct2425 where (custEmailId=? or custMobileNo=?) && custPassword=?";
		try {
			ps = con.prepareStatement(sqlQuery);
			ps.setString(1, emailIdormobileno);
			ps.setString(2, emailIdormobileno);
			ps.setString(3, password);
			
			System.out.println(ps);
			rs  = ps.executeQuery();
			
			if(rs.next())
				return true;
			else
				return false;
			
			
			
		}catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean changePassword(String adminUsername, String adminOldPassword, String adminNewPassword) {
		//Update qeuery on admin table....
		return false;
	}

}
