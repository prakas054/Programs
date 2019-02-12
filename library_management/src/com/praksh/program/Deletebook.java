package com.praksh.program;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Deletebook")
public class Deletebook extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Deletebook() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 int BookId = Integer.parseInt( req.getParameter("bid"));
		  Connection con = null;
		  PreparedStatement pstmt = null;
		  String qry = "delete from book_in_library where book_id=?";
		 try {
			Class.forName("com.mysql.jdbc.Driver");
			  con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_management?user=root&password=root");
			  pstmt = con.prepareStatement(qry);
			   pstmt.setInt(1,BookId);
		       int a = pstmt.executeUpdate();
		   
				if(a==1)
				 {
					PrintWriter out = resp.getWriter();
						out.println("<html><br><br><br><center><body background='image.jpeg'>"
								+ "<h3>Book is Deleted. </h3><br>"+"<form action='admin.jsp'>"
								+ "<input type=submit value =Back>"
								+"</form></body></center></html>");
						out.flush();
						out.close();
					}
				else
					{
						PrintWriter out = resp.getWriter();
						out.println("<html><br><br><br><center><body background='image.jpeg'>"
								+ "<h3>Inputed ID is incorrect. </h3><br>"+"<form action='admin.jsp'>"
								+ "<input type=submit value =Back>"
								+"</form></body></center></html>");
						
						
						out.flush();
						out.close();
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
	}

}
