package com.cts.mms.servlets;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cts.mms.dao.AdminMedicineDao;
import com.cts.mms.model.AdminMedicine;
import com.cts.mms.util.ConnectionHandler;

/**
 * Servlet implementation class AdminUpdateMedicineServlet1
 */
@WebServlet("/AdminUpdateMedicine1")
public class AdminUpdateMedicineServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminUpdateMedicineServlet1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try{
			//connection=DriverManager.getConnection(connectionUrl+dbName,userId,password);
			int medicineId=0;
			medicineId=Integer.parseInt(request.getParameter("medicineId"));
			
			AdminMedicineDao adminMedicineDao=new AdminMedicineDao();
			AdminMedicine am=adminMedicineDao.getMedicine(medicineId);
			//Connection con=ConnectionHandler.getConnection();
			HttpSession session=request.getSession();
			session.setAttribute("medicine",am);
			//String medicineId1=(String)session.getAttribute("medicineId");
			System.out.println(medicineId);
		//(AdminMedicine)session.getAttribute("medicineId");
		System.out.println("in update medicines servlet"+am.getMedicineId());
		RequestDispatcher rd=request.getRequestDispatcher("/updateMedicines.jsp");
		rd.forward(request, response);
		//	con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		 
	}
		
			protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
