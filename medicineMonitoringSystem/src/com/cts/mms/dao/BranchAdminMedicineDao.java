package com.cts.mms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.cts.mms.model.BranchAdminMedicine;
import com.cts.mms.util.ConnectionHandler;

public class BranchAdminMedicineDao {
	
	private static Connection con=null;
	public int registerBranchAdminMedicine(BranchAdminMedicine branchAdminMedicine)throws ClassNotFoundException {
		String INSERT_USERS_SQL = "INSERT INTO BRANCH_MEDICINES"
				+ " (branch_name,medicine_name,medicine_id,medicine_usage) VALUES " + "(?,?,?,?);";
		int result = 0;
		try{
			con=ConnectionHandler.getConnection();
			PreparedStatement preparedStatement = con.prepareStatement(INSERT_USERS_SQL);
			preparedStatement.setString(1, branchAdminMedicine.getBranchName());
			preparedStatement.setString(2,branchAdminMedicine.getMedicineName());
			preparedStatement.setInt(3, branchAdminMedicine.getMedicineId());
			preparedStatement.setString(4, branchAdminMedicine.getMedicineUsage());
			System.out.println(preparedStatement);
			result = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

		return result;
			

	}
}


