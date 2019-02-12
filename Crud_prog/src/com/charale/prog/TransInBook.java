package com.charale.prog;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TransInBook {
	
	public static void main(String[] args) {
		
	     int book_id= 3; 
	   //  String BookID="book_id" ;
	     String id_of_student="2" ;
	     String name_of_student = "sahana";
		 String url="jdbc:mysql://localhost:3306/library_management?user=root&password=root";
			String driver="com.mysql.cj.jdbc.Driver";
			Connection connection=null;

				try {
							
					Class.forName(driver);
					connection=DriverManager.getConnection(url);					
					Statement st=connection.createStatement();
				    

         	connection.setAutoCommit(false);
				st.executeUpdate("UPDATE library_management.book_in_library SET no_of_copy=no_of_copy-1 WHERE book_id=" +book_id);
				connection.commit();
				System.out.println("transction done");
			
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
										
				}
				try {
					
					Class.forName(driver); //not need to load and register the driver in Mysql server 8.0+.
					
					 connection=DriverManager.getConnection(url);
					 
					 //by default jdbc is autocommit true,
					 //we can make false by using below line
					 //at last we need maually commit
					 
					connection.setAutoCommit(false);
					
					Statement statement=connection.createStatement();
					
					
					int updatecount=statement.executeUpdate("insert into library_management.issued_book_list(book_id, id_of_student, name_of_student) values('"+book_id+"','"+id_of_student+"','"+name_of_student+"')");
					
					/*System.out.println("data inserted successfully &*&*&*&*& ");
					System.out.println("The updatecount is " +updatecount);*/
					connection.commit();

				}
				catch (Exception e) {
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
