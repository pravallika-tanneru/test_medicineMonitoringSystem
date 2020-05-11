package com.cts.mms.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cts.mms.dao.AdminDao;
import com.cts.mms.model.Admin;

/**
 * Servlet implementation class AdminLoginServlet
 */
@WebServlet("/AdminLogin")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AdminDao adminDao=new AdminDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String adminId=request.getParameter("AdminId");
		int adminId1=Integer.parseInt(adminId);
		String password=request.getParameter("password");
		System.out.println("AdminId"+adminId);
		System.out.println("password"+password);
		
		Admin admin=new Admin();
		admin.setAdminId(adminId1);
		admin.setPassword(password);
		int i=adminDao.loginAdmin(admin);
		if(i==1){
			out.println("Login successful");
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/adminHome.jsp");
			dispatcher.forward(request, response);
			
			
		}else{
			out.println("Login unsuccessful!!  Your Id or password may be invalid, Please try again!");
		}
		
		
	}

}
