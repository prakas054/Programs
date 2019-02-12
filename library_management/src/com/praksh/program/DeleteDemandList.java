package com.praksh.program;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteDemandList {

	int Delete(int Demand_id) {
		
		 Connection con = null;
		  PreparedStatement pstmt = null;
		  String qry = "delete from demandlist where Demandid=?";
		 try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			  con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_management?user=root&password=root");
			  pstmt = con.prepareStatement(qry);
			   pstmt.setInt(1,Demand_id);
		       int a = pstmt.executeUpdate();
		   
				if(a==1)
				 {
					
					}
				else
					{
					
					}
		} 
		 catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}	
		 finally
		 {
			 if(pstmt!=null)
			 {
				 try
				 {
					 pstmt.close();
				 }
				 catch(SQLException e)
	    		  {
	    			  e.printStackTrace();
	    		  }
			 }
			 if(con!=null)
			 {
				 try
				 {
					 con.close();
				 }
				 catch(SQLException e)
	    		  {
	    			  e.printStackTrace();
	    		  }
		     }
		 }
		return 0;
		
	}
}
