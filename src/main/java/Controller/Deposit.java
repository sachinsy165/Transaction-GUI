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

@WebServlet("/deposit")
public class Deposit extends HttpServlet
{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
{
  String amount       = req.getParameter("amount");
  
     double amt       = Double.parseDouble(amount);
     
   long acno  =  (long) req.getSession().getAttribute("acno");
   
     BankDao bankDao =new BankDao();
     
    Bankaccount bankaccount   =  bankDao.fetch_by_accno(acno);
    
 bankaccount.setAmount((bankaccount.getAmount()+amt));   //before putting any data inside database we should set the data

 
    BankTransaction bankTransaction=new BankTransaction();
// bankTransaction.setTid(0);
 bankTransaction.setDeposit(amt);
 bankTransaction.setWithdraw(0);
 bankTransaction.setBalance(bankaccount.getAmount());
 bankTransaction.setLocalDateTime(LocalDateTime.now());
 
 List<BankTransaction>  list  = bankaccount.getBankTransactions(); //older transaction history
 list.add(bankTransaction); // inside this list now we are having older transaction history+current transaction history
 
 
   
 bankDao.update(bankaccount);
 
 resp.getWriter().print("<h1>Amount has been added successfully<h1>");
 req.getRequestDispatcher("Transactionpage.jsp").include(req, resp);
}
}

