package com.praksh.program;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Transaction {
	
	boolean TransactionMethod(int book_id, String id_of_student, String name_of_student) {
		
		
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
			
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
										
				}
				
                try {
					
					Class.forName(driver); 					
					connection=DriverManager.getConnection(url);
					connection.setAutoCommit(false);					
					Statement statement=connection.createStatement();
										
					int updatecount=statement.executeUpdate("insert into library_management.issued_book_list(book_id, id_of_student, name_of_student) "
							                                             + "values('"+book_id+"','"+id_of_student+"','"+name_of_student+"')");
					connection.commit();
					
					
					if (updatecount==0) {
						return false;
					}

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
	
		
		return true;
		
	}

}
