package com.prakash.program;

public class TestForSingleton {
	
	public static void main(String[] args) {
	
		SingletonObject obj1= SingletonObject.giveObject();
		System.out.println(obj1);
		
		SingletonObject obj2= SingletonObject.giveObject();
		System.out.println(obj2);
		
		
	}
}

