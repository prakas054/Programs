package com.praksh.program;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FirstPage")
public class FirstPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static int x=0;

    public FirstPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		String uname=request.getParameter("uname");
		String password= request.getParameter("password");
		
   /*		System.out.println(uname);
		System.out.println(password);*/
		
		
		String qry = "select * from users where usersname='"+uname+"' and password='"+password+"' limit 1"; 
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
			if(rs.next()){
				//rs.previous();
				do{
					/*System.out.println("--usres id--" +rs.getInt(1));
					System.out.println("--users Name--" +rs.getString(2));
					System.out.println("--users Address--" +rs.getString(3));*/
				//	System.out.println("type :"+rs.getString(5));
					if(rs.getString(5).equalsIgnoreCase("student"))
					{
						x=1;
						response.sendRedirect("student.jsp");
					}
					
					else if (rs.getString(5).equalsIgnoreCase("admin")) 
					{
						x=1;
						response.sendRedirect("admin.jsp");
					}
					
					else if (rs.getString(5).equalsIgnoreCase("librarian")) 
					{
						x=1;
						response.sendRedirect("librarian.jsp");
					}
					else{
						x=0;
							response.sendRedirect("unauthentic.jsp");
						//}
					}
		
				}
			while (rs.next());
				//System.out.println(" _______________________________________________");
			}
			else
			{
				
				response.sendRedirect("unauthentic.jsp");
				
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
	}

}
