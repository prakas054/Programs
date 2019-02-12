package com.charale.prog;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ProgToUpdate {
	
	public static void main(String[] args) {	
			
			String url="jdbc:mysql://localhost:3306/project?useSSL=false";
			String user="root";
			String pwd="root";
			//String driver="com.mysql.jdbc.Driver";
			Connection connection=null;

			String qry="update employee set name='mohit' where id=4";
		try {
			
			//Class.forName(driver);
			
			 connection=DriverManager.getConnection(url, user, pwd);
			
			Statement statement=connection.createStatement();
			
			
			int updatecount=statement.executeUpdate(qry);
			
			System.out.println("data updated successfully &*&*&"   +updatecount);


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

	}

}
