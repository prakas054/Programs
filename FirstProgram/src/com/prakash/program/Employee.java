package com.prakash.program;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Employee implements Serializable {
	
	private int id;
	private String name;
	
	public Employee() 
	{
		
	}
	
	public void setId(int id) 
	{
		this.id= id;
	}
	
	public int getId()
	{
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
