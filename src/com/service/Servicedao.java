package com.service;

import com.dao.Admindao;
import com.dao.Userdao;

import java.sql.SQLException;
import java.util.*;
public class Servicedao {
	Admindao  dao;
	Userdao user;
	Scanner  sc;
	public Servicedao()
	{
		sc = new Scanner(System.in);
		dao =new Admindao();
		user=new Userdao();
		
	}
	public void admin() throws SQLException
	{
		dao.aminvalidation();
		String Choice="y";
		int ch=0;
		while(Choice.equals("y"))
		{
			System.out.println("1.insertdata");
			System.out.println("2.retrive  products ");
			System.out.println("3.search by id to product");
			System.out.println("4.search by product");
			System.out.println("5.search by catagory product");
			System.out.println("6.total amount");
			System.out.println("7.profit amount from catagorie wise");
			ch=sc.nextInt();
			switch(ch)
			{
			case 1:
				dao.insert();
				break;
			case 2:
				dao.retrivedata();
				break;
			case 3:
				dao.searchbyid();
				break;
			case 4:
				dao.searchbyname();
				break;
			case 5:
				dao.catagory();
				break;
			case 6:
				dao.amount();
				break;
			case 7:
				dao.profit();
				break;
				
				
			}
			
		}
	}
	public void user() throws SQLException
	{
		//user.userlogin();
		String choice="y";
		int ch=0;
		while(choice.equals("y"))
		{
			System.out.println("1.register  new user");
			System.out.println("2.existing user");
			ch =sc.nextInt();
			switch(ch)
			{
			case 1:
				user.userlogin();
				String choice1="y";
				int ch1=0;
				while(choice1.equals("y"))
				{
					System.out.println("1.review list");
					System.out.println("2.catagorie wise to find out elements");
					System.out.println("3.search by price");
					System.out.println("serach by price and catagorie");
					ch1=sc.nextInt();
					switch(ch1)
					{
					case 1:
						dao.retrivedata();
						break;
					case 2:
						dao.catagory();
						break;
					case 3:
						dao.amount();
						break;
					case 4:
						user.seachprice();
						break;
					}
				}
				break;
			case 2:
				user.existinguser();
				String cho="y";
				int c=0;
				while(cho.equals("y"))
				{
					System.out.println("1.review list");
					System.out.println("2.catagorie wise to find out elements");
					System.out.println("3.search by price");
					System.out.println("4.serach by price and catagorie");
					System.out.println("5.search  by id or name");
					c=sc.nextInt();
					switch(c)
					{
					case 1:
						dao.retrivedata();
						break;
					case 2:
						dao.catagory();
						break;
					case 3:
						dao.amount();
						break;
					case 4:
						user.seachprice();
						break;
					case 5:
						user.purchaseProduct();
						break;
					}
				}
				break;
			case 3:
				System.exit(0);
				break;
			
			}
			System.out.println("you want to continue(y/n)");
			String x  = sc.next();
}
	}
}

