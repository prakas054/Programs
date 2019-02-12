package com.Java.practice.program;
import  com.Java.practice.program.PNBE;


class ICIC extends PNBE {

	public void WithDraw () {
		 System.out.println("this is withdraw method of ICIC");
	           	
	}
	
	public void GetMiniStatement() {
		
		 System.out.println("this is GetMiniStatement method of ICIC");
	}
	
	 public void CheckBlance() {
		   System.out.println("this is checkBlance method of ICIC");
		   
	   }
	
}


public class ATM_Method_MainRunner {

	public static void main(String[] args) {
          
		ICIC ic = new ICIC();
		ic.CheckBlance();
		
		SBI sb = new SBI();
		sb.WithDraw();
		sb.CheckBlance();
		
        PNBE pn = new PNBE() {
		};
		
		pn.WithDraw();
		pn.GetMiniStatement();

	}

}
