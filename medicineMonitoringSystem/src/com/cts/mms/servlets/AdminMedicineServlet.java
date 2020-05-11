package com.cts.mms.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cts.mms.dao.AdminMedicineDao;
import com.cts.mms.model.AdminMedicine;

/**
 * Servlet implementation class AdminMedicineServlet
 */
@WebServlet("/registerMedicine")
public class AdminMedicineServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AdminMedicineDao adminMedicineDao=new AdminMedicineDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminMedicineServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/medicineAdmin.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String medicineName=request.getParameter("medicineName");
		String medicineId = request.getParameter("medicineId");
		String medicineUsage = request.getParameter("medicineUsage");
		System.out.println(medicineId+ " "+medicineUsage);
		AdminMedicine adminMedicine=new AdminMedicine();
		System.out.println(adminMedicine);
		adminMedicine.setMedicineName(medicineName);
		adminMedicine.setMedicineId(Integer.parseInt(medicineId));
		adminMedicine.setMedicineUsage(medicineUsage);
		System.out.println(adminMedicine);
		try{

			adminMedicineDao.registerAdminMedicine(adminMedicine);
			}catch(ClassNotFoundException e){
				e.printStackTrace();
			}
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/adminmedicineSubmit.jsp");
			dispatcher.forward(request, response);
			
			System.out.println("servlet run");
	}

}
