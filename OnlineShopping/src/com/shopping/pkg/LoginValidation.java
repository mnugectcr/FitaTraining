package com.shopping.pkg;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginValidation extends HttpServlet
{
    
    private static final long serialVersionUID = 830832246356258998L;
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException
    {
	
	HttpSession session = req.getSession();
	//session.invalidate(); used to clear the session attributes
	String alreadyloggedin = (String)session.getAttribute("isuserloggedin");
	if("true".equals(alreadyloggedin))
	{
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/jsp/search.jsp");
	       	rd.forward(req, resp);
	}
	String username = req.getParameter("username");
	String password = req.getParameter("password");
	Validate val=new Validate();
	try
	{
	   boolean validity = val.validation(username,password);
	   if(validity)
	   {
	       session.setAttribute("isuserloggedin", "true");
	       RequestDispatcher rd = getServletContext().getRequestDispatcher("/jsp/search.jsp");
	       rd.forward(req, resp);
	   }
	   else
	   {
	       	RequestDispatcher rd = getServletContext().getRequestDispatcher("/jsp/error.jsp");
	       	rd.forward(req, resp);
	   }
	} catch (ClassNotFoundException e)
	{
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException
    {
	doGet(req,resp);
    }
    
}
