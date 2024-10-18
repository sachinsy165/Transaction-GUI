package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/logout")
public class Logout extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		req .getSession().invalidate();//it is used to destroy or kill the session which has been created.
	
		resp.getWriter().print("<h1>Logout_success</h1>");
		
		req.getRequestDispatcher("Home.html").include(req, resp);
	}

}
