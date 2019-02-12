package com.praksh.program;

import java.io.IOException;
import java.io.PrintWriter;
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

@WebServlet("/IssueServlet")
public class IssueServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public IssueServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		int a =Integer.parseInt(request.getParameter("demand_id"));
		/*System.out.println(a);
		System.out.println("getting here");*/
		
		String qry = "select * from demandlist where Demandid = "+a ; 
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
			
			ResultSet rs= statement.executeQuery(qry);
			
			if(rs.next()) {	
				 int Demandid= rs.getInt(1);
			     int book_id= Integer.parseInt( rs.getString(2));
			     String id_of_student=  rs.getString(3);
			     String name_of_student= rs.getString(4);
			     
			         Check c = new Check();
			     boolean case1= c.CheckNoOfBook(book_id);		   
			     boolean case2=c.student(id_of_student, name_of_student);
			   
			   
			   if(case1 == true && case2 == true) {
						System.out.println("every thing is fine");
						Transaction tr = new Transaction();
						boolean case3 = tr.TransactionMethod(book_id,id_of_student, name_of_student);
						
						if(case3== true) {
							
							DeleteDemandList dl = new DeleteDemandList();
							dl.Delete(Demandid);
							
							pr.println("<html><br><br><br><center><body background=\"image.jpeg\">"
									+ "<h3>book issued successfully...... </h3><br>"+"<form action='issue.jsp'>"
									+ "<input type=submit value =Back>"
									+"</form></body></center></html>");
							
							
						}
						
						else {
							 pr.println("<html><center><body background=\"image.jpeg\">"
										+"<h3> I am is case 3 false in issue servlet...."									
										+ "</h3><br>"+"</body></center></html>");
							 
						}
						
					}
			   
			   else {
				   pr.println("<html><br><br><br><center><body background=\"image.jpeg\">"
							+ "<h3>either no. of book is not available or student is not present</h3><br>"
						    +"<form action='issue.jsp'>"
							+ "<input type=submit value =Back>"
							+"</form></body></center></html>");
		    	}
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
