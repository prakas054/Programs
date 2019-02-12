package com.praksh.program;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SecondPage")
public class SecondPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public SecondPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//int idBook= Integer.parseInt(request.getParameter("id"));
				String nameBook= request.getParameter("name");
				int nocopy= Integer.parseInt(request.getParameter("copy"));
				
				String qry = "insert into book_in_library(name, no_of_copy) values ('"+nameBook+"' , '"+nocopy+"') ";
				String url= "jdbc:mysql://localhost:3306/library_management?useSSL=false";
				String user= "root";
				String pwd= "root";
				String driver="com.mysql.cj.jdbc.Driver";
				PrintWriter pr = response.getWriter();
			
				Connection connection= null;
				
				try {
					Class.forName(driver);  

					connection = DriverManager.getConnection(url, user, pwd);

					Statement statement = connection.createStatement();
					
					if(nameBook!= "" && nocopy!= 0 ){
						
					int updateCount= statement.executeUpdate(qry);
					System.out.println(updateCount);
					
					if (updateCount != 0) {
						response.sendRedirect("add_page.jsp");
					}	
					
					else{
						
						pr.println("<html><center><body background=\\\"image.jpeg\\\">"
								+"<h3>data not inserted </h3><br>"+"</body></center></html>");
					}
					
					}
					else {
						pr.println("<html><center><body background=\"image.jpeg\">"
								+"<h3>invalid entry....name of book cant be null or number of book cant be 0 </h3><br>"+"</body></center></html>");
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
