package com.cts.mms.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cts.mms.dao.CustomerDao;
import com.cts.mms.model.Customer;

/**
 * Servlet implementation class CustomerServlet
 */
@WebServlet("/registerCustomer")
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CustomerDao customerDao=new CustomerDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/customerRegistration.jsp");
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
		String customerId = request.getParameter("customerId");
		String password = request.getParameter("password");
		System.out.println(firstName+" "+lastName+" "+age+" "+gender+ " "+phoneNumber+ " "+customerId+ " "+password);
		Customer customer = new Customer();
		System.out.println(customer);
		customer.setFirstName(firstName);
		customer.setLastName(lastName);
		customer.setAge(age);
		customer.setGender(gender);
		customer.setPhoneNumber(phoneNumber);
		customer.setCustomerId(Integer.parseInt(customerId));
		customer.setPassword(password);
		System.out.println(customer);
		
		try{

			customerDao.registerCustomer(customer);
			}catch(ClassNotFoundException e){
				e.printStackTrace();
			}
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/customerDetails.jsp");
			dispatcher.forward(request, response);
			
			System.out.println("servlet run");

	}

}
