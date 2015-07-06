package com.shopping.pkg;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyShop extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException
    {
	FileToDB ftb = new FileToDB();
	try
	{
	    ftb.takingfromfile();
	} catch (ClassNotFoundException e)
	{
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
