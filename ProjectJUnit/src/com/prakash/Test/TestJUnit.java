package com.prakash.Test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.prakash.prog.MessagePrint;

public class TestJUnit {
	
	   String message = "Hello World";	
	   String msg= "hello Sweeta";
	   MessagePrint obj = new MessagePrint(message);

	@Test
	public void testPrintMessage() {
		 assertEquals(message,obj.printMessage());
		 System.out.println(obj.getClass() +"-----------------");
	
	}	
	
}
