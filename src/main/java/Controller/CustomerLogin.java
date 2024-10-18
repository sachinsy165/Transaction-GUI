package Controller;

 

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.CustomerDao;
import Dto.Customer;

@WebServlet("/customerlogin")
public class CustomerLogin extends HttpServlet
{
	
	
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
{
	String custid  = req.getParameter("custid");
	
	String pwd  = req.getParameter("pwd");
	
	long id  =Long.parseLong(custid);
	
	
CustomerDao customerDao	=new CustomerDao();
 Customer customer      =customerDao.fetchByCustId(id);
 
 if(customer==null)
 {
	 resp.getWriter().print("<h1>You enterd invalid custid");
	 req.getRequestDispatcher("customerlogin.html").include(req, resp);
 }
 else
 {
	// resp.getWriter().print("<h1>Login success<h1>");
	 
	 if(customer.getPwd().equals(pwd))
	 {
		 resp.getWriter().print("<h1>Login success<h1>");
		 req.getSession().setAttribute("customer", customer);
		 req.getRequestDispatcher("customerhome.html").include(req, resp);
	 }
	 else
	 {
		 resp.getWriter().print("<h1>You enterd invalid password<h1>");
		 req.getRequestDispatcher("customerlogin.html").include(req, resp);
	 }
 }
  
}
}

