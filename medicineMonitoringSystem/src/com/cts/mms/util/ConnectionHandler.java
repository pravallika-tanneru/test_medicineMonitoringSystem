 
	package com.cts.mms.util;

	import java.sql.Connection;
	import java.sql.DriverManager;

	public class ConnectionHandler {
	public static Connection getConnection( )
	{
	Connection con=null;
	try {
	Class.forName("com.mysql.jdbc.Driver");
	con=DriverManager
	.getConnection("jdbc:mysql://localhost:3306/medicalmonitoringsystem?useSSL=false","root","VInnynaidu11*");
	}catch(Exception e) {}
	return con;
	}
	public static void main(String[] args) {
	System.out.println("pravallika"+getConnection());
	}
	
	}




    