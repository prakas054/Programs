package com.prakash.program;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginPage
 */
@WebServlet("/LoginPage")
public class LoginPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginPage() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
		String username= request.getParameter("un");
		String password= request.getParameter("pw");
		
        System.out.println(username);
        System.out.println(password);
        
        Detail dl = new Detail();
        
    	//   Collection Col = new Collection();
    	   String uname = dl.getUsername();
           String Passw = dl.getPassword();
     System.out.println(uname);
     System.out.println(Passw);

		if(username.equals(uname) && password.equals(Passw)) {
			PrintWriter out = response.getWriter();
			out.println("<html><center><body>"
					+ "<br><h3>welcome: </h3>"
					+uname+"<br><br>"
				+"<form action='Login.jsp'>"
						+"<input type=submit value =Back>"
								+ "</form></body></center></html>");
		
			out.flush();
			out.close();
		}

		else
		{
			PrintWriter out = response.getWriter();
			out.println("<html><center><body>"
					+ "<br><h3>invalid user </h3>"
					 +"<br><br>"+"<form action='Login.jsp'>"
						+ "<input type=submit value =Back>"
								+ "</form></body></center></html>");
		
			out.flush();
			out.close();
		}
	
	//	doGet(request, response);
		
	}

}
