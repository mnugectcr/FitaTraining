package com.shopping.pkg;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class Validate
{
    public boolean validation(String username, String password) throws ClassNotFoundException
    {
	boolean flag=false;
	Class.forName("com.mysql.jdbc.Driver");
	Connection conn = null;
	try
	{
	    conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/Online_Shopping","root","haiitsme");
	    PreparedStatement ps = conn.prepareStatement("select * from user where username=? and password=?");
	    ps.setString(1, username);
	    ps.setString(2, password);
	    ResultSet rs = ps.executeQuery();
	    while(rs.next())
	    {
		flag=true;
		System.out.println(rs.getString("username"));
		System.out.println(rs.getString("password"));
		System.out.println(username);
		System.out.println(password);
/*		if(rs.getString(username).equals(username))
		{
		    if(rs.getString(password).equals(password))
		    {
		    }
		    
		}
*/	    }
	} catch (SQLException e)
	{
	    e.printStackTrace();
	}
	finally{
	    try
	    {
		conn.close();
	    } catch (SQLException e)
	    {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }
	}
	return flag;
	
    }
}
