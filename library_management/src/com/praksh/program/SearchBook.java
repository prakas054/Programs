package com.praksh.program;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SearchBook")
public class SearchBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public SearchBook() {
        super();

    }

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String title = req.getParameter("bk");
		String bkname="";
	    int id= 0;
		int bkcount=0;
		String qry = "select * from book_in_library where name=?";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_management?user=root&password=root");
			pstmt = con.prepareStatement(qry);
			pstmt.setString(1,title);
		//	pstmt.setString(2,title);
			rs = pstmt.executeQuery();
			
			if(rs.next())
			{
				id=rs.getInt(1);
			    bkname = rs.getString(2);
				bkcount=rs.getInt(3);
			}
			if(title.equalsIgnoreCase(bkname))
			{
				
				PrintWriter out = resp.getWriter();
				out.println("<html><center><body background=\"image.jpeg\">"
						+ "<br><h3>The Available Book is: </h3>"
						+id+ "| "
						+	bkname	+ " | "
							 +bkcount +"<br><br>"+"<form action='search.jsp'>"
							+ "<input type=submit value =Back>"
									+ "</form></body></center></html>");
			
				out.flush();
				out.close();
			}
			else
			{
				PrintWriter out = resp.getWriter();
				out.println("<html><br><br><br><center><body background=\"image.jpeg\">"
						+ "<h3>The Book is not Available </h3><br>"+"<form action='search.jsp'>"
						+ "<input type=submit value =Back>"
						+"</form></body></center></html>");
				
				
				out.flush();
				out.close();
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally
		{

			if(rs!=null)
			{
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pstmt!=null)
			{
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(con!=null)
			{
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	

}
