package com.cts.mms.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cts.mms.dao.BranchAdminDao;

import com.cts.mms.model.BranchAdmin;

/**
 * Servlet implementation class BranchAdminServlet
 */
@WebServlet("/registerBranch")
public class BranchAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BranchAdminDao branchadminDao=new BranchAdminDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BranchAdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/branchAdminRegister.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		int age = Integer.parseInt(request.getParameter("age"));
		String gender = request.getParameter("gender");
		String phoneNumber = request.getParameter("phoneNumber");
		String branchAdminId = request.getParameter("branchAdminId");
		String password = request.getParameter("password");

		System.out.println(firstName+" "+lastName+" "+age+" "+gender+ " "+phoneNumber+ " "+branchAdminId+ " "+password);
		BranchAdmin branchadmin = new BranchAdmin();
		System.out.println(branchadmin);
		branchadmin.setFirstName(firstName);
		branchadmin.setLastName(lastName);
		branchadmin.setAge(age);
		branchadmin.setGender(gender);
		branchadmin.setPhoneNumber(phoneNumber);
		branchadmin.setBranchAdminId(Integer.parseInt(branchAdminId));
		branchadmin.setPassword(password);
		System.out.println(branchadmin);
		
		try{

			branchadminDao.registerBranchAdmin(branchadmin);
			}catch(ClassNotFoundException e){
				e.printStackTrace();
			}
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/branchAdminDetails.jsp");
			dispatcher.forward(request, response);
			
			System.out.println("servlet run");
	}

}
