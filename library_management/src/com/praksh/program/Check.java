package com.praksh.program;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Check {
    
	 boolean book(String idbook)
	  {
		// System.out.println(id);
		  
		    String qry = "select count(*) as isexist from book_in_library where book_id="+idbook; 
			String url= "jdbc:mysql://localhost:3306/library_management?useSSL=false";
			String user= "root";
			String pwd= "root";
			String driver="com.mysql.cj.jdbc.Driver";
		//	int re;
		
			Connection connection= null;
			
			try {
				
				Class.forName(driver);
				
				connection = DriverManager.getConnection(url, user, pwd);
								
				Statement statement = connection.createStatement();
				
				ResultSet rs= statement.executeQuery(qry);
				rs.next();
//				System.out.println("is exist "+ rs.getInt("isexist"));
				if(rs.getInt("isexist")==1)
					return true;
				//else
					//return false;
				
				
			} catch (ClassNotFoundException | SQLException e) {

				e.printStackTrace();
			}
			
			finally {
				if(connection != null)
				{
					try{
						connection.close();	
					}
					
					catch(SQLException e){						
						e.printStackTrace();
						
					}
				}
	   }
		return false;
	  }
	 
	 boolean CheckNoOfBook(int id) {
			// System.out.println(id);
			  
		    String qry = "select * from book_in_library where book_id="+id; 
			String url= "jdbc:mysql://localhost:3306/library_management?useSSL=false";
			String user= "root";
			String pwd= "root";
			String driver="com.mysql.cj.jdbc.Driver";
		
			Connection connection= null;
			
			try {
				
				Class.forName(driver);
				
				connection = DriverManager.getConnection(url, user, pwd);
								
				Statement statement = connection.createStatement();
				
				ResultSet rs= statement.executeQuery(qry);
				rs.next();
			    
				// System.out.println(rs.getString(3));
				if( Integer.parseInt( rs.getString(3))!=0 )
					return true;
						
			} catch (ClassNotFoundException | SQLException e) {

				e.printStackTrace();
			}
			
			finally {
				if(connection != null)
				{
					try{
						connection.close();	
					}
					
					catch(SQLException e){						
						e.printStackTrace();
						
					}
				}
	   }
		return false;	
		}
	  
	  boolean student(String idstudent, String namestudent)
	  {
		// System.out.println(id);
		  
		    String qry = "select *  from users where id='"+idstudent+"' and name='"+namestudent+"' "; 
			String url= "jdbc:mysql://localhost:3306/library_management?useSSL=false";
			String user= "root";
			String pwd= "root";
			String driver="com.mysql.cj.jdbc.Driver";
		
			Connection connection= null;
			
			try {
				
				Class.forName(driver);
				
				connection = DriverManager.getConnection(url, user, pwd);
								
				Statement statement = connection.createStatement();
				
				ResultSet rs= statement.executeQuery(qry);
			if(	rs.next()){
			//	System.out.println("the fifth index is" +);
			
						if(rs.getString(5).equalsIgnoreCase("student"))
						return true;
			}
			
				
			} catch (ClassNotFoundException | SQLException e) {

				e.printStackTrace();
			}
			
			finally {
				if(connection != null)
				{
					try{
						connection.close();	
					}
					
					catch(SQLException e){						
						e.printStackTrace();
						
					}
				}
	   }
		return false;
	  }
}
