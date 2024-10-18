package Controller;

 

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.BankDao;
import Dto.Bankaccount;

@WebServlet("/changestatus")
public class Changestatus extends HttpServlet
{
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
{
    String acn    = req.getParameter("acno");
    
   long acnn      =  Long.parseLong(acn);
   
     BankDao bankDao       =new BankDao();
    Bankaccount bankaccount  = bankDao.fetch_by_accno(acnn);
    
    if(bankaccount.isStatus())
    {
    	bankaccount.setStatus(false);
    }
    else
    {
    	bankaccount.setStatus(true); //
    }
    
    bankDao.update(bankaccount);
   List<Bankaccount>  list  =bankDao.fetch_All_Bank_Details();
   req.getSession().setAttribute("list", list);
   req.getRequestDispatcher("Account_home.jsp").include(req, resp);
    resp.getWriter().print("<h1>bank status has beeen updated<h1>");
}
}


