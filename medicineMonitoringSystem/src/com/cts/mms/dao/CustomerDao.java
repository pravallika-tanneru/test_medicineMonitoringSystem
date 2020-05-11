package com.cts.mms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cts.mms.model.Customer;
import com.cts.mms.util.ConnectionHandler;

public class CustomerDao {
	private static Connection con=null;
	public int registerCustomer(Customer customer) throws ClassNotFoundException{
		
		String INSERT_USERS_SQL = "INSERT INTO customer"
				+ " (first_name,last_name,age,gender,phone_number,customer_id,password) VALUES " + "(?,?,?,?,?,?,?);";
		int result = 0;
		try{
			
			con=ConnectionHandler.getConnection();
			PreparedStatement preparedStatement = con.prepareStatement(INSERT_USERS_SQL);
			

			preparedStatement.setString(1, customer.getFirstName());
			preparedStatement.setString(2, customer.getLastName());
			preparedStatement.setInt(3, customer.getAge());
			preparedStatement.setString(4, customer.getGender());
			preparedStatement.setString(5, customer.getPhoneNumber());
			preparedStatement.setInt(6, customer.getCustomerId());
			preparedStatement.setString(7, customer.getPassword());
			System.out.println(preparedStatement);
			result = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

		return result;

	}
	public int loginCustomer(Customer customer){
		ResultSet rs=null;
		int result=0;
		try{
			con=ConnectionHandler.getConnection();
			String customerLogin="SELECT * FROM customer WHERE customer_id=? and password=?";
			  PreparedStatement preparedStatement = con.prepareStatement(customerLogin);
			  System.out.println("in customerDao class");
			  System.out.println(customer.getCustomerId());
			  System.out.println(customer.getPassword());
			  preparedStatement.setInt(1, customer.getCustomerId());
				preparedStatement.setString(2, customer.getPassword());
				 rs=preparedStatement.executeQuery();
				 if(rs.next()){
						result=1;
					}else{
						result=0;
					}
					
				}catch(SQLException e){
			  e.printStackTrace();
		  }
		  return result;
		  
	  }
		
	}


