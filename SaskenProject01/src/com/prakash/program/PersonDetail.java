package com.prakash.program;

public class PersonDetail {
	private String username;
	private String password;
	private String phoneno;
	private String email;
    public static int count = 0;

//zero argument constructor. Gets called by default when an object is created for the Employee class
public PersonDetail(){}

//Parameterized Constructor
public PersonDetail(String username, String password,String phoneno, String email)
{
super();
this.username = username;
this.password = password;
this.phoneno=phoneno;
this.email=email;
count++;
}

public String getUsername() {
	return username;
}

public String getPassword() {
	return password;
}

public String getPhoneno() {
	return phoneno;
}

public String getEmail() {
	return email;
}

public static int getCount() {
	return count;
}

}





