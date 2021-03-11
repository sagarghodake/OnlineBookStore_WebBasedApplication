package com.shashank.bookstore.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection 
{
	// Connection is interface which used to store connection between database and java applicatin. 
	private static Connection con;
	private static String url="jdbc:mysql://localhost:3306/bookstore_ct2425";
	private static String user="root";
	private static String password="root";
	
	// No need any object of this because all methods are static.
	private DBConnection() {
	}
	public static Connection getConn()
	{
		if(con==null)
		{		
			try {
				//1.step for JDBC Connection
				// Register Driver
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				//2. step Establish the Connections with mysql server.
				con = DriverManager.getConnection(url, user, password);
								
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return con;
	}
	
/*	
	public static void main(String[] args) 
	{
		Connection con = DBConnection.getConn();
		if(con!=null)
			System.out.println("Connected");
		else
			System.out.println("Not Connected.");
	}
*/
}
