package com.prakash.prog;

public class MessagePrint {
	
	 private String message;

	   //Constructor
	   //@param message to be printed
		
	   public MessagePrint(String message){
	      this.message = message;
	   }
	      
	   // prints the message
	   public String printMessage(){
	      System.out.println(message +"________________________");
	      return message;
	   }   

}
