package com.cts.mms.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cts.mms.dao.CustomerDao;
import com.cts.mms.model.Customer;

/**
 * Servlet implementation class CustomerLoginServlet
 */
@WebServlet("/customerLogin")
public class CustomerLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CustomerDao customerDao=new CustomerDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String customerId=request.getParameter("customerId");
		int customerId1=Integer.parseInt(customerId);
		String password=request.getParameter("password");
		System.out.println("CustomerId"+customerId);
		System.out.println("password"+password);
		
		Customer customer=new Customer();
		customer.setCustomerId(customerId1);
		customer.setPassword(password);
		int i=customerDao.loginCustomer(customer);
		if(i==1){
			out.println("Login successful");
		}else{
			out.println("Login unsuccessful!!  Your Id or password may be invalid, Please try again!");
		}
		
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/customerHome.jsp");
		dispatcher.forward(request, response);
	}

}
