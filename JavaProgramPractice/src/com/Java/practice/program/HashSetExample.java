package com.Java.practice.program;

import java.util.HashSet;

public class HashSetExample {
	public static void main(String[] args) {
		HashSet<String> hs = new HashSet<String>();
		
		hs.add("India");
		hs.add("America");
		hs.add("Japan");
		hs.add("China");
		hs.add("America");
		
		System.out.println(hs);
		
		
	}

}
