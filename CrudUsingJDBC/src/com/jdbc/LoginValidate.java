package com.jdbc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/LoginValidate")
public class LoginValidate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    DatabaseConnection dcon=new DatabaseConnection();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out=response.getWriter();
		
		String UserName=request.getParameter("username");
		String Password=request.getParameter("password");
		
		try
		{
			ResultSet fetchUser=dcon.fetchUser();
			while(fetchUser.next())
			{
				String userName=fetchUser.getString("UserName");
				String password=fetchUser.getString("Password");
				
				if(UserName.equals(userName) && Password.equals(password))
				{
					HttpSession session=request.getSession();
					session.setAttribute("UserName", userName);
					
					response.sendRedirect("ShowUserDetails.jsp");
				}
				else
				{
					out.println("You have enter wrong username and password.");
					RequestDispatcher rd=request.getRequestDispatcher("Login.jsp");
					rd.include(request, response);
				}
			}
			fetchUser.close();
			dcon.disConnect();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
	}

}
