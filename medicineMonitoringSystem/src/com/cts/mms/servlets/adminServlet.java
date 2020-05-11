package com.cts.mms.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cts.mms.dao.AdminDao;
import com.cts.mms.model.Admin;

/**
 * Servlet implementation class adminServlet
 */
@WebServlet("/registerUser")
public class adminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AdminDao adminDao = new AdminDao();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public adminServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/adminRegister.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		int age = Integer.parseInt(request.getParameter("age"));
		String gender = request.getParameter("gender");
		String phoneNumber = request.getParameter("phoneNumber");
		String adminId = request.getParameter("adminId");
		String password = request.getParameter("password");

		System.out.println(firstName+" "+lastName+" "+age+" "+gender+ " "+phoneNumber+ " "+adminId+ " "+password);
		Admin admin = new Admin();
		System.out.println(admin);
		admin.setFirstName(firstName);
		admin.setLastName(lastName);
		admin.setAge(age);
		admin.setGender(gender);
		admin.setPhoneNumber(phoneNumber);
		admin.setAdminId(Integer.parseInt(adminId));
		admin.setPassword(password);
		System.out.println(admin);
		
		try{

		adminDao.registerAdmin(admin);
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/adminDetails.jsp");
		dispatcher.forward(request, response);
		
		System.out.println("servlet run");
	}
}
