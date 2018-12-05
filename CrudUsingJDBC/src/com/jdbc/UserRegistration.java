package com.jdbc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UserRegistration")
public class UserRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	DatabaseConnection dcon=new DatabaseConnection();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out=response.getWriter();
		
		String UserName=request.getParameter("username");
		String EmailId=request.getParameter("emailid");
		String Password=request.getParameter("password");
		
		try
		{
			boolean insert=dcon.insertUser(UserName,EmailId,Password);
			if(insert==true)
			{
				out.println("User register Successfully.");
			}
			else
			{
				out.println("User Not Register,Please Try Again.");
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
	}

}
