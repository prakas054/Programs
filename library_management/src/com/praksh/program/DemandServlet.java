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

@WebServlet("/DemandServlet")
public class DemandServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DemandServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id_of_book=request.getParameter("idBook");
		String id_of_student= request.getParameter("idStudent");
		String name_of_student= request.getParameter("nameStudent");
		PrintWriter out = response.getWriter();
		
		Check c = new Check();
		boolean isexist1=c.book(id_of_book);

		boolean isexist2=c.student(id_of_student, name_of_student);
		
		if(isexist1== true && isexist2== true){
        String qry = "insert into demandList(id_of_book, id_of_student, name_of_student) values ('"+id_of_book+"' , '"+id_of_student+"' , '"+name_of_student+"') "; 
		String url= "jdbc:mysql://localhost:3306/library_management?useSSL=false";
		String user= "root";
		String pwd= "root";
		String driver="com.mysql.cj.jdbc.Driver";
	
		Connection connection= null;
		
		try {
			
			Class.forName(driver);
			
			connection = DriverManager.getConnection(url, user, pwd);
							
			Statement statement = connection.createStatement();
			
			int updateCount= statement.executeUpdate(qry);
			
			if(updateCount!=0){				
				out.println("<html><center><body background='image.jpeg'>" + "<h3>Demand Update </h3>" +"</body></center></html>");
			}
			
			else {
				out.println("<html><center><body  background='image.jpeg'>" + "<h3>not updated...something error </h3>" +"</body></center></html>");
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
		else
			out.println("<html><body background='image.jpeg'>" + "<h3>Demand not updated...either bookid or studentid not exit </h3>" +"</body></html>");
	}

}
