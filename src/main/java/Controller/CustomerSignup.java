package Controller;

 

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.CustomerDao;
import Dto.Customer;
@WebServlet("/customersignup")
public class CustomerSignup extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String custname  =req.getParameter("custname");
		String custmobile  =req.getParameter("mobile");
		String password  =req.getParameter("password");
		String email  =req.getParameter("email");
		String gender  =req.getParameter("gender");
		String dob  =req.getParameter("dob");
		
		
	long mobile	   =Long.parseLong(custmobile);
		
	/*	resp.getWriter().println("<h1>Name:"+custname+"<h1>");
		resp.getWriter().println("<h1>Mobile:"+custmobile+"<h1>");
		resp.getWriter().println("<h1>password:"+password+"<h1>");
		resp.getWriter().println("<h1>email:"+email+"<h1>");
		resp.getWriter().println("<h1>geneder:"+gender+"<h1>");
		resp.getWriter().println("<h1>Dob:"+dob+"<h1>");*/
		
	/*	resp.getWriter().println("<h1>Name:"+custname+"<h1>"
				+ "<h1>Mobile:"+custmobile+"<h1>"
				+ "<h1>Password:"+password+"<h1>"
				+ "<h1>Email:"+email+"<h1>"
				+ "<h1>Gender:"+gender+"<h1>"
				+ "<h1>Dob:"+dob+"<h1>");*/
			
		Date date   =Date.valueOf(dob);
		
	Period period	 =Period.between(date.toLocalDate(),LocalDate.now());
	
	  int age     =period.getYears();
	
	if(age<18)
	{
		resp.getWriter().print("<h1>You are not eligible to create account<h1>");
	}
	  
	else
	{
	//	resp.getWriter().print("<h1>You are eligible to create account<h1>");
	
		CustomerDao customerDao  =new CustomerDao();
	
		List<Customer> list1  = customerDao.fetch(mobile);
		
	   List<Customer> list2	=customerDao.fetch(email);
		
		//	if(customerDao.fetch(mobile))
		
	  if(list1.isEmpty() && list2.isEmpty())
	  {
		Customer customer   =new Customer();
		customer.setName(custname);
		customer.setEmail(email);
		customer.setGender(gender);
		customer.setPwd(password);
		customer.setDob( date);
		customer.setMob(mobile);
		
	//	CustomerDao customerDao  =new CustomerDao();
		
		customerDao.save(customer);
		
	//	resp.getWriter().print("<h1> Account has been created successfully<h1>");
		
	  Customer customer2	 =customerDao.fetch(email).get(0);
	 
	   long id   =  customer2.getCustid();
	  if(customer2.getGender().equals("male")) 
	  {
		  resp.getWriter().print("<h1>Hello sir account has been created successfully<h1>");
		  resp.getWriter().print("<h1>your customer id is:"+id+"<h1>");
		  req.getRequestDispatcher("Home.html").include(req, resp);
		  
	  }
	  
	  else
	  {
		  resp.getWriter().print("<h1>Hello madam account has been created successfully<h1>");
		  resp.getWriter().print("<h1>your customer id is:"+id+"<h1>");
		  req.getRequestDispatcher("Home.html").include(req, resp);
	  }
	  
	  
 
	  }
	  
	  
	  
	  else
	  {
		  resp.getWriter().print("<h1>Account is already existed<h1>");
	  }
	  }
	}

}

