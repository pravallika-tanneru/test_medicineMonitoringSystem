package com.cts.mms.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cts.mms.dao.AdminMedicineDao;
import com.cts.mms.model.AdminMedicine;

/**
 * Servlet implementation class AdminEditServlet
 */
@WebServlet("/MedicineEdit")
public class MedicineEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AdminMedicineDao adminMedicineDao=new AdminMedicineDao();
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int medicineId=Integer.parseInt(request.getParameter("medicineId"));
		 AdminMedicine adminMedicine=new AdminMedicine();
  	   adminMedicine.setMedicineId(medicineId);
  	   adminMedicine.setMedicineName(request.getParameter("medicineName"));
  			   adminMedicine.setMedicineUsage(request.getParameter("medicineUsage"));
  			 //  AdminMedicineDao adminMedicineDao=new AdminMedicineDao();
  			   //adminMedicineDao.editMedicine(medicineId);
		PrintWriter out=response.getWriter();
		//out.println("<h1>"+medicineId+"</h1>");
		int k=adminMedicineDao.editMedicine(adminMedicine);
		if(k==1){
			out.println("edited");
			
		}else{
			out.println("not edited");
		}
			
		
	}
  
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
