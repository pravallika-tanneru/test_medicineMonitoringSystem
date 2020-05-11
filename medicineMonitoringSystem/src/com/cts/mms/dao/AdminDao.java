package com.cts.mms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.cts.mms.model.Admin;
import com.cts.mms.util.ConnectionHandler;

public class AdminDao {
	
	private static Connection con=null;
	public  int registerAdmin(Admin admin) throws ClassNotFoundException {
		
		String INSERT_USERS_SQL = "INSERT INTO admin"
				+ " (first_name,last_name,age,gender,phone_number,admin_id,password) VALUES " + "(?,?,?,?,?,?,?);";
		int result = 0;
		try{
			con=ConnectionHandler.getConnection();
		
			
			PreparedStatement preparedStatement = con.prepareStatement(INSERT_USERS_SQL);
			

			preparedStatement.setString(1, admin.getFirstName());
			preparedStatement.setString(2, admin.getLastName());
			preparedStatement.setInt(3, admin.getAge());
			preparedStatement.setString(4, admin.getGender());
			preparedStatement.setString(5, admin.getPhoneNumber());
			preparedStatement.setInt(6, admin.getAdminId());
			preparedStatement.setString(7, admin.getPassword());

			System.out.println(preparedStatement);
			result = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

		return result;
	}
  public int loginAdmin(Admin admin){
	  ResultSet rs=null;
	  int result=0;
	  try{
		  con=ConnectionHandler.getConnection();
		  String adminLogin="SELECT * FROM admin WHERE admin_id=? and password=?";
		  PreparedStatement preparedStatement = con.prepareStatement(adminLogin);
		  System.out.println("in adminDao");
		  System.out.println(admin.getAdminId());
		  System.out.println(admin.getPassword());
		  preparedStatement.setInt(1, admin.getAdminId());
			preparedStatement.setString(2, admin.getPassword());
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

