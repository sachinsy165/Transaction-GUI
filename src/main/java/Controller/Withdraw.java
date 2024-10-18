package Controller;

 

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.BankDao;
import Dto.BankTransaction;
import Dto.Bankaccount;

@WebServlet("/withdraw")
public class Withdraw extends HttpServlet
{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
{
	 String amount       = req.getParameter("amount");
	  
     double amt       = Double.parseDouble(amount);
     
   long acno  =  (long) req.getSession().getAttribute("acno");
   
     BankDao bankDao =new BankDao();
     
    Bankaccount bankaccount   =  bankDao.fetch_by_accno(acno);
    
    if(bankaccount.getAmount()<amt )
    {
    	resp.getWriter().print("<h1>Insufficient balance your actual balance is:"+bankaccount.getAmount());
    }
    else
    {
    	if (amt>bankaccount.getAcc_limit())
    	{
    		resp.getWriter().print("<h1>your account limit is exceeding  your actual account limit is:<h1>"+bankaccount.getAcc_limit());
    	}
    	else
    	{
    		
          bankaccount.setAmount((bankaccount.getAmount()-amt));   //before putting any data inside database we should set the data
        
          BankTransaction bankTransaction=new BankTransaction();
       // bankTransaction.setTid(0);
        bankTransaction.setDeposit(0);
        bankTransaction.setWithdraw(amt);
        bankTransaction.setBalance(bankaccount.getAmount());
        bankTransaction.setLocalDateTime(LocalDateTime.now());
        
        List<BankTransaction>  list  = bankaccount.getBankTransactions(); //older transaction history
        list.add(bankTransaction);
          
          
          
          bankDao.update(bankaccount);
          resp.getWriter().print("<h1>Amount has been withdrawn  successfully<h1>");
          req.getRequestDispatcher("Transactionpage.jsp").include(req, resp);
    	}
    	}
 
}
}

