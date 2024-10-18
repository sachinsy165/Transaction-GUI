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

@WebServlet("/adminlogin")
public class AdminLogin extends HttpServlet
{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
{
	String email   = req.getParameter("adminemail");
	
	String password   = req.getParameter("adminpassword");
	
	if(email.equals("admin@gmail.com")&&password.equals("admin"))
	{
		resp.getWriter().print("<h1>Admin login success<h1>");
		
		   BankDao bankDao=new BankDao();
		   
	List<Bankaccount>	list    =  bankDao.fetch_All_Bank_Details();
		   
	req.getSession().setAttribute("list", list);
		req.getRequestDispatcher("Account_home.jsp").include(req, resp);
		
		 
	}
	else
	{
		resp.getWriter().print("<h1>Invalid credentials<h1>");
		req.getRequestDispatcher("admin.html").include(req, resp);
	}
}
}

