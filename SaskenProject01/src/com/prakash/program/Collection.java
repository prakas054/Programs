package com.prakash.program;

import java.util.ArrayList;

public class Collection {
	  
	/*Detail d = new Detail();
	
	private String username = d.getUsername();
	private String password = d.getPassword();
	private String phoneno = d.getPhoneno();
	private String email = d.getEmail();*/
	
	void data( Detail d) {
		 String username = d.getUsername();
		 String password = d.getPassword();
		 String phoneno = d.getPhoneno();
	     String email = d.getEmail();
		
	 ArrayList<String> ar1 = new ArrayList<String>();
		
		ar1.add(username);
		ar1.add(password);
		ar1.add(phoneno);
		ar1.add(email);
		
	    System.out.println(ar1);
	}
}



