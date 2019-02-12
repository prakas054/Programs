package com.Java.practice.program;

import java.util.regex.Pattern;

public class Regex01 {

	public static void main(String[] args) {
		String S= "9431066491";
		
		System.out.println(Pattern.matches("[789]{1}[0-9]{9}", S));

	}

}
