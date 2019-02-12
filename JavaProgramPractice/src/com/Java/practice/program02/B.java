package com.Java.practice.program02;

import com.Java.practice.program.A;

public class B extends A{
	B(){System.out.println("I am in B consructor"); }

	public void print() {
		System.out.println("B");
	}
	
	public static void main(String[] args) {
		new B();
	//	new A();
	}

}
