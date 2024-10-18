package Controller;

 


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/setactiveaccount")
public class SetActice_Account extends HttpServlet
{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String acn   = req.getParameter("acno");
		
		  long acno  =Long.parseLong(acn);
		  
		  req.getSession().setAttribute("acno", acno); // here i can tell my active account has been set for furter operation
	req.getRequestDispatcher("Transactionpage.jsp").include(req, resp);
	}

}

