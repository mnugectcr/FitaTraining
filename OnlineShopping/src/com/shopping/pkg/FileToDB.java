package com.shopping.pkg;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FileToDB
{
    //List<Products> productList = new ArrayList<Products>();
    public void takingfromfile() throws IOException, ClassNotFoundException
    {
	
	BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File("/home/manu/Desktop/product_details.txt"))));
	Products prod = new Products();
	String line=null;
	FileToDB ftb = new FileToDB();
	while((line=br.readLine())!=null)
	{
	    String arr[]=line.split(",");
	    prod.pid=Integer.parseInt(arr[0]);
	    prod.pname=arr[1];
	    prod.price=arr[2];
	    prod.discount=arr[3];
	    prod.catagory=arr[4];
	    prod.imagename=arr[5];
	    //productList.add(prod);
	    ftb.puttingtodb(prod.pid, prod.pname, prod.price, prod.discount, prod.catagory, prod.imagename);
	}
	/*for(int i=0;i<productList.size();i++)
	{
	    System.out.println(productList.get(i).pname);
	}
	for(int i=0;i<productList.size();i++)
	{
	    ftb.puttingtodb(productList.get(i).pid,productList.get(i).pname,productList.get(i).price,productList.get(i).discount,productList.get(i).catagory,productList.get(i).imagename);
	}*/
	
	
    }
    public void puttingtodb(int pid,String pname, String price, String discount, String catagory, String imagename) throws ClassNotFoundException
    {
	boolean flag = true;
	Class.forName("com.mysql.jdbc.Driver");
	Connection conn=null;
	try
	{
	    conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/Online_Shopping","root","haiitsme");
	    PreparedStatement ps = conn.prepareStatement("insert into product(pid,pname,price_MRP,discount,catagory,product_image) values(?,?,?,?,?,?)");
	    ps.setInt(1, pid);
	    ps.setString(2, pname);
	    ps.setString(3, price);
	    ps.setString(4, discount);
	    ps.setString(5, catagory);
	    ps.setString(6, imagename);
	    
	    PreparedStatement ps1 = conn.prepareStatement("select * from product where pid=?");
	    ps1.setInt(1, pid);
	    ResultSet rs=ps1.executeQuery();
	    while(rs.next())
	    {
		flag=false;
	    }
	    if(flag)
	    {
		 ps.execute();
	    }
	} catch (SQLException e)
	{
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	finally
	{
	    try
	    {
		conn.close();
	    } catch (SQLException e)
	    {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }
	}
	return;
    }
}
