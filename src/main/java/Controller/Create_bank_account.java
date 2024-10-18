package Controller;

 

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.BankDao;
import Dao.CustomerDao;
import Dto.Bankaccount;
import Dto.Customer;

@WebServlet("/createbankaccount")
public class Create_bank_account extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String banktype  = req.getParameter("banktype");
		
	 Customer customer    =	(Customer) req.getSession().getAttribute("customer");
	 
	List<Bankaccount> list1    = customer.getList();  //it will give the list of bank accounts which have been created for current user
	boolean flag=true;
	for (Bankaccount bankaccount : list1)
	{
		if(bankaccount.getAccount_type().equals(banktype))
		{
			resp.getWriter().print("<h1>Already account is existed");
			flag=false;
		}
	}
	  if(flag)
	  {
	            Bankaccount bankaccount        =new Bankaccount();
	          //  bankaccount.setAcc_no(0);--it will get generated automatically so its not required to set externally
	         //  bankaccount.setAmount(0);---
	        //    bankaccount.setStatus(false);
	            
	            bankaccount.setAccount_type(banktype);
	          
	            if(bankaccount.getAccount_type().equals("savings"))
	            bankaccount.setAcc_limit(10000);
	            
	            else
	            	  bankaccount.setAcc_limit(15000);
	            
	            bankaccount.setCustomer(customer);
	            
	          BankDao bankDao   =new BankDao();
	          bankDao.save(bankaccount);
	          
	          
	     List<Bankaccount>list2  =list1;  //savings
	     list2.add(bankaccount); // savings+current
	     customer.setList(list2);
	     
	      CustomerDao customerDao   =new CustomerDao();
	      customerDao.update(customer);
	      resp.getWriter().print("<h1>Bankaccount has been created successfully waiting for manager approval<h1>");
	      req.getRequestDispatcher("admin.html").include(req, resp);
	 
	  }
	  }

}

