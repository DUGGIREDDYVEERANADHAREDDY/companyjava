package com.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import com.pojo.Userdetails;

import connection.DataConnection;
public class Userdao {
	Scanner sc;
	public Connection con;
	public PreparedStatement sat;
	public Userdao()
	{
		con=DataConnection.getConnection();
		sc=new Scanner(System.in);
	}
	public void userlogin() throws SQLException
	{
		
		sat=con.prepareStatement("insert into user values(?,?)");
		//insert into item values
		Userdetails us = new Userdetails();
		System.out.println("enter user name");
		sat.setString(1,sc.next());
		System.out.println("enter password");
		sat.setString(2, sc.next());
		int result=sat.executeUpdate();
		if(result>0)
		{
			System.out.println("user login sucessfully");
			System.out.println("user clamed 100 coins");
		}
		
	}
	public void existinguser() throws SQLException
	{
		System.out.println("enter user name");
		String name =sc.next();
		System.out.println("enter password");
		String pass =sc.next();
		sat=con.prepareStatement("SELECT * FROM user WHERE username = ? AND password = ?");
		//SELECT * FROM user WHERE username = ? AND password = ?
		sat.setString(1, name);
		sat.setString(2, pass);
		ResultSet result=sat.executeQuery();
		if(result.next())
		{
			System.out.println("user log in sucessfully");
		}
		else
		{
			System.out.println("the user not found");
		}
	}
	
		/*System.out.println("enter user name");
		String name=sc.next();
		System.out.println("enter password");
		String password=sc.next();
		if(name.equalsIgnoreCase(name) && password.equalsIgnoreCase(password)) 
		{
			System.out.println("user login sucessfully and ear  100 coins");
		}
		else
		{
			System.out.println("");
		}
	}*/
	public void seachprice() throws SQLException
	{
		System.out.println("enter  catagorie");
		String name=sc.next();
		double max=50;
		double min=1000;
		sat=con.prepareStatement("SELECT * FROM item WHERE category = ? AND price >= ? AND price <= ?");
		sat.setString(1,name);
		sat.setDouble(2, max);
		sat.setDouble(3, max);
		ResultSet result = sat.executeQuery();
		while(result.next())
		{
			System.out.println("product id is"+result.getInt(1));
			System.out.println("producct name is"+result.getString(2));
		}
		
	}
	
	public void purchaseProduct() {
	    try {
	    	System.out.println("enter id or catagory");
	    	String userInput =sc.next();
	        boolean isNumeric = userInput.matches("\\d+");

	        String query;
	        if (isNumeric) {
	            query = "SELECT * FROM item WHERE prodid  = ?";
	        } else {
	            query = "SELECT * FROM item WHERE prodname = ?";
	        }

	        PreparedStatement statement = con.prepareStatement(query);
	        statement.setString(1, userInput);

	        ResultSet resultSet = statement.executeQuery();

	        if (resultSet.next()) {
	            int productId = resultSet.getInt("prodid");
	            String productName = resultSet.getString("prodname");
	            
	            System.out.println("Product found - ID: " + productId );
	            System.out.println("product name is"+productName);
	        } else {
	            System.out.println("Product not found.");
	        }
	    } catch (SQLException e) {
	        // Handle SQL exception
	        e.printStackTrace();
	    }
	}

	

}
