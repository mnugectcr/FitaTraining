package com.shopping.pkg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class SetToDB
{
    public boolean savingdata(String username,String password,String email,String mobile) throws ClassNotFoundException
    {
	boolean flag=true;
	Class.forName("com.mysql.jdbc.Driver");
	Connection conn = null;
	try
	{
	    conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/Online_Shopping","root","haiitsme");
	    PreparedStatement ps = conn.prepareStatement("insert into user(username,password,email,mobile) values(?,?,?,?)");
	    ps.setString(1, username);
	    ps.setString(2, password);
	    ps.setString(3, email);
	    ps.setString(4, mobile);
	    PreparedStatement ps1 = conn.prepareStatement("select * from user where username=?");
	    ps1.setString(1, username);
	    ResultSet rs=ps1.executeQuery();
	    if(username.equals(null))
	    {
		flag=false;
	    }
	    while(rs.next())
	    {
		flag=false;
	    }
	    if(flag)
	    {
		ps.execute();
	    }
	    if(!flag)
	    {
		return flag;
	    }
	}
	catch (SQLException e)
	{
	    e.printStackTrace();
	}
	finally
	{
	    try
	    {
		conn.close();
	    } 
	    catch (SQLException e)
	    {
		e.printStackTrace();
	    }
	}
	return flag;
	
    }
}
