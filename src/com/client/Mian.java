package com.client;

import java.sql.SQLException;

import com.menu.Seviceoperation;

public class Mian extends Thread{
	public void run()
	{
		Seviceoperation service;
		try
		{
			service=new Seviceoperation();
			service.displaymenu();
			Thread.sleep(MAX_PRIORITY);
		}
		catch(Exception ex)
		{
			ex.getMessage()
			
		}
	}
	public static void main(String[] args) throws SQLException, InterruptedException {
		//Seviceoperation st = new Seviceoperation();
		//st.displaymenu();
		Mian m=new Mian();
		m.start();
		
	}
	

}
