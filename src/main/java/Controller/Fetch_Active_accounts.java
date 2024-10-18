package Controller;

 

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dto.Bankaccount;
import Dto.Customer;

@WebServlet("/fetchActiveAccounts")
public class Fetch_Active_accounts extends HttpServlet 
{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
	 Customer customer   = (Customer) req.getSession().getAttribute("customer");
	 
	List<Bankaccount>  list   = customer.getList();
	
	List<Bankaccount>    list2=new ArrayList<Bankaccount>();
	
	for (Bankaccount bankaccount : list) 
	{
		if(bankaccount.isStatus())
		{
			list2.add(bankaccount); //inside l2 only active accounts information is presented
			//resp.getWriter().print("<h1>Active accounts found<h1>");
		}
		 
	}
	req.getSession().setAttribute("list", list2);
	req.getRequestDispatcher("Accounts.jsp").include(req, resp);
	}
}

