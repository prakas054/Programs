package com.prakash.program;

public class SingletonObject {
	
	private SingletonObject() 
	{
				
	}
	
	private static SingletonObject singleObject = new SingletonObject();
	
	public static SingletonObject giveObject() 
	{
		return singleObject;
		
	}

}
