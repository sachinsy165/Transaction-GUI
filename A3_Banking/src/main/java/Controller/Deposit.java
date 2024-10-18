package Controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.BankDao;
import Dto.BankTransaction;
import Dto.Bank_account;

@WebServlet("/deposit")
public class Deposit extends HttpServlet
{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String amt    =req.getParameter("amnt");
		
		double amount   =Double.parseDouble(amt);
		
		 long acno   =(Long) req.getSession().getAttribute("ac_number") ;
		 
		 
		BankDao bankDao =new BankDao();
		
	Bank_account bank_account	   =bankDao.find(acno);
	
  bank_account.setAmount(bank_account.getAmount()+amount);	 
  
    BankTransaction bankTransaction=new BankTransaction();
   // bankTransaction.setTid(0);
    bankTransaction.setDeposit(amount);
    bankTransaction.setWithdraw(0);
    bankTransaction.setBalance(bank_account.getAmount()); //
    bankTransaction.setDate_time(LocalDateTime.now());
    
    
    List<BankTransaction>  list   = bank_account.getList();
     list.add(bankTransaction); //previos transaction history+current bankTransaction
     bank_account.setList(list);
     
     bankDao.update_the_details(bank_account);
  
  
  
  resp.getWriter().print("<h1>amount deposited successfully</h1>");
  req.getRequestDispatcher("Accounthome.html").include(req, resp);
	}
	
}
