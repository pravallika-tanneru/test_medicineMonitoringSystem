package com.cts.mms.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cts.mms.model.AdminMedicine;
import com.cts.mms.util.ConnectionHandler;

public class AdminMedicineDao {
	private static Connection con=null;
	public int registerAdminMedicine(AdminMedicine adminMedicine)throws ClassNotFoundException {
		String INSERT_USERS_SQL = "INSERT INTO medicines"
				+ " (medicine_name,medicine_id,medicine_usage) VALUES " + "(?,?,?);";
		int result = 0;
		try{
			con=ConnectionHandler.getConnection();
		
			
			PreparedStatement preparedStatement = con.prepareStatement(INSERT_USERS_SQL);
			preparedStatement.setString(1,adminMedicine.getMedicineName());
			preparedStatement.setInt(2, adminMedicine.getMedicineId());
			preparedStatement.setString(3, adminMedicine.getMedicineUsage());
			

	
		System.out.println(preparedStatement);
		result = preparedStatement.executeUpdate();
	} catch (SQLException e) {
		
		e.printStackTrace();
	}

	return result;
	
}
	public AdminMedicine getMedicine(int medicineId){
		String SELECT_medicine_SQL = "SELECT * FROM medicines WHERE medicine_id=?";
		
		String medicineName=null;
		
		ResultSet resultSet=null;	
		AdminMedicine adminMedicine=new AdminMedicine();
		System.out.println("in dao :"+medicineId);
		try{
			con=ConnectionHandler.getConnection();
		
			
			PreparedStatement preparedStatement = con.prepareStatement(SELECT_medicine_SQL);
			preparedStatement.setInt(1, medicineId);
		
			
		System.out.println(preparedStatement);
		resultSet= preparedStatement.executeQuery();
		if(resultSet.next()){	
			
			adminMedicine.setMedicineName(resultSet.getString("medicine_name"));
			adminMedicine.setMedicineId(resultSet.getInt("medicine_id"));
			adminMedicine.setMedicineUsage(resultSet.getString("medicine_usage"));
			
			
		}
	} catch (SQLException e) {
		
		e.printStackTrace();
	}

	return adminMedicine;
	}
	public List getAllMedicines(){
		
			String SELECT_USERS_SQL = "SELECT * FROM medicines";
			
			String medicineName=null;
			int medicineId=0;
			String medicineUsage=null;
			ResultSet resultSet=null;	
			List <AdminMedicine>list=new ArrayList<>();
			try{
				con=ConnectionHandler.getConnection();
			
				
				PreparedStatement preparedStatement = con.prepareStatement(SELECT_USERS_SQL);
				
				
			System.out.println(preparedStatement);
			resultSet= preparedStatement.executeQuery();
			while(resultSet.next()){
				//medicineName=resultSet.getString(1);
				//medicineId=resultSet.getInt(2);
				//medicineUsage=resultSet.getString(3);
				AdminMedicine adminMedicine=new AdminMedicine();
				adminMedicine.setMedicineName(resultSet.getString("medicine_name"));
				adminMedicine.setMedicineId(resultSet.getInt("medicine_id"));
				adminMedicine.setMedicineUsage(resultSet.getString("medicine_usage"));
				list.add(adminMedicine);
				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

		return list;
	}
	public int editMedicine(AdminMedicine adminMedicine){
		String UPDATE_medicines_SQL = "UPDATE  medicines SET medicine_name=?,medicine_usage=? WHERE medicine_id=?";
		int result=0;
		String medicineName=null;
		int medicineId1=0;
		String medicineUsage=null;
		
		//List <AdminMedicine>list=new ArrayList<>();
		try{
			con=ConnectionHandler.getConnection();
		
			
			PreparedStatement preparedStatement = con.prepareStatement(UPDATE_medicines_SQL);
			preparedStatement.setString(1, adminMedicine.getMedicineName());
			preparedStatement.setString(2,adminMedicine.getMedicineUsage());
			preparedStatement.setInt(3, adminMedicine.getMedicineId());
			
			
		System.out.println(preparedStatement);
		 result=preparedStatement.executeUpdate();
		
			
		
	} catch (SQLException e) {
		
		e.printStackTrace();
	}

	return result;
		
	}
}
