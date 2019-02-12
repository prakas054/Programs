package com.Java.practice.program;

public interface ATM_Method {
	
	void WithDraw();
	void CheckBlance();

}


class SBI implements ATM_Method {
	
    
   public void WithDraw() {
	   System.out.println("this is withdraw method of SBI");
	   
   }
   
   public void CheckBlance() {
	   System.out.println("this is checkBlance method of SBI");
	   
   }	
}


abstract class PNBE implements ATM_Method {
	
	
	
	public void WithDraw () {
		 System.out.println("this is withdraw method of PNBE");
		
	           	
	}
	
	public void GetMiniStatement() {
		
		 System.out.println("this is GetMiniStatement method of PNBE");
	}
	
	@Override
	public void CheckBlance() {
		System.out.println("not required");
		
	}
} 