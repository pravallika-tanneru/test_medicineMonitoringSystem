package com.cts.mms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cts.mms.model.BranchAdmin;
import com.cts.mms.util.ConnectionHandler;

public class BranchAdminDao {
	private static Connection con=null;
	public int registerBranchAdmin(BranchAdmin branchadmin)throws ClassNotFoundException{
		
		String INSERT_USERS_SQL = "INSERT INTO branchadmin"
				+ " (first_name,last_name,age,gender,phone_number,branch_admin_id,password) VALUES " + "(?,?,?,?,?,?,?);";
		int result = 0;
		try{
			con=ConnectionHandler.getConnection();
		
			
			PreparedStatement preparedStatement = con.prepareStatement(INSERT_USERS_SQL);
			

			preparedStatement.setString(1, branchadmin.getFirstName());
			preparedStatement.setString(2, branchadmin.getLastName());
			preparedStatement.setInt(3, branchadmin.getAge());
			preparedStatement.setString(4, branchadmin.getGender());
			preparedStatement.setString(5, branchadmin.getPhoneNumber());
			preparedStatement.setInt(6, branchadmin.getBranchAdminId());
			preparedStatement.setString(7, branchadmin.getPassword());

			System.out.println(preparedStatement);
			result = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

		return result;
	}
	public int loginBranchAdmin(BranchAdmin branchadmin){
		ResultSet rs=null;
		int result=0;
		try{
			con=ConnectionHandler.getConnection();
			String branchAdminLogin="SELECT * FROM branchadmin WHERE branch_admin_id=? and password=?";
			PreparedStatement preparedStatement=con.prepareStatement(branchAdminLogin);
			System.out.println("in branchadmin dao class");
			System.out.println(branchadmin.getBranchAdminId());
			System.out.println(branchadmin.getPassword());
			preparedStatement.setInt(1, branchadmin.getBranchAdminId());
			preparedStatement.setString(2, branchadmin.getPassword());
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


