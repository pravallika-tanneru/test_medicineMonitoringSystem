package com.cts.mms.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cts.mms.dao.BranchAdminDao;
import com.cts.mms.model.BranchAdmin;

/**
 * Servlet implementation class BranchAdminLoginServlet
 */
@WebServlet("/BranchAdminLogin")
public class BranchAdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BranchAdminDao branchadminDao=new BranchAdminDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BranchAdminLoginServlet() {
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
		String branchAdminId=request.getParameter("branchAdminId");
		int branchAdminId1=Integer.parseInt(branchAdminId);
		String password=request.getParameter("password");
		System.out.println("BranchAdminId"+branchAdminId);
		System.out.println("password"+password);
		
		BranchAdmin branchadmin=new BranchAdmin();
		branchadmin.setBranchAdminId(branchAdminId1);
		branchadmin.setPassword(password);
		int i=branchadminDao.loginBranchAdmin(branchadmin);
		if(i==1){
			out.println("Login successful");
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/branchAdminHome.jsp");
			dispatcher.forward(request, response);
		}else{
			out.println("Login unsuccessful!!  Your Id or password may be invalid, Please try again!");
		}
	}

}
