package com.Java.practice.program;

import java.util.ArrayList;

public class ArrayListExample {
	
	public static void main(String[] args) {
		
		ArrayList<String> ar1 = new ArrayList<String>();
		
		ar1.add("Apple");
		ar1.add("Mango");
		ar1.add("Grapes");
		ar1.add("Guava");
		ar1.add("Apple");
		
	    System.out.println(ar1);
	    
	    
	    ar1.remove(3);
	    ar1.remove("Apple");
	    
	    System.out.println(ar1);
		
	}

}
