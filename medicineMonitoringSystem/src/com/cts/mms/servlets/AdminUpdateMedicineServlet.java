package com.cts.mms.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

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
 * Servlet implementation class AdminUpdateMedicineServlet
 */
@WebServlet("/AdminUpdateMedicine")
public class AdminUpdateMedicineServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminUpdateMedicineServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("userId");
		
		Connection connection=null;
		Statement statement=null;
		ResultSet rs=null;
		HttpSession session=request.getSession();
				try{
			//connection=DriverManager.getConnection(connectionUrl+dbName,userId,password);
			int medicineId=0;
			AdminMedicineDao adminMedicineDao=new AdminMedicineDao();
			connection=ConnectionHandler.getConnection();
			List<AdminMedicine> medicinelist =adminMedicineDao.getAllMedicines();
			session.setAttribute("List",medicinelist);
			AdminMedicine am=new AdminMedicine();
			System.out.println(am.getMedicineId());
			session.setAttribute("medicine",am);
			System.out.println("");
			
			RequestDispatcher rd=request.getRequestDispatcher("/updateAdminData.jsp");
			rd.forward(request, response);
			
			connection.close();
		}catch(Exception e){
			e.printStackTrace();
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
