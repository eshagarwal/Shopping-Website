package com.connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConn {
	private static Connection con=null;
	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		if(con==null)
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con =DriverManager.getConnection("jdbc:mysql://@localhost:3306/proj","root","Delete@36");
			System.out.println("connected");
		}
		return con;
}
}