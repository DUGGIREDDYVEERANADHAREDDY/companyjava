package com.menu;

import com.service.Servicedao;

import java.sql.SQLException;
import java.util.*;

public class Seviceoperation {
	Servicedao dt;
	Scanner sc;
	public Seviceoperation()
	{
		dt=new Servicedao();
		sc=new Scanner(System.in);
	}
	public void displaymenu() throws SQLException
	{
		String choice="y";
		int ch =0;
		while(choice.equals("y"))
		{
			System.out.println("enter choice");
			System.out.println("1.adminlogin");
			System.out.println("2.user login");
			System.out.println("3.exit");
			int ch1=sc.nextInt();
			switch(ch1)
			{
			case 1:
				dt.admin();
				break;
			case 2:
				dt.user();
				break;
			case 3:
				System.exit(0);
				break;
			}
			
		}
	}
	 

}
