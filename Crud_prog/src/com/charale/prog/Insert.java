package com.charale.prog;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class Insert {

	public static void main(String[] args) {
		
		
		String url="jdbc:mysql://localhost:3306/library_management?useSSL=false";
		String user="root";
		String pwd="root";
		String driver="com.mysql.cj.jdbc.Driver";
		Connection connection=null;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter users id:");
		int id=sc.nextInt();
		System.out.println("Enter users name:");
		String name=sc.next();
		System.out.println("Enter users usersname:");
		String usersname=sc.next();
		System.out.println("Enter users password:");
		String password=sc.next();
		System.out.println("Enter users type_of_users:");
		String type_of_users=sc.next();
		
		String qry="insert into users values("+id+",'"+name+"','"+usersname+"','"+password+"','"+type_of_users+"')";

		//String qry1=String.format("insert into employee values(%d,%s,%s)", id,name,address);
		System.out.println();
	try {
		
		Class.forName(driver); //not need to load and register the driver in Mysql server 8.0+.
		
		 connection=DriverManager.getConnection(url, user, pwd);
		 
		 //by default jdbc is autocommit true,
		 //we can make false by using below line
		 //at last we need maually commit
		 
		connection.setAutoCommit(false);
		
		Statement statement=connection.createStatement();
		
		
		int updatecount=statement.executeUpdate(qry);
		
		System.out.println("data inserted successfully &*&*&*&*& ");
		System.out.println("The updatecount is " +updatecount);
		connection.commit();

	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	finally {
		if(connection!=null)
			
		{
			
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
     sc.close();
  }
}
