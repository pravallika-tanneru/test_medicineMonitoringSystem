package com.cts.mms.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cts.mms.dao.BranchAdminMedicineDao;
import com.cts.mms.model.BranchAdminMedicine;

/**
 * Servlet implementation class BranchAdminMedicineServlet
 */
@WebServlet("/registerBranchMedicine")
public class BranchAdminMedicineServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BranchAdminMedicineDao branchAdminMedicineDao=new BranchAdminMedicineDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BranchAdminMedicineServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/medicineBranchAdmin.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String branchName=request.getParameter("branchName");
		String medicineName=request.getParameter("medicineName");
		String medicineId = request.getParameter("medicineId");
		String medicineUsage = request.getParameter("medicineUsage");
		System.out.println(medicineId+ " "+medicineUsage);
		BranchAdminMedicine branchAdminMedicine=new BranchAdminMedicine();
		System.out.println(branchAdminMedicine);
		branchAdminMedicine.setBranchName(branchName);
		branchAdminMedicine.setMedicineName(medicineName);
		branchAdminMedicine.setMedicineId(Integer.parseInt(medicineId));
		branchAdminMedicine.setMedicineUsage(medicineUsage);
		System.out.println(branchAdminMedicine);
		try{

			branchAdminMedicineDao.registerBranchAdminMedicine(branchAdminMedicine);
			}catch(ClassNotFoundException e){
				e.printStackTrace();
			}
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/branchAdminMedicineSubmit.jsp");
			dispatcher.forward(request, response);
			
			System.out.println("servlet run");
	}

}
