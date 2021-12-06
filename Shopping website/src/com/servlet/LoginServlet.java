package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.connector.DbConn;
import com.dao.UserDao;
import com.initiate.User;


/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		
		PrintWriter out=response.getWriter();
		
		//accepting username and password from loginForm.html
		String Email=request.getParameter("email"); 
		String Pass=request.getParameter("password");
		
		//database
		try {
			  System.out.println("inside try one");
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con;
				try
				{
					System.out.println("inside try second");
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proj","root","Delete@36");
					Statement stmt= con.createStatement();
					ResultSet rs=stmt.executeQuery("SELECT email,password FROM users;");
					boolean flag=false;
					while(rs.next())
					{
						String usertmp=rs.getString(1);
						String passtmp=rs.getString(2);
						
						if(usertmp.equals(Email)&&passtmp.equals(Pass))
						{
							System.out.println("Data :"+usertmp);
							System.out.println("Data :"+passtmp);
							flag=true;
					     }
					}
					if(flag)
					{
						System.out.println("inside if");
						//if username and password true then go to transaction.html 
						response.sendRedirect("Store.html");
					}
					else //if wrong username and password 
					{
						System.out.println("inside else");
					
						out.println("<script type=\"text/javascript\">alert('Please Register!');");
						
						out.println("location='Register.html';");
						
						out.println("</script>");
					}
					con.close();
				} 
				catch (SQLException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
		}
		catch (ClassNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	}
