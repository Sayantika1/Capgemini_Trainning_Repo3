package com.Lambda;

public class Main {

	public static void main(String args[])
	{
	/*	Demo demo = ()->{
			System.out.println("Implememnted demo");
		};
		
		demo.sample();
		
		Demo demo1 = ()->
			System.out.println("Implememnted demo1");
		
		demo1.sample();	
		
//if a method is an argument method and not a return type method in the Functional Interface
	*/
		
	/*	Demo demo=(num)->{
			System.out.println("For Argument method");
		};
		demo.sample(10);
		
//if a method is an single argument method and single statement is provided for the  method
	
		Demo demo3= num ->System.out.println("For Argument method");
	*/
	
	
	 Demo demo3 = (num1 , num2) -> System.out.println("For two Argument method");
	 demo3.sample(100,2000);
	 
//if a method is two argument method and single statement is provided for the  method
	
	 
		
	}
}
