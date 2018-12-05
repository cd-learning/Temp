package com.jdbc;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Connection;

public class DatabaseConnection 
{
	String connectionUrl="jdbc:mysql://localhost:3307/test";
	String userName="root";
	String Password="root";
	Connection con=null;
	
	public void connect()
	{
		try
		{
			if(con==null)
			{
				Class.forName("com.mysql.jdbc.Driver");
				con=(Connection)DriverManager.getConnection(connectionUrl,userName, Password);
				System.out.println("Connected successfully to database.");
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Not Connected to database."+e);
		}
	} 
	
	public void disConnect()
	{
		if(con!=null)
		{
			try
			{
				con.close();
			}
			catch (SQLException e)
			{	
				e.printStackTrace();
			}
		}
	}
	
	public boolean insertUser(String UserName,String EmailId,String Password) throws SQLException
	{
		String insertQuery="INSERT INTO userregistration (UserName, EmailId, Password) VALUES (?, ?, ?)";
			
		connect();
			
		PreparedStatement statement=con.prepareStatement(insertQuery);
		statement.setString(1, UserName);
		statement.setString(2, EmailId);
		statement.setString(3, Password);
		boolean insert=statement.executeUpdate() > 0;
		
		statement.close();
		disConnect();
		
		return insert;
	}
	
	public ResultSet fetchUser() throws SQLException
	{
		String fetchQuery="SELECT * FROM userregistration";
		
		connect();
			
		Statement statement=con.createStatement();
		ResultSet resultset=statement.executeQuery(fetchQuery);
		
		statement.close();
		return resultset;
		
		
	}
}
