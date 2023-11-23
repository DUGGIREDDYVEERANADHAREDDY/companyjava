package connection;

import java.sql.*;
public class DataConnection {
    private static Connection con;
      private DataConnection()
      {
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ONLINESTORE","root","veera");
            System.out.println("succfully connected database");
            //System.out.println("connection established ");
        } catch (ClassNotFoundException | SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
      }
      public static Connection getConnection()
      {
          DataConnection c2=new DataConnection();
          return con;
      }
        public static void main(String[] args) {
            getConnection();
        }
    }

