package com.prakash.program;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Registration
 */
@WebServlet("/Registration")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Registration() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String username= request.getParameter("un");
		String password= request.getParameter("pw");
		String phoneno= request.getParameter("mn");
		String email= request.getParameter("em");
		
		Detail pd = new Detail();
		pd.setUsername(username);
		pd.setPassword(password);
		pd.setPhoneno(phoneno);
		pd.setEmail(email);
		
		/*
        ArrayList<String> ar1 = new ArrayList<String>();
		
		ar1.add(username);
		ar1.add(password);
		ar1.add(phoneno);
		ar1.add(email);
		
	    System.out.println(ar1);*/
	    
	    
	    PrintWriter out = response.getWriter();
		out.println("<html><center><body>"
				+ "<br><h3>welcome..... </h3>"
				+username+" <br><br>" +"You are sucessfully registered"
			+"<form action='Login.jsp'>" 
					+"<br><br> <input type=submit value =login>"
							+ "</form></body></center></html>");
	
		out.flush();
		out.close();
		
		/*Detail det = new Detail();
		det.data();*/
		Collection co = new Collection();
		co.data(pd);
	//	doGet(request, response);
	}

}
