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
public class Customersignup extends HttpServlet
{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String name  = req.getParameter("name");
		String mobile  = req.getParameter("mob");
		
		
	     long mob	   =Long.parseLong(mobile);
		
		String passward  = req.getParameter("pwd");
		String email  = req.getParameter("email");
		String gender  = req.getParameter("gender");
		String dob  = req.getParameter("dob");
		
//		resp.getWriter().print("<h1>"+name+"</h1>"
//			    + "<h1>"+mob+"</h1>" 
//				+ "<h1>"+passward+"</h1>"
//				+ "<h1>"+email+"</h1>"
//				+ "<h1>"+gender+"</h1>"
//				+ "<h1>"+dob+"</h1>");
	 
	Date date	=Date.valueOf(dob); //here it is indicating that we have converted successfully string value into date formate.
		
Period period    =	Period.between(date.toLocalDate(), LocalDate.now());

  int  age   =period.getYears();
  
   Customer customer  =new Customer();
  CustomerDao customerDao =new CustomerDao(); 
  
  if(age>18)
  {
	//  resp.getWriter().print("<h1>He is eligible to create bank account</h1>");
	 // customer.setCid(age); it will get generated randomly
	 
	  if(customerDao.check1(email).isEmpty() && customerDao.check2(mob).isEmpty())
	  {
	  customer.setCname(name);
	  customer.setEmail(email);
	  customer.setGender(gender);
	  customer.setMob(mob);
	  customer.setDate(date);
	  customer.setPwd(passward);
	  
	  customerDao.save(customer);
	//  resp.getWriter().print("<h1>Account has created successfully</h1>");
	  
	 Customer customer2 = customerDao.check1(email).get(0);
	//Customer customer2   = list.get(0);
	 
	 if(customer2.getGender().equals("female"))
	 {
		 resp.getWriter().print("<h1>Hello madam</h1>"); 
	 }
	 else
	 {
		 resp.getWriter().print("<h1>Hello sir</h1>"); 
	 }
	 
	 resp.getWriter().print("<h1>Account has created successfully your customer id is:   "+customer2.getCid()+"</h1>");
	 req.getRequestDispatcher("customerlogin.html").include(req, resp);
	 
	  
	  }
	  else
	 {
		  
		  resp.getWriter().print("<h1>this credentials is already existed try with different mail and mobile number" +"</h1>"); 
	  }
	  }
  
  
  else
  {
	  resp.getWriter().print("<h1>your not eligible to create bank account because your age is less than 18 years</h1>");
	  
  }
	}
	
}
