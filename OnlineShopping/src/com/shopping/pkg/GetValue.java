package com.shopping.pkg;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetValue extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException
    {
	String username=null;
	username=req.getParameter("username");
	String password=req.getParameter("password");
	String email=req.getParameter("email");
	String mobile=req.getParameter("mobile");
	SetToDB std = new SetToDB();
	try
	{
	    boolean val = std.savingdata(username, password, email, mobile);
	    if(!val)
	    {
		RequestDispatcher rd1 = getServletContext().getRequestDispatcher("/jsp/error1.jsp");
		rd1.forward(req, resp);
	    }
	} 
	catch (ClassNotFoundException e)
	{
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	RequestDispatcher rd = getServletContext().getRequestDispatcher("/jsp/shoplogin.jsp");
	rd.forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException
    {
	doGet(req,resp);
    }
    
}
