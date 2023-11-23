package com.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import com.mysql.cj.protocol.Resultset;
import com.pojo.Product;

import connection.DataConnection;
public class Admindao {
	public Scanner sc;
	private Connection con;
	public PreparedStatement ps;
	
	public Admindao()
	{
		sc=new Scanner(System.in);
		con=DataConnection.getConnection();
	}
	public  void aminvalidation()
	{
		System.out.println("enter admin name");
		String admin= sc.next();
		System.out.println("enter password");
		String pass=sc.next();
		if(admin.equalsIgnoreCase("admin") && pass.equalsIgnoreCase("admin"))
		{
			System.out.println("admin is sucessfully log in");
		}
		else
		{
			System.out.println("invalid admin");
			System.exit(0);
		}
	}
	public void insert() throws SQLException
	{
		System.out.println("enter how many items you wnat to enter");
		int x = sc.nextInt();
		for(int i=0;i<x;i++)
		{
		ps=con.prepareStatement("insert into item values(?,?,?,?,?)");
	    System.out.println("Enter the ProductId ");
	    ps.setInt(1,sc.nextInt());
	    System.out.println("Enter ProductName ");
	    ps.setString(2, sc.next());
	    System.out.println("Enter the catagory ");
	    ps.setString(3, sc.next());
	    System.out.println("Enter the Available Quantity");
	    ps.setInt(4, sc.nextInt());
	    System.out.println("Enter the Buying price of product ");
	    Double bp=sc.nextDouble();
	    ps.setDouble(5, bp);
	    //ps.setDouble(6, (bp*0.5)+bp);
	    int result=ps.executeUpdate();
	    if(result>0)
	    {
	        System.out.println("Data Inserted Successfully...");
    }
	    else
	    {
	    	System.out.println("data was not inserted");
	    	System.exit(0);

	    }
		}
	}
	
	/*
	 * List of Products
2. Search By Product Id
3. List Of Products by Catagory
4. Search By Product Name
5. Total Amount of Products
6. Profit of Catagory 
7. Insert Items 
8. Exit
	 */
	public void retrivedata() throws SQLException
	{
		ps=con.prepareStatement("select * from item");
		ResultSet re = ps.executeQuery();
		while(re.next())
		{
			System.out.println("the id is:-"+re.getInt(1));
			System.out.println("enter productname:-"+re.getString(2));
			System.out.println("the catagorie is the:-"+re.getString(3));
			
		}
		
		
	}
	public void searchbyid() throws SQLException
	{
		System.out.println("enter id you want to search");
		int id=sc.nextInt();
		ps=con.prepareStatement("select*from item where prodid=?");
		ps.setInt(1, id);
		ResultSet re = ps.executeQuery();
		while(re.next())
		{
			System.out.println("the id is:-"+re.getInt(1));
			System.out.println("the product name is:-"+re.getString(2));
		}
	}
	public void searchbyname() throws SQLException
	{
		System.out.println("enter id you want to search");
		String name =sc.next();
		ps=con.prepareStatement("select*from item where prodname=?");
		ps.setString(1, name);
		ResultSet re = ps.executeQuery();
		while(re.next())
		{
			System.out.println("the id is:-"+re.getInt(1));
			System.out.println("the product name is:-"+re.getString(2));
		}
	}
		public void catagory() throws SQLException
		{
			System.out.println("enter you want to search catagorie");
			String cat =sc.next();
			ps=con.prepareStatement("select * from item where category=?");
			ps.setString(1, cat);
			ResultSet re = ps.executeQuery();
			while(re.next())
			{
				System.out.println("the id is:-"+re.getInt(1));
				System.out.println("the product name is:-"+re.getString(2));
				System.out.println("the catagorie is:-"+re.getString(3));
			}
		}
		public void amount() throws SQLException
		{
			ps=con.prepareStatement("select sum(price) from item");
			ResultSet re =ps.executeQuery();
			while(re.next())
			{
				System.out.println("the total amount of price is"+re.getDouble(1));
			}
			
			
		}
		public void profit() throws SQLException {
			System.out.println("enter profit for the catagorie wise");
			double profit=sc.nextDouble();
			ps=con.prepareStatement("select sum(Price) from items where category=?");
			ps.setDouble(1, profit);
			ResultSet r =ps.executeQuery();
			while(r.next())
			{
				System.out.println("the profit amount is the"+r.getDouble(1));
			}
		}
}
